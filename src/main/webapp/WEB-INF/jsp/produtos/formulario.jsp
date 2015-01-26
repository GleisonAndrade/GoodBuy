<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 	<form action="<c:url value="/produtos"/>" method="POST">
		<fieldset>
			<legend>Adicionar Produto</legend>
			<label for="nome">Nome:</label> 
			<input id="nome" type="text" name="produto.nome" value = "${produto.nome}"/> 
			<label for="descricao">Descrição:</label>
			<textarea id="descricao" name="produto.descricao" value = "${produto.descricao}"></textarea>
			<label for="preco">Preço:</label> 
			<input id="preco" type="text"	name="produto.preco" value = "${produto.preco}"/>
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
	-->
	<form action="<c:url value="/produtos"/>" method="POST">
		<fieldset>
			<legend>Adicionar produtos</legend>
			<label for="nome">Nome:</label> <input id="nome" class="required"
				minlength="3" type="text" name="produto.nome"
				value="${produto.nome }" /> <label for="descricao">Descrição:</label>
			<textarea id="descricao" class="required" maxlength="40"
				name="produto.descricao">${produto.descricao }</textarea>
			<label for="preco">Preço:</label> <input id="preco" min="0" class="required"
				type="text" name="produto.preco" value="${produto.preco }" />
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
</body>
</html>