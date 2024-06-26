<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="{{asset('css/app.css')}}">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" }
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Login</title>
</head>
<body>
    <nav class="topNav" id="loginNavbar">
        <a href="{{ route('landing') }}"><p class="h4" id="kitsuneTitle">kitsune</p></a>
    </nav>
    <form class="container" id="loginBox" >
        <p class="h2" id="loginTitle">Log In</p>
        <p id="loginNuevoRegistro">¿Eres nuevo? <a href="">Registrate aquí</a></p>
        <input type="text" id="usernameInput" class="form-control" placeholder="Username">
        <input type="password" class="form-control" id="passwordInput" placeholder="Password">
        <button id="loginSubmitBtn" type="submit">Log in</button>
        <a href=""><button id="loginCancelBtn">Return</button></a>    
    </form>
</body>
</html>