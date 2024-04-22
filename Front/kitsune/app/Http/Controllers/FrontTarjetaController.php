<?php

namespace App\Http\Controllers;


use Illuminate\Http\Request;
use GuzzleHttp\Client;
use GuzzleHttp\Exception\RequestException;

class FrontTarjetaController extends Controller
{
    public function crearTarjeta(Request $request){
        try{



            //Creas un objeto que contenga la data
            $body = [
                "username" => $request->input('usuario'),
                "cvv" => $request->input('cvv'),
                "pan" => $request->input('pan'),
                "fechaCaducidad" => $request->input('fechaCaducidad'),
                "metodosDePago" => [$request->input('metodoPago')]

                
            ];

         
            //Transoformas el objeto a json
            $jsonBody = json_encode($body);

            //Creas el objeto que tiene las funciones http
            $client = new Client();

            //Usas el objeto guardando el response que creamos en el back
            $response = $client->post('http://localhost:8082/kitsune/tarjeta/crear', [
                'headers' => ['Content-Type' => 'application/json'],
                'body' => $jsonBody,
            ]); 
           
            //Podes tomar variables pequeñas para cosas como
            $username = $request->input('usuario');
            //Esta
            $response = $client->get('http://localhost:8082/kitsune/tarjeta/idClienteObtener/'.$username);

        

            $responseData = json_decode($response->getBody(), true);
            $responseBody = $responseData['responseBody'];
            $clienteId = $responseBody;


            return  redirect(route('usuario.perfil', $clienteId));

        }catch(RequestException $e){

            return 'Error al crear la tarjeta'.$e->getMessage();

        }

    }
}
