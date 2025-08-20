package com.walter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Dev {

    public Dev(){
        System.out.println("Dev Constructor");
    }

    public void build(){



        System.out.println("Working on Awesome Projekt");
    }
}
