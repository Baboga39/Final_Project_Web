<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<d:web>
    <div class="content">
        <div class="tag mb-3">
            <div class="navbar-expand-lg">
                <div class="container-sm d-flex justify-content-sm-between">
                    <a class="navbar-brand mb-0 h1 mt-1" href="#"><i class="bi bi-backspace-reverse-fill" style="color: #3f3f3f"></i></a>
                    <div class="collapse navbar-collapse">
                        <ul class="navbar-nav mr-auto">
                            <c:forEach items="${tags}" var="o">
                                <li class="nav-item active">
                                    <a href="#" class=" link-cate mr-3" style="font-size: 10px; color: black;">${o.value}</a>
                                </li>
                            </c:forEach>


                        </ul>
                    </div>
                    <div class="weather-item text-heading border-danger">TP.HCM 27°C  - CHỦ NHẬT - ${Day}</div>
                </div>
            </div>
        </div>



        <hr class="mt-5">
        <div class="new-news">
            <div class="container">
                <div class="text-heading border-danger" style="font-size: 25px"><i class="bi bi-align-start"></i>
                    Tìm kiếm </div>
                <div class="row mt-5">
                    <ul class="list-unstyled mt-5">
                        <c:forEach items="${listA}" var="o">
                            <li class="media my-4">
                                <img src="${pageContext.request.contextPath}/image/Article/${o.avatar}" class="mr-3 img-fluid d-block w-25  " alt="...">
                                <div class="media-body">
                                    <a href="#">
                                        <h4 class="mt-0 mb-1">${o.title}</h4>
                                    </a>
                                    <p> ${o.abstracts} </p>
                                    <p><i class="bi bi-hash mr-2"></i>${o.categoryName}</p>
                                    <p><i class="bi bi-calendar mr-2"></i> ${o.publish_date} </p>
                                </div>
                            </li>
                            <hr>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</d:web>