package ubs.com.br.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/v1")
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class CalculoController {

	

@ApiOperation(value = "View a list of available employees", response = List.class)
@GetMapping ("/exemplo")
public List < String > getAllEmployees() {
    return null;
}
}
