<%--
    Document   : show
    Created on : 29 mars 2016, 06:23:10
    Author     : samuel     < smlfolong@gmail.com >
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tiles:insertDefinition name="layout">
    <tiles:putAttribute name="body">
        <div class="row">
            <div class="col-md-12 col-md-offset-2">
                <h3>
                    <spring:message code="fournisseur.show" />
                </h3>
                <hr/>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 col-md-offset-3" id="table_show">
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>
                                <spring:message code="fournisseur.code" />
                            </th>
                            <td>${fournisseur.code}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="fournisseur.nom" />
                            </th>
                            <td>${fournisseur.nom}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="fournisseur.prenom" />
                            </th>
                            <td>${fournisseur.prenom}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="fournisseur.cni" />
                            </th>
                            <td>${fournisseur.cni}</td>
                        </tr>
                        <c:if test="${fournisseur.numeroContribuable.length() gt 3}">
                            <tr>
                                <th>
                                    <spring:message code="fournisseur.numeroContribuable" />
                                </th>
                                <td>${fournisseur.numeroContribuable}</td>
                            </tr>
                        </c:if>
                        <tr>
                            <th>
                                <spring:message code="client.email" />
                            </th>
                            <td>${fournisseur.adresse.email}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="adresse.telephone" />
                            </th>
                            <td>${fournisseur.adresse.telephone}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="adresse.boitePostal" />
                            </th>
                            <td>${fournisseur.adresse.boitePostal}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>


        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <hr/>
                <spring:url value="/fournisseur/${fournisseur.id}/delete" htmlEscape="true" var="fournisseur_delete"/>
                <form:form method="post" commandName="fournisseur" action="${fournisseur_delete}">

                    <spring:url value="/fournisseur/" var="fournisseur_home"/>
                    <a href="${fournisseur_home}" class="btn btn-primary  btn-primary">
                        <span class="glyphicon glyphicon-list"></span>
                        <spring:message code="fournisseur.list" />
                    </a>
                    <form:hidden path="id"/>
                    <spring:url value="/fournisseur/${fournisseur.id}/edit" var="fournisseur_edit"/>
                    <a href="${fournisseur_edit}" class="btn btn-default  btn-warning">
                        <span class="glyphicon glyphicon-edit"></span>
                        <spring:message code="action.modifier" />
                    </a>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


                    <button type="submit" class="btn btn-default  btn-danger">
                        <span class="glyphicon glyphicon-remove-sign"></span>
                        <spring:message code="action.effacer" />
                    </button>
                </form:form>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>