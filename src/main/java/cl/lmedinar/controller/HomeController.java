package cl.lmedinar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(ModelMap mapa) {

        return "home";
    }

    @GetMapping("/acerca-de")
    public String abaut(ModelMap mapa) {
        return "acerca-de";
    }

    // eliminar esto
    @GetMapping("/precios")
    public String precios(ModelMap mapa) {
        return "precios";
    }

    @GetMapping("/album")
    public String portfolio(ModelMap mapa) {
        return "album";
    }

    // se va a referenciar cuando se pinche una
    // imagen
    @GetMapping("/detalle-album/{id}")
    public String portfolioDetails(
        ModelMap mapa, 
        @RequestParam(name = "id", required = false) Integer id) {

        // se carga la información detallada de la imagen
        
        return "detalle-album";
    }

    @GetMapping("/contacto")
    public String contact(ModelMap mapa) {

        return "contacto";
    }

    @GetMapping("/login")
    public String login(ModelMap mapa) {

        return "/login/login";
    }

}
