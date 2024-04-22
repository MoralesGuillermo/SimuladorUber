function rideAceptado(){
    request = new XMLHttpRequest();
    let rideDiv = document.getElementById("rideId");
    let rideId = rideDiv.dataset.ride;
    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200){
            let jsonResponse = JSON.parse(request.responseText);
            if (jsonResponse.status == 200){
                // Mostrar vista para el inicio del viaje
            }
        }
    };
    request.open("GET", `peticion-viaje-aceptado/${rideId}`)
    request.send();
}

setInterval(rideAceptado, 10000);