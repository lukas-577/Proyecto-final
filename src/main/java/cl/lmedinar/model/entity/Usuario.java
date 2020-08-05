package cl.lmedinar.model.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.lmedinar.model.entity.Usuario;
import cl.lmedinar.config.EncoderUtils;
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
	private String nombre;
	private String email;
	private String contrasenia;
	private String urlImagen;

	private Integer rut;
	private Rol rol;
	
    public void setContrasenia(String contrasenia) {
        this.contrasenia = EncoderUtils.passwordEncoder().encode(contrasenia);
    }
    
    /**
     * Método diseñado para poder convertir esta entidad
     * en una cadena de texto, con formáto json.
     * Esto es útil para los js, que tengamos
     * en la vista 
     */
    public String toJson() {
        Usuario aux = new Usuario(id, nombre, email, contrasenia, urlImagen, id, rol, imagenes);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(aux);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return jsonString;
    }
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "usuario",orphanRemoval = true)
	
	private List<Imagen> imagenes;
}
