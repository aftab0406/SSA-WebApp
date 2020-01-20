<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>

<meta charset="ISO-8859-1">
<title>SSA Registration Form</title>
</head>
<body>
	<h1 style="color:red;text-align:center">Registration Form For SSA</h1>
	<form:form action="RegisterCitizenShip" method="POST" modelAttribute="appModel">
		<table border="2" align="center">
			<tr>
				<td>First Name: </td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name: </td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Date Of Birth: </td>
				<td><form:input path="dob" id="datepicker"/></td>
			</tr>
			<tr>
				<td>Gender: </td>
				<td>
					<form:radiobutton path="gender" value="Male"/>Male
					<form:radiobutton path="gender" value="Female" checked="true"/>Female
				</td>
			</tr>
			<tr>
				<td>State: </td>
				<td>
					<form:select path="state">
						<form:option value="NONE">-Select-</form:option>
						<form:options items="${stateNames}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Submit"/>
					<input type="reset" value="Result"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>

<script>
  $(function() {
    $("#datepicker").datepicker({
		changeMonth: true,
		changeYear: true
    });
  });
  
</script>
</html>