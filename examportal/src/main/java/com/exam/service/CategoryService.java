package com.exam.service;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.exam.dto.CategoryDTO;
import com.exam.exception.CategoryAlreadyExistsException;
import com.exam.exception.CategoryNotFoundException;
import com.exam.model.Category;

public interface CategoryService {
	public Category addCategory(CategoryDTO category)throws CategoryAlreadyExistsException;
	public void updateCategory(Long categoryId,String title) throws CategoryNotFoundException;
	public Set<Category> getCategories();
	public CategoryDTO getCategory(Long cid)throws CategoryNotFoundException;
	public void deleteCategory(long categoryId);

}
