<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;

class TestController extends Controller
{

    public function index()
    {
        $cliente = new Client();

        $response = $cliente->get('localhost:8081/kitsune/cliente/test');
            
            $historico = $response->getBody();
    
            return view('back', compact('historico'));
 
    }

    public function vista(){
        return view('index');
    }
}
