package eus.birt.dam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Driver;
import eus.birt.dam.repository.DriverRepository;
import eus.birt.dam.repository.TeamRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/drivers")
public class DriverController {

	@Autowired
	DriverRepository driverRepository;
	
	@Autowired
	TeamRepository teamRepository;
		
	@GetMapping({"/",""})
	public List <Driver> index() {
		return driverRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Driver show(@PathVariable("id") Long id) {
		return driverRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Driver create(@RequestBody Driver driver) {
		return driverRepository.save(driver);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Driver update(@RequestBody Driver driver, @PathVariable("id") Long id) {
		Driver tempDriver = driverRepository.findById(id).orElse(null);
		
		tempDriver.setFirstName(driver.getFirstName());
		tempDriver.setLastName(driver.getLastName());
		tempDriver.setBirthDate(driver.getBirthDate());
		tempDriver.setNationality(driver.getNationality());
		tempDriver.setTeam(driver.getTeam());
		
		return driverRepository.save(tempDriver);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		driverRepository.deleteById(id);
	}
	
}