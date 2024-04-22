<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href='css/app.css'">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"  crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Historico Rides | Kitsune</title>
</head>
<body>
    <nav class="topNav" id="loginNavbar" style="background-color: orange;color: white;position: absoute;width: 100vw;height: 7vh;text-align: right;padding: 1%;">
        <a href="{{ route('landing') }}">><p class="h4" id="kitsuneTitle" style=" position: absolute;top: 10px;left: 3vw;color: white;">kitsune</p></a>
    </nav>

    <table style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);background-color: #FD8600;border-collapse: collapse; border-radius: 10px; margin-top: 20%;margin-left: 35%;" >
        <thead>
            <tr>
                <td style="padding: 10px; background-color: orange;border-top-left-radius: 10px; color: #ffffff;">Cliente</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Precio</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Fecha</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Origen</td>
                <td style="padding: 10px; background-color: orange;color: #ffffff;">Destino</td>
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

                    <tr>
                        <td style="padding: 10px; background-color: #ffe6cd;border-bottom-left-radius: 10px;">Carlos</td>
                        <td style="padding: 10px; background-color: #ffe6cd;">25</td>
                        <td style="padding: 10px; background-color: #ffe6cd;">12/2/2345</td>
                        <td style="padding: 10px; background-color: #ffe6cd;">13.53.65</td>
                        <td style="padding: 10px; background-color: #ffe6cd;">12.43.53</td>
                        <td style="padding: 10px;background-color: #ffe6cd;border-bottom-right-radius: 10px;">4/5</td>
                    </tr>
                

            </tr>

        </tbody>

    </table>
    <a href="#" onclick="history.go(-1); return false;" class="btn" style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);background-color: orange; margin: 10px; color: #ffffff;margin-left: 35%;">Volver</a>
    <a href="{{ route('ride') }}" class="btn" style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);background-color: orange; margin: 10px; color: #ffffff;margin-left: 35%;">Nuevo Ride</a>
</body>
</html>