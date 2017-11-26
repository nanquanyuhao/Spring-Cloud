package net.nanquanyuhao.cloud.dao;

import net.nanquanyuhao.cloud.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by nanquanyuhao on 2017/11/26.
 */
public interface PersonDao extends MongoRepository<Person, String>, PersonDaoCustom {

    /**
     * 按照名称字段进行查询，类似于JPA
     *
     * @param name
     * @return
     */
    List<Person> name(String name);

    /**
     * 使用 MongDB 的 Query进行查询
     *
     * @param name
     * @param age
     * @return
     */
    @Query(value = "{'name' : ?0, 'age' : ?1}", fields = "{'name' : 1}")
    List<Person> findByNameAndAge(String name, int age);
}
