package com.walter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Dev {

    private Computer comp;


    public Dev(){
        System.out.println("Dev Constructor");
    }



    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void build(){
        System.out.println("Working on Awesome Projekt");
        comp.compile();
    }

}
