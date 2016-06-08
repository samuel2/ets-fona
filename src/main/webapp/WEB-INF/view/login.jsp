<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en-IN">
    <head>
        <meta charset="utf-8">
        <title></title>
        <!-- Bootstrap -->
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/jquery-ui.structure.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/jquery-ui.theme.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/img/fona.png" />" rel="shortcut icon"  type="image/png">

        <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    </head>
    <body class="row">
        <hr>
        <div class="modal-content modal-dialog">
            <div class="text-center modal-header">
                <img alt="fona.png" height="150" width="300" src="<c:url value="/resources/img/fona.png"/>"/>
            </div>
            <div id="login-form">
                <br>
                <div>
                    <c:if test="${not empty error}">
                        <div class="text ui-widget-shadow text-center text-danger ">
                            <h4 class="text-uppercase">
                                <b>${error}</b>
                            </h4>
                        </div>
                    </c:if>
                    <c:if test="${not empty msg}">
                        <div class="text text-danger">${msg}</div>
                    </c:if>
                </div>
            </div>
            <section class="container modal-body">
                <article class="col-xs-4 col-xs-offset-1">
                    <form role="form"
                          method='POST'
                          name='loginForm'
                          class="panel panel-default"
                          action="<c:url value='/login'/>">
                        <header class="panel-heading">
                            <h3 class="text-muted text-center">
                                Connectez-vous...
                            </h3>
                        </header>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="input-group">
                                    <input required
                                           type="text"
                                           id="username"
                                           name='username'
                                           class="form-control"
                                           placeholder="Votre nom d'utilisateur"/>
                                    <label for="username" class="input-group-addon">
                                        <i class="glyphicon glyphicon-user"></i>
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input required
                                           id="password"
                                           type="password"
                                           name='password'
                                           class="form-control"
                                           placeholder="Votre Mot de passe"/>
                                    <label for="password" class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <footer class="panel-footer">
                            <div class="row">
                                <spring:url value="user/new" var="userNew" />
                                <button type="submit" class="btn btn-primary btn-block text-center">
                                    <b>
                                        <span class="glyphicon glyphicon-log-in">
                                            Se connecter
                                        </span>

                                    </b>
                                </button> &nbsp;&nbsp;
                                <button type="reset" class="btn btn-warning btn-block text-center">
                                    <b>
                                        <span class="glyphicon glyphicon-refresh">
                                            Réinitialiser
                                        </span>
                                    </b>
                                </button> &nbsp;&nbsp;
                                <br/>
                                <a href="${userNew}">
                                    <span class="glyphicon glyphicon-log-in">
                                        S'enregistrer
                                    </span>
                                </a>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </footer>
                    </form>
                </article>
            </section>
        </div>

    </body>
</html>