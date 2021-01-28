window.addEventListener('load', function () {
    //iniciar joc
    document.getElementById("iniciar").onclick = function () {
        let id = document.getElementById("codiP1").value;
        iniciarJoc(id);
    };

    document.getElementById("consultar").onclick = function () {
        let codiP = document.getElementById("codiP2").value;
        consultarEstatPartida(codiP);
    };

    document.getElementById("moviment1").onclick = function () {
        let codiP = document.getElementById("codiJ1").value;
        let jugador = document.getElementById("jugador1").value;
        let tipus = document.getElementById("tipus1").value;
        moureJugador(codiP, jugador, tipus);
    };

    document.getElementById("moviment2").onclick = function () {
        let codiP = document.getElementById("codiJ2").value;
        let jugador = document.getElementById("jugador2").value;
        let tipus = document.getElementById("tipus2").value;
        moureJugador(codiP, jugador, tipus);
    };

    document.getElementById("acabar").onclick = function () {
        var codiP = document.getElementById("codiP4").value;
        acabarJoc(codiP);
    };
    
    function iniciarJoc(id) {
        var xhr = new XMLHttpRequest();

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(xhr.response);
                document.getElementById("resposta").innerHTML = xhr.response;
            }
        });
        xhr.open("POST", "http://localhost:3000/iniciarJoc/" + id);
        xhr.send(null);
    }

    function consultarEstatPartida(codiP) {
        var xhr = new XMLHttpRequest();

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.response);
                document.getElementById("resultat").innerHTML = xhr.response;
            }
        });
        xhr.open("GET", "http://localhost:3000/consultarEstatPartida/" + codiP);
        xhr.send();
    }

    function moureJugador(codiP, jugador, tipus) {
        var xhr = new XMLHttpRequest();

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.response);
                document.getElementById("resultatMov").innerHTML = xhr.response;
            }
        });

        xhr.open("PUT", "http://localhost:3000/moureJugador/" + codiP + "/" + jugador + "/" + tipus);
        xhr.send();
    }

    function acabarJoc(codiP) {
        var xhr = new XMLHttpRequest();

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.response);
                document.getElementById("resultatFin").innerHTML = xhr.response;
            }
        });
        xhr.open("DELETE", "http://localhost:3000/acabarJoc/" + codiP);
        xhr.send();
    }
});