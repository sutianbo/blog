package com.blog.core.base;

import com.blog.core.constant.DeleteFlag;

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
