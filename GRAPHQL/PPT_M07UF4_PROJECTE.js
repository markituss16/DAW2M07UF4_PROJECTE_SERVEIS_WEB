const express  = require('express');
const { graphqlHTTP } = require('express-graphql');
const { buildSchema } = require('graphql');

const esquema = buildSchema(`
type Partida {
    id: ID!
    jug1: Jugador
    jug2: Jugador
}

type Jugador {
    nom: String
    puntuacio: Int
    tipus: String
}

type Query {
    consultarEstatPartida(codiP: ID!): Partida
}

type Mutation {
    iniciarJoc(codiP: ID!): Partida
    moureJugador(codiP: ID!, jugador:String, tipus: String): Partida
    acabarJoc(codiP: ID!): Int
}
`);

const llistaPartides = [];

const arrel = {
    iniciarJoc: ({codiP}) => {
        for(let i=0; i<llistaPartides.length; i++){
            if(llistaPartides[i].id == codiP){
                throw new Error('Ja existeix una partida amb aquest codi!');
            }
        }
        let j1 = new Jugador("",0,"");
        let j2 = new Jugador("",0,"");
        let partida = new Partida(codiP,j1,j2);
        llistaPartides.push(partida);
        return partida;
    },
    consultarEstatPartida: ({codiP}) => {
        let partida = llistaPartides.find(a => a.id == codiP);
        if (!partida) throw new Error('Cap partida amb codi ' + codiP);
        return partida;
    },
    moureJugador: ({codiP,jugador,tipus}) => {
        let partida = llistaPartides.find(a => a.id == codiP);
        if(partida){
            let index = llistaPartides.indexOf(partida);           
            if(llistaPartides[index].jug1.nom == ""){
                llistaPartides[index].jug1.nom = jugador;
            }else if(llistaPartides[index].jug2.nom == ""){
                llistaPartides[index].jug2.nom = jugador;
            }
            if(llistaPartides[index].jug1.tipus == "" && llistaPartides[index].jug1.nom == jugador){
                llistaPartides[index].jug1.tipus = tipus;
            }else if(llistaPartides[index].jug2.tipus == "" && llistaPartides[index].jug2.nom == jugador){
                llistaPartides[index].jug2.tipus = tipus;
            }
            if(llistaPartides[index].jug1.puntuacio == 3 || llistaPartides[index].jug2.puntuacio == 3){
                throw new Error('Hi ha un guanyador !');
            }else{
                if(llistaPartides[index].jug1.tipus != "" && llistaPartides[index].jug2.tipus != ""){
                    if((llistaPartides[index].jug1.tipus === 'paper' && llistaPartides[index].jug2.tipus === 'pedra') || (llistaPartides[index].jug1.tipus === 'pedra' && llistaPartides[index].jug2.tipus === 'tisora') || (llistaPartides[index].jug1.tipus === 'tisora' && llistaPartides[index].jug2.tipus === 'paper')){
                        llistaPartides[index].jug1.puntuacio++;
                        llistaPartides[index].jug1.tipus = "";
                        llistaPartides[index].jug2.tipus = "";
                    }else if(llistaPartides[index].jug1.tipus != llistaPartides[index].jug2.tipus){
                        llistaPartides[index].jug2.puntuacio++;
                        llistaPartides[index].jug1.tipus = "";
                        llistaPartides[index].jug2.tipus = "";
                    }
                }
            }
            return llistaPartides[index];
        }
        throw new Error('Cap partida amb codi ' + codiP);
    },
    acabarJoc: ({codiP}) => {
        let partida = llistaPartides.find(a => a.id == codiP);
        if (partida){
            let index = llistaPartides.indexOf(partida);
            llistaPartides.splice(index,1);
        }
    }
};

const app = express();
const cors = require(`cors`);
app.use(cors());
app.use('/graphql', graphqlHTTP({
    schema: esquema,
    rootValue: arrel,
    graphiql: true,
}));
app.listen(4000);
console.log('Executant servidor GraphQL API a http://localhost:4000/graphql');

class Partida {
    constructor(id,jug1,jug2){
        this.id = id;
        this.jug1 = jug1;
        this.jug2 = jug2;
    }
}

class Jugador {
    constructor(nom,puntuacio,tipus){
        this.nom = nom;
        this.puntuacio = puntuacio;
        this.tipus = tipus;
    }
}