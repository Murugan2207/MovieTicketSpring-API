package com.movieticketapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketapp.model.MoviesList;

import com.movieticketapp.repository.MovieRepository;

@RestController
public class MovieController {
	@Autowired
	MovieRepository movieRepository;

	@PostMapping("movies/save") // register
	public MoviesList save(@RequestBody MoviesList moviesList) {
		movieRepository.save(moviesList);
		return moviesList;
	}

	@GetMapping("movies/list")
	public List<MoviesList> findAll() {
		List<MoviesList> movieslist = movieRepository.findAll();
		return movieslist;
	}

	@GetMapping("movies/findById/{movie_id}")
	public MoviesList findById(@PathVariable("movie_id") Integer movie_id) {
		Optional<MoviesList> moviesList = movieRepository.findById(movie_id);
		if (moviesList.isPresent()) {
			MoviesList movieObj = moviesList.get();
			return movieObj;
		} else {
			return null;
		}

	}

	@GetMapping("movies/findBycategory/{category}")
	public List<MoviesList> findByCategory(@PathVariable("category") String category) {
		List<MoviesList> moviesList = movieRepository.findByCategory(category);
		return moviesList;

	}

	@GetMapping("movies/findByLanguage/{language}")
	public List<MoviesList> findByLanguages(@PathVariable("language") String language) {
		List<MoviesList> moviesList = movieRepository.findByLanguage(language);
		return moviesList;
	}
	@GetMapping("movies/findByMovieName/{movie_name}")
	public MoviesList findByMovieName(@PathVariable("movie_name") String movie_name) {
		Optional<MoviesList> moviesList = movieRepository.findByMovieName(movie_name);
		if (moviesList.isPresent()) {
			MoviesList movieObj = moviesList.get();
			return movieObj;
		} else {
			return null;
		}
	}
		@GetMapping("movies/findByRatings/{ratings}")
		public List<MoviesList> findByRatings(@PathVariable("ratings") Integer ratings) {
			List<MoviesList> moviesList = movieRepository.findByRatings(ratings);
			return moviesList;
		}
}

