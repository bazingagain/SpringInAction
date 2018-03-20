package com.leon.springmail.bean;

/**
 * Created on 20/03/2018.
 *
 * @author Xiaolei-Peng
 */
public class MailContent {
    public MailContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;
}
