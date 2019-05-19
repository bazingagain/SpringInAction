package com.charlie.controller;

import com.charlie.entity.Result;
import com.charlie.mapper.test1.Result1Mapper;
import com.charlie.mapper.test2.Result2Mapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @Autowired
    private Result1Mapper result1Mapper;

    @Autowired
    private Result2Mapper result2Mapper;

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("getResult1")
    public Result getResult1(Long id) {
        return result1Mapper.getResultById(id);
    }

    @RequestMapping("getResult2")
    public Result getResult2(Long id) {
        return result2Mapper.getResultById2(id);
    }
}
