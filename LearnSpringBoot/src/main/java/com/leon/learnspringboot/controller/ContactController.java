package com.leon.learnspringboot.controller;

import com.leon.learnspringboot.model.Contact;
import com.leon.learnspringboot.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created on 15/03/2018.
 *
 * @author Xiaolei-Peng
 */

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object home(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        List<Contact> contacts = contactService.findAllContact(pageNum, pageSize);
        return contactService.findAllContact(pageNum, pageSize);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<Contact> contacts = contactService.findAllContact(0, 3);
        model.put("contacts", contacts);
        return "home";
        //return "redirect:/";
    }


    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int add(Contact contact) {
        return contactService.addContact(contact);
    }
}
