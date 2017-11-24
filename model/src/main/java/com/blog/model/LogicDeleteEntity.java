package com.blog.model;

import javax.persistence.MappedSuperclass;

import com.blog.model.constant.DeleteFlag;

@MappedSuperclass
public class LogicDeleteEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1043208156035273003L;
	
	private DeleteFlag deleteFlag;

	public DeleteFlag getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(DeleteFlag deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
