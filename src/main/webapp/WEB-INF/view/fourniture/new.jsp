<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tiles:insertDefinition name="layout">
    <tiles:putAttribute name="body">

        <div class="row">
            <div class="col-md-12 col-md-offset-1 ">
                <h3>
                    <spring:message code="fourniture.new" />
                </h3>
                <hr/>
                <form:errors path="*"/>
            </div>
            <spring:url htmlEscape="true" value="/fourniture/create" var="fourniture_create" />
            <spring:url value="/fourniture/" var="fournitures" />

            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <form:form  method="post" commandName="fourniture" action="${fourniture_create}">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <form:label path="" for="reference">
                                        <spring:message code="fourniture.reference" />
                                    </form:label>
                                    <form:input id="reference" path="reference" cssClass="form-control" />
                                    <form:errors path="reference" cssClass="text-danger" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <form:label path="" for="designation">
                                        <spring:message code="fourniture.designation" />
                                    </form:label>
                                    <form:input id="designation" path="designation" cssClass="form-control" />
                                    <form:errors path="designation" cssClass="text-danger" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <form:label path="" for="seuil">
                                        <spring:message code="fourniture.seuil" />
                                    </form:label>
                                    <form:input id="seuil" path="seuil" cssClass="form-control" />
                                    <form:errors path="seuil" cssClass="text-danger" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <form:label for="date" path="">
                                        <spring:message code="fourniture.dateDePeremption" />
                                    </form:label>
                                    <form:input id="date" path="dateDePeremption" cssClass="form-control input-sm" />
                                    <form:errors path="dateDePeremption" cssClass="text-danger" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <form:label path="" for="cat">
                                        <spring:message code="fourniture.categorie" />
                                    </form:label>
                                    <form:select id="cat" path="categorie.id" cssClass="form-control" >
                                        <form:options items="${categories}" />
                                    </form:select>
                                    <form:errors path="categorie.id" cssClass="text-danger" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <hr />
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <div class="col-md-6">
                                <button type="submit" class="btn btn-primary btn-sm">
                                    <span class="glyphicon glyphicon-save"></span>
                                    <spring:message code="action.enregistrer" />
                                </button>
                                <a href="${fournitures}" class="btn btn-default btn-sm">
                                    <span class="glyphicon glyphicon-list"></span>
                                    <spring:message code="fourniture.list" />
                                </a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>