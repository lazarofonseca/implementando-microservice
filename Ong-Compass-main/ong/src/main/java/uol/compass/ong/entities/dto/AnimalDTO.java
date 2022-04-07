package uol.compass.ong.entities.dto;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;
import uol.compass.ong.entities.Animal;
import uol.compass.ong.enums.Porte;
import uol.compass.ong.enums.Sexo;

@Getter
@Setter
public class AnimalDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Long id_animal;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Enumerated(EnumType.STRING)
	private Porte porte;
	
	private Integer idade;
	private String raca;
	private String especie;
	
	public AnimalDTO() {}
	
	public AnimalDTO(Animal animalObj) {
		this.id_animal = animalObj.getId_animal();
		this.id_animal = animalObj.getId_animal();
		this.sexo = animalObj.getSexo();
		this.porte = animalObj.getPorte();
		this.idade = animalObj.getIdade();
		this.raca = animalObj.getRaca();
		this.especie = animalObj.getEspecie();
	}
}
