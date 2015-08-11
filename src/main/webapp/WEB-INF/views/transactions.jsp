<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file = "include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
</head>
<body>
<div id= tab1>
	<form:form method= "post" action="transaction/createTansaction" modelAttribute="transactionEntity">
		<table>
			<tr>
				<td><label for="customerName">Customer Name</label></td>
				<td><label for="txnDt">Transaction Date</label></td>
				<td><label for="trueDt">True Date</label></td>
			</tr>
			<tr>
				<td><form:input id = "customerName" path="custName"/></td>
				<td><form:input id = "txnDt" path="txnDt"/></td>
				<td><form:input id = "trueDt" path="trueDt"/></td>
			</tr>
			
			<tr>
				<td><label for="prodName">Product Name</label></td>
				<td><label for="mfgName">Supplier Name</label></td>
				<td><label for="ppu">Price Per Unit</label></td>
				<td><label for="qty">QTY</label></td>
				<td><label for="amt">Amount</label></td>
			</tr>
			<tr>
				<td><form:input id = "prodName" path="itemList[0].prodName"/></td>
				<td><form:input id = "mfgName" path="itemList[0].mfgName"/></td>
				<td><form:input id = "ppu" path="itemList[0].ppu"/></td>
				<td><form:input id = "qty" path="itemList[0].qty"/></td>
				<td><form:input id = "amt" path=""/></td>
			</tr>
			
			<tr><td><input type="submit" name="Submit"/></td></tr>
		</table>
	
	</form:form>
</div>

</body>
</html>
