<%--
  Created by IntelliJ IDEA.
  User: BIGse
  Date: 25-Feb-19
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
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
          <span class="col text-center">${MESSAGE.getString("taxes_calculator")}</span>
        </div>
        <form method="POST" action="/calculator">
          <c:forEach items="${TAXES}" var="tax">
            <div class="row my_block">
              <div class="col-lg-5 text-left">
                  ${MESSAGE.getString(tax.getName())}
              </div>
              <div class="col-lg-7 text-center">
                <input class="form-control" type="text"
                       data-toggle="tooltip" data-placement="top" title="${MESSAGE.getString("input_field_message")}"
                       name="${tax.getName()}" value= "${pageContext.request.getAttribute(tax.getName())}">
              </div>
            </div>
          </c:forEach>
            <div class="row my_block">
              <div class="col-lg-4"></div>
              <div class="col-lg-4 text-center">
                <button type="submit" class="btn btn-outline-dark"
                        data-toggle="tooltip" data-placement="top" title="${MESSAGE.getString("input_button_message")}"
                    >${MESSAGE.getString("calculate")}</button>
              </div>
              <div class="col-lg-4"></div>
            </div>
        </form>

      </div>
    </div>


<%@include file="includes/footer.jsp" %>
<script>
  $(function () {
    $('[data-toggle="tooltip"]').tooltip()
  })
</script>
</html>
