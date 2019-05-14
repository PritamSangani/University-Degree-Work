<!-- The HTML starts here-->
<?php
$servername = "localhost";
$username = "root";
$password = "";
$db = "lab2";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $db);

// Check connection
if (!$conn) 
{
    die("Connection failed: " . mysqli_connect_error());
}
else
{
	echo "Connection is successfull";
}
?>

<table border='1'>
<tr>
<td>Rectangle 1: Pritam Sangani, 16039231, Today's Date:  <?php echo date('d/m/y'); ?>, Version of MySQL: <?php echo mysql_get_server_info(); ?></td>
<td>Rectangle 2: <?php $sqlQuery = 'SELECT * FROM lab2 WHERE username = 13022';
					   $result = mysqli_query($conn, $sqlQuery);
					  
					   while($row = mysqli_fetch_assoc($result))
					   {
						   echo "ID: " . $row["id"];
					   }
				  ?></td>
</tr>
<tr>
<td>Rectangle 3: <?php $sqlQuery = 'SELECT * FROM lab2 WHERE password = "5f4f7141b65a730b4efb0e0d51f63e94"';
					   $result = mysqli_query($conn, $sqlQuery);
					  
					   while($row = mysqli_fetch_assoc($result))
					   {
						   echo "ID: " . $row["id"];
					   }
				  ?></td>
<td>Rectangle 4:  <?php $sqlQuery = 'SELECT * FROM lab2 WHERE name = "McKee  Heidi C."';
					   $result = mysqli_query($conn, $sqlQuery);
					  
					   while($row = mysqli_fetch_assoc($result))
					   {
						   echo "Password: " . $row["password"];
					   }
				  ?></td>
</tr><td>Rectangle 5: <?php $sqlQuery = 'SELECT * FROM lab2 WHERE username < 100';
					   $result = mysqli_query($conn, $sqlQuery);
					   echo nl2br("List of people with a numeric 'username' value less than 100: \n");
					   while($row = mysqli_fetch_assoc($result))
					   {
						   echo $row["name"];
                           echo nl2br("\n");
					   }
				      ?></td> 
<td>Rectangle 6: <?php $sqlQuery = 'SELECT * FROM lab2 WHERE password LIKE "%b42c3e0713278dd%"';
					   $result = mysqli_query($conn, $sqlQuery);
					   echo "Person who has password like that: ";
					   while($row = mysqli_fetch_assoc($result))
					   {
						   echo $row["name"];
					   }
                 ?></td>
</tr>
<tr>
<td>Rectangle 7: <?php $sqlQuery = 'SELECT * FROM lab2 WHERE name LIKE "%Kelly%"';
					   $result = mysqli_query($conn, $sqlQuery);
					   echo nl2br("List of people who have 'Kelly' in their name: \n");
					   while($row = mysqli_fetch_assoc($result))
					   {
						   echo $row["name"];
                          					   echo nl2br("\n");
					   }
                  ?></td>
<td>Rectangle 8: <?php $sqlQuery = 'SELECT * FROM lab2 WHERE name LIKE "%Penny%"';
					   $result = mysqli_query($conn, $sqlQuery);
					   echo "Number of 'Penny's in the database: " . mysqli_num_rows ($result);
                  ?></td>
</tr>
<tr>
<td>Rectangle 9: <?php $sqlQuery = 'SELECT * FROM lab2 WHERE username < 600';
					   $result = mysqli_query($conn, $sqlQuery);
					   echo "Number of people with a numeric 'username' value less than 600: " . mysqli_num_rows($result);
                  ?></td>
<td>Rectangle 10: <?php $sqlQuery = 'SELECT * FROM lab2 WHERE username BETWEEN 700 AND 1500';
					   $result = mysqli_query($conn, $sqlQuery);
					   echo "Number of people with a numeric 'username' value between 700 and 1500: " . mysqli_num_rows ($result);
                  ?></td>
</tr>
</table> 