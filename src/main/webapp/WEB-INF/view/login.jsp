<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>DevOps Demo | Log in</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" type="text/css"
	href="${contextPath}/css/bootstrap.min.css">
<!-- Custom Fonts -->
<link rel="stylesheet" type="text/css"
	href="${contextPath}/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="${contextPath}/css/ionicons.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="${contextPath}/css/blue.css">
<!-- Theme style -->
<link rel="stylesheet" href="${contextPath}/css/AdminLTE.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>DevOps Demo</b></a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg"></p>

			<form action="${contextPath}/login/validate" method="post">
				<div class="form-group has-feedback">
					<input type="email" class="form-control" name="username"
						placeholder="用户名" id="email" >  <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control"
						placeholder="密码" id="password" > <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group" style="display: none" id="error-info">
					<span>Please input Email.</span>
				</div>
				<div class="form-group" style="display: none" id="error-info2">
					<span>Please input Password.</span>
				</div>
				<div class="form-group" style="display: none" id="error-info3">
					<span>Invalid Email address.</span>
				</div>
				<div class="form-group" style="display: none" id="error-info4">
					<span>Email address or password is not correct.</span>
				</div>
				<div class="form-group" style="display: none" id="error-info5">
					<span>Wrong password.</span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<!-- <label> <input type="checkbox"> Remember Me
							</label> -->
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="button" id="loginButton"
							class="btn btn-primary btn-block btn-flat">Sign In</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<!-- <div class="social-auth-links text-center">
				<p>- OR -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
					class="fa fa-facebook"></i> Sign in using Facebook</a> <a href="#"
					class="btn btn-block btn-social btn-google btn-flat"><i
					class="fa fa-google-plus"></i> Sign in using Google+</a>
			</div>
			/.social-auth-links
 			-->
			<!-- <a href="#">I forgot my password</a><br>  -->
			<div>没有账号?  <a href="${contextPath}/login/register" class="text-center">注册</a></div>

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script type="text/javascript"
		src="${contextPath}/js/jquery-3.1.1.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="${contextPath}/js/icheck.min.js"></script>
	<script>
	
	jQuery(document).ready(function() {
	    jQuery("#email").focus(function() {
	        jQuery("input").css("background-color", "#FFFFFF").css("border-color", "#d2d6de");
	        jQuery("#error-info").css("display", "none");
	    });
	    jQuery("#password").focus(function() {
	        jQuery("input").css("background-color", "#FFFFFF").css("border-color", "#d2d6de");
	        jQuery("#error-info").css("display", "none");
	        var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
	        var str = jQuery("#email").val();
	        if (str == undefined || str == null || str == "") {
	            jQuery("#error-info").css("display", "block").css("color", "red").text("Please input Email.");
	            jQuery("#email").css("background-color", "#FFFFCC").css("border-color", "red");
	        } else if (reg.test(str) == false) {
	            jQuery("#error-info").css("display", "block").css("color", "red").text("Invalid Email address.");
	            jQuery("#email").css("background-color", "#FFFFCC").css("border-color", "red");
	        }
	    });
	    jQuery("#email").blur(function() {
	            var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
	            var str = jQuery("#email").val();
	            if (str == undefined || str == null || str == "") {
	                jQuery("#error-info").css("display", "block").css("color", "red").text("Please input Email.");
	                jQuery("#email").css("background-color", "#FFFFCC").css("border-color", "red");
	            } else if (reg.test(str) == false) {
	                jQuery("#error-info").css("display", "block").css("color", "red").text("Invalid Email address.");
	                jQuery("#email").css("background-color", "#FFFFCC").css("border-color", "red");
	            }
	        });
	    jQuery("#password").blur(function() {
	    		var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
	            var str = jQuery("#email").val();
	            var pwd = jQuery("#password").val();
	            if (str == undefined || str == null || str == "") {
	                jQuery("#error-info").css("display", "block").css("color", "red").text("Please input Email.");
	                jQuery("#email").css("background-color", "#FFFFCC").css("border-color", "red");
	            } else if (reg.test(str) == false) {
	                jQuery("#error-info").css("display", "block").css("color", "red").text("Invalid Email address.");
	                jQuery("#email").css("background-color", "#FFFFCC").css("border-color", "red");
	            } else if (pwd == undefined || pwd == null || pwd == "") {
	                jQuery("#error-info").css("display", "block").css("color", "red").text("Please input Password.");
	                jQuery("#password").css("background-color", "#FFFFCC").css("border-color", "red");
	            }
        });
	});
	jQuery(document).ready(function() {
        jQuery("#loginButton").click(function() {
	        var username = jQuery("input[name=username]").val();
	        var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
	        if (username == undefined || username == null || username == "") {
	            jQuery("#error-info").css("display", "block").css("color", "red").text("Please input Email.");
	            jQuery("#email").css("background-color", "#FFFFCC").css("border-color", "red");
	            return;
	        } else if (reg.test(username) == false) {
	            jQuery("#error-info").css("display", "block").css("color", "red").text("Invalid Email address.");
	            jQuery("#email").css("background-color", "#FFFFCC").css("border-color", "red");
	            return;
	        }
	        var password = jQuery("input[name=password]").val();
	        if (password == undefined || password == null || password == "") {
	            jQuery("#error-info").css("display", "block").css("color", "red").text("Please input Password.");
	            jQuery("#password").css("background-color", "#FFFFCC").css("border-color", "red");
	            return;
	        }
	        var user = {
	            "username": username,
	            "password": password
	        };
	        jQuery.ajax({
	            type: "post",
	            dataType: "json",
	            data: user,
	            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
	            url: "${contextPath}/login/validate",
	            //async: false,
	            success: function(data) {
	            	console.log(data);
	                if (data == false) {
	                    jQuery("#error-info4").css("display", "block").css("color", "red").text("Email address or password is not correct.");
	                } else if (data == true) {
	                	var currentUrl = "${currenturl}";
	                	var indexUrl = window.location.protocol + "//" + window.location.host + "/demo/dashboard";
	                	if ("" != currentUrl) {
	                		indexUrl =  "${contextPath}"+ currentUrl;
	                	}
	                    window.location = indexUrl;
	                }
	            },
	            error: function() {
	                alert("Server connection timed out, please try to sign in again.");
	            }
	        });
	    });
	   /*  jQuery("body").keydown(function() {
	        if (event.keyCode == "13") {
	            jQuery("#loginButton").click();
	        }
	    }); */
	});
	
	jQuery(document).ready(function() {
		jQuery("body").keydown(function() {
	        if (event.keyCode == "13") {
	            jQuery("#loginButton").click();
	        }
	    });
	});
	
	
	$(function() {
		$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
		});
	});
	</script>
</body>
</html>
