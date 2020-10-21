package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepo;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController 
{
	@Autowired
	private ActorRepo actorRepo;
	
	// List all Actors
	@GetMapping("/")
	public List<Actor> getAllActors() {
		return actorRepo.findAll();
	}
	
	// Get a Actor by id
	@GetMapping("/{id}")
	public Optional<Actor> getActor(@PathVariable int id) {
		Optional<Actor> m = actorRepo.findById(id);
		if(m.isPresent())
		{
			return m;
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found");
	}
	// Add a Actor
	@PostMapping("/")
	public Actor addActor(@RequestBody Actor p)
	{
		if(p != null)
			return actorRepo.save(p);
		else
		{
			System.out.println("No actor given");
			return null;
		}
	}
	
	// Edit a Actor
	@PutMapping("/")
	public Actor updateActor(@RequestBody Actor p)
	{
		if(p != null)
			return actorRepo.save(p);
		else
		{
			System.out.println("No actor given");
			return null;
		}
	}
	
	// Delete a Actor
	@DeleteMapping("/")
	public Actor deleteActor(@RequestBody Actor p)
	{
		if(p != null)
			actorRepo.delete(p);
		else
			System.out.println("No Actor given");
		
		return p;
	}
}