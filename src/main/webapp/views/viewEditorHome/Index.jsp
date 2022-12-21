<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="articles" scope="request" type="java.util.List<com.example.edit.beans.Articles>"/>

<t:editor>
  <jsp:body>
  <div class="container">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
      <div class="text-top-heading-main float-left mt-5">Control Panel</div>
    </div>
    <div class="card shadow mb-4 mt-5">
      <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Articles</h6>
      </div>
      <c:choose>
        <c:when test="${articles.size() == 0}">
          <div class="card-header py-3">
            <h6 class="text-center">Không có dữ liệu phù hợp !</h6>
          </div>
        </c:when>
        <c:otherwise>
          <table class="table">
            <thead class="thead-dark">
            <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Date</th>
              <th>Abstract</th>
              <th>Category</th>
              <th>Tag</th>
              <th>Writer</th>
              <th>Content</th>
              <th>Status</th>
              <th>Reason</th>
              <th>Time</th>
              <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${articles}" var="c">
              <tr>
                <td>${c.articleId}</td>
                <td>${c.title}</td>
                <td>${c.publishDate}</td>
                <td>${c.abstracts}</td>
                <td>
                  <select class="browser-default custom-select">
                    <option selected>Thể Thao</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                  </select>
                </td>
                <td>
                  <select class="browser-default custom-select">
                    <option selected>Tag</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                  </select>
                </td>
                <td>${c.writerId}</td>
                <td>${c.content}</td>
                <td><div class="card text-white bg-danger mb-4">draft</div></td>
                <td><textarea name="" cols="10" rows="2"></textarea></td>
                <td><input type="date"></td>
                <td><button type="button" class="btn btn-outline-danger"><span class="bi bi-x"></span></button></td>
                <td><button type="button" class="btn btn-outline-success"><span class="bi bi-check"></span></button></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </c:otherwise>
      </c:choose>

      <div class="card-footer">
        <div class="pag d-flex justify-content-sm-end">
          <nav aria-label="...">
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
  </jsp:body>
</t:editor>