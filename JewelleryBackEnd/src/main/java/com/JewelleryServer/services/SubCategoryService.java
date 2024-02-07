package com.JewelleryServer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JewelleryServer.dao.SubCategoryDao;
@Service
public class SubCategoryService {
	@Autowired
	private SubCategoryDao subCategoryDao;
}
