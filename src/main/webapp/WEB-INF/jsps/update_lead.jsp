<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
    <h2>Update Lead</h2>
    
    <form action ="updateLead" method="post">
    
    <pre>
    Id<input type="text" name="id" value="${lead.id}"/>
     First name<input type="text" name="firstName"value="${lead.firstName}"/>
    Last name<input type="text" name="lastName" value="${lead.lastName}"/>
    Email<input type="text" name="email" value="${lead.email}"/>
    Mobile<input type="text" name="mobile" value="${lead.mobile}"/>
    
    <input type = "submit" value= "update">
    </pre>
   
    </form>
    
   ${msg}
    
</body>
</html>