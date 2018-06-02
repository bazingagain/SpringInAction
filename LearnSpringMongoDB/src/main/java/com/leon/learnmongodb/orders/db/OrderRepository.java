package com.leon.learnmongodb.orders.db;

import com.leon.learnmongodb.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on 2018/6/2.
 *
 * @author Xiaolei-Peng
 */
public interface OrderRepository extends MongoRepository<Order, String> {
}
