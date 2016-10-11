<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
 <head><title>Login Page</title></head>
 <h2>Please login:</h2>
 <form method="POST" action="j_security_check">
  <p>Enter Customer ID: <input type="text" name="j_username" size="25"></p>
  <p>Enter Password:<input type="password" size="15" name="j_password"></p>
  <input type="submit" value="Submit">
  <input type="reset" value="Reset">
 </form>
</html>
