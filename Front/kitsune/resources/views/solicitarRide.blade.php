<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="../resources/css/app.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" }
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script src="../resources/js/maps.js"></script>
    <title>Solicitar Ride | Kitsune</title>
</head>
<body>
    <nav class="topNav" id="loginNavbar">
        <a href=""><p class="h4" id="kitsuneTitle">kitsune</p></a>
    </nav>
    <div id="mapsDiv">
        <script async
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA65TP6PdIhoidkcK1P7ScDs1Lql9hJyEU&callback=initMap&v=weekly&solution_channel=GMP_CCS_geocodingservice_v1"
        defer
        ></script>
    </div>
    <form id="solicitudPeticionDiv" class="containter" action="{{route('solicitarNuevoRide')}}" method="GET">
        <input id="solicitudOrigin" type="text" readonly placeholder="Origen">
        <input id="solicitudDestino" type="text" readonly placeholder="Destino">
        <input id="solicitudPrecio" type="text" readonly placeholder="Precio">
        <button id="solicitudHacerBtn" type="submit" disabled>Confirmar</button>
        <input class="hidden-element" id="originLat" name="originLat" type="text">
        <input class="hidden-element" id="originLng" name="originLng" type="text">
        <input class="hidden-element" id="destinationLat" name="destinationLat" type="text">
        <input class="hidden-element" id="destinationLng" name="destinationLng" type="text">
        <input class="hidden-element" id="distance" name="distance" type="text">
        <input class="hidden-element" id="clienteId" name="clienteId" type="text" value="{{$clienteId}}">
        <input class="hidden-element" id="realPrice" name="realPrice" type="text">    
    </form>
    <a id="solicitudCancelAnchor"href="" onclick="history.go(-1); return false;"><button id="solicitudCancelBtn">Cancelar</button></a>
</body>
</html>
