<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="CSS/login.css" rel="stylesheet">
<script src="bootstrap/js/bootstrap.min.js"></script>


<!------ Include the above in your HEAD tag ---------->

<!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
    <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
             <s:if test="message=='failed'">
                <div class="alert alert-danger">
                    <strong>User Id and Password Does not match!</strong>
                </div>
            </s:if>
            <form class="form-signin" action="login">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" id="inputEmail" name="userName" class="form-control" placeholder="Email address" required autofocus>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
            </form><!-- /form -->
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->