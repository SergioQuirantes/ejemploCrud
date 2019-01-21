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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "controladorTodo", tags = { "controladorCrud" })
public class CrudController {

	@Autowired
	private TODOService todoService;

	@ApiOperation(value = "Se muestra una lista de todas las tareas TODO", response = List.class)
	@RequestMapping(value = "/TODO", method = RequestMethod.GET)
	public List<TODO> getTODOs() {
		return todoService.getTODOs();
	}

	@ApiOperation(value = "Devuelve una tarea TODO por el ID indicado en el path", response = TODO.class)
	@RequestMapping(value = "/TODO/{id}", method = RequestMethod.GET)
	public TODO getTODOById(@PathVariable("id") @ApiParam(value = "ID de la tarea solicitada") Long id) {
		return todoService.getTODObyId(id);
	}

	@ApiOperation(value = "Añade una nueva tarea TODO especificada en el cuerpo de la petición (title, description, state)")
	@RequestMapping(value = "/TODO", method = RequestMethod.POST)
	public void saveTODO(
			@RequestBody @ApiParam(value = "cuerpo de la peticion. Solo debe incluir title, description y state") TODO cuerpo) {
		todoService.saveTODOs(cuerpo);
	}

	@ApiOperation(value = "Actualiza una tarea TODO con la información del cuerpo de la petición")
	@RequestMapping(value = "/TODO/{id}", method = RequestMethod.PATCH)
	public void updateTODO(@PathVariable("id") @ApiParam(value = "ID de la tarea a actualizar") Long id,
			@RequestBody @ApiParam(value = "cuerpo de la peticion. Solo debe incluir title, description y state") TODO cuerpo) {
		todoService.updateTODO(cuerpo, id);
	}

	@ApiOperation(value = "Elimina la tarea TODO por el ID indicado en el path")
	@RequestMapping(value = "/TODO/{id}", method = RequestMethod.DELETE)
	public void deleteTODOById(@PathVariable("id") @ApiParam(value = "ID de la tarea a eliminar") Long id) {
		todoService.deleteTODOById(id);
	}
}
