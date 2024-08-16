package br.com.jorgeramos.place_service.domain;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlaceRepository extends ReactiveCrudRepository <Place, Long>, ReactiveQueryByExampleExecutor<Place>{
    
} 