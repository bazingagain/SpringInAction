package com.leon.learnspringboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.leon.learnspringboot.mapper.ContactMapper;
import com.leon.learnspringboot.model.Contact;
import com.leon.learnspringboot.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 15/03/2018.
 *
 * @author Xiaolei-Peng
 */

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public int addContact(Contact contact) {
        return contactMapper.insert(contact);
    }

    @Override
    public List<Contact> findAllContact(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return contactMapper.selectAllContact();
    }
}
