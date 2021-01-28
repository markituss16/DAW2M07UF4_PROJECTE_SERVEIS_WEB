const express = require('express');
const app = express();
var bodyParser = require('body-parser');
const fs = require('fs');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
var cors = require('cors');
app.use(cors());

//Per a guardar les partides
var llistaPartides = [];


/*************PER A CREAR LA PARTIDA***************/
app.post("/iniciarJoc/:codiPartida", (req,res) => {
    var id = req.params.codiPartida;
    for(let i=0; i<llistaPartides.length; i++){
        if(llistaPartides[i].id == id){
            console.log("La partida ja existia!");
            res.send("Aquesta partida ja existeix.");
        }
    }
    var partida = {id: id, jugador1: {nom: "",puntuacioJug1:0, tipusMoviment: ""}, jugador2: {nom:"",puntuacioJug2:0, tipusMoviment: ""}}; //Objecte on es guarda la info de la partida
    llistaPartides.push(partida);
    console.log(`S'ha creat una partida amb el codi ${id}`);
    res.send(JSON.stringify(partida));
});

/**************CONSULTAR ESTAT DE LA PARTIDA *************/
app.get("/consultarEstatPartida/:codiPartida", (req,res) => {
    var id = req.params.codiPartida;
    for(let i=0; i<llistaPartides.length; i++){
        if(llistaPartides[i].id == id){
            res.send(llistaPartides[i]);
        }
    }
        res.send("Aquesta partida no existeix.");
});

/*********** EL JUGADOR REALITZA UN MOVIMENT*********/

app.put("/moureJugador/:codiPartida/:jugador/:tipusMoviment", (req,res) => {
    var id = req.params.codiPartida;
    var nom = req.params.jugador;
    var tipusMoviment = req.params.tipusMoviment;
    
    for(let i=0; i<llistaPartides.length; i++){
        if(llistaPartides[i].id == id){
            if(llistaPartides[i].jugador1.nom == ""){
                llistaPartides[i].jugador1.nom = nom;
            }else if(llistaPartides[i].jugador2.nom == ""){
                llistaPartides[i].jugador2.nom = nom;
            }
            if(llistaPartides[i].jugador1.tipusMoviment == "" && llistaPartides[i].jugador1.nom == nom){
                llistaPartides[i].jugador1.tipusMoviment = tipusMoviment;
            }else if(llistaPartides[i].jugador2.tipusMoviment == "" && llistaPartides[i].jugador2.nom == nom){
                llistaPartides[i].jugador2.tipusMoviment = tipusMoviment;
            }

            if(llistaPartides[i].jugador1.puntuacioJug1 == 3 || llistaPartides[i].jugador2.puntuacioJug2 == 3){
                res.send("Hi ha un guanyador!");
            }else{
                if (llistaPartides[i].jugador1.tipusMoviment != "" && llistaPartides[i].jugador2.tipusMoviment != ""){
                    console.log("Moviments dels jugadors");
                    if((llistaPartides[i].jugador1.tipusMoviment === 'paper' && llistaPartides[i].jugador2.tipusMoviment === 'pedra') || (llistaPartides[i].jugador1.tipusMoviment === 'pedra' && llistaPartides[i].jugador2.tipusMoviment === 'tisora')
                        || (llistaPartides[i].jugador1.tipusMoviment === 'tisora' && llistaPartides[i].jugador2.tipusMoviment === 'paper')){
                        llistaPartides[i].jugador1.puntuacioJug1++;
                        res.send(JSON.stringify(llistaPartides[i]));
                        llistaPartides[i].jugador1.tipusMoviment = "";
                        llistaPartides[i].jugador2.tipusMoviment = "";
                    }else if (llistaPartides[i].jugador1.tipusMoviment != llistaPartides[i].jugador2.tipusMoviment){
                        llistaPartides[i].jugador2.puntuacioJug2++;
                        res.send(JSON.stringify(llistaPartides[i]));
                        llistaPartides[i].jugador1.tipusMoviment = "";
                        llistaPartides[i].jugador2.tipusMoviment = "";
                    }
                }
            }
            res.send("Esperant a l'altre jugador!");
        }
    }
    res.send("La partida no existeix.");
});


app.delete("/acabarJoc/:codiPartida", (req,res) => {
    let id = req.params.codiPartida;

    for(let i=0; i<llistaPartides.length; i++){
        if(llistaPartides[i].id == id){
            llistaPartides.splice(llistaPartides[i],1);
            res.send(`S'ha acabat la partida amb el codi ${id}.`);
            console.log('La partida ha finalitzat.');
        }
    }
    res.send("La partida que vols eliminar no existeix.")
});

app.listen(3000, ()=>console.log('Iniciant el servidor al port 3000 per a començar la partida.'));