<%--
    Document   : fournisseur
    Created on : 6 mai 2016, 12:56:30
    Author     : samuel
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
            <div class="col-md-offset-2">
                <h3>
                    <spring:message code="fournisseur.new" />
                </h3>
                <hr/>
            </div>
            <spring:url value="/entree/${fournisseur.id}/create" var="fournisseur_create" htmlEscape="true" />
            <spring:url value="/fournisseur/" var="fournisseurs" />

            <div class="row">
                <div class="col-md-12 col-md-offset-0">
                    <form:form method="post" commandName="fournisseur" action="${fournisseur_create}">
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="form-group">
                                <form:label path="" for="code">
                                    <spring:message code="fournisseur.code" />
                                </form:label>
                                <form:input id="code" path="code" cssClass="form-control" />
                                <form:errors path="code" cssClass="text-danger" />
                            </div>
                        </div>

                        <div class="col-xs-6 col-md-4 col-lg-3">
                            <div class="form-group">
                                <form:label path="" for="nom">
                                    <spring:message code="fournisseur.nom" />
                                </form:label>
                                <form:input id="nom" path="nom" cssClass="form-control" />
                                <form:errors path="nom" cssClass="text-danger" />
                            </div>
                        </div>

                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="form-group">
                                <form:label path="" for="prenom">
                                    <spring:message code="fournisseur.prenom" />
                                </form:label>
                                <form:input id="prenom" path="prenom" cssClass="form-control" />
                                <form:errors path="prenom" cssClass="text-danger" />
                            </div>
                        </div>

                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="form-group">
                                <form:label path="" for="cni">
                                    <spring:message code="fournisseur.cni" />
                                </form:label>
                                <form:input id="cni" path="cni" cssClass="form-control" />
                                <form:errors path="cni" cssClass="text-danger" />
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="form-group">
                                <form:label path="" for="contr">
                                    <spring:message code="fournisseur.numeroContribuable" />
                                </form:label>
                                <form:input id="contr" path="numeroContribuable" cssClass="form-control" />
                                <form:errors path="numeroContribuable" cssClass="text-danger" />
                            </div>
                        </div>

                        <hr/>
                        <hr>
                    </div>
                    <div class="col-md-12 col-md-offset-0">
                        <fieldset>
                            <legend class="label-info text-center ">
                                <spring:message code="fournisseur.adresse"/>
                            </legend>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <form:label path="" for="email">
                                        <spring:message code="adresse.email" />
                                    </form:label>
                                    <form:input id="email" path="adresse.email" cssClass="form-control" />
                                    <form:errors path="adresse.email" cssClass="text-danger" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <form:label path="" for="telephone">
                                        <spring:message code="adresse.telephone" />
                                    </form:label>
                                    <form:input id="telephone" path="adresse.telephone" cssClass="form-control" />
                                    <form:errors path="adresse.telephone" cssClass="text-danger" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <form:label path="" for="bp">
                                        <spring:message code="adresse.boitePostal" />
                                    </form:label>
                                    <form:input id="bp" path="adresse.boitePostal" cssClass="form-control" />
                                    <form:errors path="adresse.boitePostal" cssClass="text-danger" />
                                </div>
                            </div>
                        </fieldset>
                    </div>
                    <hr />
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <form:hidden path="id"/>
                    <div class="panel-footer">
                        <button type="submit" class="btn btn-primary btn-sm">
                            <span class="glyphicon glyphicon-save"></span>
                            <spring:message code="action.enregistrer" />
                        </button>

                        <a href="${fournisseurs}" class="btn btn-default btn-sm">
                            <span class="glyphicon glyphicon-list"></span>
                            <spring:message code="fournisseur.list" />
                        </a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</tiles:putAttribute>
</tiles:insertDefinition>
