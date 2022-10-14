package com.trantor.jdbc.repo;

import com.trantor.jdbc.entity.Customer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


public interface CustomerRepo {
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer getById(int id);
    String deleteBYID(int id);

    List<Customer> allCustomer();
}
