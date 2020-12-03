package daw2;

import java.util.Objects;

class Jugador {
    private String nom="";
    private int puntuacio = 0;
    private String tipusMoviment="";
   // private int estatPartida;
    
    public Jugador(){}
    
    public Jugador (String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public String getTipusMoviment() {
        return tipusMoviment;
    }

    public void setTipusMoviment(String tipusMoviment) {
        this.tipusMoviment = tipusMoviment;
    }

    /*public int afegirGuanyada(){
        System.out.println("Guanya el jugador " + this);
        setGuanyades(getGuanyades()+1);
        return getGuanyades();
    }*/

    @Override
    public String toString() {
        return "{'nom': " + nom + ", 'puntuacio': " + puntuacio + "}";
    }
    
}
