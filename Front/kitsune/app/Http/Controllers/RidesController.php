<?php

namespace App\Http\Controllers;

use GuzzleHttp\Client;
use Illuminate\Http\Request;

class RidesController extends Controller
{
    public function solicitarRide(Request $request){
        $originLat = $request->input('originLat');
        $originLng = $request->input('originLng');
        $destinationLat = $request->input('destinationLat');
        $destinationLng = $request->input('destinationLng');
        $distancia = $request->input('distance');
        $clienteId = intval($request->input('clienteId'));
        $precio = floatval($request->input('realPrice'));
        $client = new Client(); // Se abre un client para hacer la request

        $response = $client->post('localhost:8081/kitsune/ride/solicitar', 
        ['json' => [
            'distancia' => $distancia,
            'costo' => $precio,
            'clienteid' => $clienteId,
            'origen' => ['latitud' => $originLat, 'longitud' => $originLng],
            'destino' => ['latitud' => $destinationLat, 'longitud' => $destinationLng]
        ]]);    // Se hace la request. El 'json' es el @RequestBody
        $data = $response->getBody();
        $jsonResponse = json_decode($data, true); // Decodificamos el body para poder usarlo como valores
        if ($jsonResponse["status"] == 200){
            echo "Ride solicitado con exito";
        }else{
            echo "NADA";
            echo $jsonResponse["status"];
        }
    }

    public function consultarPrecio($distancia){
        $client = new Client();
        $requestUrl = 'localhost:8081/kitsune/ride/solicitar-precio/'.$distancia;
        $response = $client->get($requestUrl);
        $jsonResponse = json_decode($response->getBody(), true);
        return $jsonResponse["responseBody"];
    }

    public function vistaCalificar($rideId){
        return view('calificarRide', compact('rideId'));
    }

    public function calificar(Request $request){
        $rideId = $request->input('rideId');
        $calificacion = $request->input('calificacion');
        $client = new Client();
        $response = $client->put('localhost:8081/kitsune/ride/calificar/'.$rideId."?calificacion=".$calificacion ); 
        $data = $response->getBody();
        $jsonResponse = json_decode($data, true); 
        echo $jsonResponse["status"];
        
    }

    public function viewSolicitar(Request $request){
        $clienteId = $request->input("clienteId");
        return view('solicitarRide', compact('clienteId'));
    }

    public function cancelar($rideId, $clienteId){
        $client = new Client();
        $requestUrl = 'localhost:8081/kitsune/ride/cancelar/'.$rideId;
        $response = $client->put($requestUrl);
        return redirect('/perfil/'.$clienteId);   
    }

    public function preguntarRideAceptado($rideId){
        $client = new Client();
        $requestUrl = 'localhost:8081/kitsune/ride/preguntar-aceptado/'.$rideId;
        $response = $client->get($requestUrl);
        return $response->getBody();
    }

}
