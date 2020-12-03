package daw2;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ppt")
public class PedraPaperTisora {

    private static ArrayList<Partida> llistaPartides = new ArrayList<Partida>();

    public List<Partida> getLlistaPartides() {
        return llistaPartides;
    }

    public void setLlistaPartides(ArrayList<Partida> llistaPartides) {
        this.llistaPartides = llistaPartides;
    }

    @Context
    private UriInfo context;

    public PedraPaperTisora() {
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("iniciarJoc/{codiPartida}")
    public Response iniciarJoc(@PathParam("codiPartida") String codiP) {
        int i;
        for (i = 0; i < llistaPartides.size(); i++) {
            if (llistaPartides.get(i).getId().equals(codiP)) {
                return Response.status(400).entity("Aquesta partida ja existeix").build();
            }
        }
        llistaPartides.add(new Partida(codiP));
        return Response.status(200).entity("Partida creada").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("consultarEstatPartida/{codiPartida}")
    public String consultarEstatPartida(@PathParam("codiPartida") String codiP) {
        int i;
        for (i = 0; i < llistaPartides.size(); i++) {
            if (llistaPartides.get(i).getId().equals(codiP)) {
                return llistaPartides.get(i).toString();
            }
        }
        return "Aquesta partida no existeix";
    }

    /**
     * PUT method for updating or creating an instance of PedraPaperTisora
     *
     * @param content representation for the resource
     */
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("moureJugador/{codiPartida}/{jugador}/{tipusMoviment}")
    public String moureJugador(@PathParam("codiPartida") String codiP, @PathParam("jugador") String jugador, @PathParam("tipusMoviment") String tipusMoviment) {
        for (int i = 0; i < llistaPartides.size(); i++) {
            if (llistaPartides.get(i).getId().equals(codiP)) {
                if (llistaPartides.get(i).getJug1().getNom().equals("")) {
                    llistaPartides.get(i).getJug1().setNom(jugador);
                } else if (llistaPartides.get(i).getJug2().getNom().equals("")) {
                    llistaPartides.get(i).getJug2().setNom(jugador);
                }
                if (llistaPartides.get(i).getJug1().getTipusMoviment().equals("") && llistaPartides.get(i).getJug1().getNom().equals(jugador)) {
                    llistaPartides.get(i).getJug1().setTipusMoviment(tipusMoviment);
                } else if (llistaPartides.get(i).getJug2().getTipusMoviment().equals("") && llistaPartides.get(i).getJug2().getNom().equals(jugador)) {
                    llistaPartides.get(i).getJug2().setTipusMoviment(tipusMoviment);
                }
                if (llistaPartides.get(i).getJug1().getPuntuacio() == 3 || llistaPartides.get(i).getJug2().getPuntuacio() == 3) {
                    return "Hi ha un guanyador !";
                } else {
                    if (!llistaPartides.get(i).getJug1().getTipusMoviment().equals("") && !llistaPartides.get(i).getJug2().getTipusMoviment().equals("")) {
                        if ((llistaPartides.get(i).getJug1().getTipusMoviment().equals("pedra") && llistaPartides.get(i).getJug2().getTipusMoviment().equals("tisora")) || (llistaPartides.get(i).getJug1().getTipusMoviment().equals("paper") && llistaPartides.get(i).getJug2().getTipusMoviment().equals("pedra"))
                                || (llistaPartides.get(i).getJug1().getTipusMoviment().equals("tisora") && llistaPartides.get(i).getJug2().getTipusMoviment().equals("paper"))) {

                            llistaPartides.get(i).getJug1().setPuntuacio(llistaPartides.get(i).getJug1().getPuntuacio() + 1);
                            llistaPartides.get(i).getJug1().setTipusMoviment("");
                            llistaPartides.get(i).getJug2().setTipusMoviment("");
                            return llistaPartides.get(i).toString();
                        } else if (!llistaPartides.get(i).getJug1().getTipusMoviment().equals(llistaPartides.get(i).getJug2().getTipusMoviment())) {
                            llistaPartides.get(i).getJug2().setPuntuacio((llistaPartides.get(i).getJug2().getPuntuacio() + 1));
                            llistaPartides.get(i).getJug1().setTipusMoviment("");
                            llistaPartides.get(i).getJug2().setTipusMoviment("");
                            return llistaPartides.get(i).toString();
                        }
                    }
                }
                return "Esperant a l'altre jugador!!";
            }
        }
        return "La partida no existeix";
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("acabarJoc/{codiPartida}")
    public String acabarJoc(@PathParam("codiPartida") String codiP) {
        int i;
        for (i = 0; i < llistaPartides.size(); i++) {
            if (llistaPartides.get(i).getId().equals(codiP)) {
                llistaPartides.remove(i);
                return "La partida " + codiP + " ha acabat.";
            }
        }
        return "La partida que vols eliminar no existeix.";
    }
}
