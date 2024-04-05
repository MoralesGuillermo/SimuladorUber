<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Alumno;

class AlumnoController extends Controller
{
    //

    public function inicio(){
        $alumnos = Alumno::all();
        return view('alumnos', compact('alumnos'));
    }

    public function crear(){
        return view('crear');
    }

    public function guardar(Request $request){
        $nvoAlumno = new Alumno();
        $nvoAlumno->nombre = $request->input('nombre');
        $nvoAlumno->apellido = $request->input('apellido');
        $nvoAlumno->correo   = $request->input('correo');
        $nvoAlumno->telefono = $request->input('telefono');
        $nvoAlumno->direccion = $request->input('direccion');
        $nvoAlumno->codigoCarrera = $request->input('codigoCarrera');
        $nvoAlumno->fechaNacimiento = $request->input('fechaNacimiento');
        $nvoAlumno->numeroCuenta    = $request->input('numeroCuenta');
        $nvoAlumno->save();

        return redirect('/alumnos');
    }

    public function editar($id){
        $alumno = Alumno::find($id);
        return view('editar', compact('alumno'));
    }

    public function actualizar(Request $request, $id){
        $alumno = Alumno::find($id);
        $alumno->nombre = $request->input('nombre');
        $alumno->apellido = $request->input('apellido');
        $alumno->correo   = $request->input('correo');
        $alumno->telefono = $request->input('telefono');
        $alumno->direccion = $request->input('direccion');
        $alumno->codigoCarrera = $request->input('codigoCarrera');
        $alumno->fechaNacimiento = $request->input('fechaNacimiento');
        $alumno->numeroCuenta    = $request->input('numeroCuenta');
        $alumno->save();

        return redirect('/alumnos');
    }

    public function eliminar($id){
        $alumno = Alumno::find($id);
        return view('eliminar', compact('alumno'));
    }

    public function destroy($id){
        $alumno = Alumno::find($id);
        $alumno->delete();

        return redirect('/alumnos');
    }
}
