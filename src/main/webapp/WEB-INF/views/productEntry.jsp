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
						
					<tr><td><form:label path='prodCategory'>Product Type</form:label></td></tr>
						<tr><td><%--  As this populates value from value tag on the screen... in our case it shows the id 
						on selecting the value from options available which is not user friendly
									
									<input placeholder="Product Type" id="prodCategory" name="prodCategory" list="productTypeList" tabindex="2">
											<datalist id="productTypeList">
															<c:forEach items="${productTypeList}" var="productType">	
																<option id="productType" value='<c:out value="${productType.getCategoryId()}"></c:out>'><c:out value="${productType.getCategoryName()}"></c:out></option>
															</c:forEach>
											</datalist>
											</input>--%>
						<%--<form:select path="prodCategory" id="prodCategory" items="${productTypeList}" itemValue="CategoryId" itemLabel="CategoryId" />--%>
						
						
											<select id="prodCategory" name="prodCategory" tabindex="2">
													<option value =''> Select the Type of Product</option>
												<c:forEach items="${productTypeList}" var="productType">	
													<option value='<c:out value="${productType.getCategoryId()}" />' <c:if test="${productFormBean.prodCategory eq productType.categoryId}">selected ="selected"</c:if>><c:out value="${productType.getCategoryName()}"/></option>
												</c:forEach>
											</select>
								</td><td><form:errors path="prodCategory"/></td></tr>
						
					<tr><td><form:label path='prodSubCategory'>Product SubType</form:label></td></tr>
					<tr><td><%-- <input placeholder="Product SubType" id='prodSubCategory' name='prodSubCategory'  list="productSubTypeList" tabindex='3'></td><td>
								<datalist id="productSubTypeList">
									<c:forEach items="${productSubTypeList}" var="productSubType">
										<option id="productSubType" name="productSubType" class='<c:out value="${productSubType.getParentCategoryId()}"/>' value="<c:out value='${productSubType.getSubCategoryId()}'/>"><c:out value='${productSubType.getSubCategoryName()}'/></option>
									</c:forEach>
								</datalist>
							</input> --%>

								<select id='prodSubCategory' name='prodSubCategory' tabindex='3'>
									<c:forEach items="${productSubTypeList}" var="productSubType">
										<option  class='<c:out value="${productSubType.getParentCategoryId()}"/>' value="<c:out value='${productSubType.getSubCategoryId()}'/>"><c:out value='${productSubType.getSubCategoryName()}'/></option>
									</c:forEach>
								</select>
						
							<form:errors path="prodSubCategory"/></td></tr>
						
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
<script type="text/javascript">
	function filterSubType(){
		
		var choosenParentType = document.getElementById("prodCategory").valueOf();
		
		document.getElementById("prodCategory").addEventListener("OnChange", hideOptions);
		
		function hideOptions()
		{
			var availableChildType = document.getElementsByName("productSubType");
			
		}
	}
</script>
</html>