<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form action="PostConditions" method="get">
		<fieldset>
			<legend>veuillez introduire les post-conditions</legend>
			<br>nom <input type="text" name="name" value="nom"><br>
                        <br> contenu<input type="text" name="type" value="type"><br>

                        <br>  <br>

			<input type="submit" value="ajouter un autre" name="other">
                        <input type="submit" value="fin" name="fin">

                        
		</fieldset>
	</form>



</body>
</html>