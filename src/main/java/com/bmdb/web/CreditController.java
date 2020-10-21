package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public Optional getCredit(@PathVariable int id) {
		Optional<Credit> m = creditRepo.findById(id);
		return m;
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
	public void deleteCredit(@RequestBody Credit p)
	{
		if(p != null)
			creditRepo.delete(p);
		else
			System.out.println("No Credit given");
	}
}