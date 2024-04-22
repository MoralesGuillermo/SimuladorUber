<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;
use GuzzleHttp\Exception\RequestException;

class UsuarioController extends Controller
{
    public function crear(Request $request){
        try{

            $genero = ($request->input('genero')=='Masculino') ? 'M' : 'F';
            $body = [
                "persona" => [
                "dni" => $request->input('dni'),
                "nombre" => $request->input('nombre'),
                "apellido" => $request->input('apellido'),
                "telefono" => $request->input('telefono'),
                "edad" => $request->input('edad'),
                "genero" => $genero,
                "email" => $request->input('email')
                ],
                "usuario" => [
                    "username" => $request->input('username'),
                    "passkey" => $request->input('passkey')
                ]
            ];

                $jsonBody = json_encode($body);
                $client = new Client();
                $response = $client->post('http://localhost:8081/kitsune/cliente/crear', [
                    'headers' => ['Content-Type' => 'application/json'],
                    'body' => $jsonBody,
                ]);

                $responseData = json_decode($response->getBody(), true);
                $responseBody = $responseData['responseBody'];
                $clienteId = $responseBody['clienteId'];
                return  redirect(route('usuario.perfil', $clienteId));
        }catch(RequestException $e){

            return 'Error al crear el Usuario'.$e->getMessage();

        }

    }

    public function perfil($clienteId){
            try {
                $client = new Client();
                $responseCliente = $client->get("http://localhost:8081/kitsune/cliente/perfil/".$clienteId);
                $responseData = json_decode($responseCliente->getBody());
                $perfilcliente = $responseData->responseBody;
                return view('perfil', compact('perfilcliente'), compact('clienteId'));
            } catch (RequestException $e) {
                return 'Error al mostrar el perfil del cliente'.$e->getMessage();
            }
        
}

public function password($clienteId){
    try {
        $client = new Client();
        $responseCliente = $client->get("http://localhost:8081/kitsune/cliente/perfil/".$clienteId);
        $responseData = json_decode($responseCliente->getBody());
        $perfilcliente = $responseData->responseBody;
        return view('cambiarPassword', compact('perfilcliente'), compact('clienteId'));
    } catch (RequestException $e) {
        return 'Error al mostrar el perfil del cliente'.$e->getMessage();
    }

}

public function savepassword(Request $request,$clienteId){
    try {
        $client = new Client();
        $password = $request->input('password');
        $response = $client->put("http://localhost:8081/kitsune/usuario/cambiarContrasena?userId=".$clienteId."&password=".$password); 
        return redirect(route('login'));
    } catch (RequestException $e) {
        return 'Error al cambiar la contraseña'.$e->getMessage();
    }

}


public function borrarUsuario($clienteId){
    try {
        $client = new Client();
        $responseCliente = $client->put("http://localhost:8082/kitsune/usuario/eliminar/".$clienteId);
        
        return view('landing');
        
    } catch (RequestException $e) {
        return 'Error al mostrar el perfil del cliente'.$e->getMessage();
    }


    
}


public function mostrarRidesClientes($clienteId){
    try {
        $client = new Client();
        $response= $client->get("http://localhost:8082/kitsune/cliente/mostrarRidesParaFront/".$clienteId);
        
        $responseData = json_decode($response->getBody(), true);
        $responseBody = $responseData['responseBody'];

        // Crear un objeto que contenga el array responseBody
        $rides = ['rides' => $responseBody];


        return view('mostrarRidesCliente', ['rides' => $responseBody]);



        
    } catch (RequestException $e) {
        return 'Error al mostrar el perfil del cliente'.$e->getMessage();
    }
}
}