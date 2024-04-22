<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Agregar Tarjeta | Kitsune</title>
</head>
<body style="background-color: #ffe6cd;">
    <nav class="topNav" id="loginNavbar" style="background-color: orange;color: white;position: absoute;width: 100vw;height: 7vh;text-align: right;padding: 1%;">
        <a href="{{ route('landing') }}"><p class="h4" id="kitsuneTitle" style=" position: absolute;top: 10px;left: 3vw;color: white;">kitsune</p></a>
    </nav>
    <div style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);background-color: white; border-radius: 10px; margin-top: 10%;margin-left: 33%; width:max-content; display: flex;justify-content: center; border-color: orange;">

        

        <form style="padding: 50px; padding-block: 20px;" method="POST" action='{{route('crearTarjeta')}}'>
            @csrf
            @method('POST')

            <p class="h3" style="color: rgb(255, 166, 2);padding: 50px; padding-block: 20px;" >Nueva tarjeta</p><br> 
            <label style="padding: 10px;color: rgb(248, 131, 6);" for="usuario">Usuario:</label> <br>
            <input class="form-control" style="padding: 10px ; border-radius: 25px;" type="text" id="usuario" name="usuario" value="pablito"><br>
    
            <label style="padding: 10px;color: rgb(248, 131, 6);;" for="pan">Pan:</label><br>
            <input class="form-control" style="padding: 10px;border-radius: 25px;" id="pan" name="pan" value="999999"><br>
    
            
            <label style="padding: 10px;color: rgb(248, 131, 6);;" for="fechaCaducidad">Fecha caducidad</label><br>
            <input class="form-control" style="padding: 10px;border-radius: 25px;" id="fechaCaducidad" name="fechaCaducidad" value="999999"><br>

            <label style="padding: 10px;color: rgb(248, 131, 6);;" for="CCV">CCV:</label><br>
            <input class="form-control" style="padding: 10px;border-radius: 25px;" id="CCV" name="CCV" value="999992"><br>

            <label style="padding: 10px;color: rgb(248, 131, 6);;" for="metodoPago">Metodo de Pago:</label><br>
            <input class="form-control" style="padding: 10px;border-radius: 25px;" id="metodoPago" name="metodoPago" value="E"><br>

            <div class="buttons" style="padding: 10px">
                <button class="btn" style="background-color: #ffe6cd;border-color: rgb(159, 152, 145);"><a href="#" onclick="history.go(-1); return false;">Cancelar</a></button>
                <button class="btn" style="background-color: #ffe6cd;border-color: rgb(159, 152, 145);" type="submit">Confirmar</button>
            </div>
        </form>
  </div>
</body>
</html>