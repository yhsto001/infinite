<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<%@ include file="../common/jscsspath.jsp" %>
<style type="text/css">
 .card-title{
 text-align:center;
 color: cornflowerblue;
 font-size: 35px;
 }
</style>
 <script src="/resources/boardjs/login.js" charset="UTF-8"></script>
</head>
<body>
  <div class="page">
      <div class="page-single">
        <div class="container">
          <div class="row">
            <div class="col col-login mx-auto">
              <form class="card" action="" id="loginchk" method="post">
                <div class="card-body p-6">
                  <div class="card-title">담비기술</div>
                  <div class="form-group">
                    <label class="form-label">아이디</label>
                    <input type="text" class="form-control" placeholder="userid" id="USERID" name="USERID">
                  </div>
                  <div class="form-group">
                    <label class="form-label">
                  	    비밀번호
                    </label>
                    <input type="password" class="form-control" placeholder="Password" id="USERPW" name="USERPW">
                  </div>
                  <div class="form-group">
                  </div>
                  <div class="form-footer">
                    <button type="button" onclick="idpwschk();" class="btn btn-primary btn-block">로그인</button>
                  </div>
                </div>
              </form>
              <div class="text-center text-muted">
              <a href="enrollpage.do">회원가입</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>
