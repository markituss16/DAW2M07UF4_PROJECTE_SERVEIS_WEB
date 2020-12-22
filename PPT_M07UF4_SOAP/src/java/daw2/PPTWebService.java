package daw2;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "PPTWebService")
public class PPTWebService {
    private ArrayList<Partida> llistaPartides = new ArrayList <>();
    public static final int PEDRA = 1;
    public static final int PAPER = 2;
    public static final int TISORA = 3;
    
    public ArrayList<Partida> getLlistaPartides() {
        return llistaPartides;
    }

    public void setLlistaPartides(ArrayList<Partida> llistaPartides) {
        this.llistaPartides = llistaPartides;
    }
    
    @WebMethod(operationName = "iniciarJoc")
    public boolean iniciarJoc(@WebParam(name = "codiPartida") int codiP) {
        int i;
        for(i=0;i<llistaPartides.size();i++){
            if(llistaPartides.get(i).getId() == codiP){
                return false;
            }
        }
        llistaPartides.add(new Partida(codiP));
        return true;
    }

    @WebMethod(operationName = "moureJugador")
    public void moureJugador(@WebParam(name = "tipus") int tipus, @WebParam(name = "codiPartida") int codiP, @WebParam(name = "nomJugador") String jugador) {
                for (int i = 0; i < llistaPartides.size(); i++) {
            if (llistaPartides.get(i).getId() == codiP) {
                if (llistaPartides.get(i).getJug1().getNom().equals("")) {
                    llistaPartides.get(i).getJug1().setNom(jugador);
                } else if (llistaPartides.get(i).getJug2().getNom().equals("")) {
                    llistaPartides.get(i).getJug2().setNom(jugador);
                }
                if (llistaPartides.get(i).getJug1().getTipusMoviment() == 0 && llistaPartides.get(i).getJug1().getNom().equals(jugador)) {
                    llistaPartides.get(i).getJug1().setTipusMoviment(tipus);
                } else if (llistaPartides.get(i).getJug2().getTipusMoviment() == 0 && llistaPartides.get(i).getJug2().getNom().equals(jugador)) {
                    llistaPartides.get(i).getJug2().setTipusMoviment(tipus);
                }
                if (llistaPartides.get(i).getJug1().getPuntuacio() == 3 || llistaPartides.get(i).getJug2().getPuntuacio() == 3) {
                } else {
                    if (llistaPartides.get(i).getJug1().getTipusMoviment() != 0 && llistaPartides.get(i).getJug2().getTipusMoviment() != 0) {
                        if ((llistaPartides.get(i).getJug1().getTipusMoviment() == PEDRA && llistaPartides.get(i).getJug2().getTipusMoviment() == TISORA) || (llistaPartides.get(i).getJug1().getTipusMoviment() == PAPER && llistaPartides.get(i).getJug2().getTipusMoviment() == PEDRA)
                                || (llistaPartides.get(i).getJug1().getTipusMoviment() == TISORA && llistaPartides.get(i).getJug2().getTipusMoviment() == PAPER)) {

                            llistaPartides.get(i).getJug1().setPuntuacio(llistaPartides.get(i).getJug1().getPuntuacio() + 1);
                            llistaPartides.get(i).getJug1().setTipusMoviment(0);
                            llistaPartides.get(i).getJug2().setTipusMoviment(0);
                        } else if (llistaPartides.get(i).getJug1().getTipusMoviment() != llistaPartides.get(i).getJug2().getTipusMoviment()) {
                            llistaPartides.get(i).getJug2().setPuntuacio((llistaPartides.get(i).getJug2().getPuntuacio() + 1));
                            llistaPartides.get(i).getJug1().setTipusMoviment(0);
                            llistaPartides.get(i).getJug2().setTipusMoviment(0);
                        }
                    }
                }
            }
        }
    } 
    
    @WebMethod(operationName = "consultarEstatPartida")
    public Integer consultarEstatPartida(@WebParam(name = "codiPartida") int codiP) {
        int i;
        for(i=0;i<llistaPartides.size();i++){
            if(llistaPartides.get(i).getId() == codiP){
                if(llistaPartides.get(i).getJug1().getPuntuacio() > llistaPartides.get(i).getJug2().getPuntuacio()){
                    return 1;
                }else if (llistaPartides.get(i).getJug2().getPuntuacio() > llistaPartides.get(i).getJug1().getPuntuacio()){
                    return 2;
                }else{
                    return 0;
                }
            }
        }
        return -1;
    }
    
    @WebMethod(operationName = "acabarJoc")
    public boolean acabarJoc(@WebParam(name = "codiPartida") int codiP) {
        int i;
        for (i = 0; i < llistaPartides.size(); i++) {
            if (llistaPartides.get(i).getId() == codiP) {
                llistaPartides.remove(i);
                return true;
            }
        }
        return false;
    }
}
