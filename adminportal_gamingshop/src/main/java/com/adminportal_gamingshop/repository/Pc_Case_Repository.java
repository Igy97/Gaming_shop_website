package com.adminportal_gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminportal_gamingshop.domain.Pc_Case;

@Repository
public interface Pc_Case_Repository extends CrudRepository<Pc_Case, Long> {

}
