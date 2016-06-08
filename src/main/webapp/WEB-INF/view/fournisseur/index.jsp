<%--
    Document   : index
    Created on : 29 mars 2016, 06:22:55
    Author     : samuel     < smlfolong@gmail.com >
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<tiles:insertDefinition name="layout">
    <tiles:putAttribute name="body">
        <div class="row">
            <div class="col-md-9">
                <div >
                    <h3>
                        <spring:message code="fournisseur.list" />
                        <hr/>
                    </h3>
                </div>
                <div class="dropdown pull-right ">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
                        <spring:message code="search.taille" />
                        : ${size}&nbsp;
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}&size=5">5</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}size=10">10</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}size=20">20</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}size=30">30</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}size=40">40</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}size=50">50</a></li>
                    </ul>
                </div>
                <table class="table table-condensed table-hover table-bordered">
                    <thead class="text-center btn-primary">
                        <tr>
                            <th> <span class="btn"> <spring:message code="fournisseur.code" /> </span> </th>
                            <th> <span class="btn"> <spring:message code="fournisseur.nom" /> </span> </th>
                            <th> <span class="btn"> <spring:message code="fournisseur.prenom" /> </span> </th>
                            <th> <span class="btn"> <spring:message code="fournisseur.cni" /> </span> </th>
                            <th> <span class="btn"> <spring:message code="fournisseur.numeroContribuable" /> </span> </th>
                            <th> <span class="btn"> <spring:message code="action.titre" /> </span> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <spring:url value="/fournisseur/new" var="fournisseurNew" />
                        <spring:url value="/" var="accueil" />

                        <c:if test="${fournisseurs.size() eq 0}">
                            <tr>
                                <td class="text-center label-danger" colspan="6">
                                    <spring:message code="empty.data" />
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <div class="row">
                        <div>
                            <a href="${fournisseurNew}" class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-new-window"></span>
                                <spring:message code="action.nouveau" />
                            </a>
                        </div>

                        <div class="pull-right">
                            <ul class="pager">

                                <li><a href="?query=${query}&page=0&size=${size}" class ="btn btn-sm disabled">
                                        <span class="glyphicon glyphicon-fast-backward"></span>
                                    </a></li>
                                <li><a href="?query=${query}&page=${page-1}&size=${size}"class ="btn btn-sm disabled">
                                        <span class="glyphicon glyphicon-backward"></span>
                                    </a></li>
                                <li><input type="text" class="pager_detail text-center" readonly value="0/0"/></li>
                                <li><a href="?query=${query}&page=${page+1}&size=${size}" class ="btn btn-sm disabled">
                                        <span class="glyphicon glyphicon-forward"></span>
                                    </a></li>
                                <li><a href="?query=${query}&page=${Totalpage-1}&size=${size}" class ="btn btn-sm disabled">
                                        <span class="glyphicon glyphicon-fast-forward"></span>
                                    </a></li>
                            </ul>
                        </div>
                    </div>

                </c:if>

                <c:if test="${fournisseurs.size() ne 0}">
                    <c:forEach items="${fournisseurs}" var="fournisseur">
                        <tr>
                            <td>${fournisseur.code}</td>
                            <td>${fournisseur.nom}</td>
                            <td>${fournisseur.prenom}</td>
                            <td>${fournisseur.cni}</td>
                            <td>${fournisseur.numeroContribuable}</td>
                            <td>
                                <spring:url value="/fournisseur/${fournisseur.id}/edit" htmlEscape="true" var="fournisseur_edit" />
                                <a href="${fournisseur_edit}" class="btn btn-primary btn-warning">
                                    <span class="glyphicon glyphicon-edit"></span>
                                    <spring:message code="action.modifier" />
                                </a>
                                &nbsp; &nbsp;
                                <spring:url value="/fournisseur/${fournisseur.id}/show" htmlEscape="true" var="fournisseur_show" />
                                <a href="${fournisseur_show}" class="btn btn-primary btn-sm">
                                    <span class="glyphicon glyphicon-open"></span>
                                    <spring:message code="action.detail" />
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                    </table>
                    <div class="row">
                        <div>
                            <a href="${fournisseurNew}" class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-new-window"></span>
                                <spring:message code="action.nouveau" />
                            </a>
                        </div>


                        <div class="pull-right">
                            <ul class="pager">

                                <li>
                                    <a href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}&page=0&size=${size}" <c:if test="${page eq 0}">class ="btn btn-sm disabled"</c:if>>
                                            <span class="glyphicon glyphicon-fast-backward"></span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}&page=${page-1}&size=${size}" <c:if test="${page eq 0}">class ="btn btn-sm disabled"</c:if>>
                                            <span class="glyphicon glyphicon-backward"></span>
                                        </a>
                                    </li>
                                    <li>
                                        <input type="text" class="pager_detail text-center" readonly value="${page+1}/${Totalpage}"/>
                                </li>
                                <li>
                                    <a href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}&page=${page+1}&size=${size}" <c:if test="${page+1 eq Totalpage}">class ="btn btn-sm disabled"</c:if>>
                                            <span class="glyphicon glyphicon-forward"></span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="?querycode=${fournisseur.code}&querynom=${fournisseur.nom}&queryprenom=${fournisseur.prenom}&page=${Totalpage-1}&size=${size}" <c:if test="${page+1 eq Totalpage}">class ="btn btn-sm disabled"</c:if>>
                                            <span class="glyphicon glyphicon-fast-forward"></span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                </c:if>
            </div>

            <div class="col-md-3">
                <div>
                    <h3>
                        <spring:message code="action.rechercher" />
                    </h3>
                    <hr/>
                </div>
                <spring:url value="/fournisseur/" var="fournisseur_home"
                            htmlEscape="true" />

                <form:form method="get" commandName="fournisseur" action="${fournisseur_home}">
                    <div class="form-group">
                        <label>
                            <spring:message code="fournisseur.code" />
                        </label>
                        <input type="text"  value="${fournisseur.code}" class="form-control input-sm" name="querycode"/>
                        <input type="hidden" value="${size}" name="size"/>
                    </div>
                    <div class="form-group">
                        <label>
                            <spring:message code="fournisseur.nom" />
                        </label>
                        <input type="text" value="${fournisseur.nom}" class="form-control input-sm" name="querynom"/>
                    </div>
                    <div class="form-group">
                        <label>
                            <spring:message code="fournisseur.prenom" />
                        </label>
                        <input type="text"  value="${fournisseur.prenom}" class="form-control input-sm" name="queryprenom"/>
                    </div>
                    <hr/>
                    <button class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-search"></span> <spring:message code="search"/></button>
                        <spring:url value="/fournisseur/" htmlEscape="true" var="fournisseur_home" />
                    <a href="${fournisseur_home}" class="btn btn-default btn-sm">
                        <span class="glyphicon glyphicon-refresh"></span>
                        <spring:message code="search.delete" />
                    </a>
                </form:form>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>
