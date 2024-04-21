<?php

use App\Http\Controllers\LoginController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('login');
})->name('login');

Route::get('/solicitar-ride', function(){
    return view('solicitarRide');
});

Route::get('/solicitar-ride/confirm', function(){
    return view('esperarSolicitud');
});

Route::get('/logon', [LoginController::class, 'auth'])->name('logon');