package com.JewelleryServer.pojo;

import javax.persistence.Column;


public class Category {
	@Column(name="c_id")
    private int cid;
	
	private String cname;
    
}
