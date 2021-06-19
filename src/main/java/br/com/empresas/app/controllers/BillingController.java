package br.com.empresas.app.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresas.app.services.BillingService;
import br.com.empresas.data.entities.dto.BillingRequest;

@RestController
@PreAuthorize("hasAuthority('admin')")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/billing")
public class BillingController {
	@Autowired
	private BillingService service;
	
	@PostMapping
	public ResponseEntity<?> createBilling(@Valid @RequestBody BillingRequest request) throws URISyntaxException {
		service.create(request);
		return ResponseEntity.created(new URI("/api/company")).build();
	}
}
