package cl.lmedinar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    private UsuarioService servicio;

    private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    
//	@GetMapping
//	public String index(ModelMap mapa) {
//        // capturo el nombre de usuario
//        Authentication auth = SecurityContextHolder.getContext()
//                .getAuthentication();
//        String name = auth.getName();
//        mapa.addAttribute("username", name);
//				
//		return "/admin/index";
//	}
	
    //empiesa foto controller solo en admin
    
    @GetMapping 
    public String home(
        @ModelAttribute("mensaje") String mensaje, 
        ModelMap mapa
    ) {
        System.out.println("mensaje:" + mensaje);
        if(mensaje != null)
            mapa.put("mensaje", mensaje);
     
        List<Usuario> usuarios = servicio.obtenerTodos();
        mapa.put("usuarios", usuarios);

        return "admin/index";
    }
    
    @PostMapping("/actualizar")
    public String actualizar(
        ModelMap mapa,
        RedirectAttributes atributos,
        @ModelAttribute Usuario usuario, 
        @RequestParam(name = "imagen", required = false) MultipartFile archivo) {
        if(archivo.isEmpty())
            servicio.actualizar(usuario);
        else
            servicio.actualizar(usuario, archivo);
        
        atributos.addFlashAttribute("mensaje", "Usuario actualizado");
        List<Usuario> usuarios = servicio.obtenerTodos();
        mapa.put("usuarios", usuarios);
        
        
        return "/admin/index";
    }

    @PostMapping
    public String ingresar(
        RedirectAttributes atributos,
        @ModelAttribute Usuario usuario, 
        @RequestParam("imagen") MultipartFile archivo) {
        Usuario Usuariorespuesta = servicio.ingresar(usuario, archivo); 
        
        atributos.addFlashAttribute(
            "mensaje", 
            "Usuario: " 
            + Usuariorespuesta.getEmail()
            + ", ingresado."
        );
        return "redirect:/admin";
    }

    @GetMapping(value = "/eliminar")
    public String eliminar(
    	ModelMap mapa,
        @RequestParam  Integer id,
        RedirectAttributes atributos) {
        Usuario usuario = servicio.buscar(id);
        servicio.eliminar(usuario);
        String mensaje = "Usuario: " + usuario.getEmail() + " eliminado";
        atributos.addFlashAttribute("mensaje", mensaje);
        //para que me liste denuevo en la vista
        List<Usuario> usuarios = servicio.obtenerTodos();
        mapa.put("usuarios", usuarios);
        return ("/admin/index");
    }

}
