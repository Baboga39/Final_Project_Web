<%@ taglib prefix="t" tagdir="/WEB-INF/tags/web.tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="authUser" scope="session" type="com.example.edit.beans.User"/>
<div class="header">
    <nav class="navbar navbar-expand-lg navbar-light  shadow-sm sticky-top" style="background: #EAE9E8">
        <div class="container d-flex justify-content-between">
            <a class="navbar-brand mb-0 h1" href="#">Brand Name</a>
            <div class="collapse navbar-collapse ml-5">
                <ul class="navbar-nav mr-auto mt-2">
                    <li class="nav-item dropdown text-category ">
                        <a class="link nav-link" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>

                    </li>
                    <li class="nav-item dropdown  text-category">
                        <a class="link nav-link" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>

                    </li>
                    <li class="nav-item dropdown  text-category">
                        <a class="link nav-link" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>

                    </li>
                    <li class="nav-item dropdown  text-category">
                        <a class="link nav-link" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>

                    </li>
                    <li class=" nav-item dropdown text-category">
                        <a class="nav-link show-modal" href="#" role="button" data-toggle="modal" data-target="#myModal" aria-expanded="false">
                            <i class="bi bi-grid ml-2" style="font-size: 17px"></i>
                        </a>
                        <div class="modal fade mt-5" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content modal-cate shadow clearfix">
                                    <button type="button" class="close text-right mr-2" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                                    <div class="modal-body w-100 h-100">
                                        <div class="container">

                                            <div class="row row-cols-4 mt-5">
                                                <div class="col-3">
                                                    <div class="panel-group" id="accordion9" role="tablist" aria-multiselectable="true">
                                                        <div class="panel panel-default">
                                                            <c:forEach items="${listC}" var="o">
                                                            <div class="panel-heading" role="tab" id="headingOne9">
                                                                <div class="row">
                                                                    <a href="#" class="link nav-link">${o.name}</a>
                                                                    <div role="button" class="nav-link navbar-expand-sm" data-toggle="collapse" data-parent="#accordion9" href="#collapseOne9" aria-expanded="true" aria-controls="collapseOne9">
                                                                        <i class="bi bi-caret-down-fill"></i>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            </c:forEach>
                                                            <div id="collapseOne9" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne9">
                                                                <div class="panel-body">
                                                                    <c:forEach items="${listP}" var="o">
                                                                    <div class="row">
                                                                        <a href="#" class="dropdown-item text-par-heading mr-1"> ${o.name} </a>
                                                                    </div>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
                <ul class="navbar-nav mr-auto mt-2">
                    <li class="nav-item dropdown text-category">
                        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/Posts/Search" >
                            <div class="p-1 rounded rounded-pill shadow-lg mw-100" style="background: snow">
                                <div class="input-group text-white">
                                    <input type="search" name="search" placeholder="Nhập vào đây" aria-describedby="button-addon1" class="form-control border-0 rounded rounded-pill bg-light">
                                    <div class="input-group-append">
                                        <button id="button-addon1" type="submit" class="btn btn-link"><i class="bi bi-search" style="color: black"></i></button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </li>
                    <c:choose>
                        <c:when test="${auth}">
                            <form action="${pageContext.request.contextPath}/User/Logout" method="post" id="frmLogout"></form>
                            <li class="nav-item dropdown text-category">
                                <div class="nav-item dropdown text-category mt-1 ml-4">
                                    <a class="nav-link" href="#" data-toggle="dropdown" role="button"  aria-expanded="false">
                                        <c:url value="${authUser.picture}" var="imgUrl"></c:url>

                                        <div class="row">
                                            <c:if test="${auth.picture eq null }">
                                            <span class="user-action"><img src="${pageContext.request.contextPath}/image/user.png" class="avatar" alt="Avatar"></span>
                                            </c:if>
                                            <c:if test="${auth.picture ne null }">
                                                <span class="user-action"><img src="${sessionScope.authUser.picture}/" class="avatar" alt="Avatar"></span>
                                            </c:if>
                                            <h5 class="text-category mt-2" style="font-size: 14px">Hi, <b>${authUser.name}</b></h5>
                                        </div>

                                    </a>
                                    <div class="dropdown-menu" class="navbarDropdown">
                                        <a href="${pageContext.request.contextPath}/User/Index" class="dropdown-item">Profile</a>
                                        <div class="dropdown-divider"></div>
                                        <a href="javascript: $('#frmLogout').submit()" class="dropdown-item">Logout</a>
                                    </div>
                                </div>
                            </li>
                        </c:when>
                        <c:when test="${authGg}">
                            <form action="${pageContext.request.contextPath}/User/Logout" method="post" id="frmLogout"></form>
                            <li class="nav-item dropdown text-category">
                                <div class="nav-item dropdown text-category mt-1 ml-4">
                                    <a class="nav-link" href="#" data-toggle="dropdown" role="button"  aria-expanded="false">
                                        <div class="row">
                                                <span class="user-action"><img src="${sessionScope.authUserGg.picture}" class="avatar" alt="Avatar"></span>
                                            <h5 class="text-category mt-2" style="font-size: 14px">Hi, <b>${sessionScope.authUserGg.name}</b></h5>
                                        </div>

                                    </a>
                                    <div class="dropdown-menu" class="navbarDropdown">
                                        <a href="${pageContext.request.contextPath}/User/Index" class="dropdown-item">Profile</a>
                                        <div class="dropdown-divider"></div>
                                        <a href="javascript: $('#frmLogout').submit()" class="dropdown-item">Logout</a>
                                    </div>
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item dropdown text-category mt-1 ml-3">
                                <a href="${pageContext.request.contextPath}/User/Login" class="text-category nav-link link" style="font-size: 20px">Login</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</div>