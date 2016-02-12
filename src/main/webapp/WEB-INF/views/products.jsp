<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="include.jsp" %>
    <%@ include file = "header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Products</title>
</head>
<body>
<div class = "container">
	<div class="button">
		<ul style="list-style-type: none;" >
			<li><a class="btn btn-default" href="/storemgmt/product/productEntry">New Entry</a></li>
		</ul>
	</div>
	<div class="list">
		<table class="table table-condensed">
			<thead><tr><th>Product Name</th><th>Product Type</th><th>Product Subtype</th><th>Entry Date</th><th>Usage Flag</th><th>Action</th></tr></thead>
			<tbody class="table-hover">
					<c:if test="${fn:length(productList) == 0}">
					<tr><td><c:out value="Sorry,No records"></c:out></td></tr>
					</c:if>
					<c:forEach items='${productList}'  var= "product">
						<tr>
							<td><c:out value='${product.prodName }'/> </td>
							<td><c:out value='${product.productCategoryName}'/> </td>
							<td><c:out value='${product.productSubCategoryName }'/> </td>
							<td><c:out value='${product.prodEntryDate }'/> </td>
							<td><c:out value='${product.prodUsgFlg }'/> </td>
							<td><a href='<c:url value="/product/edit/${product.prodId}" />'>Edit</a></td></tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>