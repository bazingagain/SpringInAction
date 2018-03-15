package com.leon.learnspringboot.service;

import com.leon.learnspringboot.model.Contact;

import java.util.List;

/**
 * Created on 15/03/2018.
 *
 * @author Xiaolei-Peng
 */
public interface ContactService {
    int addContact(Contact contact);
    List<Contact> findAllContact(int pageNum, int pageSize);
}
