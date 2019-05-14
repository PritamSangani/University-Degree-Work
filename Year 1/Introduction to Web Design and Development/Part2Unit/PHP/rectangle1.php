<!-- The HTML starts here-->
<table border='1'>
<tr>
<td>Rectangle 1: Pritam Sangani 16039231 <?php echo date('d/m/y'); ?></td>
<td>Rectangle 2: <?php echo (3 + 4 + 5); ?></td>
</tr>
<tr>
<td>Rectangle 3: <?php srand(3034); echo(rand()); ?></td>
<td>Rectangle 4: <?php for($x = 30; $x <= 40; $x++){
	if($x % 2 == 0){
		echo ("$x ");
	}
} ?></td>
</tr><td>Rectangle 5: <form action="rectangle1.php" method="post">
						  Enter four digit number or four letters: <input type="text" name="userInput">
						  <input type="submit">
					  </form>
					  <?php $x = $_POST["userInput"];  ?></td> 
<td>Rectangle 6: <?php if(is_numeric($x)){
							if($x % 2 == 0){
								echo"{$x} is even";
							}
							else{
								echo"{$x} is odd";
							}
						}
						else{
							echo"{$x} is not a number";
						}
				?>
</td>
</tr>
<tr>
<td>Rectangle 7: <?php if(is_numeric($x))
						{
							srand($x); echo(rand());
						}
						else
						{
							echo"Enter a number in rectangle 5";
						}?></td>
<td>Rectangle 8: <?php if(is_string($x))
						{			
							echo str_rot13($x); 
						}
						else
						{
							echo"Enter a word or a string in rectangle 5";
						}?></td>
</tr>
<tr>
<td>Rectangle 9: <script>
                    var x = "<?php echo $x ?>";
                    var rot13 = x.replace(/[a-zA-Z]/g,function(c){return String.fromCharCode((c<="Z"?90:122)>=(c=c.charCodeAt(0)+13)?c:c-26);});
                    document.write(rot13);
                </script></td>
<td>Rectangle 10: <?php $i = 0; 
						while($i <= 10000)
						{
							if(md5("m".$i) == '77c12394ef7d4f23a8fa07d87309afd9')
							{
								echo "m".$i;
							}
						$i++;
						}?></td>
</tr>
</table> 