package com.project.portal.server.repo;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.project.portal.server.model.User;

public interface UserRepository extends SolrCrudRepository<User,String> {

}
