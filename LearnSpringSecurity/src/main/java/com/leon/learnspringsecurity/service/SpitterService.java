package com.leon.learnspringsecurity.service;

import com.leon.learnspringsecurity.entity.Spitter;

/**
 * Created on 31/03/2018.
 *
 * @author Xiaolei-Peng
 */
public interface SpitterService {
    int deleteByPrimaryKey(Integer id);

    int insert(Spitter record);

    int insertSelective(Spitter record);

}
