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
		<div class="col-md-6">
				<form:form class ="form" method="post" action='/storemgmt/product/add'
					modelAttribute='productFormBean' autocomplete="off">
					
					<span class="form-group ${(not empty (pageResult.getFieldErrors('prodName'))) ? 'has-error': ''}">
						<form:label path='prodName' class="control-label">Product Name</form:label>
						<form:input path='prodName' id='prodName' tabindex='1' placeholder="Product Name" class="form-control" />
						<form:errors path="prodName" />
					</span>

					<span class="form-group">
						<form:label path='prodCategory' class="control-label">Product Type</form:label>
											
							<%--  As this populates value from value tag on the screen... in our case it shows the id 
						on selecting the value from options available which is not user friendly
									
									<input placeholder="Product Type" id="prodCategory" name="prodCategory" list="productTypeList" tabindex="2">
											<datalist id="productTypeList">
															<c:forEach items="${productTypeList}" var="productType">	
																<option id="productType" value='<c:out value="${productType.getCategoryId()}"></c:out>'><c:out value="${productType.getCategoryName()}"></c:out></option>
															</c:forEach>
											</datalist>
											</input>--%> <%--<form:select path="prodCategory" id="prodCategory" items="${productTypeList}" itemValue="CategoryId" itemLabel="CategoryId" />--%>

							<select id="prodCategory" name="prodCategory" tabindex="2" class="form-control"
							onchange="filterSubType()">
								<option value='0'>Select the Type of Product</option>
								<c:forEach items="${productTypeList}" var="productType">
									<option
										value='<c:out value="${productType.getCategoryId()}" />'
										<c:if test="${productFormBean.prodCategory eq productType.categoryId}">selected ="selected"</c:if>><c:out
											value="${productType.getCategoryName()}" /></option>
								</c:forEach>
						</select>
					
						<form:errors path="prodCategory" />
					</span>

					<span class="form-group">
						<form:label path='prodSubCategory' class="control-label" >Product SubType</form:label>
							<%-- <input placeholder="Product SubType" id='prodSubCategory' name='prodSubCategory'  list="productSubTypeList" tabindex='3'>
								<datalist id="productSubTypeList">
									<c:forEach items="${productSubTypeList}" var="productSubType">
										<option id="productSubType" name="productSubType" class='<c:out value="${productSubType.getParentCategoryId()}"/>' value="<c:out value='${productSubType.getSubCategoryId()}'/>"><c:out value='${productSubType.getSubCategoryName()}'/></option>
									</c:forEach>
								</datalist>
							</input> --%> 
							<select id='prodSubCategory' name='prodSubCategory'
							tabindex='3' class="form-control">
							<option value="0">Sub Category</option>
								<c:forEach items="${productSubTypeList}" var="productSubType">
									<option	class='<c:out value="${productSubType.getParentCategoryId()}"/>'
										value="<c:out value='${productSubType.getSubCategoryId()}'/>"
										<c:if test="${productFormBean.prodSubCategory eq productSubType.subCategoryId}"> selected ="selected"</c:if>>
									<c:out value="${productSubType.getSubCategoryName()}" />
									</option>
								</c:forEach>
						</select> 
						<form:errors path="prodSubCategory" />
					</span>	
					<span class="form-group">
					<form:label path="measurementScale" class="control-label">Measurement Scale</form:label><br>
					
<!-- 							<select id="measurementScaleName" name ="measurementScaleName"> -->
								<c:forEach items="${measurementScaleList}" var="measurementScale">
									<label class="radio-inline"><input type="radio" name="measurementScaleName" value="${measurementScale}" 
										<c:if test="${productFormBean.getMeasurementScaleName() eq measurementScale}"> checked="true"</c:if>
									/>${measurementScale}</label>							
								</c:forEach>
<!-- 							</select> -->
					<br>
					</span>
					
					<span class="form-group">
						<form:label path='prodDesc' class="control-label">Product Desc</form:label>
						<form:input path='prodDesc' id='prodDesc' tabindex='4' class="form-control"/>
						<form:errors path="prodDesc" />
					</span>

					<span class="form-group">
						<form:label path='barCode' class="control-label">Bar Code</form:label>
						<form:input path='barCode' id='barCode' tabindex='5' class="form-control" />
						<form:errors path="barCode" />
					</span>

					<c:if test="${not empty productFormBean.prodEntryDate}">
						<span class="form-group">
							<form:label path='prodEntryDate' class="control-label">Product created On</form:label>
							<form:input path='prodEntryDate' id='prodEntryDate'	disabled="true" tabindex='6' class="form-control"/>
							<form:errors path="prodEntryDate" />
						</span>
					</c:if>

					<span class="form-group">
						<form:label path="profitPercentage" class="control-label">Profit Percentage</form:label>					
						<input name="profitPercentage" id="profitPercentage" type="text" value="${productFormBean.profitPercentage}"
							tabindex="7" class="form-control"/>
						<form:errors path="profitPercentage" />
					</span>

						<form:hidden path='prodId' id='prodId' />
						
						
					<span class="form-group">	
						<br><button type="Submit" tabindex="7" class="btn btn-default">Submit</button>
					</span>

				</form:form>
		</div>
	</div>
</body>
<script type="text/javascript">
	function filterSubType() {
		
		var choosenParentType = document.getElementById("prodCategory").value;
		var availableChildTypes = document.getElementById("prodSubCategory").getElementsByTagName("OPTION");
		var childTypesCount = availableChildTypes.length;
		var classNameString = "";
		
		for(var i=0; i< childTypesCount ;i++)
		{
			availableChildTypes[i].disabled = false;	
		}
		
		for(var i=0; i< childTypesCount ;i++)
		{
			 classNameString = availableChildTypes[i].className
			if(classNameString !== choosenParentType)
			{
				availableChildTypes[i].disabled = true;	
			}
		}
		
	}
	
	function errorFunction(selectedElement){
		alert(selectedElement);
	}
</script>
</html>