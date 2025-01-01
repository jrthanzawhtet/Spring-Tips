package com.spring.dev.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.spring.dev.service.Pet;

@Controller
public class PetsController {
	
	@QueryMapping
	List<Pet> pets(){
		return List.of(
				new Pet("Kit Kit","capuccino"),
				new Pet("Ke Ke", "black")
				);
	}

}
