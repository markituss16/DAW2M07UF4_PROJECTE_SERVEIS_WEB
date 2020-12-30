package ppt_m07uf4_consumidor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PPT_M07UF4_CONSUMIDOR {

    public static void main(String[] args) {
        jocTest();
    }
    
    public static void jocTest() {   
        System.out.println("Benvingut al joc del Pedra, paper o tisora !");
        Scanner input = new Scanner(System.in);
        String resposta = new String(), jugador;
        int opcio,codiP, tipus, nCmpt = 0;
        
        do {
            System.out.println("Entra '1' per a escollir un joc i iniciar la partida");
            System.out.println("Entra '2' si vols consultar l'estat de la partida.");
            System.out.println("Entra '3' si vols realitzar un moviment");
            System.out.println("Entra '4' per a finalitzar el joc.");
            try {
                opcio = input.nextInt();

                switch (opcio) {
                    case 1:
                        System.out.println("Introdueix un codi per a iniciar la partida.");
                        codiP = input.nextInt();
                        boolean existeix = iniciarJoc(codiP);
                        if(existeix == false){
                            System.out.println("Aquesta partida ja existeix!");
                        }else{
                            iniciarJoc(codiP);
                            System.out.println("\nCodi acceptat!");
                        }
                        System.out.println("\nVols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;
                    case 2:
                        System.out.println("Introdueix el codi de la partida per a consultar el seu estat.");
                        codiP = input.nextInt();
                        int resultat = consultarEstatPartida(codiP);
                        if(resultat == 1){
                            System.out.println("\nGuanya el jugador 1 !!");
                            nCmpt++;
                        }else if(resultat == 2){
                            System.out.println("\nGuanya el jugador 2 !!");
                            nCmpt++;
                        }else if (resultat == 0){
                            System.out.println("\nEls jugadors van empatats !!");
                            nCmpt++;
                        }
                        System.out.println("\nVols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;
                    case 3:
                        System.out.println("Introdueix el codi per a poder entrar a la partida");
                        codiP = input.nextInt();
                        System.out.println("Introdueix el teu nom per a identificar-te.");
                        jugador = input.next();
                        System.out.println("Introdueix el moviment que vols fer. 1 = PEDRA, 2 = PAPER, 3 = TISORA");
                        tipus = input.nextInt();
                        if(nCmpt == 3){
                            System.out.println("\nJa no podeu realitzar més moviments, hi ha un guanyador !");
                        }else{
                            moureJugador(tipus, codiP, jugador);
                            nCmpt++;
                        }
                        System.out.println("\nVols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;
                    case 4:
                        System.out.println("Introdueix el codi per a poder finalitzar la partida");
                        codiP = input.nextInt();
                        acabarJoc(codiP);
                        System.out.println("Partida finalitzada.");
                        System.out.println("\nVols continuar? Entra 'y' o 'n'.");
                        resposta = input.next();
                        break;
                    default:
                        System.out.println("Si us plau, introdueix un número vàlid.");
                        jocTest();
                }      
                        
            } catch (InputMismatchException e) {
                System.out.println("Si us plau, introdueix un número.");
                jocTest();
                break;
            }

        } while (resposta.equalsIgnoreCase("y"));
        System.out.println("Esperem que hagueu gaudit de la partida.");
    }

    private static boolean iniciarJoc(int codiPartida) {
        edu.fje.daw2.PPTWebService_Service service = new edu.fje.daw2.PPTWebService_Service();
        edu.fje.daw2.PPTWebService port = service.getPPTWebServicePort();
        return port.iniciarJoc(codiPartida);
    }

    private static Integer consultarEstatPartida(int codiPartida) {
        edu.fje.daw2.PPTWebService_Service service = new edu.fje.daw2.PPTWebService_Service();
        edu.fje.daw2.PPTWebService port = service.getPPTWebServicePort();
        return port.consultarEstatPartida(codiPartida);
    }

    private static void moureJugador(int tipus, int codiPartida, java.lang.String nomJugador) {
        edu.fje.daw2.PPTWebService_Service service = new edu.fje.daw2.PPTWebService_Service();
        edu.fje.daw2.PPTWebService port = service.getPPTWebServicePort();
        port.moureJugador(tipus, codiPartida, nomJugador);
    }

    private static boolean acabarJoc(int codiPartida) {
        edu.fje.daw2.PPTWebService_Service service = new edu.fje.daw2.PPTWebService_Service();
        edu.fje.daw2.PPTWebService port = service.getPPTWebServicePort();
        return port.acabarJoc(codiPartida);
    }
    
    
}
