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
                    <spring:message code="client.new" />
                </h3>
                <hr/>
            </div>
            <spring:url value="/client/${client.id}/update" var="client_update" htmlEscape="true" />
            <spring:url value="/client/" var="clients" />

            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <form:form method="post" commandName="client" action="${client_update}">
                        <div class="form-group">
                            <form:label path="" for="code">
                                <spring:message code="client.code" />
                            </form:label>
                            <form:input id="code" path="code" cssClass="form-control" />
                            <form:errors path="code" cssClass="text-danger" />
                        </div>

                        <div class="form-group">
                            <form:label path="" for="nom">
                                <spring:message code="client.nom" />
                            </form:label>
                            <form:input id="nom" path="nom" cssClass="form-control" />
                            <form:errors path="nom" cssClass="text-danger" />
                        </div>

                        <div class="form-group">
                            <form:label path="" for="prenom">
                                <spring:message code="client.prenom" />
                            </form:label>
                            <form:input id="prenom" path="prenom" cssClass="form-control" />
                            <form:errors path="prenom" cssClass="text-danger" />
                        </div>

                        <div class="form-group">
                            <form:label path="" for="cni">
                                <spring:message code="client.cni" />
                            </form:label>
                            <form:input id="cni" path="cni" cssClass="form-control" />
                            <form:errors path="cni" cssClass="text-danger" />
                        </div>
                        <div class="form-group">
                            <form:label path="" for="contr">
                                <spring:message code="client.numeroContribuable" />
                            </form:label>
                            <form:input id="contr" path="numeroContribuable" cssClass="form-control" />
                            <form:errors path="numeroContribuable" cssClass="text-danger" />
                        </div>

                        <fieldset>
                            <legend class="label-info text-center ">
                                <spring:message code="client.adresse"/>
                            </legend>
                            <div class="form-group">
                                <form:label path="" for="email">
                                    <spring:message code="client.email" />
                                </form:label>
                                <form:input id="email" path="adresse.email" cssClass="form-control" />
                                <form:errors path="adresse.email" cssClass="text-danger" />
                            </div>
                            <div class="form-group">
                                <form:label path="" for="telephone">
                                    <spring:message code="client.telephone" />
                                </form:label>
                                <form:input id="telephone" path="adresse.telephone" cssClass="form-control" />
                                <form:errors path="adresse.telephone" cssClass="text-danger" />
                            </div>
                            <div class="form-group">
                                <form:label path="" for="bp">
                                    <spring:message code="client.boitePostale" />
                                </form:label>
                                <form:input id="bp" path="adresse.boitePostal" cssClass="form-control" />
                                <form:errors path="adresse.boitePostal" cssClass="text-danger" />
                            </div>
                        </fieldset>
                        <hr />
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="panel-footer">
                            <button type="submit" class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-save"></span>
                                <spring:message code="action.enregistrer" />
                            </button>

                            <a href="${clients}" class="btn btn-default btn-sm">
                                <span class="glyphicon glyphicon-list"></span>
                                <spring:message code="client.list" />
                            </a>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>