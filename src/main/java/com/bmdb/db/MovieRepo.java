package com.bmdb.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bmdb.business.*;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
