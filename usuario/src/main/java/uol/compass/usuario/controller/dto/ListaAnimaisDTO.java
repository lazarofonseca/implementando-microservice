package uol.compass.usuario.controller.dto;

import java.io.Serializable;
import java.util.List;

public class ListaAnimaisDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<ListaAnimaisDTO> list;

	public List<ListaAnimaisDTO> getList() {
		return list;
	}

	public void setList(List<ListaAnimaisDTO> list) {
		this.list = list;
	}
	
	

}
