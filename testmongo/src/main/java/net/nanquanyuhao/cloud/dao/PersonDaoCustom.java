package net.nanquanyuhao.cloud.dao;

import net.nanquanyuhao.cloud.entity.Person;

import java.util.List;

/**
 * Created by nanquanyuhao on 2017/11/26.
 */
public interface PersonDaoCustom {

    /**
     * 实现自己查询逻辑想查全部的
     *
     * @return
     */
    List<Person> myQuery();
}
