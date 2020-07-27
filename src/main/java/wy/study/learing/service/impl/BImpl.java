package wy.study.learing.service.impl;

import org.springframework.stereotype.Service;
import wy.study.learing.service.AService;
@Service("bservice")
public class BImpl implements AService {
    @Override
    public String testa() {
        System.out.println("B");
        return "线程B";
    }
}
