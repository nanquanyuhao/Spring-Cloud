package net.nanquanyuhao.cloud.dao.impl;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import net.nanquanyuhao.cloud.dao.PersonDaoCustom;
import net.nanquanyuhao.cloud.entity.Person;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的查询方法
 * Created by nanquanyuhao on 2017/11/26.
 */
public class PersonDaoImpl implements PersonDaoCustom {
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Person> myQuery() {

        return mongoTemplate.execute(Person.class, new CollectionCallback<List<Person> >() {

            public List<Person> doInCollection(DBCollection collection) throws MongoException, DataAccessException {

                DBCursor cursor = collection.find();
                List<Person> result = new ArrayList<Person>();
                while(cursor.hasNext()) {
                    DBObject source = cursor.next();
                    Person p = new Person();
                    ObjectId objectId = (ObjectId)source.get("_id");
                    p.setId(objectId.toHexString());
                    p.setAge((Integer) source.get("age"));
                    p.setName((String) source.get("name"));
                    p.setCompany((String) source.get("company"));
                    result.add(p);
                }

                return result;
            }
        });
    }
}
