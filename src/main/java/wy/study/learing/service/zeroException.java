package wy.study.learing.service;

import org.springframework.stereotype.Service;
import wy.study.learing.service.impl.ioz;

@Service
public class zeroException implements ioz {
    @Override
    public void zero(){
        int i=1/0;
    }
}
