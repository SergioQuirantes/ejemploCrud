package com.formacionsergio.ejemploCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.formacionsergio.ejemploCrud.service.TODOService;

@RestController
public class CrudController {

	@Autowired
	private TODOService todoService;
	
	
	
}
