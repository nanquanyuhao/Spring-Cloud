package net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.dao;

import net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Spring 会为 PersonDao 生成代理类，实现了其父类接口的全部方法
 *
 * Created by nanquanyuhao on 2017/11/26.
 */
public interface PersonDao extends JpaRepository<Person, Integer>, PersonDaoCustom {

    /**
     * 接口直接使用字段名查询
     *
     * @param name
     * @return
     */
    List<Person> name(String name);

    /**
     * 使用And进行属性的共同限制
     *
     * @param name
     * @param age
     * @return
     */
    List<Person> findByNameAndAge(String name, int age);

    /**
     * LessThan 关键字选取某字段小于某值的数据
     *
     * @param age
     * @return
     */
    List<Person> findByAgeLessThan(int age);

    /**
     * 根据名称（第二个字段）进行查询
     *
     * @param name
     * @return
     */
    @Query("select p from Person p where p.name = ?1")
    List<Person> findByPersonName(String name);

    /**
     * 原生 SQL 语句查询
     *
     * @param name
     * @return
     */
    @Query(value = "SELECT * FROM CRA_PERSON WHERE NAME = ?1", nativeQuery = true)
    List<Person> findNativeName(String name);
}
