window.addEventListener('load', function () {
    
    document.getElementById("iniciar").onclick = function () {
        var codiP = document.getElementById("codiP1").value;
        iniciarJoc(codiP);
    }
    document.getElementById("consultar").onclick = function() {
        var codiP = document.getElementById("codiP2").value;
        consultarEstatPartida(codiP);
    }
    document.getElementById("moviment").onclick = function() {
        var codiP = document.getElementById("codiP3").value;
        var jugador = document.getElementById("jugador").value;
        var tipus = document.getElementById("tipus").value;
        moureJugador(codiP,jugador,tipus);
    }
    document.getElementById("acabar").onclick = function() {
        var codiP = document.getElementById("codiP4").value;
        acabarJoc(codiP);
    }

    function iniciarJoc(codiP) {
        console.log();
        fetch('http://localhost:4000/graphql', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                query: `mutation {
                    iniciarJoc(codiP: "${codiP}"){
                        id
                    }
                }`
            }),
        })
    }
    function consultarEstatPartida(codiP) {
        let resposta = document.getElementById("resultat");
        fetch('http://localhost:4000/graphql', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                query: `query {
                    consultarEstatPartida(codiP: "${codiP}"){
                        id
                        jug1{nom 
                            puntuacio 
                            tipus}
                        jug2{nom 
                            puntuacio 
                            tipus}
                    }}`
            }),
        })
        .then(res => res.json())
        .then(dades => resposta.innerText = JSON.stringify(dades));
    }
    function moureJugador(codiP,jugador,tipus) {
        fetch('http://localhost:4000/graphql', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                query: `mutation {
                    moureJugador(codiP: "${codiP}",jugador: "${jugador}",tipus: "${tipus}"){
                        id
                        jug1{nom 
                            puntuacio 
                            tipus}
                        jug2{nom 
                            puntuacio 
                            tipus}
                    }}`
            }),
        })
    }

    function acabarJoc(codiP) {
        fetch('http://localhost:4000/graphql', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                query: `mutation {
                    acabarJoc(codiP: "${codiP}")
                }`
            }),
        })
    }
});