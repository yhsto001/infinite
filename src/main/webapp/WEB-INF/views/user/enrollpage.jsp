<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/jscsspath.jsp" %>  
<style type="text/css">
 .card-title{
 text-align:center;
 color: cornflowerblue;
 font-size: 35px;
 }
 .container{
 height: 700px;
 }
 .row{
 height:700px;
 }
 .col-login {
    max-width: fit-content;
}
.ml-auto, .mx-auto {
    margin-left: auto;
}
.mr-auto, .mx-auto {
    margin-right: auto;
}
.card{
    height: 702px;
    width: 552px;
}
</style>
</head>
<body>
<div class="page">
      <div class="page-single">
        <div class="container">
          <div class="row">
            <div class="col col-login mx-auto">
              <form class="card" action="enroll.do" method="post">
                <div class="card-body p-6">
                  <div class="card-title">회원가입</div>
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
              <!--      <div class="form-group">
                    <label class="form-label">
                  	    비밀번호 확인
                    </label>
                    <input type="password" class="form-control" placeholder="Passwordcheck" id="USERPWCH">
                  </div> -->
                       <div class="form-group">
                    <label class="form-label">이름</label>
                    <input type="text" class="form-control" placeholder="홍길동" id="USERNAME" name="USERNAME">
                  </div>
                        <div class="form-group">
                    <label class="form-label">이메일</label>
                    <input type="email" class="form-control" placeholder="abcdefg@gmail.com" id="USERMAIL" name="USERMAIL">
                  </div>
                        <div class="form-group">
                    <label class="form-label">전화번호</label>
                    <input type="tel" class="form-control" placeholder="010-1234-5678" id="USERPHONE" name="USERPHONE">
                  </div>
                  <div class="form-footer">
                    <button type="submit" class="btn btn-primary btn-block">회원가입</button>
                  </div>
                </div>
              </form>
              <div class="text-center text-muted">
              <a href="javascript:history.back()">로그인화면</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>