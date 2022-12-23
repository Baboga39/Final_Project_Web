<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="d" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<d:user>
    <jsp:body>
        <br><br><br><br>
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
                    <div class="card-body py-5 px-md-5">
                        <div>
                            <h1 class="fw-bold mb-5 text-heading">User Profile</h1>
                        </div>
                        <div class="row row-cols-2">
                            <div class="col-4 ml-3 shadow-lg" style="background: #f7f7f7">
                                <div class="row mt-5">
                      <span class="user-icon" style="margin: 0px auto">
                        <img src="./img/khoa.png" class="img-fluid">
                          </span>
                                </div>
                                <div class="row mt-3">
                                    <h4 class="" style="margin: 0px auto">Phan Dai Dang Khoa</h4>
                                </div>
                                <div class="row mt-2">
                                    <p class="" style="margin: 0px auto">Name Writer</p>
                                </div>
                                <div class="row mt-2 mb-5">
                                    <p class="" style="margin: 0px auto">Name Role</p>
                                </div>
                            </div>
                            <div class="col-7 ml-5" style="background: #eee">
                                <ul class="list-group list-group-flush mt-3">
                                    <li class="list-group-item">
                                        <div class="row mt-4">
                                            <span class="col-4">Full Name: </span>
                                            <div class="col-6">
                                                <input type="email" id="txtEmail" name="email" placeholder="Email"class="form-control" />
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        <div class="row mt-4">
                                            <span class="col-4">Name Writer: </span>
                                            <div class="col-6">
                                                <input type="email"  name="email" placeholder="Email"class="form-control" />
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        <div class="row mt-4">
                                            <span class="col-4">Email: </span>
                                            <div class="col-6">
                                                <input type="email"  name="email" placeholder="Email"class="form-control" />>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        <div class="row mt-4 mb-2">
                                            <span class="col-4">Birthday: </span>
                                            <div class="col-6">
                                                <input type="email"  name="email" placeholder="Email"class="form-control" />
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <div class="row mt-2 mb-2">
                                    <div class="col text-right">
                                        <a href="#" class="btn btn-sm btn-outline-secondary alert-link nav-link text-heading">Cật nhập thông tin</a>
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
                                                <input type="email" name="email" placeholder="Email"class="form-control" />
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        <div class="row">
                                            <span class="col-4">Password: </span>
                                            <div class="col-8">
                                                <input type="email"  name="email" placeholder="Email"class="form-control" />
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        <div class="row">
                                            <span class="col-4">Status: </span>
                                            <div class="col-8">
                                                <input type="email"  name="email" placeholder="Email"class="form-control" />
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        <div class="row">
                                            <span class="col-4">Date: </span>
                                            <div class="col-8">
                                                <input type="email"  name="email" placeholder="Email"class="form-control" />
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
                </div>
            </div>

        </div>
    </jsp:body>
</d:user>