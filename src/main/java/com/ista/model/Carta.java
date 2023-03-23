package com.ista.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "carta")
@Data
public class Carta {
	
	@Id
	private Long  id_carta;
	
	private String nombre;
	
	private String categoria;
	
	private int cantidad;
	
	private List<Plato> listPlato;
}
