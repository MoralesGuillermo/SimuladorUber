<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Editar Alumno</title>
</head>
<body>
    <div class="container">
        
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h2>Editar Alumno</h2>
                <br>
                <form action='{{route('alumno.actualizar', $alumno->codigoAlumno)}}' method="POST">
                    @csrf
                    @method('PUT')
                    <div class="form-group">
                        <label for="color">Codigo Alumno:</label>
                        <input type="text" class="form-control" name="nombre" id="nombre" value="{{$alumno->codigoAlumno}}" readonly/>
                    </div>
                    <div class="form-group">
                        <label for="color">Nombre:</label>
                        <input type="text" class="form-control" name="nombre" id="nombre" value="{{$alumno->nombre}}"/>
                    </div>
                    <div class="form-group">
                        <label for="metros">Apellido:</label>
                        <input type="text"class="form-control" name="apellido" value="{{$alumno->apellido}}"/>
                    </div>
                    <div class="form-group">
                        <label for="tipoPropiedad">Correo:</label>
                        <input type="text" class="form-control" name="correo" value="{{$alumno->correo}}"/>
                    </div>
                    <div class="form-group">
                        <label for="costomtr">Telefono:</label>
                        <input type="text" class="form-control" name="telefono" value="{{$alumno->telefono}}"/>
                    </div>
                    <div class="form-group">
                        <label for="codigoduenio">Direccion:</label>
                        <input type="text" class="form-control" name="direccion" value="{{$alumno->direccion}}"/>
                    </div>
                    <div class="form-group">
                        <label for="domicilio">Codigo Carrera:</label>
                        <input type="text" class="form-control" name="codigoCarrera" value="{{$alumno->codigoCarrera}}"/>
                    </div>

                    <div class="form-group">
                        <label for="domicilio">Fecha Nacimiento:</label>
                        <input type="date" class="form-control" name="fechaNacimiento" value="{{$alumno->fechaNacimiento}}"/>
                    </div>

                    <div class="form-group">
                        <label for="domicilio">Numero cuenta:</label>
                        <input type="text" class="form-control" name="numeroCuenta" value="{{$alumno->numeroCuenta}}"/>
                    </div>

                    <br>
                    <div class="form-group">
                        <a href="{{route('alumno.principal')}}" class="btn btn-warning">Volver</a>
                        <button type="submit" class="btn btn-success">Guardar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>