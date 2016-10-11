<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Login error page</title></head>
<body>
<c:url var="url" value="/index.jsp"/>
<h2>Invalid user name or password.</h2>
<p>Please enter a user name or password that is authorized to access this application.  For this application, this means a user has been created in the <code>file</code> realm and has been assigned to the <em>group</em> of <code>user</code>.  Click here to <a href="${url}">Try Again</a></h2>
</body>
</html>

