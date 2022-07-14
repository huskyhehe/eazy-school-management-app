package com.huksyhehe.easyschool.repository;

import com.huksyhehe.easyschool.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class HolidayRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HolidayRepository(JdbcTemplate jdbcTemple) {
        this.jdbcTemplate = jdbcTemple;
    }

    public List<Holiday> findAllHolidays() {
        String sql = "SELECT * FROM HOLIDAYS";
        var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
}
