package com.blog.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.core.base.BaseRepository;
import com.blog.model.User;
import com.blog.model.dto.UserModel;


@Repository
public interface UserRepository extends BaseRepository<User, Long>{
	
	User findByUsername(@Param("username")String username);

	@Query(value = "select new com.blog.model.dto.UserModel(username,password) from User where username =:username")
	UserModel findDtoByUsername(@Param("username")String username);
}
