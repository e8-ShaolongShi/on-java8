package ch10_interfaces.factory;

interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

// ==================== 服务1与它的工厂类 ========================
class Service1 implements Service {

    Service1() {
    }

    @Override
    public void method1() {
        System.out.println("Service1.method1()");
    }

    @Override
    public void method2() {
        System.out.println("Service1.method2()");
    }
}

class Service1Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Service1();
    }
}
// ==================== 服务1与它的工厂类 ========================


// ==================== 服务2与它的工厂类 ========================
class Service2 implements Service {

    @Override
    public void method1() {
        System.out.println("Service2.method1()");
    }

    @Override
    public void method2() {
        System.out.println("Service2.method2()");
    }
}

class Service2Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Service2();
    }
}
// ==================== 服务2与它的工厂类 ========================

/**
 * @author shishaolong
 * @datatime 2020/4/10 14:42
 */
public class Factories {

    public static void serviceConsumer(ServiceFactory serviceFactory) {
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Service2Factory());
        serviceConsumer(new Service1Factory());
    }
}
