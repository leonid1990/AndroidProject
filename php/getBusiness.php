<?php 
header('Content-Type: text/html; charset=utf-8'); 
$servername = "localhost"; 
$username = "mor_arye"; 
$password = "android5777_8159_8300"; 
$dbname = "android5777_8159_8300"; 

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
mysql_query("SET NAMES 'utf8'", $conn);
// Check connection
if ($conn->connect_error) {
 die("Connection failed: " . $conn->connect_error);
}


 $sql ="SELECT *
 		FROM `Business_table`";
 
 $result = $conn->query($sql); 
 
 $data = array();
 if ($result->num_rows > 0)   // if there is rows, add to array
	{  while ($row = $result->fetch_assoc()) 
		{array_push($data,$row); }  
       echo json_encode(array('Businesses' => $data)); }

 else {  echo "0 results"; }

  $conn->close(); 
?>

