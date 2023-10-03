package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TableCreator implements ApplicationRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createTable();
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS persons (" +
                "id VARCHAR(36) NOT NULL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL" +
                ")";
        jdbcTemplate.execute(sql);
    }
}
