<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
 <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <link rel="stylesheet" href="contact.css">
</head>
<body>
 <div class="container">
        <div data-aos="fade-up"
     data-aos-duration="3000">

<div class="contact">
<form action="AdminLoginServlet2" method="post"> <!-- Change method to "post" -->
            <label for="name">Username:</label>
            <input type="text" id="name" name="name" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <button type="submit">Login</button>
        </form>
 </div>
 </div>
</div>

<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
    AOS.init();
  </script>
</body>
</html>