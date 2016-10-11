<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rslt" dataSource="jdbc/mysqlpool">
  select isbn, title, quantity, price from dbsample.books
</sql:query>
<html>
 <head>
   <title>JDBC Connection Test</title>
 </head>
 <body>
  <h1>Available books:</h1>
  <font face="arial">
  <c:forEach var="book" items="${rslt.rows}">
    <b>Isbn:</b> ${book.isbn}<br/>
    <b>Title:</b> ${book.title}<br/>
    <b>Price:</b> $${book.price}<br/>
    <b>In stock:</b> ${book.quantity}<br/>
    <br/>
   </c:forEach>
   </font>
  </body>
</html>
