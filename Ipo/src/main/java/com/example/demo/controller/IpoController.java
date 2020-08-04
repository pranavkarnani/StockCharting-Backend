package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Ipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.IpoService;

@RestController
@RequestMapping("/ipo")
public class IpoController {

	@Autowired
	IpoService iposervice;

	@GetMapping("/")
	public List<Ipo> getIpo(){
		return iposervice.getIpo();
	}
	
	@PostMapping("/add")
	public void insertIpo(@RequestBody Ipo user) {
		iposervice.saveIpo(user);
	}

	@GetMapping("/{id}")
	public Optional<Ipo> getIpo(@PathVariable Long id) {
		return iposervice.getByIpoId(id);
	}

	@PutMapping("/update")
	public HttpStatus updateStudent(@RequestBody Ipo student) {
		return iposervice.updateIpo(student)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}
