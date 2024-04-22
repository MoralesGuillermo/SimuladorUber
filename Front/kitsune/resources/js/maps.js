/**
 * @license
 * Copyright 2019 Google LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
let map;
let originMarker;
let destinationMarker;
let geocoder;
let responseDiv;
let response;

function initMap() {

    map = new google.maps.Map(document.getElementById("mapsDiv"), {
        zoom: 16,
        center: {lat: 14.0818, lng: -87.2061},
        mapTypeControl: false,
        minZoom: 14,
        maxZoom: 18
      });    
    
    geocoder = new google.maps.Geocoder();

    if (navigator.geolocation){
        navigator.geolocation.getCurrentPosition(
            (position) => {
                const pos = {
                    lat : position.coords.latitude,
                    lng: position.coords.longitude
                };
                map.setCenter(pos);
                originMarker.setPosition(pos);
                originMarker.setMap(map)
            }
        )
    }

    response = document.createElement("pre");
    response.id = "response";
    response.innerText = "";
    responseDiv = document.createElement("div");
    responseDiv.id = "response-container";
    responseDiv.appendChild(response);

    map.controls[google.maps.ControlPosition.LEFT_TOP].push(responseDiv);
    originMarker = new google.maps.Marker({
        map,
    });
    destinationMarker = new google.maps.Marker({
        map,
    });
    map.addListener("click", (e) => {
        geocode({ location: e.latLng });
    });
}

function clear() {
    originMarker.setMap(null);
}

function geocode(request) {
    let originInput = document.getElementById("solicitudOrigin");
    let destinoInput = document.getElementById("solicitudDestino");
    let confirmarBtn = document.getElementById("solicitudHacerBtn");
    let originLat = document.getElementById('originLat');
    let originLng = document.getElementById('originLng');
    let destinationLat = document.getElementById('destinationLat');
    let destinationLng = document.getElementById('destinationLng');
  
    geocoder
        .geocode(request)
        .then((result) => {
        const { results } = result;
        map.setCenter(results[0].geometry.location);
        let lat = results[0].geometry.location.lat();
        let lng = results[0].geometry.location.lng();
        if (originInput.value == ""){
            map.setCenter(results[0].geometry.location);
            originMarker.setPosition(results[0].geometry.location);
            originMarker.setMap(map);
            originInput.value = results[3].formatted_address;
            originLat.value = lat;
            originLng.value = lng;
        }else{
            destinationMarker.setPosition(results[0].geometry.location);
            destinationMarker.setMap(map);
            destinoInput.value = results[3].formatted_address;
            confirmarBtn.disabled = false;
            confirmarBtn.style.backgroundColor = "green";
            destinationLat.value = lat;
            destinationLng.value = lng;

            let origin = {lat: parseFloat(originLat.value), lng: parseFloat(originLng.value)}
            let destination = {lat: parseFloat(destinationLat.value), lng: parseFloat(destinationLng.value)}
            calculatePrice(origin, destination);
        }
        return results;
        })
        .catch((e) => {
        alert("Geocode was not successful for the following reason: " + e);
        });
}

function calculatePrice(origin, destination){
    // Calcular la distancia del viajes
    let distanceService = new google.maps.DistanceMatrixService();
    let request = {
        origins: [origin],
        destinations: [destination],
        travelMode: google.maps.TravelMode.DRIVING,
        unitSystem: google.maps.UnitSystem.METRIC,
        avoidHighways: false,
        avoidTolls: false,
    }
    distanceService.getDistanceMatrix(request).then((response) => {
        let distance = response.rows[0].elements[0].distance.value / 1000; // La distancia se encuentra en metros, hay que pasarla a kilométros
        let distanceInput = document.getElementById("distance");
        distanceInput.value = distance;
        requestPrice(distance);
    })    
}

function requestPrice(distancia){
    let request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200){
            let precioInput = document.getElementById("solicitudPrecio");
            let realPrice = document.getElementById("realPrice");
            precioInput.value = request.responseText;
            realPrice.value = request.responseText;
        }
    };
    request.open("GET", `consultar-precio/${distancia}`)

    request.send();

}

window.initMap = initMap;