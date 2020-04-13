package com.cgi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.model.Register;
@Repository
public interface RegisterDao extends CrudRepository<Register,String> {
	Register findByEmailId(String emailId);

	Register findByEmailIdAndPassword(String emailId, String password);
	
}
