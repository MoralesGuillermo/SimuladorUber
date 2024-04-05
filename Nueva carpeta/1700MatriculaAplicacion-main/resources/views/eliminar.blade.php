<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Eliminar</title>
</head>
<body>
    <h1>Eliminar Alumno</h1>
    <br>
    <br>
    <table class="table">
        <thead>
            <tr>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Correo</th>
                <th>Telefono</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td>{{$alumno->codigoAlumno}}</td>
                    <td>{{$alumno->nombre}}</td>
                    <td>{{$alumno->apellido}}</td>
                    <td>{{$alumno->correo}}</td>
                    <td>{{$alumno->telefono}}</td>
                </tr>
        </tbody>
    </table>
    <div class="form-group">
        <a href="{{route('alumno.principal')}}" class="btn btn-warning">Volver</a>
        <a href="{{route('alumno.destroy', $alumno->codigoAlumno)}}" class="btn btn-danger">Eliminar</a>                    
    </div>

</body>
</html>