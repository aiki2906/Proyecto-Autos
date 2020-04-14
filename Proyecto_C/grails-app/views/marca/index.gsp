<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'marca.label', default: 'Marca')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>

    <body>

        <a href="#list-marca" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li><form method="get" action="http://localhost:8080/modelos/index">
                <input type="submit" value="Modelos lista " />
            </form>
            </ul>
        </div>
        <div id="list-marca" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${marcaList}" />

            <div class="pagination">
                <g:paginate total="${marcaCount ?: 0}" />
            </div>
        </div>


            <form method="get" action="http://localhost:8080/emailSender/index">
            <input type="submit" value="Enviar correo" />
            </form>

    </body>
</html>