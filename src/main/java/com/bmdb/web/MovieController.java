package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Actor;
import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController 
{
	@Autowired
	private MovieRepo movieRepo;
	
	// List all Movies
	@GetMapping("/")
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}
	
	// List all Movies for a rating
	@GetMapping("")
	public List<Movie> getAllMoviesByRating(@RequestParam String rating) {
		return movieRepo.findByRating(rating);
	}
	
	// Get a Movie by id
	@GetMapping("/{id}")
	public Optional<Movie> getMovie(@PathVariable int id) {
		Optional<Movie> m = movieRepo.findById(id);
		if(m.isPresent())
		{
			return m;
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
	}
	// Add a Movie
	@PostMapping("/")
	public Movie addMovie(@RequestBody Movie p)
	{
		if(p != null)
			return movieRepo.save(p);
		else
		{
			System.out.println("No movie given");
			return null;
		}
	}
	
	// Edit a Movie
	@PutMapping("/")
	public Movie updateMovie(@RequestBody Movie p)
	{
		if(p != null)
			return movieRepo.save(p);
		else
		{
			System.out.println("No movie given");
			return null;
		}
	}
	
	// Delete a Movie
	@DeleteMapping("/")
	public Movie deleteMovie(@RequestBody Movie p)
	{
		if(p != null)
			movieRepo.delete(p);
		else
			System.out.println("No Movie given");
		
		return p;
	}
}