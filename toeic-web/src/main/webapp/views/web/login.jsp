<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="login.html"/>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<div id="login-box" class="login-box visible widget-box no-border">
    <div class="widget-body">
        <div class="widget-main">
            <h4 class="header blue lighter bigger">
                <i class="ace-icon fa fa-coffee green"></i>
                <fmt:message key="label.nhap_thong_tin" bundle="${lang}"/>
            </h4>

            <div class="space-6"></div>

            <form action="${formUrl}" method="post">
                <fieldset>
                    <label class="block clearfix">
						<span class="block input-icon input-icon-right">
							<input type="text" class="form-control" placeholder="Tên đăng nhập" name="pojo.name"/>
							<i class="ace-icon fa fa-user"></i>
						</span>
                    </label>

                    <label class="block clearfix">
						<span class="block input-icon input-icon-right">
							<input type="password" class="form-control" placeholder="Mật khẩu" name="pojo.password"/>
							<i class="ace-icon fa fa-lock"></i>
						</span>
                    </label>

                    <label class="block clearfix">
						<span class="block input-icon input-icon-right">
							<input type="password" class="form-control" placeholder="Xác nhận mật khẩu" name="confirmPassword"/>
							<i class="ace-icon fa fa-lock"></i>
						</span>
                    </label>

                    <div class="space"></div>

                    <div class="clearfix">
                        <label class="inline">
                            <input type="checkbox" class="ace"/>
                            <span class="lbl"> <fmt:message key="label.nho_dang_nhap" bundle="${lang}"/> </span>
                        </label>

                        <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                            <i class="ace-icon fa fa-key"></i>
                            <span class="bigger-100"><fmt:message key="label.dang_nhap" bundle="${lang}"/> </span>
                        </button>
                    </div>

                    <div class="space-4"></div>
                </fieldset>
            </form>

            <div class="social-or-login center">
                <span class="bigger-110">Đăng nhập bằng</span>
            </div>

            <div class="space-6"></div>

            <div class="social-login center">
                <a class="btn btn-primary">
                    <i class="ace-icon fa fa-facebook"></i>
                </a>

                <a class="btn btn-info">
                    <i class="ace-icon fa fa-twitter"></i>
                </a>

                <a class="btn btn-danger">
                    <i class="ace-icon fa fa-google-plus"></i>
                </a>
            </div>
        </div><!-- /.widget-main -->

        <div class="toolbar clearfix">
            <div>
                <a href="#" data-target="#forgot-box" class="forgot-password-link">
                    <i class="ace-icon fa fa-arrow-left"></i>
                    <fmt:message key="label.tim_mat_khau" bundle="${lang}"/>
                </a>
            </div>

            <div>
                <a href="#" data-target="#signup-box" class="user-signup-link">
                    <fmt:message key="label.dang_ky" bundle="${lang}"/>
                    <i class="ace-icon fa fa-arrow-right"></i>
                </a>
            </div>
        </div>
    </div><!-- /.widget-body -->
</div><!-- /.login-box -->

</body>
</html>
