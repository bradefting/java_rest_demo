package com.demoRestApi.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by chansehorton on 2/15/17.
 */

public interface CustomerDao extends CrudRepository<Customer, Long> {

    List<Customer> findAllByOrderByIdAsc();

}
