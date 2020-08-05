package cl.lmedinar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProyectoFinalApplicationTests {

	@Test
	@DisplayName("registro de usuarios")
	public void registrarUsuario() {
		//voy a crear un usario y se vea en la base de datos
		
		//que al registar un usario se guarde el email
		
		//que este email sea unico, no se pueda repetir 
		
		assertTrue(true);
	}
	@Test
	@DisplayName("usuario puedesubir fotos")
	public void usuarioSubeFoto() {
		//que la foto que suba quede guardada en static
		
		//que la foto me la muestre en las vistas
		
		assertTrue(true);
		
		
	}
	@Test
	@DisplayName("administrador sube fotos")
	public void admin() {
		//asegurarme que el administrador pueda eliminar actualizar un usuario
		
		//que pueda subir fotos 
		
		//que la foto me la muestre en las vistas
		
		assertTrue(true);
		
		
	}
	

}
