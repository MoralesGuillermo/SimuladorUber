<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
    <body style="background-color: #ffe6cd;">
        <nav class="topNav" id="loginNavbar" style="background-color: orange;color: white;position: absoute;width: 100vw;height: 7vh;text-align: right;padding: 1%;">
            <a href="{{ route('landing') }}"><p class="h4" id="kitsuneTitle" style=" position: absolute;top: 10px;left: 3vw;color: white;">kitsune</p></a>
        </nav>
        <div style=" display: flex;justify-content: center; ">
            <div style=" border-radius: 10px; margin-top: 5%;margin-left: 10%; display: flex;justify-content: center; width: 1000px;height: 500px;">
                <div style="width: 90%;height: 80%;background-color: rgb(255, 241, 241); border-radius: 20px;margin-top: 6%; border: 2px solid orange">
                    <div style="margin-top: 10%;justify-content: center;margin-bottom: 7%;"> <p style="display: grid;justify-content: center; background-color: rgba(254, 180, 77, 0.475); margin-inline: 10%;border-radius: 20px">Solicitud pendiente</p></div>
                    <div style="display: grid; grid-template-rows: 100px 100px;grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr;">
                    
                       <div style="display: grid; grid-template-rows: 100px 100px;grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr; "> 
                    
                        <div style="margin-left: 300%;">
                            <div style="grid-column: 2; grid-row: 1;"><h6>Cliente:</h6></div>
                            <div style="grid-column: 3; grid-row: 1;"><h6>Origen:</h6></div>
                            <div style="grid-column: 4; grid-row: 1;"><h6>Destino:</h6></div>
                            <div style="grid-column: 5; grid-row: 1;"><h6>Kilometros:</h6></div>
                            <div style="grid-column: 6; grid-row: 1;"><h6>Cuota:</h6></div>
                        </div>

                        <div style="margin-left: 550%;"> 
                            <div style="grid-column: 2;grid-row: 2;">Cliente</div> 
                            <div style="grid-column: 3;grid-row: 2;">Origen</div> 
                            <div style="grid-column: 4;grid-row: 2;">Destino</div> 
                            <div style="grid-column: 5;grid-row: 2;">12312300</div> 
                            <div style="grid-column: 6;grid-row: 2;">23</div> 
                        </div>
                    
                    </div> 
                        
                        


                        <button style="grid-column: 2;grid-row: 3; background-color: rgb(248, 131, 6);" class="btn">Rechazar</button>
                        <button style="grid-column: 6;grid-row: 3; background-color: rgba(254, 180, 77, 0.475);" class="btn">Aceptar</button>

                    </div>
                </div>
            </div>
        
            <div style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);background-color: rgb(255, 238, 238); border-radius: 10px; margin-top: 5%;margin-left: 10%;margin-right: 10%; max-width: 400px;min-width: 200px;; border: 2px solid orange"justify-content:center;">
                <div style="display: flex; margin-top: 10%;margin-left: 5%;">
                    <img src="css\src html danny\user.png" alt="" style="max-width: 15px;max-height: 15px;margin-top: 6px;">
                    <a style="margin-left: 5px;color: rgb(248, 131, 6); text-decoration: none;" href="" >Conductor</a>
                    
                </div>
                <div style="display:grid; margin-top: 10%; justify-content: center;">
                    <h6>Rating:</h6>

                </div>
                <p style= "margin-inline: 10px;border-radius: 10px;background-color: rgba(254, 180, 77, 0.475) ;display: grid;justify-content: center;">asaasdasdasdasdsdasd</p>
                <div style="display:grid; margin-top: 10%; justify-content: center;">
                    <h6>Vehiculo:</h6>
                </div>
                <p style= "margin-inline: 10px;border-radius: 10px;background-color: rgba(254, 180, 77, 0.475) ;display: grid;justify-content: center;">asaasdasdasdasdsdasd</p>
                <div style="display:grid; margin-top: 10%; justify-content: center;">
                    <h6>Placa:</h6>
                </div>
                <p style= " margin-inline: 10px;border-radius: 10px;background-color: rgba(254, 180, 77, 0.475) ;display: grid;justify-content: center;">asaasdasdasdassd</p>
                <div style="display:grid; margin-top: 10%; justify-content: center;">
                    <h6>Ubicacion:</h6>
                </div>
                <p style= "margin-inline: 10px;border-radius: 10px;background-color: rgba(254, 180, 77, 0.475) ;display: grid;justify-content: center;">asaasdasdasdasdsdasd</p>

                <div style="display: flex;justify-content: center;margin-top: 30%;border-radius: 10px;border: 10px;">
                    <div style="display: flex;justify-content: center;width: 150px; height: 50px; background-color: rgba(254, 180, 77, 0.475); border-radius: 20px;">
                        <h6 style="margin-top: 13px;display: block;justify-content: center;">Disponible</h6>
                    </div>
                </div>
                
            </div>
        
        </div>
        
        
    
    </body>
    </html>