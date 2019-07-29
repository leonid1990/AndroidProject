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

$nameBusiness = $_REQUEST["nameBusiness"];
$addressBusiness = $_REQUEST["addressBusiness"];
$phoneNumber = $_REQUEST["phoneNumber"];
$emailAddress = $_REQUEST["emailAddress"];
$websiteLink = $_REQUEST["websiteLink"];


/*$sql = "INSERT INTO `android5777_8159_8300`.`Business_table`
	(`nameBusiness`, `addressBusiness`, `phoneNumber`, `emailAddress`, `websiteLink`,)
	VALUES (\"$nameBusiness\",\"$addressBusiness\", \"$phoneNumber\", \"$emailAddress\", \"$websiteLink\",)";*/
$sql = "INSERT INTO `Business_table`(`idBusiness`, `nameBusiness`, `addressBusiness`,`phoneNumber`, `emailAddress`, `websiteLink`) VALUES (NULL, '$nameBusiness', '$addressBusiness', ' $phoneNumber ', '$emailAddress' ,'$websiteLink')";

$sqlUpdate="UPDATE `Changes` SET `business`=1";

if ($conn->query($sql) === TRUE) {
 $conn->query($sqlUpdate); 
 echo "New record created successfully";
} else {
 echo "Error: " . $sql . "<br>" . $conn->error;
}
$conn->close();
?>  
