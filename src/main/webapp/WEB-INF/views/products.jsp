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

	<table border="1">
		<thead><tr><td>Product Name</td><td>Product Type</td><td>Product Description</td><td>Product Subtype</td><td>Entry Date</td><td>Usage Flag</td><td>Action</td></tr></thead>
		<tbody>
				<c:if test="${fn:length(productList) == 0}">
				<tr><td><c:out value="Sorry,No records"></c:out></td></tr>
				</c:if>
				<c:forEach items='${productList}'  var= "product">
					<tr>
						<td><c:out value='${product.prodName }'/> </td>
						<td><c:out value='${product.prodDesc }'/> </td>
						<td><c:out value='${product.prodType}'/> </td>
						<td><c:out value='${product.prodSubType }'/> </td>
						<td><c:out value='${product.prodEntryDate }'/> </td>
						<td><c:out value='${product.prodUsgFlg }'/> </td>
						<td><a href='<c:url value="/product/edit/${product.prodId}" />'>Edit</a></td></tr>
				</c:forEach>
		</tbody>
	</table>
<table>
<form:form method= "post" action = '/storemgmt/product/add' modelAttribute='productFormBean'>
		<tr><td><form:label path='prodName'>Product Name</form:label></td></tr>
			<tr><td><form:input path='prodName' id='prodName' tabindex='1'/></td><td><form:errors path="prodName"/></td></tr>
			
		<tr><td><form:label path='prodType'>Product Type</form:label></td></tr>
			<tr><td><form:input path='prodType' id='prodType' tabindex='2'/></td><td><form:errors path="prodType"/></td></tr>
			
		<tr><td><form:label path='prodSubType'>Product SubType</form:label></td></tr>
			<tr><td><form:input path='prodSubType' id='prodSubType' tabindex='3'/></td><td><form:errors path="prodSubType"/></td></tr>
			
		<tr><td><form:label path='prodDesc'>Product Desc</form:label></td></tr>
			<tr><td><form:input path='prodDesc' id='prodDesc' tabindex='4' /></td><td><form:errors path="prodDesc"/></td></tr>
			
		<tr><td><form:label path='barCode'>Bar Code</form:label></td></tr>
			<tr><td><form:input path='barCode' id='barCode' tabindex='5'/></td><td><form:errors path="barCode"/></td></tr>
		
		
			<tr><td><form:hidden path='prodId' id='prodId'/></td></tr>
				
		<tr><td><button type="Submit" tabindex="6"> Submit</button></td></tr>
</form:form>
</table>
</div>
</body>
</html>