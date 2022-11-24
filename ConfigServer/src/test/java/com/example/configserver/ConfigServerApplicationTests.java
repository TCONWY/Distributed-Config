package com.example.configserver;

import com.example.configserver.models.Config;
import com.example.configserver.models.Service;
import com.example.configserver.protoController.ConfigServiceGrpc;
import com.example.configserver.protoController.Protofile;
import com.example.configserver.protoController.ServiceServiceGrpc;
import io.grpc.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
public class ConfigServerApplicationTests {
    private static Protofile.Config validConfig;
    private static Protofile.Config validUpdateConfig;
    private static ConfigServiceGrpc.ConfigServiceBlockingStub stubCon;
    private static ServiceServiceGrpc.ServiceServiceBlockingStub stubSer;

    private static Protofile.Config createDefaultConfigEmptyService() {
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("firstName").setValue("Vladimir").build());
        dataList.add(Protofile.Data.newBuilder().setKey("lastName").setValue("Ivanov").build());
        return Protofile.Config.newBuilder().addAllData(dataList).build();
    }

    private static Protofile.Config createDefaultConfig() {
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("firstName").setValue("Vladimir").build());
        dataList.add(Protofile.Data.newBuilder().setKey("lastName").setValue("Ivanov").build());
        return Protofile.Config.newBuilder().setService("MyService").addAllData(dataList).build();
    }

    private static Protofile.Config createDefaultUpdateConfig() {
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("firstName").setValue("Rasul").build());
        dataList.add(Protofile.Data.newBuilder().setKey("lastName").setValue("Nalivkin").build());
        return Protofile.Config.newBuilder().setService("MyService").addAllData(dataList).build();
    }

    @BeforeAll
    static void setup() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9090").usePlaintext().build();
        stubCon = ConfigServiceGrpc.newBlockingStub(channel);
        stubSer = ServiceServiceGrpc.newBlockingStub(channel);
        validConfig = createDefaultConfig();
    }

    @Before
    public void serverSetup() {
        Protofile.Service myService = Protofile.Service.newBuilder().setName("MyService").build();
        stubSer.addService(myService);
    }

    @Test
    public void addService() throws Exception {
        Protofile.Service newService = Protofile.Service.newBuilder().setName("NewService2").build();
        Protofile.ResponseService responseService = stubSer.addService(newService);
        Assertions.assertEquals("OK", responseService.getResponse());
    }

    @Test
    public void addServiceFail() {
        Protofile.Service newService = Protofile.Service.newBuilder().setName("addServiceFail").build();
        Protofile.ResponseService responseService = stubSer.addService(newService);
        Assertions.assertEquals("OK", responseService.getResponse());
        Assertions.assertThrows(StatusRuntimeException.class,()-> stubSer.addService(Protofile.Service.newBuilder().build()));
        Assertions.assertThrows(StatusRuntimeException.class,()-> stubSer.addService(Protofile.Service.newBuilder().setName("addServiceFail").build()));
    }

    @Test
    public void addConfig() throws Exception {
        Protofile.ResponseConfig responseConfig = stubCon.addConfig(validConfig);
        Assertions.assertEquals("OK", responseConfig.getResponse());
    }

    @Test
    public void addConfigFail() {
        Assertions.assertThrows(StatusRuntimeException.class, ()-> stubCon.addConfig(Protofile.Config.newBuilder().build()));
    }

    @Test
    public void getService() throws Exception {
        Protofile.NameService serviceName = Protofile.NameService.newBuilder().setName("MyService").build();
        Protofile.ResponseService responseService = stubSer.getService(serviceName);
        Assertions.assertEquals(serviceName.getName(), responseService.getResponse());
    }

    @Test
    public void getServiceFail() {
        Protofile.NameService serviceName = Protofile.NameService.newBuilder().setName("getServiceFail").build();
        Assertions.assertThrows(StatusRuntimeException.class,()-> stubSer.getService(serviceName));
    }

    @Test
    public void getConfig() throws Exception {
        Protofile.NameConfig nameConfig = Protofile.NameConfig.newBuilder().setName("MyService").build();
        Protofile.ResponseConfig responseConfig = stubCon.getConfig(nameConfig);
        Assertions.assertEquals("{firstName=Vladimir, lastName=Ivanov}", responseConfig.getResponse());
    }

    @Test
    public void getConfigFail() {
        Protofile.NameConfig nameConfig = Protofile.NameConfig.newBuilder().setName("getConfigFail").build();
        Assertions.assertThrows(StatusRuntimeException.class,()-> stubCon.getConfig(nameConfig));
    }

    @Test
    public void updateConfig() throws Exception {
        Protofile.Service service = Protofile.Service.newBuilder().setName("MyService").build();
        Protofile.ResponseService qwe = stubSer.addService(service);
        validUpdateConfig = createDefaultUpdateConfig();
        Protofile.ResponseConfig responseConfig1 = stubCon.addConfig(validUpdateConfig);
        Assertions.assertEquals("OK", responseConfig1.getResponse());
        validUpdateConfig = createDefaultConfig();
        Protofile.ResponseConfig responseConfig = stubCon.updateConfig(validUpdateConfig);
        Assertions.assertEquals("OK", responseConfig.getResponse());
    }

    @Test
    public void updateConfigFail() {
        validUpdateConfig = createDefaultConfigEmptyService();
        Assertions.assertThrows(StatusRuntimeException.class,()-> stubCon.addConfig(validUpdateConfig));
    }

    @Test
    public void getAllConfig() throws Exception {
        Protofile.Config config = createDefaultConfig();
        Protofile.Config config1 = createDefaultUpdateConfig();
        stubCon.addConfig(config);
        stubCon.addConfig(config1);
        Protofile.ArrayConfig arrayConfig = stubCon.getAllConfig(null);
        Assertions.assertEquals(8, arrayConfig.getConfigList().size());
    }

    @Test
    public void getAllConfigsService() {
        Protofile.Service myService1 = Protofile.Service.newBuilder().setName("getAllConfigsService").build();
        Protofile.ResponseService qwe = stubSer.addService(myService1);
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("firstName").setValue("Vladimir").build());
        dataList.add(Protofile.Data.newBuilder().setKey("lastName").setValue("Ivanov").build());
        Protofile.Config config =  Protofile.Config.newBuilder().setService("getAllConfigsService").addAllData(dataList).build();
        Protofile.Config config1 =  Protofile.Config.newBuilder().setService("getAllConfigsService").addAllData(dataList).build();
        Protofile.Config config2 =  Protofile.Config.newBuilder().setService("getAllConfigsService").addAllData(dataList).build();

        List<Protofile.Config> configList = new ArrayList<>();
        configList.add(config);
        configList.add(config1);
        configList.add(config2);
        Protofile.ArrayConfig arrayConfig1 = Protofile.ArrayConfig.newBuilder().addAllConfig(configList).build();
        System.out.println(configList.get(2));
        stubCon.addConfig(config);
        stubCon.addConfig(config1);
        stubCon.addConfig(config2);
        Protofile.ArrayConfig arrayConfig = stubSer
                .getAllConfigs(Protofile.NameService.newBuilder().setName("getAllConfigsService").build());
        Assertions.assertEquals(arrayConfig1.getConfigList(), arrayConfig.getConfigList());
    }

    @Test
    public void getAllConfigsServiceFail() {
        Protofile.Service myService1 = Protofile.Service.newBuilder().setName("getAllConfigsServiceFail").build();
        Protofile.ResponseService qwe = stubSer.addService(myService1);
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("firstName").setValue("Vladimir").build());
        dataList.add(Protofile.Data.newBuilder().setKey("lastName").setValue("Ivanov").build());
        Protofile.Config config =  Protofile.Config.newBuilder().setService("getAllConfigsServiceFail").addAllData(dataList).build();
        Protofile.Config config1 =  Protofile.Config.newBuilder().setService("getAllConfigsServiceFail").addAllData(dataList).build();
        Protofile.Config config2 =  Protofile.Config.newBuilder().setService("getAllConfigsServiceFail").addAllData(dataList).build();
        stubCon.addConfig(config);
        stubCon.addConfig(config1);
        stubCon.addConfig(config2);
        Assertions.assertThrows(StatusRuntimeException.class, ()-> stubSer
                .getAllConfigs(Protofile.NameService.newBuilder().setName("getAllConfigsServiceFailL").build()));
    }

    @Test
    public void deleteConfig() {
        Protofile.Service myService1 = Protofile.Service.newBuilder().setName("deleteConfig").build();
        Protofile.ResponseService qwe = stubSer.addService(myService1);
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("firstName").setValue("Vladimir").build());
        dataList.add(Protofile.Data.newBuilder().setKey("lastName").setValue("Ivanov").build());
        Protofile.Config config =  Protofile.Config.newBuilder().setService("deleteConfig").addAllData(dataList).build();
        Protofile.Config config1 =  Protofile.Config.newBuilder().setService("deleteConfig").addAllData(dataList).build();
        Protofile.Config config2 =  Protofile.Config.newBuilder().setService("deleteConfig").addAllData(dataList).build();
        stubCon.addConfig(config);
        stubCon.addConfig(config1);
        stubCon.addConfig(config2);
        Protofile.NameAndVersion nameAndVersion = Protofile.NameAndVersion.newBuilder().setName("deleteConfig")
                .setVersion(0).build();
        Protofile.ResponseConfig responseConfig = stubCon.deleteConfig(nameAndVersion);
        Assertions.assertEquals("deleted", responseConfig.getResponse());
    }

    @Test
    public void deleteConfigFail() {
        Protofile.Service myService1 = Protofile.Service.newBuilder().setName("deleteConfigFail").build();
        Protofile.ResponseService qwe = stubSer.addService(myService1);
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("firstName").setValue("Vladimir").build());
        dataList.add(Protofile.Data.newBuilder().setKey("lastName").setValue("Ivanov").build());
        Protofile.Config config =  Protofile.Config.newBuilder().setService("deleteConfigFail").addAllData(dataList).build();
        Protofile.Config config1 =  Protofile.Config.newBuilder().setService("deleteConfigFail").addAllData(dataList).build();
        Protofile.Config config2 =  Protofile.Config.newBuilder().setService("deleteConfigFail").addAllData(dataList).build();
        stubCon.addConfig(config);
        stubCon.addConfig(config1);
        stubCon.addConfig(config2);
        Protofile.NameAndVersion nameAndVersion = Protofile.NameAndVersion.newBuilder().setName("deleteConfigFailL")
                .setVersion(2).build();
        Assertions.assertThrows(StatusRuntimeException.class, ()->stubCon.deleteConfig(nameAndVersion));
        Assertions.assertThrows(StatusRuntimeException.class, ()->stubCon.deleteConfig(Protofile.NameAndVersion.newBuilder().setName("deleteConfigFail").setVersion(777).build()));
        Assertions.assertThrows(StatusRuntimeException.class, ()->stubCon.deleteConfig(Protofile.NameAndVersion.newBuilder().build()));
    }

    @Test
    public void deleteService() {
        Protofile.Service myService1 = Protofile.Service.newBuilder().setName("deleteService").build();
        Protofile.ResponseService qwe = stubSer.addService(myService1);
        Protofile.NameService nameService = Protofile.NameService.newBuilder().setName("deleteService").build();
        Protofile.ResponseService responseService = stubSer.deleteService(nameService);
        Assertions.assertEquals("deleted", responseService.getResponse());
    }

    @Test
    public void deleteServiceFail() {
        Protofile.Service myService1 = Protofile.Service.newBuilder().setName("deleteServiceFail").build();
        Protofile.ResponseService qwe = stubSer.addService(myService1);
        Protofile.NameService nameService = Protofile.NameService.newBuilder().setName("deleteServiceFailL").build();
        Assertions.assertThrows(StatusRuntimeException.class, ()->stubSer.deleteService(nameService));
        Assertions.assertThrows(StatusRuntimeException.class, ()->stubSer.deleteService(Protofile.NameService.newBuilder().build()));
        Assertions.assertThrows(StatusRuntimeException.class, ()->stubSer.deleteService(Protofile.NameService.newBuilder().build()));
    }

    @Test
    public void getVersionConfig() {
        Protofile.Service myService1 = Protofile.Service.newBuilder().setName("getVersionConfig").build();
        Protofile.ResponseService qwe = stubSer.addService(myService1);
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("firstName").setValue("Vladimir").build());
        dataList.add(Protofile.Data.newBuilder().setKey("lastName").setValue("Ivanov").build());
        Protofile.Config config =  Protofile.Config.newBuilder().setService("getVersionConfig").addAllData(dataList).build();
        Protofile.Config config1 =  Protofile.Config.newBuilder().setService("getVersionConfig").addAllData(dataList).build();
        Protofile.Config config2 =  Protofile.Config.newBuilder().setService("getVersionConfig").addAllData(dataList).build();
        stubCon.addConfig(config);
        stubCon.addConfig(config1);
        stubCon.addConfig(config2);
        Protofile.NameAndVersion nameAndVersion = Protofile.NameAndVersion.newBuilder()
                .setName("getVersionConfig").setVersion(1).build();
        Protofile.ResponseConfig responseConfig = stubCon.getVersionConfig(nameAndVersion);
        Assertions.assertEquals(config1.getDataList().stream().collect(Collectors
                .toMap(Protofile.Data::getKey, Protofile.Data::getValue)).toString(), responseConfig.getResponse());
    }

    @Test
    public void getVersionConfigFail () {
        Protofile.Service myService1 = Protofile.Service.newBuilder().setName("getVersionConfigFail").build();
        Protofile.ResponseService qwe = stubSer.addService(myService1);
        List<Protofile.Data> dataList = new ArrayList<>();
        dataList.add(Protofile.Data.newBuilder().setKey("firstName").setValue("Vladimir").build());
        dataList.add(Protofile.Data.newBuilder().setKey("lastName").setValue("Ivanov").build());
        Protofile.Config config =  Protofile.Config.newBuilder().setService("getVersionConfigFail").addAllData(dataList).build();
        Protofile.Config config1 =  Protofile.Config.newBuilder().setService("getVersionConfigFail").addAllData(dataList).build();
        Protofile.Config config2 =  Protofile.Config.newBuilder().setService("getVersionConfigFail").addAllData(dataList).build();
        stubCon.addConfig(config);
        stubCon.addConfig(config1);
        stubCon.addConfig(config2);
        Protofile.NameAndVersion nameAndVersion = Protofile.NameAndVersion.newBuilder()
                .setName("getVersionConfigFailL").setVersion(1).build();
        Assertions.assertThrows(StatusRuntimeException.class,()-> stubCon.getVersionConfig(Protofile.NameAndVersion.newBuilder().build()));
        Assertions.assertThrows(StatusRuntimeException.class,()-> stubCon.getVersionConfig(Protofile.NameAndVersion.newBuilder().setVersion(3).build()));
        Assertions.assertThrows(StatusRuntimeException.class,()-> stubCon.getVersionConfig(Protofile.NameAndVersion.newBuilder().setName("getVersionConfigFail").setVersion(999).build()));
        Assertions.assertThrows(StatusRuntimeException.class,()-> stubCon.getVersionConfig(nameAndVersion));
    }

    @Test
    public void testUtil() {
        Service service = new Service("lsd");
        service.setId(3);
        Assertions.assertEquals("Service{id=3, name='lsd', configs=null}", service.toString());
        Config config = new Config(new HashMap<>());
        config.setServiceOwner(service);
        Assertions.assertEquals("Config{id=0, data={}, active=false, service='null', configVersion=0, serviceOwner=Service{id=3, name='lsd', configs=null}}", config.toString());
        Assertions.assertEquals("Service{id=3, name='lsd', configs=null}", config.getServiceOwner().toString());
    }

}
