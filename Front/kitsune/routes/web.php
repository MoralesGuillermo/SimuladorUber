<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TestController;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\UsuarioController;
use App\Http\Controllers\FrontTarjetaController;

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

Route::get('/', function () {
    return view('login');
})->name('login');

Route::get('/crear', function () {
    return view('crearUsuario');})->name('crearUsuario');

    
    Route::post('/guardar', [UsuarioController::class, 'crear'])->name('crear');
    Route::get('/guardarperfil', [UsuarioController::class, 'perfil'])->name('perfil');
   
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

Route::get('/landing', function () {
    return view('landing');
})->name('landing');


Route::get('/perfil', function () {
    return view('perfil');
})->name('perfil');




    //Creadas por Danny
            Route::get('/nuevaTarjeta', function () {
                return view('nuevaTarjeta');
            })->name('nuevaTarjeta');





                Route::post('/crearTarjeta', [FrontTarjetaController::class, 'crearTarjeta'])->name('crearTarjeta');
                Route::get('/perfil/{clienteId}',[UsuarioController::class, 'perfil'])->name('usuario.perfil');


                Route::get('/mostrarRidesCliente/{clienteId}',[UsuarioController::class, 'mostrarRidesClientes'])->name('mostraRidesCliente');
                Route::put('/borrarUsuario/{clienteId}',[UsuarioController::class, 'borrarUsuario'])->name('borrarUsuario');