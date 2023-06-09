package com.jordan.soccerclubcrud.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoControlador {
    @GetMapping("/saludar/{nombre}")
    public String saludar(@PathVariable String nombre){
        return "Hola mundo Spring " + nombre;
    }
@GetMapping("/suma/{numero1}/{numero2}")
    public String suma(@PathVariable int numero1, @PathVariable int numero2){
        int total = numero1 + numero2;
        return numero1 + " + " +  numero2 +  " = " + total;
    }
}


