package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Credit;
import com.bmdb.db.CreditRepo;

@CrossOrigin
@RestController
@RequestMapping("/credits")
public class CreditController 
{
	@Autowired
	private CreditRepo creditRepo;
	
	// List all Credits
	@GetMapping("/")
	public List<Credit> getAllCredits() {
		return creditRepo.findAll();
	}
	
	// Get a Credit by id
	@GetMapping("/{id}")
	public Optional<Credit> getCredit(@PathVariable int id) {
		Optional<Credit> m = creditRepo.findById(id);
		if(m.isPresent())
		{
			return m;
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Credit not found");
	}
	// Add a Credit
	@PostMapping("/")
	public Credit addCredit(@RequestBody Credit p)
	{
		if(p != null)
			return creditRepo.save(p);
		else
		{
			System.out.println("No credit given");
			return null;
		}
	}
	
	// Edit a Credit
	@PutMapping("/")
	public Credit updateCredit(@RequestBody Credit p)
	{
		if(p != null)
			return creditRepo.save(p);
		else
		{
			System.out.println("No credit given");
			return null;
		}
	}
	
	// Delete a Credit
	@DeleteMapping("/")
	public Credit deleteCredit(@RequestBody Credit p)
	{
		if(p != null)
			creditRepo.delete(p);
		else
			System.out.println("No Credit given");
		
		return p;
	
	}
}