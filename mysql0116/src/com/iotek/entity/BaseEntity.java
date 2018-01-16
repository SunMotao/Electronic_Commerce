package com.iotek.entity;

import java.io.Serializable;

/**
 * Created by xiaohuang on 2018/1/13.
 */
public class BaseEntity<T> implements Serializable {
   private  T  id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
