package com.bolsadeideas.springboot.app.springbootweb.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.app.springbootweb.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
    
    //Métodos
    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model){
        model.addAttribute("titulo", "Hola Spring Framework con Model!");
        return "index";
    }

    /*@GetMapping({"/index", "/", "/home"})
    public String index(Map<String, Object> map){
        map.put("titulo", "Hola Spring Framework con Map!");
        return "index";
    }*/

    /*@GetMapping({"/index", "/", "/home"})
    public ModelAndView index(ModelAndView mv){
        mv.addObject("titulo", "Hola Spring Framework con ModelAndView!");
        mv.setViewName("index");
        return mv;
    }*/

    @RequestMapping("/perfil")
    public String perfil(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Christian");
        usuario.setApellido("Rojas");
        usuario.setEmail("chris@mail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de Usuario: ".concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){
        
        model.addAttribute("titulo", "Listado de usuarios");

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(new Usuario("Christian", "Rojas", "chris@mail.com"),
                new Usuario("Karina", "Arteaga", "kari@mail.com"),
                new Usuario("Gloria", "Dominguez", "glory@mail.com"),
                new Usuario("Natalia", "Campo", "naty@mail.com"));

        return usuarios;
    }
}
