package wy.study.learing.service;

public class CServiceImpl implements CService {
    CServiceImpl c=new CServiceImpl();

    @Override
    public String testc() {
        return "ccc";
    }

    @Override
    public AService a() {
        AService aService = null;
        return aService;
    }

    @Override
    public BService b() {
        return null;
    }
}
