<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	       <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <a href="index.html" class="brand-logo">
                <img class="logo-abbr" src="./images/logo.png" alt="">
                <img class="logo-compact" src="./images/logo-text.png" alt="">
                <img class="brand-title" src="./images/logo-text.png" alt="">
            </a>

            <div class="nav-control">
                <div class="hamburger">
                    <span class="line"></span><span class="line"></span><span class="line"></span>
                </div>
            </div>
        </div>
        <!--**********************************
            Nav header end
        ***********************************-->

        <!--**********************************
            Header start
        ***********************************-->
        <div class="header">
            <div class="header-content">
                <nav class="navbar navbar-expand">
                    <div class="collapse navbar-collapse justify-content-between">
                        <div class="header-left">
                            <div class="search_bar dropdown">
                                <span class="search_icon p-3 c-pointer" data-toggle="dropdown">
                                    <i class="mdi mdi-magnify"></i>
                                </span>
                                <div class="dropdown-menu p-0 m-0">
                                    <form>
                                        <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                                    </form>
                                </div>
                            </div>
                        </div>

                        <ul class="navbar-nav header-right">
                            <li class="nav-item dropdown notification_dropdown">
                                <a class="nav-link" href="#" role="button" data-toggle="dropdown">
                                    <i class="mdi mdi-bell"></i>
                                    <div class="pulse-css"></div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <ul class="list-unstyled">
                                        <li class="media dropdown-item">
                                            <span class="success"><i class="ti-user"></i></span>
                                            <div class="media-body">
                                                <a href="#">
                                                    <p><strong>Martin</strong> has added a <strong>customer</strong> Successfully
                                                    </p>
                                                </a>
                                            </div>
                                            <span class="notify-time">3:20 am</span>
                                        </li>
                                     </ul>
                                    <a class="all-notification" href="#"> <i
                                            class="ti-arrow-right"></i></a>
                                </div>
                            </li>
                            <li class="nav-item dropdown header-profile">
                                <a class="nav-link" href="#" role="button" data-toggle="dropdown">
                                    <i class="mdi mdi-account"></i>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a href="AdminProfileController" class="dropdown-item">
                                        <i class="icon-user"></i>
                                        <span class="ml-2">Profile </span>
                                    </a>
                                    <a href="UsersLogoutServlet" class="dropdown-item">
                                        <i class="icon-key"></i>
                                        <span class="ml-2">Đăng xuất</span>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->
        <div class="quixnav">
            <div class="quixnav-scroll">
                <ul class="metismenu" id="menu">
                    <li class="nav-label first">HỆ THỐNG WEBSITE</li>
                    <!-- <li><a href="index.html"><i class="icon icon-single-04"></i><span class="nav-text">Dashboard</span></a>
                    </li> -->
                    <li><a class="has-arrow"  aria-expanded="false"><i
                                class="icon icon-single-04"></i><span class="nav-text">Dashboard</span></a>
                        <ul aria-expanded="false">
                            <li><a href="AdminController">Thông kê</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Quản lý hệ thống</li>
                    <li><a class="has-arrow"  aria-expanded="false"><i
                                class="icon icon-app-store"></i><span class="nav-text">Sách</span></a>
                        <ul aria-expanded="false">
                            <li><a href="AdminManagaBookController">Quản lý Sách</a></li>
                        </ul>
                    </li>
                      <li><a class="has-arrow"  aria-expanded="false"><i
                                class="icon icon-app-store"></i><span class="nav-text">Quản lý Danh Mục</span></a>
                        <ul aria-expanded="false">
                            <li><a href="AdminManagaCategoryController">Danh Mục</a></li>
                        </ul>
                    </li>  <li><a class="has-arrow"  aria-expanded="false"><i
                                class="icon icon-app-store"></i><span class="nav-text">Quản lý Tác Giả</span></a>
                        <ul aria-expanded="false">
                            <li><a href="AdminMangageAuthorController">Tác Giả</a></li>
                        </ul>
                    </li>
                    <li><a class="has-arrow"  aria-expanded="false"><i class="icon icon-chart-bar-33"></i><span class="nav-text">Quản lý đặt hàng</span></a>
                        <ul aria-expanded="false">
                            <li><a href="AdminManageOrderController">Đơn Hàng được đặt</a></li>
                        </ul>
                         <ul aria-expanded="false">
                            <li><a href="AdminOrderCancelController">Đơn  Hàng được hủy</a></li>
                        </ul>
                    </li>
                    <li><a class="has-arrow" aria-expanded="alse"><i class="icon icon-chart-bar-33"></i><span class="nav-text">Quản lý vận chuyển</span></a>
                        <ul aria-expanded="false">
                            <li><a href="AdminManagaTransportController">Vận chuyển hàng</a></li>
                        </ul>
                    </li>
                       <li><a class="has-arrow" aria-expanded="alse"><i class="icon icon-chart-bar-33"></i><span class="nav-text">Quản lý Hóa đơn</span></a>
                        <ul aria-expanded="false">
                            <li><a href="AdminManagaBillController">hóa đơn</a></li>
                        </ul>
                    </li>

                  

                    <li class="nav-label">Thông Tin</li>
                    <li><a class="has-arrow"  aria-expanded="false"><i
                                class="icon icon-form"></i><span class="nav-text">Quản lý tài khoản</span></a>
                        <ul aria-expanded="false">
                            <li><a href="AdminManagaUserController">Quản lý khách hàng</a></li>
                        </ul>
                    </li>
                  

                </ul>
            </div>
        </div>
        </body>
        </html>
      