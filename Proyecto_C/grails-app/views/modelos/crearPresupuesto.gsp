<%--
  Created by IntelliJ IDEA.
  User: Jorge
  Date: 8/04/2020
  Time: 09:11
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:form controller="modelos" action="enviarPresupuesto">
        <g:hiddenField name="id" value="${params.id}"/>

        <label>A quien quieres enviar el presupuesto?</label>
        <input name="email" type="email"/>

        <g:submitButton name="Enviar"/>
    </g:form>
</body>
</html>