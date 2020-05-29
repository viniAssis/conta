

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista Contas</title>
	
	<script src="resources/js/jquery.js"></script>
	<script>
	
		function pagaAgora(id){
			
			$.post("pagaConta", {'id': id }, function(){
				$("#conta_"+id).html("paga");
				$("#conta"+id).html("Paga!");
			});
			
		}
	
	</script>
	
		
</head>
<body>

<table>
	<tr>
		<th>Código</th>
		<th>Descrição</th>
		<th>Valor</th>
		<th>Tipo</th>
		<th>Paga?</th>
		<th>Data de pagamento</th>
	</tr>
	<c:forEach items="${contas}" var="conta">
		<tr>
			<td>${conta.id}</td>
			<td>${conta.descricao}</td>
			<td>${conta.valor}</td>
			<td>${conta.tipo}</td>
			<td id="conta_${conta.id }">
				<c:if test="${conta.paga eq false }">
					Não paga
				</c:if>
				
				<c:if test="${conta.paga eq true }">
					Paga!
				</c:if>
			</td>
			<td><fmt:formatDate value="${conta.dataPagamento.time}" type="date" pattern="dd/MM/yyyy"/>${conta.id}</td>
			<td> <a href="removerConta?id=${conta.id}">Remover</a></td>
			<td> <a href="mostraConta?id=${conta.id}">Editar</a></td>
			
			<td id="conta${conta.id}">
				 
				 <c:if test="${conta.paga eq false}">
				 	<a href="#" onClick="pagaAgora(${conta.id})">Pagar</a> 
				 </c:if>
				 
				 <c:if test="${conta.paga eq true}">				 	
				 	Paga!
				 </c:if>
				 
			</td>
			
			
		</tr>
		
		<%		
    	%>
		
	</c:forEach>

	
</table>
	


</body>
</html>