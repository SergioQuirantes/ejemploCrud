package com.formacionsergio.ejemploCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionsergio.ejemploCrud.model.TODO;
import com.formacionsergio.ejemploCrud.repository.TODORepository;

@Service("todoService")
public class TODOService {
	
	private TODORepository todoRepository;
	
	@Autowired
	public TODOService(TODORepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public void saveTODO(TODO todo) {
		
		
		
	}
	
}
