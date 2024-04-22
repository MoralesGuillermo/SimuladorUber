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
                return view('perfil', compact('perfilcliente'));
            } catch (RequestException $e) {
                return 'Error al mostrar el perfil del cliente'.$e->getMessage();
            }
        
}
}
