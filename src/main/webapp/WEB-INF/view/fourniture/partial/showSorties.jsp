<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<fieldset>
    <legend>
        <spring:message code="fourniture.sorties" />
    </legend>

    <button class="btn btn-default pull-left" data-toggle="modal" data-target="#searchLigneSortieModal">
        <spring:message code="action.rechercher" />
    </button>

    <div class="dropdown pull-right ">
        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
            <spring:message code="search.taille" />
            : <span id='sizeSortie'>${sizeSortie}</span>&nbsp;
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
            <li role="presentation"><a role="menuitem" tabindex="-1" id="sizeSortie_value" href="sizeSortie=2">2</a></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" id="sizeSortie_value" href="sizeSortie=5">5</a></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" id="sizeSortie_value" href="sizeSortie=10">10</a></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" id="sizeSortie_value" href="sizeSortie=20">20</a></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" id="sizeSortie_value" href="sizeSortie=30">30</a></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" id="sizeSortie_value" href="sizeSortie=40">40</a></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" id="sizeSortie_value" href="sizeSortie=50">50</a></li>
        </ul>
    </div>
    <table class="table table-bordered">
        <thead>
            <tr class="btn-primary">
                <th><spring:message code="operation.numero" /></th>
                <th><spring:message code="operation.dateOperation" /></th>
                <th><spring:message code="operation.departement" /></th>
                <th><spring:message code="ligneOperation.quantite" /></th>
                <th><spring:message code="ligneOperation.observation" /></th>
            </tr>
        </thead>
        <tbody id="ligneSortieContent">
            <c:if test="${ ligneSorties.size() le 0}" >
                <tr>
                    <td class="text-center label-danger" colspan="8">
                        <spring:message code="empty.data" />
                    </td>
                </tr>
            </tbody>
        </table>
    </c:if>
    <c:if test="${0 ne ligneSorties.size()}" >
        <c:forEach var="ligneSortie" items="${ligneSorties}">
            <tr>
                <td>${ligneSortie.operation.numero} </td>
                <td>${ligneSortie.operation.dateOperation} </td>
                <td>${ligneSortie.operation.departement.intitule} </td>
                <td>${ligneSortie.quantite} </td>
                <td>${ligneSortie.observation} </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="row">
    <div class="pull-right">
        <ul class="pager">

            <li>
                <a id="fast_back_ligneSortie" href="pageSortie=0&sizeSortie=${sizeSortie}" <c:if test="${pageSortie eq 0}">class ="btn btn-sm disabled"</c:if>>
                        <span class="glyphicon glyphicon-fast-backward"></span>
                    </a>
                </li>
                <li>
                    <a id="back_ligneSortie" href="pageSortie=${pageSortie-1}&sizeSortie=${sizeSortie}" <c:if test="${pageSortie eq 0}">class ="btn btn-sm disabled"</c:if>>
                        <span class="glyphicon glyphicon-backward"></span>
                    </a>
                </li>
                <li>
                    <input type="text" id="pageSortier_detail" class="pageSortier_detail text-center" readonly value="${pageSortie+1}/${TotalpageSortie}"/>
            </li>
            <li>
                <a id="forward_ligneSortie" href="pageSortie=${pageSortie+1}&sizeSortie=${sizeSortie}" <c:if test="${pageSortie+1 eq TotalpageSortie}">class ="btn btn-sm disabled"</c:if>>
                        <span class="glyphicon glyphicon-forward"></span>
                    </a>
                </li>
                <li>
                    <a id="fast_forward_ligneSortie" href="pageSortie=${TotalpageSortie-1}&sizeSortie=${sizeSortie}" <c:if test="${pageSortie+1 eq TotalpageSortie}">class ="btn btn-sm disabled"</c:if>>
                        <span class="glyphicon glyphicon-fast-forward"></span>
                    </a>
                </li>
            </ul>
        </div>

        <div class="modal fade" tabindex="-1" role="dialog" id="searchLigneSortieModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">
                        <spring:message code="fourniture.searchSorties" />
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-6 col-xs-offset-3">
                            <form action="" class="form-horizontal">
                                <fieldset>
                                    <div class="form-group">
                                        <label><spring:message code="debut" />:</label>
                                        <input class="form-control" name="dateDebutSortie" id="dateDebutSortie"/>
                                    </div>
                                    <div class="form-group">
                                        <label><spring:message code="fin" />:</label>
                                        <input class="form-control" name="dateFinSortie" id="dateFinSortie"/>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <spring:message code="action.fermer" />
                    </button>
                    <a href='#' id="searchLigneSortie" class="btn btn-primary">
                        <spring:message code="action.rechercher" />
                    </a>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
</c:if>
</fieldset>


