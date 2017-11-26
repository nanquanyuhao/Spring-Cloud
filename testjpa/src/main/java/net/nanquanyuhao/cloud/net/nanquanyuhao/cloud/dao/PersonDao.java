package net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.dao;

import net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring 会为 PersonDao 生成代理类，实现了其父类接口的全部方法
 *
 * Created by nanquanyuhao on 2017/11/26.
 */
public interface PersonDao extends JpaRepository<Person, Integer>, PersonDaoCustom {

}
