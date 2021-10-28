<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>buyer page</title>
	</head>
	<body>
			<h1>Dobrodošao kupac</h1>
		<!-- ovo je html komentar -->
		
		<%
			//ovo je skriptlet
			int x = 15;
		    int y = 7;
		    int zbir = x + y;
		%>
		
		<p>Zbir nekih brojeva je: <%=zbir %></p>
		
		<%
			int zbir2 = zbir + 11;
		    String ime = "Mile";
		%>
		
		<p>Zbir nekih drugih brojeva je: <%=zbir2 %></p>
		<p>Neko ime je: <%=ime %></p>
		
		<p>Ovo je staticka tabela</p>
		<table border = 1px>
			<tr>
				<th>redni broj</th>
				<th>ime</th>
			</tr>
			<tr>
				<td>1</td>
				<td>ime1</td>
			</tr>
			<tr>
				<td>2</td>
				<td>ime2</td>
			</tr>
			<tr>
				<td>3</td>
				<td>ime3</td>
			</tr>
		</table>
		
		
		<p>Ovo je dinamicka tabela</p>
		<table border = 1px>
			<tr>
				<th>redni broj dinamicki</th>
				<th>ime dinamicki</th>
			</tr>
		<%
			for(int i = 1; i <= 10; i++){
		
		%>
		
			<tr>
				<td><%=i %></td>
				<td>ime<%=i %></td>
			</tr>
			
		<%
			}
		%>
		</table>
		
	</body>
</html>