<spring:url value="fourniture/${fourniture.id}/searchSorties.json" var="fourniture_search"/>
<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script>
    $(function () {
        $("#dateDebutSortie, #dateFinSortie").datepicker({
            changeMonth: true,
            changeYear: true,
            dateFormat: "dd/mm/yy",
            showButtonPanel: false
        });
        var href = "";
        $("#searchLigneSortie").on("mouseenter", function () {
            href = "";
            href += "dateDebutSortie=" + $("#dateDebutSortie").val();
            href += "&dateFinSortie=" + $("#dateFinSortie").val();
            $("#searchLigneSortie").attr("href", href);
        });
        $("#searchLigneSortie").on("click", function () {
            queryLigneSortie(href);
            return false;
        });

        $("#fast_back_ligneSortie").on("click", function () {
            if (!$("#fast_back_ligneSortie").hasClass("disabled")) {
                queryLigneSortie(href + "&" + $("#fast_back_ligneSortie").attr("href"));
            }
            return false;
        });
        $("#back_ligneSortie").on("click", function () {
            if (!$("#back_ligneSortie").hasClass("disabled")) {
                queryLigneSortie(href + "&" + $("#back_ligneSortie").attr("href"));
            }
            return false;
        });
        $("#forward_ligneSortie").on("click", function () {
            if (!$("#forward_ligneSortie").hasClass("disabled")) {
                queryLigneSortie(href + "&" + $("#forward_ligneSortie").attr("href"));
            }
            return false;
        });
        $("#fast_forward_ligneSortie").on("click", function () {
            if (!$("#fast_forward_ligneSortie").hasClass("disabled")) {
                queryLigneSortie(href + "&" + $("#fast_forward_ligneSortie").attr("href"));
            }
            return false;
        });
        $("a[id=sizeSortie_value]").each(function (index, value) {
            $(this).on("click", function () {
                if (href === "") {
                    queryLigneSortie($(this).attr("href"));
                } else {

                    queryLigneSortie(href + "&" + $(this).attr("href"));
                }
                return false;
            });

        });

        function queryLigneSortie(href) {
            var url = getBaseURL() + "${fourniture_search}?" + href;
            var row = "";
            console.log(url);
            $.get(url, function (data) {
                $.each(data["ligneSorties"], function (index, value) {
                    row += "<tr><td>" + value["operation"]['numero'] + "</td>";
                    row += "<td>" + value["operation"]['dateOperation'] + "</td>";
                    row += "<td>" + value["operation"]["departement"]['intitule'] + "</td>";
                    row += "<td>" + value["quantite"] + "</td>";
                    row += "<td>" + value["observation"] + "</td></tr>";
                });

                var pageSortie = parseInt(data["pageSortie"]);
                var totalPage = parseInt(data["TotalpageSortie"]);
                $("#fast_back_ligneSortie").attr("href", "pageSortie=0" + "&sizeSortie=" + data["sizeSortie"]);
                $("#back_ligneSortie").attr("href", "pageSortie=" + (pageSortie - 1) + "&sizeSortie=" + data["sizeSortie"]);
                $("#forward_ligneSortie").attr("href", "pageSortie=" + (pageSortie + 1) + "&sizeSortie=" + data["sizeSortie"]);
                $("#fast_forward_ligneSortie").attr("href", "pageSortie=" + (totalPage - 1) + "&sizeSortie=" + data["sizeSortie"]);
                if (pageSortie === 0) {
                    if (!$("#fast_back_ligneSortie").hasClass("disabled")) {
                        $("#fast_back_ligneSortie").addClass("disabled");
                        $("#back_ligneSortie").addClass("disabled");
                    }
                } else {
                    if ($("#fast_back_ligneSortie").hasClass("disabled")) {
                        $("#fast_back_ligneSortie").removeClass("disabled");
                        $("#back_ligneSortie").removeClass("disabled");
                    }
                }

                if (pageSortie + 1 === totalPage) {
                    if (!$("#fast_forward_ligneSortie").hasClass("disabled")) {
                        $("#forward_ligneSortie").addClass("disabled");
                        $("#fast_forward_ligneSortie").addClass("disabled");
                    }
                } else {
                    if ($("#fast_forward_ligneSortie").hasClass("disabled")) {
                        $("#forward_ligneSortie").removeClass("disabled");
                        $("#fast_forward_ligneSortie").removeClass("disabled");
                    }
                }

                $("#ligneSortieContent").html(row);
                $("#sizeSortie").html(data["sizeSortie"]);
                $("#pageSortier_detail").val((pageSortie + 1) + "/" + totalPage);
            });
        }

        function getBaseURL() {
            var url = location.href;  // entire url including querystring - also: window.location.href;
            var baseURL = url.substring(0, url.indexOf('/', 14));


            if (baseURL.indexOf('http://localhost') !== -1) {
                // Base Url for localhost
                var url = location.href;  // window.location.href;
                var pathname = location.pathname;  // window.location.pathname;
                var index1 = url.indexOf(pathname);
                var index2 = url.indexOf("/", index1 + 1);
                var baseLocalUrl = url.substr(0, index2);

                return baseLocalUrl + "/";
            } else {
                // Root Url for domain name
                return baseURL + "/";
            }

        }
    });
</script>