<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add customer</title>
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
	
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<h3>Save Customer</h3>
	
	<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	
			<form:hidden path="id"></form:hidden>
	
			First name: <form:input type="text" path="firstName" />
			
			<br><br>
			Last name: <form:input type="text" path="lastName" />
			<form:errors path="lastName" cssClass="error"></form:errors>
			<br><br>
			Email : <form:input path="email"/>
			<form:errors path="email" cssClass="error"></form:errors>
			<br><br>
		
			
			<input type="submit" value="Save" class="save">
		 
	</form:form>

<p>
	<a href="${pageContext.request.contextPath }/customer/list">Back to list</a>
</p>

</body>
</html>