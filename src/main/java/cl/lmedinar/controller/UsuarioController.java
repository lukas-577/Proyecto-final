package cl.lmedinar.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.lmedinar.model.entity.Usuario;
import cl.lmedinar.service.UsuarioService;





@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
    private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
    @GetMapping
    public String index(ModelMap mapa) {

        return "/usuario/index";
    }

    @Autowired
    private UsuarioService servicio;
    
    @PostMapping
    public String ingresar(
        RedirectAttributes atributos,
        @ModelAttribute Usuario usuario, 
        @RequestParam("imagen") MultipartFile archivo) {
    	logger.info("XXXXXXXX"+usuario);
        Usuario Usuariorespuesta = servicio.ingresar(usuario, archivo); 
        
        atributos.addFlashAttribute(
            "mensaje", 
            "Usuario: " 
            + Usuariorespuesta.getEmail()
            + ", ingresado."
        );
        return "redirect:/usuario";
    }

}
