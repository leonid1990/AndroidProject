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

$typeOfRecreation = $_REQUEST["typeOfRecreation"];
$nameOfCountry = $_REQUEST["nameOfCountry"];
$dateOfBeginning = $_REQUEST["dateOfBeginning"];
$dateOfEnding = $_REQUEST["dateOfEnding"];
$price = $_REQUEST["price"];
$description = $_REQUEST["description"];
$idBusiness = $_REQUEST["idBusiness"];


$sql = "INSERT INTO `android5777_8159_8300`.`Recreation_table`
	(`typeOfRecreation`, `nameOfCountry`, `dateOfBeginning`, `dateOfEnding`, `price`, `description`,`idBusiness`)
	VALUES (\"$typeOfRecreation\", \"$nameOfCountry\", \"$dateOfBeginning\", \"$dateOfEnding\", \"$price\", \"$description\",\"$idBusiness\")";

$sqlUpdate="UPDATE `Changes` SET `recreation`=1";

if ($conn->query($sql) === TRUE) { 
 $conn->query($sqlUpdate);
 echo "New record created successfully";
} else {
 echo "Error: " . $sql . "<br>" . $conn->error;
}
$conn->close();
?>  
