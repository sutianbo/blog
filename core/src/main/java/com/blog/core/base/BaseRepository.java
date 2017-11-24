package com.blog.core.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T, ID>,QueryDslPredicateExecutor<T>{
	
	 List<T> findAll(Predicate predicate);
	 
	 List<T> findAll(Predicate predicate, Sort sort);
	 
	 List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);
	 
	 List<T> findAll(OrderSpecifier<?>... orders);
}
