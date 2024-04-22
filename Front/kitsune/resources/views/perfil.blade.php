<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="{{ asset('../resources/css/app.css') }}">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Perfil | Kitsune</title>
</head>
<body style="background-color: orange;">



    <style type="text/css">
    html {
        -webkit-text-size-adjust: 100%;
        -ms-text-size-adjust: 100%;
        text-size-adjust: 100%;
        line-height: 1.4;
    }
    
    
    * {
        margin: 0;
        padding: 0;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
    }
    .seccion-perfil-usuario .perfil-usuario-portada {
    display: block;
    position: relative;
    width: 90%;
    height: 17rem;
    background-image: linear-gradient(45deg, #BC3CFF, #317FFF);
    border-radius: 0 0 20px 20px;
    
    background-image: url('{{ asset('../resources/img/kitsune.jpg') }}');
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    
}
    
    </style>

        <section class="seccion-perfil-usuario">
            <div class="perfil-usuario-header">
                <div class="perfil-usuario-portada">
                    <a href="{{ route('landing') }}"><p class="h4" id="kitsuneTitle">kitsune</p></a>
                    <div class="perfil-usuario-avatar">
                        <img src="{{ asset('../resources/img/usuario.jpg') }}" alt="img-avatar">
                        <button type="button" class="boton-avatar"  href="{{ route('borrarUsuario', ['clienteId' => $clienteId]) }}">
                            <i class="far fa-image"></i>
                        </button>
                    </div>
                </div>
            </div>
            <div class="perfil-usuario-body">
                <div class="perfil-usuario-bio">
                    <h3 class="titulo">{{$perfilcliente->perfilPersona->nombre}} {{$perfilcliente->perfilPersona->apellido}}</h3>
                    <p class="texto">Comienza a viajar con nosotros {{$perfilcliente->perfilPersona->nombre}} !!
                    </p>
                </div>
                <div class="perfil-usuario-uber">
                    <ul class="lista-datos">
                        <li><i class="icono fas fa-map-signs"></i> DNI: {{$perfilcliente->perfilPersona->dni}}</li>
                        <li><i class="icono fas fa-phone-alt"></i> Telefono: {{$perfilcliente->perfilPersona->telefono}}</li>
                        <li><i class="icono fas fa-briefcase"></i> Email: {{$perfilcliente->perfilPersona->email}}</li>
                        <li><i class="icono fas fa-building"></i> Edad: {{$perfilcliente->perfilPersona->edad}}</li>
                    </ul>
                    <ul class="lista-datos">
                        <li><i class="icono fas fa-map-marker-alt"></i> Genero: {{$perfilcliente->perfilPersona->genero}}</li>
                        <li><i class="icono fas fa-calendar-alt"></i> Username: {{$perfilcliente->username}}</li>
                        <a class="btn btn-warning"  href="{{ route('ride') }}">Solicitar Ride</a>
                        <a class="btn btn-success" href="{{ route('mostraRidesCliente', ['clienteId' => $clienteId]) }}">Historico Rides</a>
                        <p> </p>
                        <a class="btn btn-warning"  href="{{ route('cambiarPassword') }}">Cambiar Contraseña</a>
                        <a class="btn btn-success"  href="{{ route('nuevaTarjeta') }}">Agregar Tarjeta</a></button>

                        <!--Cambio hecho por Danny, para agregar el boton borrar usuario -->
                        <form method="POST" action="{{ route('borrarUsuario', ['clienteId' => $clienteId]) }}" style="margin-top: 10%">
                            @csrf
                            @method('PUT')
                            <button type="submit" class="btn btn-warning">Borrar usuario</button>
                        </form>
                    </ul>
            </div>
        </section>

    <style>
    .mensaje a {
        color: inherit;
        margin-right: .5rem;
        display: inline-block;
    }
    .mensaje a:hover {
        color: #309B76;
        transform: scale(1.4)
    }
    </style>
</body>
</html>