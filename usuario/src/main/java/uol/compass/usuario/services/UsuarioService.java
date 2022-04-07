package uol.compass.usuario.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uol.compass.usuario.controller.dto.AnimalDTO;
import uol.compass.usuario.controller.dto.ListaAnimaisDTO;

@Service
public class UsuarioService {

	public void getAnimal(AnimalDTO animalDTO) {

		RestTemplate usuario = new RestTemplate();
		ResponseEntity<ListaAnimaisDTO> exchange =
		usuario.exchange("http://localhost:8081/animais/Especie/" + animalDTO.getEspecie(),
				HttpMethod.GET, null, ListaAnimaisDTO.class);
		
		System.out.println(exchange.getBody().getList());

	}

}
