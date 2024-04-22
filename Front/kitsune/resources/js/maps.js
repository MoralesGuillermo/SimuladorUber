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
    let confirmarBtn = document.getElementById("solicitudHacerBtn")
    geocoder
        .geocode(request)
        .then((result) => {
        const { results } = result;
        map.setCenter(results[0].geometry.location);
        if (originInput.value == ""){
            map.setCenter(results[0].geometry.location);
            originMarker.setPosition(results[0].geometry.location);
            originMarker.setMap(map);
            originInput.value = results[3].formatted_address;
        }else{
            destinationMarker.setPosition(results[0].geometry.location);
            destinationMarker.setMap(map);
            destinoInput.value = results[3].formatted_address;
            confirmarBtn.disabled = false;
            confirmarBtn.style.backgroundColor = "green";
            // TODO: REQUEST PRICE FOR THE TRIP
        }
        return results;
        })
        .catch((e) => {
        alert("Geocode was not successful for the following reason: " + e);
        });
}

window.initMap = initMap;