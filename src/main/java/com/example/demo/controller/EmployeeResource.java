package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;


@Controller //used to define a controller and to 
//indicate that the return value of the methods should be be bound to the web response body.
@RequestMapping("/api") //declares that all Apis’ url in the controller will start with /api.
public class EmployeeResource {

	@Autowired  //to inject EmployeeRepository bean to local variable.
	private EmployeeRepository employeeRepository;

	@GetMapping("/index")
	public String index() {
		return "index";
	}


	@GetMapping("/listemployees")
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", employeeRepository.findAll());
		return "index";
	}

	@GetMapping("/addnew")
	public String addNew(Employee employee) {
		return "add-employee";
	}

	@PostMapping("/addemployee")
	public String addEmployee(Employee employee,Model model) {
		employeeRepository.save(employee);
		model.addAttribute("employees", employeeRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") long id, Model model) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
		model.addAttribute("employee", employee);

		return "update-employee";
	}

	@PostMapping("/updateemployee/{id}")
	public String updateEmployee(@PathVariable("id") long id,Employee employee,Model model) {
		Optional<Employee> employeeData = employeeRepository.findById(id);
		if (employeeData.isPresent()) {
			Employee _employee = employeeData.get();
			_employee.setFirstName(employee.getFirstName());
			_employee.setLastName(employee.getLastName());
			employeeRepository.save(_employee);
		}
		model.addAttribute("employees", employeeRepository.findAll());
		return "index";
	}	

	@GetMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable("id") long id,Model model) {
		employeeRepository.deleteById(id);
		model.addAttribute("employees", employeeRepository.findAll());
		return "index";
	}

	@DeleteMapping("/deleteemployees")
	public String deleteAllEmployees(Model model) {
		employeeRepository.deleteAll();
		model.addAttribute("employees", employeeRepository.findAll());
		return "index";
	}
}
