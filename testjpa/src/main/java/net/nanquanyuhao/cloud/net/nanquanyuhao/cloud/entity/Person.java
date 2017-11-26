package net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nanquanyuhao on 2017/11/26.
 */
@Entity
@Table(name = "CRA_PERSON")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
