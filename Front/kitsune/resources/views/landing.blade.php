<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Kitsune</title>
</head>
    <body style="background-color: #ffe6cd;">
        <nav class="topNav" id="loginNavbar" style="background-color: orange;color: white;position: absoute;width: 100vw;height: 7vh;text-align: right;padding: 1%;">
            <a href="{{ route('landing') }}">><p class="h4" id="kitsuneTitle" style=" position: absolute;top: 10px;left: 3vw;color: white;">kitsune</p></a>
        </nav>
        <div style=" display: flex;justify-content: center; ">
            <div style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);background-color: white; border-radius: 10px; margin-top: 5%;margin-left: 10%; display: flex;justify-content: center; border-color: orange;">
                <img src="../resources/img/zorrito.png" alt="D">
            </div>
            <div style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);background-color: white; border-radius: 10px; margin-top: 5%;margin-left: 10%;margin-right: 10%; width:max-content; border-color: orange;justify-content:center;">

                <h4 style="margin-top: 10%;text-align: center; color: rgb(248, 131, 6);justify-content:center;">Acerca de kitsune</h4> <br>

                <p style="margin-inline: 10%;color: rgb(248, 131, 6); text-align: center;display: block;max-width: 550px;max-height: 500px;">Kitsune es una innovadora aplicación diseñada para transformar tus viajes diarios en una experiencia fluida y conveniente. Con Kitsune, puedes planificar y realizar tus recorridos de manera eficiente, ya sea que estés yendo al trabajo, a una reunión o simplemente explorando la ciudad. Nuestra plataforma intuitiva te conecta con conductores expertos y te ofrece opciones personalizadas para cada viaje. Simplifica tu día a día con Kitsune y disfruta de la libertad de moverte por la ciudad sin complicaciones.</p>

                <div class="buttons" style="display: flex;justify-content: center; padding: 10px;margin-bottom: 10px;">
                    <button class="btn" style="margin-right: 10px;background-color: #ffe6cd;border-color: rgb(159, 152, 145);"><a href="{{ route('login') }}">Login</a></button>
                    <button class="btn" style="background-color: #ffe6cd;border-color: rgb(159, 152, 145);"><a href="{{ route('crearUsuario') }}">Register</a></button>
                </div>
            </div>
        
        </div>
        
        
    
    </body>
    </html>