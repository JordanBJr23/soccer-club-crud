package com.jordan.soccerclubcrud.controladores;

import com.jordan.soccerclubcrud.modelo.Team;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/teams")
public class TeamControlador {
    ArrayList<Team> teams = new ArrayList<Team>(
            List.of(
            new Team ("Argentina", "Conmebool"),
            new Team ("España", "UEFA"),
            new Team ("Marruecos", "CAF"),
            new Team ("Uruguay", "Conmebool"),
            new Team ("Croacia", "UEFA")
            )
    );
    @GetMapping
    public List<Team> listarEquipos(){
        return teams;
    }

    @GetMapping("/{name}")
    public Team equipoPorNombre(@PathVariable String name){
      for(Team t: teams){
          if(t.getNombrePais().equalsIgnoreCase(name)){
          return t;
      }
      }
      return null;
    }
    @PostMapping
    public void crearTeam(@RequestBody Team equipo){ // Se utiliza @RequestBody cuando hay que indicar que es un objeto
teams.add(equipo);
    }
    @DeleteMapping("/{name}")
    public void eliminarTeam(@PathVariable String name){
        Optional<Team> optTeam = teams.stream().filter(team -> team.getNombrePais().equalsIgnoreCase(name)).findFirst();

        if(optTeam.isPresent()){
            teams.remove(optTeam.get());
        }

    }

    @PutMapping("/teams")
    public void modificarEquipo(@RequestBody Team equipo){
        Optional<Team> optTeam = teams.stream().filter(team -> team.getNombrePais().equalsIgnoreCase(equipo.getNombrePais())).findFirst();

        if(optTeam.isPresent()){
            Team encontrado = optTeam.get();
            encontrado.setConfederacion(equipo.getConfederacion());
            encontrado.setRankingFifa(equipo.getRankingFifa());
        }
    }
@GetMapping("/play/{equipoA}/{equipoB}")
    public String jugar(@PathVariable String equipoA, @PathVariable String equipoB){
    Random r = new Random();
    int golesA = r.nextInt(5);
    int golesB = r.nextInt(6);
    String ganador ="";

    if (golesA > golesB){
        ganador = equipoA;
    } else if (golesA < golesB) {
        ganador = equipoB;

    }else{
        ganador = "empate";
    }

    return "Marcador <br/> " + equipoA + " " + golesA + " " + equipoB + " " + golesB + "<br/> Ganador: " + ganador;


}
}
