package com.example.demo;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void insertDataTest() {
		String sql = "INSERT INTO persons ( id, name ) VALUES ( ?, ? )";
		List<String> params = new ArrayList<>();
		String id = UUID.randomUUID().toString();
		String name = "Pole";
		params.add(id);
		params.add(name);

		jdbcTemplate.update(sql, params.toArray());
	}

	@Test
	void selectPersonById() {
		String sql = "SELECT * FROM persons WHERE id = '593a895-90e4-479d-ab95-65a2d749b92b'";
		Person person = jdbcTemplate.queryForObject(
				sql,
				(rs, i) -> {
					UUID personId = UUID.fromString(rs.getString("id"));
					String name = rs.getString("name");
					return new Person(personId, name);
				});
		System.out.println(person);

	}
}
