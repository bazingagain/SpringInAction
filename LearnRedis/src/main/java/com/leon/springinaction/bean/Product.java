package com.leon.springinaction.bean;

import java.io.Serializable;

/**
 * Created on 06/02/2018.
 *
 * @author Xiaolei-Peng
 */
public class Product {
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
