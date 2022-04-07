package uol.compass.ong.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uol.compass.ong.entities.dto.ResgateDTO;
import uol.compass.ong.enums.Status;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resgate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Resgate;

	@NotNull
	@NotEmpty
	private String endereco;

	@NotNull
	@NotEmpty
	private String caracteristicas_animal;

	private String descricao;

	@NotNull
	@NotEmpty
	private String usuario;

	@Enumerated(EnumType.STRING)
	private Status status;

	public Resgate(ResgateDTO resgateDTO) {
		this.id_Resgate = resgateDTO.getId_resgate();
		this.endereco = resgateDTO.getEndereco();
		this.caracteristicas_animal = resgateDTO.getCaracteristicas_animal();
		this.descricao = resgateDTO.getDescricao();
		this.usuario = resgateDTO.getUsuario();
		this.status = resgateDTO.getStatus();
	}
}
