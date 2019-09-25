<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Search Form</title>
<link
	href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js" />"></script>
<script
	src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#checkBoxAll').click(function() {
			if ($(this).is(":checked"))
				$('.chkCheckBoxId').prop('checked', true);
			else
				$('.chkCheckBoxId').prop('checked', false);
		});
	});
</script>
</head>
<body>
	<div align="center">
		<h1>Employee Search Form</h1>

		<form:form action="employeeSearch" modelAttribute="employeeSearch"
			method="POST">
			<label>Employee Name</label>
			<input type="text" name="employee_name"
				value="${param.employee_name}" placeholder="Enter Employee Nmae">
			<br />
			<table>
				<%
					int incrementYears = 8;
						//first is Jan 
						Calendar first = Calendar.getInstance();
						first.set(Calendar.MONTH, Calendar.JANUARY);
						first.set(Calendar.DAY_OF_MONTH, 1);

						//second is Dec
						Calendar second = Calendar.getInstance();
						second.set(Calendar.MONTH, Calendar.DECEMBER);
						second.set(Calendar.DAY_OF_MONTH, 31);
				%>

				<tr>
					<td>Date Of Birth</td>
					<td>
						<!-- year dropdown --> <%@ page import="java.util.Calendar"%>
						<select name="year_select">
							<%
								int current_year = Calendar.getInstance().get(Calendar.YEAR);
									for (int year = 1980; year <= current_year; year++) {
							%>
							<option>
								<%=year%>
							</option>
							<%
								}
							%>
					</select>
					</td>

					<td><select name="monthy">
							<%
								while (second.after(first)) {
										if (first.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH)) {
							%>
							<option value="<%=first.get(Calendar.MONTH) + 1%>"
								selected="true"><%=first.get(Calendar.MONTH) + 1%></option>
							<%
								} else {
							%>
							<option value="<%=first.get(Calendar.MONTH) + 1%>"><%=first.get(Calendar.MONTH) + 1%></option>
							<%
								}
							%>
							<%
								first.add(Calendar.MONTH, 1);
									}
							%>
					</select></td>

				</tr>

				<tr>
					<td><label>Age</label> <input type="text" name="age"
						value="${param.age}"> <br /></td>
				</tr>

				<tr>
					<td><label>Gender</label></td>
					<td><input type="radio" name="gender" value="male">Male
						<input type="radio" name="gender" value="female">Female <input
						type="radio" name="gender" value="custom">Custom</td>
				</tr>

			</table>
			<button>Search</button>
			<td><input type="button"
				onclick="location.href='/spring5training'" value="Back"></td>
		</form:form>

		<form:form action="deleteEmployee" modelAttribute="employee"
			method="POST">

			<input type="submit" value="Delete"
				onclick="return confirm('Are u sure?')" />
			<input type="submit" value="Excel"
				onclick="return confirm('Want to Excel Sheet?')" />
			<table border="1">



				<th>No</th>
				<th><input type="checkbox" id="checkBoxAll" /></th>
				<th>Edit</th>
				<th>EmployeeID</th>
				<th>EmployeeName</th>
				<th>Date Of Birth</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Note</th>

				<c:forEach var="employee" items="${listEmployee}"
					varStatus="loopCounter">

					<tr>
						<td><c:out value="${loopCounter.count}" /></td>
						<td><input type="checkbox" class="chkCheckBoxId"
							value="${employee.id}" name="id" /></td>
						<td><a href="editEmployee?id=${employee.id}">Edit</a></td>
						<td>${employee.employee_id}</td>
						<td>${employee.employee_name}</td>
						<td>${employee.date_of_birth}</td>
						<td>${employee.age}</td>
						<td>${employee.gender}</td>
						<td>${employee.note}</td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
	</div>

	<!-- script -->
</body>
</html>