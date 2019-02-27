<%--
  Created by IntelliJ IDEA.
  User: BIGse
  Date: 25-Feb-19
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>MSS: Lab_2</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/styles.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/styles.css" />
    <script src="${pageContext.request.contextPath}/view/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/popper.js"></script>
    <script src="${pageContext.request.contextPath}/view/js/bootstrap.bundle.js"></script>
  </head>
  <body>
  <div class="container">
    <div class="my_top">
      <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <!-- Links -->
        <div class="col-4">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="#">Lab_2</a>
            </li>
          </ul>
        </div>

        <!-- Brand/logo -->
        <div class="col-8 text-right">
          <a class="navbar-brand my_logo" href="#"> MSS </a>
        </div>
      </nav>
    </div>

    <div class="lab2_main">
      <div class="container my_main_block">
        <div class="row my_block my_head_block">
          <span class="col text-center">${MESSAGE.getString("taxes_calculator")}</span>
        </div>
        <form method="POST" action="/Home">
          <c:forEach items="${TAXES}" var="tax">
            <div class="row my_block">
              <div class="col-lg-5 text-left">
                  ${MESSAGE.getString(tax.getName())}
              </div>
              <div class="col-lg-7 text-center">
                <input class="form-control" type="text" name="${tax.getName()}" value= "${request.getAttribute(tax.getName())}">
              </div>
            </div>
          </c:forEach>
            <div class="row my_block">
                <div class="col text-center">
                    <button type="submit" class="btn btn-outline-dark">${MESSAGE.getString("calculate")}</button>
                </div>
            </div>
        </form>

      </div>
    </div>

    <div class="my_bottom bg-dark text-white">
      <div class="row">
        <div class="col-lg-5">
          <a href="https://www.mcdonalds.ua/ua.html">
            <img src="${pageContext.request.contextPath}/view/pict/ad.jpg" class="my_small_left rounded float-left" alt="ad" title="ad: Fast Food">
          </a>
        </div>
        <div class="col-lg-7 text-right">
          <p class="my_papers">
            Designed by: <br>
            National Technical University of Ukraine<br>
            "Igor Sikorsky Kyiv Polytechnic Institute"<br>
            Faculty of Applied Mathematics <br>
            Special-Purpose Computer Systems Department<br>
            Group KV-51<br>
            <span class="font-italic bg-light text-dark" title="Микитенко С.С."> Mykytenko S.S. </span><br>Tuesday, April 10, 2018
          </p>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
