<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="authUser" scope="session" type="com.example.edit.beans.User"/>

<d:web>
    <jsp:attribute name="css">
        <style>
          .user-icon img{
            border-radius: 50%;
            width: 150px;
            margin-right: 10px;
          }
        </style>
    </jsp:attribute>
  <jsp:body>
    <div class="content">
      <div class="container">
        <!-- Background image -->
        <div class="p-5 bg-image" style="
        background: bisque;
        height: 300px;
        "></div>
        <!-- Background image -->

        <div class="card mx-4 mx-md-5 shadow" style="
        margin-top: -250px;
        background: #eee;
        backdrop-filter: blur(30px);
        ">
          <c:choose>
            <c:when test="${auth}">
              <div class="card-body py-5 px-md-5">
                <div>
                  <h1 class="fw-bold mb-5 text-heading">User Profile</h1>
                </div>
                <div class="row row-cols-2">
                  <div class="col-4 ml-3 shadow-lg" style="background: #f7f7f7">
                    <div class="row mt-5">
                      <span class="user-icon" style="margin: 0px auto">
                         <img src="${pageContext.request.contextPath}/image/user.png" class="img-fluid">
                         </span>
                    </div>
                    <div class="row mt-3">
                      <h4 class="" style="margin: 0px auto">${authUser.name}</h4>
                    </div>
                    <c:if test="${authUser.role_id == 3}">
                      <div class="row mt-2">
                        <p class="" style="margin: 0px auto">${authUser.second_name}</p>
                      </div>
                    </c:if>
                    <c:if test="${authUser.role_id == 1}">
                      <div class="row mt-5">
                        <p class="" style="margin: 0px auto">Administrator</p>
                      </div>
                    </c:if>
                    <c:if test="${authUser.role_id == 2}">
                      <div class="row mt-5">
                        <p class="" style="margin: 0px auto">User</p>
                      </div>
                    </c:if>
                    <c:if test="${authUser.role_id == 3}">
                      <div class="row mt-5">
                        <p class="" style="margin: 0px auto">Reporter</p>
                      </div>
                    </c:if>
                    <c:if test="${authUser.role_id == 4}">
                      <div class="row mt-5">
                        <p class="" style="margin: 0px auto">Editor</p>
                      </div>
                    </c:if>
                  </div>
                  <div class="col-7 ml-5" style="background: #eee">
                    <ul class="list-group list-group-flush mt-3">
                      <li class="list-group-item">
                        <div class="row mt-4">
                          <span class="col-4">Name: </span>
                          <div class="col-8">
                            <input style="    width: 100% !important" type="text" name="name" placeholder="${authUser.name}">
                          </div>
                        </div>
                      </li>
                      <c:if test="${authUser.role_id == 3} ">
                        <li class="list-group-item">
                          <div class="row mt-4">
                            <span class="col-4">Name Writer: </span>
                            <div class="col-8">
                              <input style="    width: 100% !important" type="text" name="secondName" placeholder="${authUser.second_name}">
                            </div>
                          </div>
                        </li>
                      </c:if>
                      <li class="list-group-item">
                        <div class="row mt-4">
                          <span class="col-4">Email: </span>
                          <div class="col-8">
                            <input style="    width: 100% !important" type="text" name="email" placeholder="${authUser.email}">
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row mt-4 mb-2">
                          <span class="col-4">Birthday: </span>
                          <div class="col-8">
                            <input style="    width: 100% !important" type="text" name="birthDay" style="    width: 100% !important" placeholder="${authUser.dateOfBirth}">
                          </div>
                        </div>
                      </li>
                    </ul>
                    <div class="row mt-2 mb-2">
                      <div class="col text-right">
                        <a href="${pageContext.request.contextPath}/User/EditProfile" class="btn btn-sm btn-outline-secondary alert-link nav-link text-heading">Cật nhập thông tin</a>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="mt-5">
                  <h4 class="fw-bold text-heading">Information Account</h4>
                </div>
                <div class="row mt-1 w-100">
                  <div class="card-body">
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item">
                        <div class="row">
                          <span class="col-4">User: </span>
                          <div class="col-8">
                            <input style="    width: 100% !important" type="text" name="birthDay" placeholder="${authUser.username}">
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row">
                          <span class="col-4">Password: </span>
                          <div class="col-8">
                            <input type="password"style="    width: 100% !important" name="birthDay" placeholder="${authUser.password}">
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row">
                          <span class="col-4">Status: </span>
                          <c:if test="${checkEx eq true}">
                            <div class="col-8">
                              <span>Vip</span>
                            </div>
                          </c:if>
                          <c:if test="${checkEx eq false}">
                            <div class="col-8">
                              <span>Hết hạn</span>
                            </div>
                          </c:if>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row">
                          <span class="col-4">Date: </span>
                          <c:if test="${checkEx eq true}">
                            <div class="col-8">
                              <span>Vip</span>
                            </div>
                          </c:if>
                          <c:if test="${checkEx eq false}">
                            <div class="col-8">
                              <span>Hết hạn</span>
                            </div>
                          </c:if>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col text-right">
                    <button class="btn btn-lg btn-warning ">Nâng Cấp Tài Khoản</button>
                  </div>
                </div>
              </div>
            </c:when>
            <c:when test="${authGg}">
              <div class="card-body py-5 px-md-5">
                <div>
                  <c:if test="${sessionScope.mess ne null}">
                    <div style="color: red;">
                      <p>${sessionScope.mess}</p>
                    </div>
                  </c:if>
                  <h1 class="fw-bold mb-5 text-heading">User Profile</h1>
                </div>
                <div class="row row-cols-2">
                  <div class="col-4 ml-3 shadow-lg" style="background: #f7f7f7">
                    <div class="row mt-5">
                      <span class="user-icon" style="margin: 0px auto">
                         <img src="${sessionScope.authUserGg.picture}" class="img-fluid">
                         </span>
                    </div>
                    <div class="row mt-3">
                      <h4 class="" style="margin: 0px auto">${sessionScope.authUserGg.name}</h4>
                    </div>
                    <div class="row mt-2 mb-5">
                      <p class="" style="margin: 0px auto">Name Role</p>
                    </div>
                  </div>
                  <div class="col-7 ml-5" style="background: #eee">
                    <ul class="list-group list-group-flush mt-3">
                      <li class="list-group-item">
                        <div class="row mt-4">
                          <span class="col-4">Name: </span>
                          <div class="col-6">
                            <span>${sessionScope.authUserGg.name}</span>
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row mt-4">
                          <span class="col-4">Email: </span>
                          <div class="col-6">
                            <span>${sessionScope.authUserGg.email}</span>
                          </div>
                        </div>
                      </li>
                    </ul>
                    <div class="row mt-2 mb-2">
                      <div class="col text-right">
                        <a href="" class="btn btn-sm btn-outline-secondary alert-link nav-link text-heading">Cật nhập thông tin</a>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="mt-5">
                  <h4 class="fw-bold text-heading">Information Account</h4>
                </div>
                <div class="row mt-1 w-100">
                  <div class="card-body">
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item">
                        <div class="row">
                          <span class="col-4">User: </span>
                          <div class="col-8">
                            <span>Goole Police</span>
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row">
                          <span class="col-4">Password: </span>
                          <div class="col-8">
                            <span>Goole Police</span>
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row">
                          <span class="col-4">Status: </span>
                          <div class="col-8">
                            <span>Vip</span>
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row">
                          <span class="col-4">Date: </span>
                          <div class="col-8">
                            <span>3 Day left</span>
                          </div>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
                <div class="row mt-2">
                  <div class="col text-right">
                    <button class="btn btn-lg btn-warning ">Nâng Cấp Tài Khoản</button>
                  </div>
                </div>
              </div>
            </c:when>
          </c:choose>
        </div>
      </div>
    </div>
  </jsp:body>
</d:web>
