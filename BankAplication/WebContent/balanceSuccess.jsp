<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABCBank</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
html,body{
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  font-family:sans-serif;
}

.b1{
  width: 100%;
  height: 100%;
  margin: auto;
  background: url(rubal5.jpg) no-repeat 50% 50%;
  display: table;
  background-size: cover;
  position:relative;
  top:0;
  bottom:0;
}
.b2{
  position:absolute;
  top:0;
  bottom:0;
  width: 100%;
  height: 100%;
  background-color:rgba(0,0,0,0.6);
}
.inner{
position:absolute;
width:80%;
top:35%;
left:10%;
height:20vh;
background:#D3D3D3;
animation:text2 1s 1;
border-radius:5px;
box-shadow:20px 15px 5px rgba(0,0,0,0.5);
}
.text{
position:absolute;
top:30%;
left:35%;
font-size:30px;
text-align:center;
font-family:sans-serif;
}
@keyframes text2{
0%{
opacity:0;
margin-top:5%
}
100%{
opacity:1;
}
}

</style>
</head>
<body>

<section class = "b1">
<section class = "b2">
<div class = "inner">
<div class = "text">
<%
session = request.getSession();
out.println("The Balance is :");
out.println(session.getAttribute("balance"));
%>
</div>
</div>
</section>
</section>
</body>
</html>