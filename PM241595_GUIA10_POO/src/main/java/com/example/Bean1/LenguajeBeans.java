package com.example.Bean1;

public class LenguajeBeans {
    private String nombre;
    private String lenguaje;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getComentarios(){
        if (lenguaje.equals("Java")){
            return "El rey de los Lenguajes Orientados a Objetos";
        }
        else if (lenguaje.equals("C++")){
            return "Demasiado complejo";
        }
        else if (lenguaje.equals("Perl")){
            return "OK si te gusta el código incomprensible";
        }
        else {
            return "Lo siento, no conozco el lenguaje " + lenguaje ;
        }
    }
    }
