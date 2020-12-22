package daw2;

class Partida {
    private int id;
    private Jugador Jug1;
    private Jugador Jug2;
    
    public Partida(){}
    
    public Partida(int codiP){
        this.id = codiP;
        this.Jug1 = new Jugador();
        this.Jug2 = new Jugador();
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Jugador getJug1() {
        return Jug1;
    }

    public Jugador getJug2() {
        return Jug2;
    }

    public void setJug2(Jugador Jug2) {
        this.Jug2 = Jug2;
    }
    
    @Override
    public String toString() {
        return "{'id': " + id + ", 'Jug1': " + Jug1.toString() + ", 'Jug2': " + Jug2.toString() + "}";
    }
}
