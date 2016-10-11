<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<head>
 <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
</head>
<h:form>
 <h2>List of books</h2>
 <br/>
 <h:dataTable value="#{book.allBooks}" var ="book"
   headerClass= "header"
   columnClasses="evenCol, oddCol">
   <h:column>
    <f:facet name="header">
      <h:outputText value="ISBN"/>
    </f:facet>
    <h:outputText value="#{book.isbn}"/>
   </h:column>
   <h:column>
    <f:facet name="header">
      <h:outputText value="Title"/>
    </f:facet>
    <h:outputText value="#{book.title}"/>
   </h:column>
   <h:column>
    <f:facet name="header">
      <h:outputText value="Author"/>
    </f:facet>
    <h:outputText value="#{book.author}"/>
   </h:column>
   <h:column>
    <f:facet name="header">
      <h:outputText  value="Price"/>
    </f:facet>
    <h:outputText value="#{book.price}"/>
   </h:column>
   <h:column>
    <f:facet name="header">
      <h:outputText  value="Copies left"/>
    </f:facet>
    <h:outputText value="#{book.quantity}"/>
   </h:column>
   <h:column>
    <h:commandLink action="#{OrderJSFBean.addToCart}" value="Add to cart">
      <f:param name = "isbn" value = "#{book.isbn}"/>
      <f:param name = "price" value = "#{book.price}"/>
    </h:commandLink>    
   </h:column>
 </h:dataTable>
 <p/>
 <h:commandButton action="showcart" value="Move to cart"/> 
 </h:form>
</f:view>