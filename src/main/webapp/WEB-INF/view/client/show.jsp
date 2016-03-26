<%--
    Document   : show
    Created on : Dec 10, 2014, 9:48:58 AM
    Author     : sando
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
                    <spring:message code="client.show" />
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
                                <spring:message code="client.code" />
                            </th>
                            <td>${client.code}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="client.nom" />
                            </th>
                            <td>${client.nom}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="client.prenom" />
                            </th>
                            <td>${client.prenom}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="client.cni" />
                            </th>
                            <td>${client.cni}</td>
                        </tr>
                        <c:if test="${client.numeroContribuable.length() gt 3}">
                            <tr>
                                <th>
                                    <spring:message code="client.numeroContribuable" />
                                </th>
                                <td>${client.numeroContribuable}</td>
                            </tr>
                        </c:if>
                        <tr>
                            <th>
                                <spring:message code="client.email" />
                            </th>
                            <td>${client.adresse.email}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="client.telephone" />
                            </th>
                            <td>${client.adresse.telephone}</td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="client.boitePostale" />
                            </th>
                            <td>${client.adresse.boitePostal}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>


        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <hr/>
                <spring:url value="/client/${client.id}/delete" htmlEscape="true" var="client_delete"/>
                <form:form method="post" commandName="client" action="${client_delete}">

                    <spring:url value="/client/" var="client_home"/>
                    <a href="${client_home}" class="btn btn-primary  btn-primary">
                        <span class="glyphicon glyphicon-list"></span>
                        <spring:message code="client.list" />
                    </a>
                    <form:hidden path="id"/>
                    <spring:url value="/client/${client.id}/edit" var="client_edit"/>
                    <a href="${client_edit}" class="btn btn-default  btn-warning">
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