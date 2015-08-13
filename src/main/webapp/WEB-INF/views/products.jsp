<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Products</title>
</head>
<body>
<div>
	<table>
		<thead><tr><td>Product Name</td><td>Product Type</td><td>Product Subtype</td><td>Entry Date</td><td>Usage Flag</td></tr></thead>
		<tbody>	
				<c:if test="${fn:length(productList) == 0}">
				<tr><td><c:out value="Sorry,No records"></c:out></td></tr>
				</c:if>
			
				<c:forEach items='${productList}'  var= "product">				
					<tr><td><c:out value='${product.prodName }'/> </td><td><c:out value='${product.prodType}'/> </td><td><c:out value='${product.prodSubType }'/> </td><td><c:out value='${product.prodEntryDate }'/> </td><td><c:out value='${product.prodUsgFlg }'/> </td></tr>
				</c:forEach>
		</tbody>
	</table>
</div>

<div>
	<form:form method= "post" action = 'add' modelAttribute='productFormBean'>
	
		<form:label path='prodName'>Product Name</form:label><form:input path='prodName' id='prodName' tabindex='1'/><form:errors path="prodName"/>
		<form:label path='prodType'>Product Type</form:label><form:input path='prodType' id='prodType' tabindex='2'/><form:errors path="prodType"/>
		<form:label path='prodSubType'>Product SubType</form:label><form:input path='prodSubType' id='prodSubType' tabindex='3'/><form:errors path="prodSubType"/>
		<form:label path='prodDesc'>Product Desc</form:label><form:input path='prodDesc' id='prodDesc' tabindex='4' /><form:errors path="prodDesc"/>
		<form:label path='barCode'>Bar Code</form:label><form:input path='barCode' id='barCode' tabindex='5'/><form:errors path="barCode"/>
		<button type="Submit"> Submit</button>	
	</form:form>
</div>
</body>
</html>