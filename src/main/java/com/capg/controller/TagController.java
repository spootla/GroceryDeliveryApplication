package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dao.TagDao;
import com.capg.model.Product;
import com.capg.model.Tag;
import com.capg.service.TagService;

@RestController
@RequestMapping(value = "/tag")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"},allowedHeaders = "*")
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private TagDao tagDao;

	@PostMapping("/addTagToProduct/{idProduct}/{idTag}")
	void addTagToProduct(@PathVariable long idProduct, @PathVariable long idTag) {
		tagService.addTagToProduct(idProduct, idTag);
	}

	@GetMapping("/findTagsForProduct/{idProduct}")
	List<Tag> findTagsForProduct(@PathVariable long idProduct) {
		return tagService.findTagsForProduct(idProduct);
	}
	
	@GetMapping("/findAllTags")
	List<Tag> findAllTags() {
		return tagService.findAllTags();
	}

	@DeleteMapping("/deleteTagFromProduct")
	void deleteTagFromProduct(@PathVariable long idTag, @PathVariable long idProduct) {
		tagService.deleteTagFromProduct(idTag, idProduct);
	}
 
	@PostMapping("/addTag")
	Tag addTag(@RequestBody Tag tag) {
		return tagService.addTag(tag);
	}

	@DeleteMapping("/deleteTag/{id}")
	void deleteTag(@PathVariable long id) {
		tagService.deleteTag(id);
	}

	@GetMapping("/findTagById/{id}")
	Tag findTagById(@PathVariable long id) {
		return tagService.findTagById(id);
	}
	@GetMapping("/findAllTagByName/{name}")
	List<Tag> findAllTagByName(@PathVariable String name) {
		return tagDao.findByName("%" + name + "%");
	}
	
	@GetMapping("/findProductsForTag/{idTag}")
	List<Product> findProductsForTag(@PathVariable long idTag) {
		return tagService.findProductsForTag(idTag);
	}

	
	

}
