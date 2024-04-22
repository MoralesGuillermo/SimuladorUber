<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TestController;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\RidesController;
use App\Http\Controllers\UsuarioController;
use App\Http\Controllers\TarjetaController;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/


Route::get('/test/inicio', [TestController::class, 'vista']);
Route::get('/test/back', [TestController::class, 'index']);

Route::get('/login', function () {
    return view('login');
})->name('login');

Route::get('/crear', function () {
    return view('crearUsuario');
})->name('crearUsuario');

    
Route::post('/guardar', [UsuarioController::class, 'crear'])->name('crear');

    Route::get('/password/{clienteId}',[UsuarioController::class, 'password'])->name('password');

    Route::put('/password/save/{clienteId}', [UsuarioController::class, 'savepassword'])->name('savepassword');
Route::get('/password', function () {
    return view('cambiarPassword');
})->name('cambiarPassword');

Route::get('/solicitar-ride', function(){
    return view('ride');
})->name('ride');

Route::get('/solicitar-ride/confirm', function(){
    return view('esperarSolicitud');
});

Route::get('/logon', [LoginController::class, 'auth'])->name('logon');

Route::get('/', function () {
    return view('landing');
})->name('landing');

Route::get('/perfil/{clienteId}',[UsuarioController::class, 'perfil'])->name('usuario.perfil');

Route::get('/nuevaTarjeta', function () {
    return view('nuevaTarjeta');
})->name('nuevaTarjeta');

Route::get('/conductor', function () {
    return view('vistaConductor');
})->name('conductor');

Route::get('/mostrarRides', function () {
    return view('mostrarRidesCliente');
})->name('mostrarRides');

Route::post('/crearTarjeta', [TarjetaController::class, 'crearTarjeta'])->name('crearTarjeta');

Route::get('/make-solicitar-ride', [RidesController::class, 'solicitarRide'])->name('solicitarNuevoRide');

Route::get('/consultar-precio/{distancia}', [RidesController::class, 'consultarPrecio']);

Route::get('/calificar/{rideId}', [RidesController::class, 'vistaCalificar'])->name('vistaCalificar');

Route::get('/calificacion', [RidesController::class, 'calificar'])->name('calificar');

Route::post('/crearTarjeta', [TarjetaController::class, 'crearTarjeta'])->name('crearTarjeta');