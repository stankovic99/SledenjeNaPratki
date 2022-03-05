<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="project.css">
    </head>
    <body>
    	<div class="nadvoresenDiv">
    		<h2 class="naslov">LOGIN HERE</h2>
    		<form action="LoginApi" method="GET">
            	<label for="usernamelogin">Username</label><br> <input required placeholder="Enter username" type="text" name="usernamelogin"> <br>
            	<label for="passwordlogin">Password</label><br> <input required placeholder="Enter password" type="password" name="passwordlogin"> <br>
            	<button type="submit">Login</button>
        	</form>
        	<a href="register.jsp"><button class="switchButton">Switch to register</button></a>
        	<a href="index.jsp"><button class="switchButton">Back home</button></a>
    	</div>
    </body>
</html>