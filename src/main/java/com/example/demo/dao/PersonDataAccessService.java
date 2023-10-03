package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("mysql")
public class PersonDataAccessService implements PersonDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertPerson(UUID id, Person person) {
        String sql = "insert into persons ( id, name ) values ( ?, ? )";
        List<String> params = new ArrayList<>();
        params.add(id.toString());
        params.add(person.getName());

        return jdbcTemplate.update(sql, params.toArray());
    }

    @Override
    public List<Person> selectAllPeople() {
        String sql = "select * from persons";

        return jdbcTemplate.query(sql, (rs, i) -> {
            UUID id = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        String sql = "select * from persons where id = ?";
        List<String> params = new ArrayList<>();
        params.add(id.toString());
        Person person = jdbcTemplate.queryForObject(
                sql,
                (rs, i) -> {
                    UUID personId = UUID.fromString(rs.getString("id"));
                    String name = rs.getString("name");
                    return new Person(personId, name);
                },
                params.toArray());

        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        String sql = "delete from persons where id = ?";

        return jdbcTemplate.update(sql, id.toString());
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        String sql = "update persons set name = ? where id = ?";
        List<String> params = new ArrayList<>();
        params.add(person.getName());
        params.add(id.toString());

        return jdbcTemplate.update(sql, params.toArray()) ;
    }
}
