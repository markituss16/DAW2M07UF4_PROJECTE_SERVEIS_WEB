package daw2;

public class Jugador {
    private String nom="";
    private int puntuacio = 0;
    private int tipusMoviment = 0;
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

    public int getTipusMoviment() {
        return tipusMoviment;
    }

    public void setTipusMoviment(int tipusMoviment) {
        this.tipusMoviment = tipusMoviment;
    }
    
    @Override
    public String toString() {
        return "{'nom': " + nom + ", 'puntuacio': " + puntuacio + "}";
    }  
}
