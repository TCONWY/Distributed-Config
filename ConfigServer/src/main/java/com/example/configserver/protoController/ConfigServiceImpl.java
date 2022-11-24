package com.example.configserver.protoController;

import com.example.configserver.models.Config;
import com.example.configserver.services.ConfigService;
import com.example.configserver.services.ServiceService;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class ConfigServiceImpl extends ConfigServiceGrpc.ConfigServiceImplBase{
    private final ConfigService configService;
    private final ServiceService serviceService;

    @Autowired
    public ConfigServiceImpl(ConfigService configService, ServiceService serviceService) {
        this.configService = configService;
        this.serviceService = serviceService;
    }

    @Override
    public void addConfig(Protofile.Config request,
                          StreamObserver<Protofile.ResponseConfig> responseConfig) {
        if(request.getService().isEmpty() || serviceService.findByName(request.getService()).isEmpty()
                || request.getDataList().isEmpty()) {
            responseConfig.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        else {
            Config config = new Config();
            config.setService(request.getService());
            config.setData(request.getDataList()
                    .stream().collect(Collectors.toMap(Protofile.Data::getKey, Protofile.Data::getValue)));

            config.setServiceOwner(serviceService.findByName(request.getService()).orElse(null));
            Config config1 = configService.findByServiceAndActive(request.getService());
            if(config1 != null) {
                config1.setActive(false);
                configService.save(config1);
                config.setConfigVersion(config1.getConfigVersion() + 1);
            }
            config.setActive(true);
            configService.save(config);
            Protofile.ResponseConfig response = Protofile.ResponseConfig
                    .newBuilder().setResponse("OK").build();

            responseConfig.onNext(response);
            responseConfig.onCompleted();
        }
    }

    @Override
    public void getConfig(Protofile.NameConfig request, StreamObserver<Protofile.ResponseConfig> responseConfig) {
        if(request.getName().isEmpty() || serviceService.findByName(request.getName()).isEmpty()) {
            responseConfig.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        else{
            Config config = configService.findByServiceAndActive(request.getName());
            Protofile.ResponseConfig response = Protofile.ResponseConfig
                    .newBuilder().setResponse(config.getData().toString()).build();

            responseConfig.onNext(response);
            responseConfig.onCompleted();
        }
    }

    @Override
    public void updateConfig(Protofile.Config request, StreamObserver<Protofile.ResponseConfig> responseConfig) {
        Config config = configService.findByService(request.getService());
        config.setData(request.getDataList().stream().collect(Collectors.toMap(Protofile.Data::getKey, Protofile.Data::getValue)));
        configService.update(config.getId(), config);
        Protofile.ResponseConfig response = Protofile.ResponseConfig
                .newBuilder().setResponse("OK").build();
        responseConfig.onNext(response);
        responseConfig.onCompleted();
    }

    @Override
    public void deleteConfig(Protofile.NameAndVersion request, StreamObserver<Protofile.ResponseConfig> responseObserver) {
        if(request.getName().isEmpty()) {
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        Config config = configService.findByServiceAndConfigVersion(request.getName(), request.getVersion());
        if (config == null || config.isActive()) {
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        }
        else {
            configService.delete(config.getId());
            Protofile.ResponseConfig response = Protofile.ResponseConfig
                    .newBuilder().setResponse("deleted").build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllConfig(Empty request, StreamObserver<Protofile.ArrayConfig> responseObserver) {
        List<Config> configList = configService.findAll();
        Protofile.ArrayConfig response = Protofile.ArrayConfig
                .newBuilder().addAllConfig(configList.stream().map(i ->{return Protofile.Config.newBuilder()
                        .setService(i.getService())
                        .addAllData(i.getData().entrySet().stream()
                                .map(pair -> {return Protofile.Data.newBuilder()
                                        .setKey(pair.getKey())
                                        .setValue(pair.getValue().toString()).build();})
                                .collect(Collectors.toList())).build();}).collect(Collectors.toList())).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getVersionConfig(Protofile.NameAndVersion request, StreamObserver<Protofile.ResponseConfig> responseObserver) {
        if(request.getName().isEmpty() || serviceService.findByName(request.getName()).isEmpty()) {
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        Config config = configService.findByServiceAndConfigVersion(request.getName(), request.getVersion());
        if(config == null)
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            Protofile.ResponseConfig response = Protofile.ResponseConfig
                    .newBuilder().setResponse(config.getData().toString()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
