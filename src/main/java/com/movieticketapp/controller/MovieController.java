package com.movieticketapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketapp.model.Movies;

import com.movieticketapp.repository.MovieRepository;

@RestController
public class MovieController {
	@Autowired
	MovieRepository movieRepository;

	@PostMapping("movies/save") // register
	public Movies save(@RequestBody Movies moviesList) {
		movieRepository.save(moviesList);
		return moviesList;
	}

	@GetMapping("movies/list")
	public List<Movies> findAll() {
		List<Movies> movieslist = movieRepository.findAll();
		return movieslist;
	}

	@GetMapping("movies/findById/{movie_id}")
	public Movies findById(@PathVariable("movie_id") Integer movie_id) {
		Optional<Movies> moviesList = movieRepository.findById(movie_id);
		if (moviesList.isPresent()) {
			Movies movieObj = moviesList.get();
			return movieObj;
		} else {
			return null;
		}

	}

	@GetMapping("movies/findBycategory/{category}")
	public List<Movies> findByCategory(@PathVariable("category") String category) {
		List<Movies> moviesList = movieRepository.findByCategory(category);
		return moviesList;

	}

	@GetMapping("movies/findByLanguage/{language}")
	public List<Movies> findByLanguages(@PathVariable("language") String language) {
		List<Movies> moviesList = movieRepository.findByLanguage(language);
		return moviesList;
	}

	@GetMapping("movies/findByMovieName/{movie_name}")
	public Movies findByMovieName(@PathVariable("movie_name") String movie_name) {
		Optional<Movies> moviesList = movieRepository.findByMovieName(movie_name);
		if (moviesList.isPresent()) {
			Movies movieObj = moviesList.get();
			return movieObj;
		} else {
			return null;
		}
	}

	@GetMapping("movies/findByRatings/{ratings}")
	public List<Movies> findByRatings(@PathVariable("ratings") Integer ratings) {
		List<Movies> moviesList = movieRepository.findByRatings(ratings);
		return moviesList;
	}
	@DeleteMapping("movies/delete/{movie_id}")
	public void delete(@PathVariable("movie_id") Integer movie_id) {
		movieRepository.deleteById(movie_id);
	}
	@PutMapping("movies/update/{movie_id}")
	public void update(@PathVariable("movie_id") Integer id, @RequestBody Movies movies) {
		System.out.println("Successfully updated");
		movies.setId(id);
		movieRepository.save(movies);
	}
}
