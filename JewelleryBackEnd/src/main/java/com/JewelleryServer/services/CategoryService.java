package com.JewelleryServer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JewelleryServer.dao.CategoryDao;
@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
}
