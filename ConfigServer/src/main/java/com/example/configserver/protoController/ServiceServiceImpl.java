package com.example.configserver.protoController;

import com.example.configserver.models.Config;
import com.example.configserver.models.Service;
import com.example.configserver.services.ConfigService;
import com.example.configserver.services.ServiceService;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;


@GrpcService
public class ServiceServiceImpl extends ServiceServiceGrpc.ServiceServiceImplBase{
    private final ServiceService serviceService;
    private final ConfigService configService;

    @Autowired
    public ServiceServiceImpl(ServiceService serviceService, ConfigService configService) {
        this.serviceService = serviceService;
        this.configService = configService;
    }

    @Override
    public void addService(Protofile.Service request, StreamObserver<Protofile.ResponseService> responseObserver) {
        if (request.getName().isEmpty() || serviceService.findByName(request.getName()).isPresent()) {
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        else {
            Service service = new Service();
            service.setName(request.getName());
            serviceService.save(service);
            Protofile.ResponseService response = Protofile.ResponseService
                    .newBuilder().setResponse("OK").build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getService(Protofile.NameService request, StreamObserver<Protofile.ResponseService> responseObserver) {
        if (request.getName().isEmpty() || serviceService.findByName(request.getName()).isEmpty()) {
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        else {
            Service service = serviceService.findByName(request.getName()).orElse(null);
            Protofile.ResponseService response = Protofile.ResponseService
                    .newBuilder().setResponse(service.getName()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteService(Protofile.NameService request, StreamObserver<Protofile.ResponseService> responseObserver) {
        if (request.getName().isEmpty()) {
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        Service service = serviceService.findByName(request.getName()).orElse(null);
        if (service == null)
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            serviceService.delete(service.getId());
            Protofile.ResponseService response = Protofile.ResponseService
                    .newBuilder().setResponse("deleted").build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllConfigs(Protofile.NameService request, StreamObserver<Protofile.ArrayConfig> responseObserver) {
        if (request.getName().isEmpty() || serviceService.findByName(request.getName()).isEmpty()) {
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        else{
            List<Config>configList = configService.findAllByService(request.getName());
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
    }
}
