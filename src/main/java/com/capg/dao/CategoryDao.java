package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Category;

public interface CategoryDao extends JpaRepository<Category, Long>  {


}
