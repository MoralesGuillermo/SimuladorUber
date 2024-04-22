<!DOCTYPE html>
<html lang="en">
<head>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body style="background-color: #ffe6cd;">
    <nav class="topNav" id="loginNavbar" style="background-color: orange;color: white;position: absoute;width: 100vw;height: 7vh;text-align: right;padding: 1%;">
        <a href="{{ route('landing') }}"><p class="h4" id="kitsuneTitle" style=" position: absolute;top: 10px;left: 3vw;color: white;">kitsune</p></a>
    </nav>
    <div style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);background-color: white; border-radius: 10px; margin-top: 10%;margin-left: 33%; width:max-content; display: flex;justify-content: center; border-color: orange;">

        

        <form style="padding: 50px; padding-block: 20px;">
            <p class="h3" style="color: rgb(255, 166, 2);padding: 50px; padding-block: 20px;" >Cambio de contraseña</p><br> 
            <label style="padding: 10px;color: rgb(248, 131, 6);" for="usuario">Usuario:</label> <br>
            <input class="form-control" style="padding: 10px ; border-radius: 25px;" type="text" id="usuario" name="usuario" value="NombreDeUsuarioMaziso"><br>
    
            <label style="padding: 10px;color: rgb(248, 131, 6);;" for="contrasena">Nueva Contraseña:</label><br>
            <input class="form-control" style="padding: 10px;border-radius: 25px;" type="password" id="contrasena" name="contrasena" value="ContraseñaMaziso2"><br>
    
            <div class="buttons" style="padding: 10px">
                <button class="btn" style="background-color: #ffe6cd;border-color: rgb(159, 152, 145);"><a href="{{ route('perfil') }}">Cancelar</a></button>
                <button class="btn" style="background-color: #ffe6cd;border-color: rgb(159, 152, 145);"><a href="{{ route('login') }}">Confirmar</a></button>
            </div>
        </form>
  </div>
</body>