package com.leon.learnmongodb.orders.db.impl;

import com.leon.learnmongodb.model.Order;
import com.leon.learnmongodb.orders.db.extend.OrderOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created on 2018/6/2.
 *
 * @author Xiaolei-Peng
 */
public class OrderRepositoryStuff implements OrderOperations {

    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Order> findOrderByType(String t) {
        String type = t.equals("NET") ? "WEB" : t;
        Criteria where = Criteria.where("type").is(t);
        Query query = Query.query(where);
        return mongo.find(query, Order.class);
    }
}
