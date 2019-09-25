<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link
	href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js" />"></script>
<script
	src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container emp-search">
		<div class="col-md-offset-2 col-md-7">
			<div class="panel panel-info">

				<div class="insertemp">
					<div class="panel-body">

						<form:form action="saveEmployee" method="post"
							modelAttribute="employee">


							<form:hidden path="id" />

							<div class="form-group row">
								<form:label path="employee_name" for="colFormLabelSm"
									class="col-sm-3 col-form-label col-form-label-sm">Employee Name</form:label>
								<div class="col-sm-6">
									<form:input path="employee_name"
										class="form-control form-control-sm" id="empname" />
								</div>
							</div>

							<%
								String pass = request.getParameter("id");
									if (pass == null) {
							%>
							<div class="form-group row">
								<form:label path="password" for="colFormLabelSm"
									class="col-sm-3 col-form-label col-form-label-sm">Password</form:label>
								<div class="col-sm-3">
									<form:password showPassword="true" path="password"
										class="form-control form-control-sm" id="password"></form:password>
								</div>
							</div>
							<%
								} else {
							%>
							<div class="form-group row">
								<form:label path="password" for="colFormLabelSm"
									class="col-sm-3 col-form-label col-form-label-sm">Password</form:label>
								<div class="col-sm-4">
									<form:password showPassword="true" path="password"
										readOnly="true" class="form-control form-control-sm"
										id="password"></form:password>
									<a href="#">Edit</a>
								</div>
							</div>
							<%
								}
							%>

							<div class="form-group row">
								<form:label path="date_of_birth" for="colFormLabelSm"
									class="col-sm-3 col-form-label col-form-label-sm">Date of Birth</form:label>
								<div class="col-sm-3">
									<form:input path="date_of_birth"
										class="form-control form-control-sm" id="dateofbirth" />
								</div>
							</div>

							<%
								String age = request.getParameter("id");
									if (age == null) {
							%>
							<div class="form-group row">
								<form:label path="age" for="colFormLabelSm"
									class="col-sm-3 col-form-label col-form-label-sm">Age</form:label>
								<div class="col-sm-3">
									<form:input path="age" class="form-control form-control-sm"
										id="age" />
								</div>
							</div>
							<%
								} else {
							%>
							<div class="form-group row">
								<form:label path="age" for="colFormLabelSm"
									class="col-sm-3 col-form-label col-form-label-sm">Age</form:label>
								<div class="col-sm-3">
									<form:input path="age" readOnly="true" />
								</div>
							</div>
							<%
								}
							%>

							<fieldset class="form-group">
								<div class="row">
									<form:label path="gender" for="colFormLabelSm"
										class="col-sm-3 col-form-label col-form-label-sm">Gender</form:label>
									<div class="col-2">
										<div class="form-check">
											<form:radiobutton class="form-check-input" id="male"
												path="gender" value="male" />
											Male
										</div>
									</div>
									<div class="col-2">
										<div class="form-check">
											<form:radiobutton class="form-check-input" id="female"
												path="gender" value="female" />
											Female
										</div>
									</div>
									<div class="col-2">
										<div class="form-check">
											<form:radiobutton class="form-check-input" id="custom"
												path="gender" value="custom" />
											Custom
										</div>
									</div>
								</div>
							</fieldset>

							<div class="form-group row">
								<form:label path="note" for="comment"
									class="col-sm-3 col-form-label col-form-label-sm">Note</form:label>
								<div class="col-6">
									<form:textarea path="note" class="form-control" id="comment" />
								</div>
							</div>

							<div class="form-group row">
								<label for="colFormLabelSm"
									class="col-sm-3 col-form-label col-form-label-sm"></label>
								<div class="col">
									<input type="submit" value="Save" class="btn btn-secondary insbut1"/> 
									<input type="reset" value="Clear" class="btn btn-secondary insbut"/>
									<%
										String back = request.getParameter("id");
											if (back == null) {
									%>
									<input type="button" onclick="location.href='/spring5training'"
										value="Back" class="btn btn-secondary insbut">
									<%
										} else {
									%>
									<input type="button"
										onclick="location.href='/spring5training/listEmployee'"
										value="Back" class="btn btn-secondary insbut">
									<%
										}
									%>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>