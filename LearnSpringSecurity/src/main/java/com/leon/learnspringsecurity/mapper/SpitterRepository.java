package com.leon.learnspringsecurity.mapper;

import com.leon.learnspringsecurity.entity.Spitter;
import org.springframework.stereotype.Repository;

/**
 * Created on 30/03/2018.
 *
 * @author Xiaolei-Peng
 */

@Repository
public class SpitterRepository {

    //TODO
    public Spitter findByUsername(String username) {
        return new Spitter();
    }
}
