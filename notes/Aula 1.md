# Aula 1 - Recapitulando

## Criando um Web Project
~~~java
1. File
2. new > Dynamic Web Project
	2.1 Project name = ??? 
		> next 
		> next
		2.2 [X] Generate web.xml deployment descriptor
		> finish
~~~

## Criando um arquivo HTML
~~~java
1. src > main > webapp >
		2. (right click) - new
		3. HTML File
			4. index.html
			5. next > finish
~~~

## Teste do Servlet
~~~java
1.1 ## Criando um Web Project
	1.2 <src/main/java>
	1.3 (right click) ? new Package
	
2.1 (right click) > 'no pacote criado'
	2.2 new
	2.3 Servlet
	2.4 Class name = ???
	2.5 next > next
		2.6 [x] doGet - 'only this'
		2.7 finish
		
3. In the code
		PrintWriter out = response.getWriter();
		
		out.print("html-text");
	}
~~~

## Usando JSP
~~~java
1.1 ## Criando um Web Project
	2.1 new 
	2.2 JSP File
	2.3 File Name - index.jsp
	> finish
	
3.0 In the code
<body>
	<%out.println("JSP Test"); %>
	<%= new Date() %>
	<%! int number = 0; %>
	<%= number += 1 %>
</body>
~~~

*<% %> - text operator
<%! %> - variable operator
<%= %> - expretion operator
<%-- --%> - comentary*

## DAO / JavaBeans
~~~java
> project
	> src/main/java
		> model
		new > Class
		<name> = DAO
		
		new > Class
		<name> = JavaBeans
		
~~~

## UrlPatterns
Camada Controller
~~~java
@WebServlet(urlPatterns = {"/Controller","/main"})
~~~