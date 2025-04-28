package org.example.ramian_pj.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
    private final JdbcTemplate jdbcTemplate;

    public TestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getNow(){
        return this.jdbcTemplate.queryForObject("select NOW()", String.class);
    }
}
