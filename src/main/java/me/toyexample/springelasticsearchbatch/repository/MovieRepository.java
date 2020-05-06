package me.toyexample.springelasticsearchbatch.repository;

import me.toyexample.springelasticsearchbatch.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
