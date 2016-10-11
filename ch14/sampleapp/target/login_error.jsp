<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <head><title>Login error page</title></head>
 <body>
  <c:url var="url" value="index.faces"/>
  <h2>User name or password is wrong.</h2>
  <p>Please enter a valid user name and password. Click here to <a href="${url}">try again.</a></p>
 </body>
</html>

