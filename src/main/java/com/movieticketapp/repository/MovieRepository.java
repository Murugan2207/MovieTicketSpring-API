package com.movieticketapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieticketapp.model.Movies;


public interface MovieRepository extends JpaRepository<Movies, Integer> {

	List<Movies> findByCategory(String category);

	List<Movies> findByLanguage(String language);

	Optional<Movies> findByMovieName(String movie_name);

	List<Movies> findByRatings(Integer ratings);

}
