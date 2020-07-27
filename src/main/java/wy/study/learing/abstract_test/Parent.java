package wy.study.learing.abstract_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wy.study.learing.service.impl.BImpl;


public abstract class Parent {
    @Autowired
    protected BImpl bImpl;
}
