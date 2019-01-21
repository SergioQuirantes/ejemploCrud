package com.formacionsergio.ejemploCrud.service;

import java.sql.Date;
import java.util.List;

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
	
	public void saveTODOs(TODO todo) {
		Date sqlDate = new Date(new java.util.Date().getTime());
		
		todo.setCreationDate(sqlDate);
		todo.setModificationDate(sqlDate);
		
		todoRepository.save(todo);
	}
	
	
	public List<TODO> getTODOs(){
		return todoRepository.findAll();
	}
	
	
	public TODO getTODObyId(Long id) {
		
		if(todoRepository.findById(id).isPresent()) {
			return todoRepository.findById(id).get();
		}
		
		return null;		
	}
	
	public void updateTODO(TODO todo, Long id) {
		if(todoRepository.findById(id).isPresent()) {
			TODO todoActualizable = todoRepository.findById(id).get();
			
			todoActualizable.setTitle(todo.getTitle());
			todoActualizable.setDescription(todo.getDescription());
			todoActualizable.setState(todo.getState());
			todoActualizable.setModificationDate(new Date(new java.util.Date().getTime()));
			
			todoRepository.save(todoActualizable);
		}
	}
	
	public void deleteTODOById(Long id) {
		todoRepository.deleteById(id);
	}
	
	
}
