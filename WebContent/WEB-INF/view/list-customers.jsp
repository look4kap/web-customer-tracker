<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype=html>
<html>
	
	<head>
		<title>
			List all customers
		</title>
		
		<!-- reference style sheet -->
		
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css " />
	</head>
	<body>

		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
	
		<div id="container">
		
			<div id="content">
				<input type="button" value="Add Customer"
					onclick="window.location.href='showFormAddCustomer';return false;"
					class="add-button"
				/>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>			
					
					<c:forEach var="tempCustomer" items="${customers}">
						
						<c:url var="updateLink" value="/customer/showFormEditCustomer">
							<c:param name="customerId" value="${tempCustomer.id}"/>
						</c:url>	
						<tr>
							<td> ${tempCustomer.firstName}</td>
							<td> ${tempCustomer.lastName}</td>
							<td> ${tempCustomer.email}</td>
							<td> <a href="${updateLink}">Edit</a></td>
							
						</tr>
						
					</c:forEach>	
				</table>
			</div>
		</div>
		
	</body>
</html>