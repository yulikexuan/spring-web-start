//: webstart.service.LoginCountService


package webstart.service;


import java.util.concurrent.atomic.LongAdder;


public interface LoginCountService {

    LongAdder COUNT = new LongAdder();

    void increment();

    long count();

    static LoginCountService of() {
        return new LoginCountServiceImpl();
    }

}

final class LoginCountServiceImpl implements LoginCountService {

    @Override
    public void increment() {
        COUNT.increment();
    }

    @Override
    public long count() {
        return COUNT.longValue();
    }

}

///:~