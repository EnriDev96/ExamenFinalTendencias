package com.ista.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.model.Restaurante;

public interface RestauranteRepository  extends MongoRepository<Restaurante, Long>{
	

}
