package com.leon.learnspringsecurity.entity;

/**
 * Created on 30/03/2018.
 *
 * @author Xiaolei-Peng
 *
 */
public class Spitter {
        private Integer id;

    private String username;

        private String password;

    public Spitter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Spitter(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username == null ? null : username.trim();
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password == null ? null : password.trim();
        }
}
