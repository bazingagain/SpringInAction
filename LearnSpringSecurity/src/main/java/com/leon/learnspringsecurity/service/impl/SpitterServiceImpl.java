package com.leon.learnspringsecurity.service.impl;

import com.leon.learnspringsecurity.dao.SpitterMapper;
import com.leon.learnspringsecurity.entity.Spitter;
import com.leon.learnspringsecurity.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created on 31/03/2018.
 *
 * @author Xiaolei-Peng
 */

@Service
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterMapper spitterMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return spitterMapper.deleteByPrimaryKey(id);
    }

    /**
     *   采用MD5 或 BCrypt 加密存储,
     * @param record
     * @return
     */
    @Override
    public int insert(Spitter record) {
        //md5
//        MessageDigestPasswordEncoder encoder1 = new MessageDigestPasswordEncoder("md5");
//        record.setPassword(encoder1.encode(record.getPassword()));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(record.getPassword());
        return spitterMapper.insert(record);
    }

    @Override
    public int insertSelective(Spitter record) {
        return 0;
    }
}
