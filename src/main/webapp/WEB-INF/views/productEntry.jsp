<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="include.jsp" %>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter a Product to Inventory</title>
</head>
<body>
<div class="container">
	<div class="form">
		<table>
			<form:form method= "post" action = '/storemgmt/product/add' modelAttribute='productFormBean' autocomplete="off">
					<tr><td><form:label path='prodName'>Product Name</form:label></td></tr>
						<tr><td><form:input path='prodName' id='prodName' tabindex='1'/></td><td><form:errors path="prodName"/></td></tr>
						
					<tr><td><form:label path='prodType'>Product Type</form:label></td></tr>
						<tr><td><select placeholder="Product Type" name="prodType" list="productTypes" tabindex="2">
											<datalist id="productTypes"/>
															<c:forEach items="${productTypes}" var="product">	
																<option value='<c:out value="${product.getType_id()}"></c:out>'><c:out value="${product.getType_name()}"></c:out></option>
															</c:forEach>
											</datalist>
											</select>
								</td><td><form:errors path="prodType"/></td></tr>
						
					<tr><td><form:label path='prodSubType'>Product SubType</form:label></td></tr>
						<tr><td><form:input path='prodSubType' id='prodSubType' tabindex='3'/></td><td><form:errors path="prodSubType"/></td></tr>
						
					<tr><td><form:label path='prodDesc'>Product Desc</form:label></td></tr>
						<tr><td><form:input path='prodDesc' id='prodDesc' tabindex='4' /></td><td><form:errors path="prodDesc"/></td></tr>
						
					<tr><td><form:label path='barCode'>Bar Code</form:label></td></tr>
						<tr><td><form:input path='barCode' id='barCode' tabindex='5'/></td><td><form:errors path="barCode"/></td></tr>
					
					<tr><td><form:label path='prodEntryDate'>Product created On</form:label></td></tr>
						<tr><td><form:input path='prodEntryDate' id='prodEntryDate' tabindex='6'/></td><td><form:errors path="prodEntryDate"/></td></tr>
					
						<tr><td><form:hidden path='prodId' id='prodId'/></td></tr>
							
					<tr><td><button type="Submit" tabindex="7"> Submit</button></td></tr>
			</form:form>
		</table>
	</div>
</div>
</body>
</html>