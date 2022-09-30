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

import com.capg.model.Cart;
import com.capg.service.CartService;

@RestController
@RequestMapping(value = "/cart")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"},allowedHeaders = "*")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addCartToUser/{idUser}")
	Cart addCartToUser(@RequestBody Cart cart, @PathVariable long idUser) {
		return cartService.addCartToUser(cart, idUser);
	}
	
//	public ResponseEntity<Cart> addCartToUser(@RequestBody Cart cart, @PathVariable long idUser){
//		Cart c = cartService.addCartToUser(cart, idUser);
//		return new ResponseEntity<Cart>(c, HttpStatus.CREATED);
		
		
		@DeleteMapping("/deleteCart/{id}")
		void deleteCart(@PathVariable long id) {
			cartService.deleteCart(id);

}
		
		@GetMapping("/findCartsForUser/{idUser}")
		List<Cart> findCartsForUser(@PathVariable long idUser) {
			return cartService.findCartsForUser(idUser);
		}
		@GetMapping("/findCartById/{id}")
		Cart findCartById(@PathVariable long id) {
			return cartService.findCartById(id);
		}
		@DeleteMapping("/removeFromCart/{idCart}/{idUser}")
		void removeFromCart(@PathVariable long idCart, @PathVariable long idUser) {
			cartService.removeFromCart(idCart, idUser);
		}
		
		@GetMapping("/findByCartName/{name}")
		Cart findByCartName(@PathVariable String name) {
			return cartService.findByCartName(name);
		}

}
