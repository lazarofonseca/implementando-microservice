package uol.compass.usuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uol.compass.usuario.controller.dto.AnimalDTO;
import uol.compass.usuario.services.UsuarioService;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void consultaAnimal(@RequestBody AnimalDTO animalDTO) {
		//System.out.println(animalDTO.getEspecie());
		usuarioService.getAnimal(animalDTO);
		
		System.out.println("Olá ");
	}

}
