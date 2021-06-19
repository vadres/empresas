package br.com.empresas.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresas.app.services.CompanyBalanceService;
import br.com.empresas.data.entities.dto.CompanyRequest;

@RestController
@PreAuthorize("hasAuthority('admin')")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/company/balance")
public class CompanyBalanceController {
	@Autowired
	private CompanyBalanceService service;

	@GetMapping
	public ResponseEntity<?> list(@RequestParam(name= "id", required = true) Integer id) {
		var request = new CompanyRequest();
		request.setId(id);
		
		return ResponseEntity.ok(service.read(request));
	}

}
