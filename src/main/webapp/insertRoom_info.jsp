<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.room_management.dao.Room_Category_Dao, com.room_management.entity.Room_category"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Info</title>
</head>
<body>
	<form method="post" action="Register_Room">
		<h1>Enter the room info here</h1>
		<select name="category_id" onchange="fetchStudent(this.value)"
			required>
			<option>Select an option</option>

			<%
			int selectedcategory = 0;
			%>
			<%
			Room_Category_Dao roomcatdao = new Room_Category_Dao();
			List<Room_category> room_categories = roomcatdao.getAllCategory();
			for (Room_category room_cat : room_categories) {
				out.println("<option value='" + room_cat.getCat_id() + "'>" + room_cat.getCat_name() + room_cat.getCat_id()
				+ "</option>");
			}
			%>




		</select>

		<%
		if (request.getParameter("catId") != null) {
			Room_Category_Dao roomcatDao = new Room_Category_Dao();
			int id = 0;

			id = Integer.parseInt(request.getParameter("catId"));

			Room_category obj = roomcatDao.getCategoryById(id);
			out.println("<p>" + "selected option is (" + obj.getCat_id() + " - " + obj.getCat_name() + ") and the price is - "
			+ obj.getPrice() + "</p>");
		%>

		<input name="room_id" value="<%=obj.getCat_id()%>" style="display: none"/> <input name="room_no"
			placeholder="Enter the room no here" /> <input type="submit"
			placeholder="Submit room details" />
	</form>
	<%
	}
	%>
	<script>
		function fetchStudent(studentId) {
			console.log(studentId);
			window.location.href = "/room_management_system/insertRoom_info.jsp?catId="
					+ studentId;
		}
	</script>

</body>
</html>