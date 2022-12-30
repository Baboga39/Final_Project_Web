
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="feedbacks" scope="request" type="java.util.List<com.example.edit.beans.Feedback>"/>

<t:main>
    <!--
    Begin content
    -->
    <div class="content-cate mt-5">
        <div class="container">
            <div class="card w-100 h-100 shadow">
                <div class="card-header d-flex justify-content-md-between">
                    <span class="text-title">Feedback</span>
                    <div class="d-flex">
                        <form class="form-inline " >
                            <div class="p-1 rounded rounded-pill shadow " style="background: white">
                                <div class="input-group text-white">
                                    <input type="search" placeholder="Nhập vào đây" aria-describedby="button-addon1" class="form-control border-0 rounded rounded-pill bg-light">
                                    <div class="input-group-append">
                                        <button id="button-addon1" type="submit" class="btn btn-link"><i class="bi bi-search" style="color: black"></i></button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${feedbacks.size() == 0}">
                        <div class="text-body">Không có feedback từ editor.</div>
                    </c:when>
                    <c:otherwise>
                        <div class="body">
                            <table class="table">
                                <thead class="thead-dark">
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Category</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Editor</th>
                                    <th scope="col">Feedback</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${feedbacks}" var="r">
                                    <tr>
                                        <th scope="row">${r.article_id}</th>
                                        <td>${r.title}</td>
                                        <td>${r.categoryName}</td>
                                        <td><span class="badge badge-dark">refused</span></td>
                                        <td>${r.second_name}</td>
                                        <td>${r.description}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:otherwise>
                </c:choose>

                <div class="card-footer d-flex justify-content-md-between">
                    <a href="${pageContext.request.contextPath}/Post" class="btn btn-light btn-lg mr-4">Back</a>
                    <div class="d-flex justify-content-md-between">
                        <a href="#" class="link mr-5 mt-2">View All</a>
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--
    End content
    -->
</t:main>