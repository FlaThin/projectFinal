package com.example.demo.repository;

import com.example.demo.model.EnfermeiroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnfermeiroRepository extends CrudRepository<EnfermeiroEntity, Long> {

}
