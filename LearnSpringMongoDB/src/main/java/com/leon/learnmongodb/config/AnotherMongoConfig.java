package com.leon.learnmongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created on 2018/6/2.
 *
 * @author Xiaolei-Peng
 */

@Configuration
@EnableMongoRepositories("orders.db")
public class AnotherMongoConfig {
}
