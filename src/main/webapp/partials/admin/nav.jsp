<%@ taglib prefix="t" tagdir="/WEB-INF/tags/main.tag" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="authUser" scope="session" type="com.example.edit.beans.User"/>

<div class="w3-container">
    <nav class="navbar navbar-expand-xl navbar-dark bg-dark shadow-lg">
        <button type="button" class="close text-right mr-4 " onclick="w3_open()" aria-label="Open"><span aria-hidden="true"><i class="bi bi-list" style="color: white; font-size: 25px"></i></span></button>
        <a href="${pageContext.request.contextPath}/Home" class="navbar-brand">Brand<b>Name</b></a>
        <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
            <div class="navbar-nav ml-auto">
                <a href="${pageContext.request.contextPath}/Home" class="nav-item nav-link active mr-2"><i class="bi bi-house"></i></a>

            </div>
            <div class="dropdown">
                <a href="#" data-toggle="dropdown" class="dropdown-link" aria-haspopup="true" aria-expanded="false">
                    <span class="wrap-icon nav-item nav-link "><i class="bi bi-bell-fill"></i></span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg-left" aria-labelledby="dropdownMenuButton">
                    <ul class="list-group">
                        <c:if test="${authUser.role_id == 3}">
                            <li class="list-group-item"><a href="${pageContext.request.contextPath}/Feedback">Feedback</a></li>
                        </c:if>
                    </ul>
                    <p class="text-center m-0 p-0"><a href="#" class="small">View All</a></p>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" data-toggle="dropdown" class="nav-item nav-link dropdown-toggle user-action"><img src="${pageContext.request.contextPath}/image/user.png" class="avatar" alt="Avatar"> ${authUser.second_name} <b class="caret"></b></a>
                <div class="dropdown-menu">
                    <a href="#" class="dropdown-item"><i class="fa fa-user-o"></i> Profile</a>
                    <a href="#" class="dropdown-item"><i class="fa fa-calendar-o"></i> Calendar</a>
                    <a href="#" class="dropdown-item"><i class="fa fa-sliders"></i> Settings</a>
                    <div class="divider dropdown-divider"></div>
                    <a href="#" class="dropdown-item"> Logout</a>
                </div>
            </div>
        </div>
    </nav>
</div>