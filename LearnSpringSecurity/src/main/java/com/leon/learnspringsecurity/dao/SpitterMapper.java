package com.leon.learnspringsecurity.dao;
import com.leon.learnspringsecurity.entity.Spitter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpitterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Spitter record);

    int insertSelective(Spitter record);

    Spitter selectByPrimaryKey(Integer id);

    Spitter findByUsername(String username);

    int updateByPrimaryKeySelective(Spitter record);

    int updateByPrimaryKey(Spitter record);


}