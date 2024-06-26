<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/css/app.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" }
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Esperando confirmación | Kitsune</title>
</head>
<body>
    <nav class="topNav" id="loginNavbar">
        <a href=""><p class="h4" id="kitsuneTitle">kitsune</p></a>
    </nav>
    <div class="d-flex justify-content-center">
        <p class="h1 blink_me" id="mensajeEspera">Esperando que un conductor acepte su viaje...</p>
        <a id="esperaRegresarBtn" href="http://localhost/kitsune/public/cancelar-ride/{{$rideId}}/{{$clienteId}}"><button class="btn btn-danger">Cancelar</button></a>
    </div>
    <div id="rideId" data-ride={{$rideId}}></div>
</body>
<script src="../resources/js/esperarSolicitud.js"></script>
</html>