import com.example.configserver.protoController.ConfigServiceGrpc;
import com.example.configserver.protoController.Protofile;
import com.example.configserver.protoController.ServiceServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class AppJava {
    private static Protofile.Config createDefaultConfig() {
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("key1").setValue("value1").build());
        dataList.add(Protofile.Data.newBuilder().setKey("key2").setValue("value2").build());
        return Protofile.Config.newBuilder().setService("MyService3").addAllData(dataList).build();
    }

    private static Protofile.Config createDefaultUpdateConfig() {
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("key3").setValue("value3").build());
        dataList.add(Protofile.Data.newBuilder().setKey("key4").setValue("value4").build());
        return Protofile.Config.newBuilder().setService("MyService3").addAllData(dataList).build();
    }

    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9090").usePlaintext().build();
        ConfigServiceGrpc.ConfigServiceBlockingStub stubCon = ConfigServiceGrpc.newBlockingStub(channel);
        ServiceServiceGrpc.ServiceServiceBlockingStub stubSer = ServiceServiceGrpc.newBlockingStub(channel);
        Protofile.Service requestSer = Protofile.Service.newBuilder().setName("MyService3").build();
        Protofile.Config requestCon = createDefaultConfig();
        Protofile.ResponseService responseService;
        Protofile.ResponseConfig responseConfig;
        try {
            responseService = stubSer.addService(requestSer);
            System.out.println(responseService);


            responseConfig = stubCon.getConfig(Protofile.NameConfig.newBuilder().setName(requestCon.getService()).build());
            System.out.println(responseConfig.getResponse());

            requestCon = createDefaultUpdateConfig();
            responseConfig = stubCon.updateConfig(requestCon);
            System.out.println(responseConfig.getResponse());

            responseConfig = stubCon.getConfig(Protofile.NameConfig.newBuilder().setName(requestCon.getService()).build());
            System.out.println(responseConfig.getResponse());

            requestCon = createDefaultConfig();
            System.out.println(responseConfig.getResponse());

            Protofile.ArrayConfig allConfig = stubCon.getAllConfig(null);
            for (Protofile.Config conf : allConfig.getConfigList()){
                System.out.println(conf);
            }

            responseConfig = stubCon.getVersionConfig(Protofile.NameAndVersion.newBuilder()
                    .setName(requestCon.getService()).setVersion(0).build());
            System.out.println(responseConfig.getResponse());

            Protofile.ArrayConfig allConfigsService = stubSer.getAllConfigs(Protofile
                    .NameService.newBuilder().setName("MyService3").build());
            for (Protofile.Config conf : allConfigsService.getConfigList()){
                System.out.println(conf);
            }



        } catch (StatusRuntimeException e) {
            System.err.println(e.getMessage());
            return;
        }
        channel.shutdownNow();

    }
}
