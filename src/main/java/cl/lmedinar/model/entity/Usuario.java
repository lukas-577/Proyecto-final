package cl.lmedinar.model.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	private String contrasenia;
	private String urlImagen;
	private String nombre;
	private Integer rut;
	private Rol rol;
//	@OneToMany(mappedBy="codigo")
//	
//	private List<Imagen> imagenes;
}
