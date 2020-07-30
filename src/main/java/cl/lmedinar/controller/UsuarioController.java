package cl.lmedinar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@GetMapping
	public String index(ModelMap mapa) {
		
		return "/usuario/indexUsuario";
	}
	
	

	
}
