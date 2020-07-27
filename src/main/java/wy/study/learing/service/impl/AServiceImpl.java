package wy.study.learing.service.impl;

import org.springframework.stereotype.Service;
import wy.study.learing.service.AService;
@Service("aservice")
public class AServiceImpl implements AService {
    @Override
    public String testa() {
        System.out.println("AService");
        return "线程A";
    }
}
