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

$TimeBusiness = $_REQUEST["TimeBusiness"];

 $sqlUpdate="UPDATE `ChangesTime` SET `business`= \"$TimeBusiness\"";
  
if ($conn->query($sqlUpdate) === TRUE) {
 echo "Business Time Updateted";
} else {
 echo "Error: " . $sql . "<br>" . $conn->error;
}	
    
  $conn->close(); 
?>

