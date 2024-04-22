<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="{{ asset('../resources/css/app.css') }}">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"  crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <nav class="topNav" id="loginNavbar">
        <a href=""><p class="h4" id="kitsuneTitle">kitsune</p></a>
    </nav>
    <table style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);background-color: #FD8600;border-collapse: collapse; border-radius: 10px; margin-top: 13%;margin-left: 23%;" >
        <thead>
            <tr>
                <td style="padding: 10px; background-color: orange;border-top-left-radius: 10px; color: #ffffff;">Cliente</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Precio</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Fecha</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Latitud Origen</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Longitud Origen</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Latitud Destino</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Longitud Destino</td>
                <td style="padding: 10px; background-color: orange;border-top-right-radius: 10px;color: #ffffff;">Calificacion</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <!--@ foreach ($duenios as $duenio) 
                    <tr>
                        <td>{$ duenio idDuenio}}</td>
                        <td>{duenio nombre}}</td>
                        <td>{duenio-apellido}}</td>
                        <td><a href="{route('duenios.eliminar', $duenio->idDuenio)}}">Eliminar</a></td>
                        <td><a href="{route('duenios.editar', $duenio->idDuenio)}}">Editar</a></td>
                    </tr>
                    @ endforeach
                    -->
                  
                        @foreach ($rides as $ride)
                        <tr>
                            <td style="padding: 10px; background-color: #ffe6cd;">{{ $ride['username'] }}</td>
                            <td style="padding: 10px; background-color: #ffe6cd;">{{ $ride['precioRide'] }}</td>
                            <td style="padding: 10px; background-color: #ffe6cd;">{{ $ride['fechaRide'] }}</td>
                            <td style="padding: 10px; background-color: #ffe6cd;">{{ $ride['origenRideLatitud'] }}</td>
                            <td style="padding: 10px; background-color: #ffe6cd;">{{ $ride['origenRideLongitud'] }}</td>
                            <td style="padding: 10px; background-color: #ffe6cd;">{{ $ride['destinoRideLatitud'] }}</td>
                            <td style="padding: 10px; background-color: #ffe6cd;">{{ $ride['destinoRideLongitud'] }}</td>
                            <td style="padding: 10px;background-color: #ffe6cd;">{{ $ride['calificacion'] }}</td>
                        </tr>
                        @endforeach


                        

            </tr>

        </tbody>

    </table>
    
</body>
</html>