package com.atakancoban.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.atakancoban.model.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

	
	@Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
	List<User> getByCustomerQuery(String search);
	
	List<User> findByNameLikeOrSurnameLike(String name,String surname);

}
