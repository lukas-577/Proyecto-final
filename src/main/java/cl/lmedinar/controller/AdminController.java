package cl.lmedinar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.lmedinar.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    private UsuarioService servicio;

	@GetMapping
	public String index(ModelMap mapa) {
        // capturo el nombre de usuario
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String name = auth.getName();
        mapa.addAttribute("username", name);
				
		return "/admin/index";
	}

}
