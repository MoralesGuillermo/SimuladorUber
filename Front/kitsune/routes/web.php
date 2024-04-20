<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('login');
});

Route::get('/solicitar-ride', function(){
    return view('solicitarRide');
});

Route::get('/solicitar-ride/confirm', function(){
    return view('esperarSolicitud');
});