package com.blog.core.base;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BaseRespositoryImpl<T, ID extends Serializable> extends QueryDslJpaRepository<T, ID>
		implements BaseRepository<T, ID> {

	private final EntityManager em;
	
	public BaseRespositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}
}
