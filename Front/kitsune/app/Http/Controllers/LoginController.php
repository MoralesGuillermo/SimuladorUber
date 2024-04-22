<?php

namespace App\Http\Controllers;

use GuzzleHttp\Client;
use Illuminate\Http\Request;

class LoginController extends Controller
{

    public function auth(Request $request){
        $username = $request->input('username');
        $password = $request->input('password');
        $client = new Client(); // Se abre un client para hacer la request

        $response = $client->get('localhost:8081/kitsune/usuario/logon', 
        ['json' => [
            'username' => $username,
            'passkey' => $password
        ]]);    // Se hace la request. El 'json' es el @RequestBody
        $data = $response->getBody();
        $jsonResponse = json_decode($data, true); // Decodificamos el body para poder usarlo como valores
        if ($jsonResponse["status"] == 200){
            $responseBody = $jsonResponse['responseBody'];
            $cliente = $responseBody['cliente'];
            $clienteId = $cliente['clienteId'];
            $responseCliente = $client->get("http://localhost:8081/kitsune/cliente/perfil/".$clienteId);
            $responseData = json_decode($responseCliente->getBody());
            $perfilcliente = $responseData->responseBody;
            return view('perfil', compact('perfilcliente'), compact('clienteId'));
        }else{
            return $this->authFail();
        }
    }
    
    private function authFail(){
        $failed = true;
        return view('login', compact('failed'));

    }
}
