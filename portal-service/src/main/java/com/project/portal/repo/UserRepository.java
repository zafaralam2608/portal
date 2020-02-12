package com.project.portal.repo;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.project.portal.model.User;

public interface UserRepository extends SolrCrudRepository<User,String> {

}
