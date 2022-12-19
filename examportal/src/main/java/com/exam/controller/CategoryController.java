package com.exam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import com.exam.dto.CategoryDTO;
import com.exam.dto.UserDTO;
import com.exam.exception.CategoryAlreadyExistsException;
import com.exam.exception.CategoryNotFoundException;
import com.exam.model.Category;
import com.exam.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private Environment environment;
	
@PostMapping("/")
public ResponseEntity<String> addCategory(@RequestBody CategoryDTO category) throws CategoryAlreadyExistsException{
		Category categoryId = categoryService.addCategory(category);
      return new ResponseEntity<String>("API.INSERT_CREATED", HttpStatus.CREATED);

	}
	
	@GetMapping("/{cid}")
	public CategoryDTO getCategory(@PathVariable("cid")Long cid) throws CategoryNotFoundException {
		CategoryDTO category=categoryService.getCategory(cid);
		return category;

	}
	
	@GetMapping("/")
	public ResponseEntity<?> getCategories()
	{
		return ResponseEntity.ok(this.categoryService.getCategories());
		
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<String> updateCategory(@PathVariable Long categoryId ,@RequestBody CategoryDTO category) throws CategoryNotFoundException{
		categoryService.updateCategory(categoryId,category.getTitle());
		return new ResponseEntity<>("Records are updated",HttpStatus.OK);
	
	}
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") long categoryId) 
		{
			this.categoryService.deleteCategory(categoryId);
		}
	}

