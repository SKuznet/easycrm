package com.easycrm.service.impl;

import com.easycrm.service.TableAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service("tableAction")
public class TableActionImpl implements TableAction {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String tableCreationStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS dogs");
            jdbcTemplate.execute("create table dogs\n" +
                    "(\n" +
                    "\tid int\n" +
                    "\t\tconstraint dogs_pk\n" +
                    "\t\t\tprimary key,\n" +
                    "\tname varchar(255),\n" +
                    "\tdescription varchar(255)\n" +
                    ");");
        } catch (Exception e) {
            return "failed: " + e.getMessage();
        }
       return "table created";
    }

    @Override
    public Integer getInfo(String name) {
        String sql = "select count(*) from cats where name = :name";
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);
        return this.namedParameterJdbcTemplate.queryForObject(sql,namedParameters, Integer.class);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}
