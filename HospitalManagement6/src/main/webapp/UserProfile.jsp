<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
        // Retrieve the session object
        HttpSession session1 = request.getSession(false);

        // Check if the session is not null and the username attribute is set
        if (session != null && session.getAttribute("username") != null) {
            
            String username = (String) session.getAttribute("username");
            String email = (String) session.getAttribute("email");
            String phone = (String) session.getAttribute("phone");
            String area = (String) session.getAttribute("area");
            String city = (String) session.getAttribute("city");
            String state = (String) session.getAttribute("state");
            String date = (String) session.getAttribute("date");
            String time = (String) session.getAttribute("time");
            String postCode = (String) session.getAttribute("postCode");
    %>
<h1>Welcome<%=username %></h1>
<h2>Here are Your Appointment Details...</h2>
<table style="border:1px solid black">
<tr>
<th>Name</th>
<th>email</th>
<th>phone</th>
<th>area</th>
<th>city</th>
<th>state</th>
<th>date</th>
<th>time</th>
<th>postal code</th>
</tr>
<tr>
<td><%=username %></td>
<td><%=email %></td>
<td><%=phone %></td>
<td><%=area %></td>
<td><%=city %></td>
<td><%=state %></td>
<td><%=date %></td>
<td><%=time %></td>
<td><%=postCode %></td>
</tr>
</table>
<a href="Index.html">Home</a>
 <%
        } else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("Index.jsp");
        }
    %>

 
</body>
</html>