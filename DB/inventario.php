
<?PHP

#Archivo usado para conectar con la base de datos, se define el tipo de conexion, l nombre de la base de datos, el usuario y la contraseña de la conexion
$hostname="den1.mysql1.gear.host:3306";
$database="grupo5";
$username="grupo5";
$password="Ue8e6SnY_x-L";
$json=array();
$codigo = $_GET['codigo'];
    if(isset($codigo)){        
        
        $conexion=mysqli_connect($hostname, $username, $password, $database);
        $consulta= "SELECT * FROM inventario WHERE codigo = '$codigo'";
        
        $resultado = mysqli_query($conexion, $consulta);
        
        if($consulta){ #Se procede a buscar el jugador, y si se encuentra, se envia un json.
            
            if($reg=mysqli_fetch_array($resultado)){
                $json['inventario'][]=$reg;
            }
            mysqli_close($conexion);
            echo json_encode($json);
        }
        else{
            $results["idInventario"]='';
			$results["cantidad"]='';
			$results["codigo"]='';
			$results["nombre"]='';
            $results["precio"]='';
            $results["idLoc"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}
    }else{
            $results["idInventario"]='';
            $results["cantidad"]='';
            $results["codigo"]='';
            $results["nombre"]='';
            $results["precio"]='';
            $results["idLoc"]='';
            $json['datos'][]=$results;
            echo json_encode($json);
    }

?>
