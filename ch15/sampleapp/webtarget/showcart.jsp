<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<head>
 <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
</head>
<h:form>
 <h2>Your shopping cart items to buy now</h2>
 <br/>
 <h:dataTable value="#{OrderJSFBean.cartItems}" var ="shoppingCart"
   headerClass= "header"
   columnClasses="evenCol, oddCol">
   <h:column>
    <f:facet name="header">
      <h:outputText value="Book isbn"/>
    </f:facet>
    <h:outputText value="#{shoppingCart.book_id}"/>
   </h:column>
   <h:column>
    <f:facet name="header">
      <h:outputText value="Quantity"/>
    </f:facet>
    <h:outputText value="#{shoppingCart.units}"/>
   </h:column>
   <h:column>
    <f:facet name="header">
      <h:outputText value="Unit price"/>
    </f:facet>
    <h:outputText value="#{shoppingCart.unit_price}"/>
   </h:column>
   <h:column>
    <h:commandLink action="#{OrderJSFBean.removeFromCart}" value="Delete">
      <f:param name = "itemId" value = "#{shoppingCart.book_id}"/>
    </h:commandLink>    
   </h:column>

 </h:dataTable>
<p/>
 <h:commandButton action="#{OrderJSFBean.ProceedToCheckout}" value="Proceed to checkout"/> 
 <h:commandButton action="continue" value="Continue shopping"/> 
</h:form>
</f:view>