<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<d:web>
    <jsp:attribute name="css">
        <link rel="stylesheet" href="/css/posts.css">
    </jsp:attribute>
    <jsp:body>
        <br><br><br><br>
        <div class="content">

            <c:forEach items="${listCa}" var="o">
            <h1>${o.name}</h1>
            </c:forEach>

    <c:if test="${check eq true}">
            <div class="menu_two">
                <ul class="nav justify-content-center">
                    <c:forEach items="${listC}" var="o">
                    <li class="nav-item">
                        <a class="link nav-link active" href="${pageContext.request.contextPath}/Post/Category?cid=${o.categories_id}">${o.name}</a>
                    </li>
                    </c:forEach>
                </ul>
            </div>
    </c:if>
            <section class="border-bottom pb-4 mb-5">
                <div class="row gx-5">
                    <div class="col-md-6 mb-4">
                        <div class="bg-image hover-overlay ripple shadow-2-strong rounded-5" data-mdb-ripple-color="light">
                            <img src="${pageContext.request.contextPath}/image/Article/${listOne.avatar}" class="img-fluid" />
                            <a href="#!">
                                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                            </a>
                        </div>
                    </div>
                    <!--  -->
                    <div class="col-md-6 mb-4">
                        <span class="badge bg-danger px-2 py-1 shadow-1-strong mb-3">Tin mới nhất</span>
                        <h4><strong><b>${listOne.title}</b></strong></h4>
                        <p class="text-muted">
                                ${listOne.abstracts}
                        </p>
                        <div class="chip">
                            #tag #tag #tag
                            <i class="close fas fa-times"></i>
                        </div>
                        <button type="button" class="btn btn-primary">Tìm hiểu ngay</button>
                    </div>
                </div>
            </section>
            <!--  -->
            <section>
                <div class="row gx-lg-5">
                    <c:forEach items="${listT}" var="o">
                    <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                        <!-- News block -->
                        <div>
                            <!-- Featured image -->
                            <div class="bg-image hover-overlay shadow-1-strong ripple rounded-5 mb-4"
                                 data-mdb-ripple-color="light">
                                <img style="    max-width: 90% !important;" src="${pageContext.request.contextPath}/image/Article/${o.avatar}" class="img-fluid" />
                                <a href="#!">
                                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                </a>
                            </div>

                            <!-- Article data -->
                            <div class="row mb-3">
                                <div class="col-6">
                                    <a href="" class="text-info">
                                        <i class="fas fa-plane"></i>
                                        <span class="badge badge-pill badge-primary">${o.categoryName}</span>
                                    </a>
                                </div>

                                <div class="col-6 text-end">
                                    <p><i class="bi bi-calendar mr-2"></i>${o.publish_date}</p>
                                </div>
                            </div>

                            <!-- Article title and description -->
                            <a href="" class="text-dark">
                                <h5><b>${o.title}</b></h5>
                                <p>
                                        ${o.abstracts}
                                </p>
                            </a>
                            <div class="chip">
                                #tag #tag #tag
                                <i class="close fas fa-times"></i>
                            </div>

                            <hr />
                          </div>
                        </div>
                    </c:forEach>
                    </div>
                    <!--  -->
                    <div class="row mt-5">
                        <ul class="list-unstyled mt-5">
                            <c:forEach items="${list}" var="o">
                            <li class="media my-4">
                                <img src="${pageContext.request.contextPath}/image/Article/${o.avatar}" class="mr-3 img-fluid d-block w-25  " alt="...">
                                <div class="media-body">
                                    <a href="#">
                                        <h4 class="mt-0 mb-1">${o.title}</h4>
                                    </a>
                                    <span class="badge badge-pill badge-primary">${o.categoryName}</span>
                                    <p> >${o.abstracts}
                                    </p>
                                    <p>#tag #tag #tag</p>
                                    <p><i class="bi bi-calendar mr-2"></i>${o.publish_date}</p>
                                </div>
                            </li>
                            <hr>
                            </c:forEach>
                        </ul>
                    </div>
            </section>
                </div>
        </div>
        <div>
            <nav class="my-4" aria-label="...">
                <ul class="pagination pagination-circle justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                    </li>
                    <li class="page-item active" aria-current="page">
                        <a class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
        </div>
    </jsp:body>
</d:web>
