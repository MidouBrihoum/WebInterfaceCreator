<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form action="operation" method="get">
		<fieldset>
			<legend>veuillez introduire les informations concrétes de l'operation</legend>
			<br>nom <input type="text" name="name" value="nom"><br>
                        <br>type du service  <input type="text" name="type" value="type"><br>
                        <br>titre concréte <input type="text" name="concret" value="concret"><br>
                        <br>ligne du début <input type="text" name="debut" value="debut"><br>
                        <br>ligne de fin <input type="text" name="fin" value="fin"><br>

                        <br>  <br>

                        <input type="submit" value="fin" name="fin">

                        
		</fieldset>
	</form>



</body>
</html>