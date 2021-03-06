package training360.employeewebapp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> listEmployeeNames() {
        return jdbcTemplate.query("select name from employee order by name",
                (rs, i) -> rs.getString("name"));
    }

    public void createEmployee(String name) {
        jdbcTemplate.update("insert into employee(name) values (?)", name);
    }
}
