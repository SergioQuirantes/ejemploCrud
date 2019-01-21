package com.formacionsergio.ejemploCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formacionsergio.ejemploCrud.model.TODO;
import com.formacionsergio.ejemploCrud.service.TODOService;

@RestController
public class CrudController {

	@Autowired
	private TODOService todoService;
	
	
	@RequestMapping(value = "/TODO", method = RequestMethod.GET)
	public List<TODO> getTODOs() {
		return todoService.getTODOs();
	}
	
	@RequestMapping(value = "/TODO/{id}", method = RequestMethod.GET)
	public TODO getTODOById(@PathVariable("id") Long id) {
		return todoService.getTODObyId(id);
	}
	
	@RequestMapping(value = "/TODO", method = RequestMethod.POST)
	public void saveTODO(@RequestBody TODO cuerpo) {
		todoService.saveTODOs(cuerpo);
	}
	
	@RequestMapping(value = "/TODO/{id}", method = RequestMethod.PATCH)
	public void updateTODO(@PathVariable("id") Long id, @RequestBody TODO cuerpo) {
		todoService.updateTODO(cuerpo, id);
	}
	
	@RequestMapping(value = "/TODO/{id}", method = RequestMethod.DELETE)
	public void deleteTODOById(@PathVariable("id") Long id) {
		todoService.deleteTODOById(id);
	}
}
