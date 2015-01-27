
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
			<th>Comprar</th>
			<th>Editar</th>
			<th>Remover</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${produtoList}" var="produto">
			<tr>
				<td>${produto.nome }</td>
				<td>${produto.descricao }</td>
				<td>${produto.preco }</td>
				<td>
					<!-- Adicionando o produto no carrinho de compras -->
					<form action="<c:url value="/carrinho"/>" method="POST">
						<input type="hidden" name="item.produto.id" value="${produto.id }" />
						<input class="qtde" name="item.quantidade" value="1" />
						<button type="submit">Comprar</button>
					</form>
				</td>
				<td><a href="<c:url value="/produtos/${produto.id}"/>">Editar</a></td>
				<td>
					<form action="<c:url value="/produtos/${produto.id}"/>"
						method="POST">
						<button class="link" name="_method" value="DELETE">Remover</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

