<%--
  Created by IntelliJ IDEA.
  User: BIGse
  Date: 25-Feb-19
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="includes/header.jsp" %>

<div class="col-lg-2 dropdown open">
  <button class="btn btn-outline-dark btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    ${MESSAGE.getString("language")}
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <c:forEach items="${LANGUAGES_LIST}" var="language">
      <a class="dropdown-item" href="${URL}?language=${language}">${MESSAGE.getString(language)}</a>
    </c:forEach>
  </div>
</div>

<div class="lab2_main">
  <div class="container my_main_block">
    <div class="row my_block my_head_block">
      <span class="col text-center">${MESSAGE.getString("taxes_table")}</span>
    </div>

    <div class="row my_block table-responsive-lg">
      <c:choose>
        <c:when test="${TAX_LIST.size() > 0}">
          <table class="col text-center table " style="margin-top: 10px;">
            <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">${MESSAGE.getString("table_name")}</th>
              <th scope="col">${MESSAGE.getString("table_value")}</th>
              <th scope="col">${MESSAGE.getString("table_tax_per_cent")}</th>
              <th scope="col">${MESSAGE.getString("table_tax")}</th>
            </tr>
            </thead>
            <tbody>
              <c:forEach var = "i" begin = "0" end = "${TAX_LIST.size() - 1}">
                <tr>
                  <th scope="row">${i + 1}</th>
                  <td>${MESSAGE.getString(TAX_LIST.get(i).getName())}</td>
                  <td>${TAX_LIST.get(i).getValue()}</td>
                  <td>${TAX_LIST.get(i).getTax_per_cent()}</td>
                  <td>${TAX_LIST.get(i).getTax()}</td>
                </tr>
              </c:forEach>
              <tr>
                <th scope="row"></th>
                <td></td>
                <td></td>
                <td>${MESSAGE.getString("table_sum")}:</td>
                <td>${TAX_SUM}</td>
              </tr>
            </tbody>
          </table>
        </c:when>
        <c:otherwise>
          <span class="col text-center">sorry, there's no data to display<br>
          please visit claculator first</span>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</div>


<%@include file="includes/footer.jsp" %>
