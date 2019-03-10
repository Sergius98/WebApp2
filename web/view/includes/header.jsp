<%--
  Created by IntelliJ IDEA.
  User: BIGse
  Date: 01-Mar-19
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>

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
                        <a class="nav-link" href="${pageContext.request.contextPath}${PATHES.get("input")}">
                            ${MESSAGE.getString("calculator")}
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}${PATHES.get("table")}">
                            ${MESSAGE.getString("table")}
                        </a>
                    </li>
                </ul>
            </div>
            <!-- Brand/logo -->
            <div class="col-8 text-right">
                <a class="navbar-brand my_logo" href="#"> MSS</a>
            </div>
        </nav>
    </div>

    <div class="col-lg-2 dropdown open"
         data-toggle="tooltip" data-placement="right" title="${MESSAGE.getString("change_language_message")}">
        <button class="btn btn-outline-dark btn-sm dropdown-toggle" type="button" id="dropdownMenuButton"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            ${MESSAGE.getString("language")}
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <c:forEach items="${LANGUAGES_LIST}" var="language">
                <a class="dropdown-item" href="${URL}?language=${language}">${MESSAGE.getString(language)}</a>
            </c:forEach>
        </div>
    </div>