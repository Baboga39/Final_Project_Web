<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="article" scope="request" type="com.example.edit.beans.Articles"/>
<jsp:useBean id="comments" scope="request" type="java.util.List<com.example.edit.beans.Comments>" />

<d:detail>
    <jsp:body>
        <br><br><br><br>
        <div class="container-fluid">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <!-- News Detail Start -->
                        <div class="position-relative mb-3">
                            <img class="img-fluid w-100" src="${pageContext.request.contextPath}/image/Article/${article.avatar}" style="object-fit: cover;">
                            <div class="bg-white border border-top-0 p-4">
                                <div class="mb-3">
                                    <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="">${article.categoryName}</a>
                                    <a class="text-body" href="">${article.publish_date}</a>
                                </div>
                                <h1 class="mb-3 text-secondary text-uppercase font-weight-bold">${article.title}</h1>
                                <p>${article.content}</p>
                            </div>
                            <div class="d-flex justify-content-between bg-white border border-top-0 p-4">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle mr-2" src="https://cdn.vectorstock.com/i/1000x1000/38/05/male-face-avatar-logo-template-pictograph-vector-11333805.webp" width="25" height="25" alt="">
                                    <span>${user.second_name}</span>
                                </div>
                                <div class="d-flex align-items-center">
                                    <span class="ml-3"><i class="far fa-eye mr-2"></i>${article.views}</span>
                                </div>
                            </div>
                        </div>
                        <!-- News Detail End -->

                        <!-- Comment List Start -->
                        <div class="mb-3">
                            <div class="section-title mb-0">
                                <h4 class="m-0 text-uppercase font-weight-bold"> Comments</h4>
                            </div>
                            <div class="bg-white border border-top-0 p-4">
                                <c:forEach items="${comments}" var="c">
                                        <div class="media mb-4">
                                            <img src="https://cdn.vectorstock.com/i/1000x1000/38/05/male-face-avatar-logo-template-pictograph-vector-11333805.webp" alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">
                                            <div class="media-body">
                                                <h6><a class="text-secondary font-weight-bold" href="#">${c.second_name}</a> <small><i>${c.create_date}</i></small></h6>
                                                <p>${c.comment}</p>
                                                <button class="btn btn-sm btn-outline-secondary">Reply</button>
                                            </div>
                                        </div>
                                </c:forEach>
                            </div>
                        </div>
                        <!-- Comment List End -->

                        <!-- Comment Form Start -->
                        <div class="mb-3">
                            <div class="section-title mb-0">
                                <h4 class="m-0 text-uppercase font-weight-bold">Post a comment</h4>
                            </div>
                            <div class="bg-white border border-top-0 p-4">
                                <form>
                                    <div class="form-row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="name">Name *</label>
                                                <input type="text" class="form-control" id="name">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label for="email">Email *</label>
                                                <input type="email" class="form-control" id="email">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="message">Comment *</label>
                                        <textarea id="message" cols="30" rows="5" class="form-control"></textarea>
                                    </div>
                                    <div class="form-group mb-0">
                                        <input type="submit" value="Post a comment"
                                               class="btn btn-primary font-weight-semi-bold py-2 px-3">
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- Comment Form End -->
                    </div>

                    <div class="col-lg-4">

                        <!-- 5 Related Articles -->
                        <div class="mb-3">
                            <div class="section-title mb-0">
                                <h4 class="m-0 text-uppercase font-weight-bold">5 Related Articles</h4>
                            </div>
                            <c:forEach items="${listRand5SameCat}" var="r">
                                <div class="bg-white border border-top-0 p-3">
                                    <div class="d-flex align-items-center bg-white mb-3" style="height: 110px;">
                                        <img class="img-fluid" src="${pageContext.request.contextPath}/image/Article/${r.avatar}" alt="" width="110">
                                        <div class="w-100 h-100 px-3 d-flex flex-column justify-content-center border border-left-0">
                                            <div class="mb-2">
                                                <a class="badge badge-primary text-uppercase font-weight-semi-bold p-1 mr-2" href="">${r.categoryName}</a>
                                                <a class="text-body" href=""><small>${r.publish_date}</small></a>
                                            </div>
                                            <a class="h6 m-0 text-secondary text-uppercase font-weight-bold"
                                               href="${pageContext.request.contextPath}/Detail?article_id=${r.article_id}">${r.title}</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <!-- 5 Related Articles -->

                        <!-- Tags Start -->
                        <div class="mb-3">
                            <div class="section-title mb-0">
                                <h4 class="m-0 text-uppercase font-weight-bold">Tags</h4>
                            </div>
                            <c:forEach items="${tags}" var="t">
                                <div class="bg-white border border-top-0 p-3">
                                    <div class="d-flex flex-wrap m-n1">
                                        <a href="${pageContext.request.contextPath}/Post/Tag?tid=${t.tags_id}" class="btn btn-sm btn-outline-secondary m-1">${t.value}</a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <!-- Tags End -->
                    </div>
                </div>
            </div>
        </div>
        <!-- News With Sidebar End -->
    </jsp:body>
</d:detail>
