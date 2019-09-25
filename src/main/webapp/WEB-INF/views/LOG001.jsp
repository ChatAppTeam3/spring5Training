<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <link href='<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />'
  rel="stylesheet">
</head>
<style type="text/css">
  .container{
    margin-top: 90px;
  }

  h5.card-title{
    text-align: center;
  }
  #logButton{
    padding-left: 24%;
  }
  #forStar{
  color:red;
  }
</style>
<body>
 <div class="container" >
  <div class="row">
   <div class="col-sm-6 offset-sm-3">
    <div class="panel">
     <div class="panel panel-heading">
      <div class="panel panel-body">
       <div class="form-group" id="box">
        <form:form action="login" method="post" modelAttribute="employee" name="employeeForm">
        <table>

         <tr><td><form:input path="id" type="hidden" name="id"  class="form-control"/></td></tr>
         
         <div class="form-group row">
           <label for="employeeId" class="col-sm-3 col-form-label">Employee Id<span id="forStar">(*)</span></label>
           <div class="col-sm-6">
            <form:input type="text" path="employee_id" name="employee_id" class="form-control" required="required"/> 
            <form:errors path="employee_id" cssClass="error" />
          </div>
        </div>
        <div class="form-group row">
          <label for="password" class="col-sm-3 col-form-label">Password<span id="forStar">(*)</span></label>
          <div class="col-sm-6">
           <form:input type="password" path="password" name="password" class="form-control" required="required" />
           <form:errors path="password" cssClass="error" />
         </div>
       </div>


       <div class="btn-sm" id="logButton">
        <div class="col-sm-8">
          <button type="submit" class="btn btn-secondary">Login</button>
         <button type="submit" class="btn btn-secondary">Cancel</button>
       </div>
     </div>
   </form:form>
 </div>
</div>
</div>
</div>
</div>
</div>
</div>
<script src="<c:url value="/webjars/jquery/3.4.1/jquery.min.js" />"></script>
<script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />"></script>
</body>
</html>