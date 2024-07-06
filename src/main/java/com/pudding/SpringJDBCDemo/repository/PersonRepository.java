package com.pudding.SpringJDBCDemo.repository;

import com.pudding.SpringJDBCDemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Person person){

        String sql = "insert into person (id,name,tech) values (?,?,?)";
        int rows = template.update(sql,person.getId(),person.getName(),person.getTech());
        System.out.println("Rows affected: " + rows);
    };

    public List<Person> findAll(){
        String sql = "select * from person";

        RowMapper<Person> mapper = ( rs, rowNum) -> {
                Person p = new Person();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setTech(rs.getString(3));
                return p;
        };
        List <Person> personList = template.query(sql,mapper);
        return personList;
    }

}
