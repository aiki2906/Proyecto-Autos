<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'modelos.label', default: 'Modelos')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>

        <meta charset="UTF-8">
        <title>Generar PDF's con PHP</title>
        <link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.indigo-pink.min.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>

    </head>
    <body>
        <a href="#list-modelos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li><form method="get" action="http://localhost:8080/marca/index">
                <input type="submit" value="Marca lista " />
            </form>
            </ul>
        </div>
        <div id="list-modelos" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${modelosList}" />

            <div class="pagination">
                <g:paginate total="${modelosCount ?: 0}" />
            </div>
        </div>

    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text"></h2>
        </div>
        <div class="mdl-card__supporting-text">
        </div>
        <div class="mdl-card__actions mdl-card--border">
            <form action="generar/generar-pdf.php">
                <input type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" value="Crear PDF">
            </form>
        </div>
        <div class="mdl-card__menu">
            <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                <i class="material-icons">folder</i>
            </button>
        </div>
    </div>

    <form method="get" action="http://localhost:8080/emailSender/index">
        <input type="submit" value="Enviar este reporte" />
    </form>
    </body>
</html>