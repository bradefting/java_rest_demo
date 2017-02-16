package com.demoRestApi.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by chansehorton on 2/15/17.
 */

public interface AddressDao extends CrudRepository<Address, Long> {

    List<Address> findAllByOrderByIdAsc();

}

