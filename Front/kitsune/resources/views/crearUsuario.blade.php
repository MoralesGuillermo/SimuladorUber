<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Nuevo Usuario | Kitsune</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
  <!-- Estilos personalizados -->
  <style>
    body {
      background-color: #F8F9FA; /* Fondo gris claro */
    }
    .form-container {
      background-color: #FFFFFF; /* Fondo blanco */
      border-radius: 10px;
      padding: 30px;
      box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    }
    .form-title {
      color: orange; /* Naranja */
    }
    text {
      display: flex; 
      justify-content: center; 
      align-items: center; 
      color:#F8F9FA;
    }
  </style>
</head>
<body style="background-color: orange;">
  <nav class="topNav" id="loginNavbar" style="background-color: orange;color: white;position: absoute;width: 100vw;height: 7vh;text-align: right;padding: 1%;">
    <a href="{{ route('landing') }}"><p class="h4" id="kitsuneTitle" style=" position: absolute;top: 10px;left: 3vw;color: white;">kitsune</p></a>
</nav>
<div style="background: orange; top:0%;" >
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="form-container">
          <h2 class="text-center form-title mb-4">Registro de Nuevo Usuario - Kitsune</h2>
          <form method="POST" action='{{route('crear')}}'>
            @csrf
            @method('POST')
            <div class="mb-3">
              <label for="dni" class="form-label">DNI:</label>
              <input type="text" pattern="[0-9]{1,13}" class="form-control" id="dni" name="dni" required>
            </div>
            <div class="mb-3">
              <label for="nombre" class="form-label">Nombre:</label>
              <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="mb-3">
              <label for="apellido" class="form-label">Apellido:</label>
              <input type="text" class="form-control" id="apellido" name="apellido" required>
            </div>
            <div class="mb-3">
              <label for="telefono" class="form-label">Teléfono:</label>
              <input type="tel" class="form-control" id="telefono" name="telefono" required>
            </div>
            <div class="mb-3">
              <label for="email" class="form-label">Email:</label>
              <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
              <label for="edad" class="form-label">Edad:</label>
              <input type="number" class="form-control" id="edad" name="edad" required>
            </div>
            <div class="mb-3">
              <label for="genero" class="form-label">Género:</label>
              <select class="form-select" id="genero" name="genero" required>
                <option value="" selected disabled>Seleccionar</option>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
              </select>
            </div>
            <div class="mb-3">
              <label for="username" class="form-label">Nombre de Usuario:</label>
              <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="mb-3">
              <label for="passkey" class="form-label">Contraseña:</label>
              <input type="password" class="form-control" id="passkey" name="passkey" required>
            </div>
            <div class="d-grid">
              <button type="submit" class="btn btn-primary" >Registrarse</a></button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
  <!-- Bootstrap Bundle with Popper -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>


