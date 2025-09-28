package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.*;

@Repository
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder,Integer>{
      public List<CustomerOrder> findCustomerOrderByCustomerId(int customerId);
}
