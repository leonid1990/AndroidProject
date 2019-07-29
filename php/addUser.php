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

$nameUser = $_REQUEST["nameUser"];
$password = $_REQUEST["password"];

$sql = "INSERT INTO `android5777_8159_8300`.`User_table`
	(`nameUser`, `password`)
	VALUES (\"$nameUser\",\"$password\")";

$sqlUpdate="UPDATE `Changes` SET `user`=1";

if ($conn->query($sql) === TRUE) {
 $conn->query($sqlUpdate);
 echo "New record created successfully";
} else {
 echo "Error: " . $sql . "<br>" . $conn->error;
}
$conn->close();
?>  
