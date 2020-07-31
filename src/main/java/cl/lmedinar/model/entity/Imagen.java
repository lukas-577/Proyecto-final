package cl.lmedinar.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer codigo;
    private String titulo;
    private String descripcion;
    private String marcaCamara;
    private String modeloCamara;
    private String iso;
    private String exposicion;
    private String urlImagen;
//	@ManyToOne
//	@JoinColumn(name="codigo",nullable=true)
//	public Usuario usuario;

}
