<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link rel="stylesheet" href="project.css">
    </head>
    <body>
    	<div class="nadvoresenDiv">
    		<h2 class="naslov">REGISTER HERE</h2>
        	<form action="RegisterApi" method="POST">
            	<label>Username</label><br><input required type="text" placeholder="Enter username" name="username"> <br>
            	<label>Password</label><br><input required type="password" placeholder="Enter password" name="password"> <br>
            	<label>Confirm password</label><br><input required type="password" placeholder="Confirm password" name="confirmpassword"> <br>
            	<label>Name</label><br><input required type="text" placeholder="Enter name" name="name"> <br>
            	<label>Surname</label><br><input required type="text" placeholder="Enter surname" name="surname"> <br>
            	<button type="submit">Register</button>
       		</form>
        	<a href="login.jsp"><button class="switchButton">Switch to login</button></a>
        	<a href="index.jsp"><button class="switchButton">Back home</button></a>
    	</div>
    </body>
</html>