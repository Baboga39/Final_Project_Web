<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header">
    <nav class="navbar navbar-expand-lg navbar-light  shadow-sm sticky-top" style="background: #EAE9E8">
        <div class="container d-flex justify-content-between">
            <a class="navbar-brand mb-0 h1" href="#">Brand Name</a>
            <div class="collapse navbar-collapse ml-5">
                <ul class="navbar-nav mr-auto mt-2">
                    <c:forEach items="${listC}" var="o">
                        <li class="nav-item dropdown text-category " style="font-size: 14px;">
                            <a class="link nav-link" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                                ${o.name}
                            </a>
                        </li>
                    </c:forEach>

                    <li class=" nav-item dropdown text-category">
                        <a class="nav-link show-modal" href="#" role="button" data-toggle="modal" data-target="#myModal" aria-expanded="false">
                            <i class="bi bi-grid ml-2" style="font-size: 17px"></i>
                        </a>
                        <div class="modal fade mt-5" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content modal-cate shadow clearfix" style="height: 125px !important;
                                                                                             width: 478px !important;
                                                                                             min-height: 125px!important;   ">
                                    <button type="button" class="close text-right mr-2" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                                    <div class="modal-body ">
                                        <div class="container">
                                            <div class="row">

                                                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                                                        <div class="panel panel-default">
                                                            <div class="panel-heading" role="tab" id="headingOne">
                                                                <div class="row">
                                                                    <c:forEach items="${listP}" var="o">
                                                                        <a href="#" class="link nav-link">${o.name}</a>

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
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/Posts/Search" >
                    <div class="p-1 rounded rounded-pill shadow-lg mw-100" style="background: snow">
                        <div class="input-group text-white">
                            <input name="search" type="search" placeholder="Nhập vào đây" aria-describedby="button-addon1" class="form-control border-0 rounded rounded-pill bg-light">
                            <div class="input-group-append">
                                <button id="button-addon1" type="submit" class="btn btn-link"><i class="bi bi-search" style="color: black"></i></button>
                            </div>
                        </div>
                    </div>
                    <div class="nav-item dropdown text-category mt-1">
                        <a class="nav-link show-modal" href="#" role="button" data-toggle="modal" data-target="#myLogin" aria-expanded="false">
                            <span class="user-action"><img src="${pageContext.request.contextPath}/image/user.png" class="avatar" alt="Avatar"></span>

                        </a>
                        <div class="modal fade mt-5" id="myLogin" tabindex="-2" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content modal-login shadow clearfix">
                                    <button type="button" class="close text-right mr-2" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                                    <div class="modal-body w-100 h-100">
                                        <div class="container ml-4">
                                            <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                                <div class="card-body p-4 p-lg-5 text-black">
                                                    <div class="d-flex align-items-center mb-3 pb-1">
                                                        <span class="h1 fw-bold mb-0">Logo</span>
                                                    </div>

                                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Đăng nhập</h5>

                                                    <div class="form-outline mb-4">
                                                        <input type="email" id="form2Example17" placeholder="Email" class="form-control form-control-lg" />
                                                    </div>

                                                    <div class="form-outline mb-4">
                                                        <input type="password" id="form2Example27" placeholder="Password" class="form-control form-control-lg" />
                                                    </div>

                                                    <div class="pt-1 mb-4">
                                                        <button class="btn btn-dark btn-lg btn-block" type="button">Login</button>
                                                    </div>
                                                    <div class="text-center">
                                                        <p>Not a member? <a href="${pageContext.request.contextPath}/User/Register">Register</a></p>
                                                        <p> <a href="${pageContext.request.contextPath}/views/viewHome/ForgotPass.jsp">Forgot password?</a></p>
                                                        <p>or sign up with:</p>
                                                        <button type="button" class="btn btn-link btn-floating mx-1">
                                                                <a href="https://www.facebook.com/dialog/oauth?client_id=515625173274802&redirect_uri=http://localhost:8080/Edit/Loging/Facebook">
                                                                <i class="bi bi-facebook h3"></i>
                                                            </a>
                                                        </button>

                                                        <button type="button" class="btn btn-link btn-floating mx-1">
                                                            <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/Edit/Loging/Google&response_type=code&client_id=1042745399242-4360ia1ghlrnq5ej8cejthrvfjr1n38s.apps.googleusercontent.com&approval_prompt=force">
                                                            <i class="bi bi-google h3"></i>
                                                            </a>
                                                        </button>

                                                        <button type="button" class="btn btn-link btn-floating mx-1">
                                                            <i class="bi bi-instagram h3"></i>
                                                        </button>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </nav>
</div>