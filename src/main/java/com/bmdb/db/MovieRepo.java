package com.bmdb.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bmdb.business.*;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
	List<Movie> findByRating(String rating);
}
