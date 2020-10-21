package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public Optional getActor(@PathVariable int id) {
		Optional<Actor> m = actorRepo.findById(id);
		return m;
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
	public void deleteActor(@RequestBody Actor p)
	{
		if(p != null)
			actorRepo.delete(p);
		else
			System.out.println("No Actor given");
	}
}