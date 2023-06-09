package com.jordan.soccerclubcrud.modelo;

import lombok.Data;
import lombok.NonNull;

@Data
public class Team {
    @NonNull
    private String nombrePais;
    @NonNull
    private String confederacion;

    private String rankingFifa;
}
