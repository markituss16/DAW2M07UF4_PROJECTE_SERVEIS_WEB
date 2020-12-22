const express  = require('express');
const { graphqlHTTP } = require('express-graphql');
const { buildSchema } = require('graphql');

const esquema = buildSchema(`
type Partida {
    codiP: ID!
    jug1: String
    jug2: String
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

var llistaPartides = [];

const arrel = {
    iniciarJoc: ({codiP}) => {
        for(let i=0; i<llistaPartides.length; i++){
            if(llistaPartides[i].codiP == codiP){
                throw new Error('Ja existeix una partida amb aquest codi!');
            }
        }
        let partida = new Partida(id,jug1,jug2);
        llistaPartides.push(partida);
        return partida;
    },
    consultarEstatPartida: ({codiP}) => {
        let partida = llistaPartides.find(a => a.codiP == codiP);
        if (!partida) throw new Error('Cap partida amb codi ' + codiP);
        return partida;
    },
    moureJugador: ({codiP,jugador,tipus}) => {
        let partida = llistaPartides.find(a => a.codiP == codiP);
        if(partida){
            if(partida.jug1.jugador == ""){
                partida.jug1.jugador = jugador;
            }else if(partida.jug2.jugador == ""){
                partida.jug2.jugador = jugador;
            }
            if(partida.jug1.tipus == "" && partida.jug1.jugador == jugador){
                partida.jug1.tipus == tipus;
            }else if(partida.jug2.tipus == "" && partida.jug2.jugador == jugador){
                partida.jug2.tipus == tipus;
            }
        }
    },
    acabarJoc: ({codiP}) => {
        let partida = llistaPartides.find(a => a.codiP == codiP);
        if (partida){
            let index = llistaPartides.indexOf(partida);
            llistaPartides.splice(index,1);
        }
    }
};

const app = express();
app.use('/graphql', graphqlHTTP({
    schema: esquema,
    rootValue: arrel,
    graphiql: true,
}));
app.listen(4000);
console.log('Executant servidor GraphQL API a http://localhost:4000/graphql');