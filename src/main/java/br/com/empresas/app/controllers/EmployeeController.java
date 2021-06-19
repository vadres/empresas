package br.com.empresas.app.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresas.app.services.EmployeeService;
import br.com.empresas.data.entities.dto.EmployeeRequest;

@RestController
@PreAuthorize("hasAuthority('admin')")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/employee")
public class EmployeeController {
    
	@Autowired
	private EmployeeService service;

	@GetMapping
	public ResponseEntity<?> list(@RequestParam(name= "name", required = false) String name) {
		var request = new EmployeeRequest();
		request.setName(name);
		
		return ResponseEntity.ok(service.read(request));
	}

	@PostMapping
	public ResponseEntity<?> createCompany(@Valid @RequestBody EmployeeRequest request) throws URISyntaxException {
		service.create(request);
		return ResponseEntity.created(new URI("/api/employee")).build();
	}
	
	@PutMapping
	public ResponseEntity<?> updateCompany(@Valid @RequestBody EmployeeRequest request, @RequestParam(name = "id", required = true) Integer id) {
		request.setId(id);
		service.update(request);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<?> removeCompany(@RequestParam(name = "id", required = true) Integer id) {
		return ResponseEntity.ok(service.delete(id));
	} 
}
