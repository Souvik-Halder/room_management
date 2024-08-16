<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Employee Details here</h1>
<form method="post" action="Employee_sevlet">
<input name="emp_id" placeholder="Enter the employee id here"/>
<input name="emp_name" placeholder="Enter the employee Name here"/>

<input name="address" placeholder="Enter the employee address here"/>

<input name="phone_no" placeholder="Enter the employee PhoneNo here"/>
<select name="designation" >
<option value="" >Select the designation of Employee</option>
<option value="manager" >Manager</option>
<option value="staff">Staff</option>
<option value="cleaning_dept">cleaning department</option>
<option value="receptionist">Receptionist</option>
</select>
<input name="jdate" type="date"/>
<input name="salary" placeholder="Enter the employee Salary here"/>
<input type="submit" placeholder="Save Data"/>
</form>

</body>
</html>