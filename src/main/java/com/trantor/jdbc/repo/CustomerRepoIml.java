package com.trantor.jdbc.repo;

import com.trantor.jdbc.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepoIml implements CustomerRepo {



    private static final String INSERT_USER_QUERY = "INSERT INTO Customer_tbl(custId, custName, custProd, prodPrize) values(?, ?, ?, ?)";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE Customer_tbl SET custName=? WHERE custId=?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM Customer_tbl WHERE custId = ? ";
    private static final String DELETE_USER_BY_ID = "DELETE FROM Customer_tbl WHERE custId=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM Customer_tbl";

    @Autowired
    private JdbcTemplate jdbcTemplate;

@Override
    public Customer saveCustomer(Customer customer) {
     jdbcTemplate.update(INSERT_USER_QUERY, customer.getCustId(), customer.getCustName(), customer.getCustProd(), customer.getProdPrize());
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, customer.getCustName(), customer.getCustId());
        return customer;
    }

    @Override
    public Customer getById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
            return new Customer(rs.getInt("custId"), rs.getString("custName"), rs.getString("custProd"), rs.getLong("prodPrize"));
        });
    }

    @Override
    public String deleteBYID(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "User got deleted with id" + id;
    }

    @Override
    public List<Customer> allCustomer() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new Customer(rs.getInt("custId"), rs.getString("custName"), rs.getString("custProd"), rs.getLong("prodPrize"));
        });
    }
}
