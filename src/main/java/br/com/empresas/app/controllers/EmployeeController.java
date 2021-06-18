package br.com.empresas.app.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAuthority('admin')")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/employee")
public class EmployeeController {

}
