package com.leon.learnspringboot.mapper;

import com.leon.learnspringboot.model.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
//@Mapper
public interface ContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer id);

    List<Contact> selectAllContact();

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);
}