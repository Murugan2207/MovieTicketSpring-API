package com.movieticketapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieticketapp.model.MoviesList;

public interface MovieRepository extends JpaRepository<MoviesList, Integer> {

	List<MoviesList> findByCategory(String category);

	List<MoviesList> findByLanguage(String language);

	Optional<MoviesList> findByMovieName(String movie_name);

	List<MoviesList> findByRatings(Integer ratings);

}
