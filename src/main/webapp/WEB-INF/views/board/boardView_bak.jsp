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
.no{
width:156px;
}
.title{
width:650px;
}
.date{
width:150px;
}
.page-header{
place-content: center;
}
.name{
width:110px;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
 <div class="page">
      <div class="page-main">
      <jsp:include page="../common/header.jsp" />
 
        <div class="my-3 my-md-5">
          <div class="container">
            <div class="page-header">
              <h1 class="page-title">
           	     게시판
              </h1>
            </div>
            <div class="card">
  
              <table class="table card-table">
                <tr>
                  <th class="no">NO</th>
                  <th class="title">제목</th>
                  <th class="name">글쓴이</th>
                  <th class="date">등록일</th>
                  <th style="text-align:center;">조회수</th>
                </tr>
             <c:forEach items="${ list }" var="a">
                <tr>
                  <td>${a.BOARDNO }</td>
                  <td><a href="/first/boardView.do?BOARDNO=${a.BOARDNO} }">${a.BOARDTITLE }</a></td>
                  <td>${a.USERNAME }</td>
                  <td>${a.BOARDDATE }</td>
                  <td style="text-align:center;">${a.BOARDREADCOUNT }</td>
                </tr>
                </c:forEach>
              </table>
            </div>
          </div>
           <div class="pageing">
                 <div class="container" style="padding-left: 23px; padding-right: 23px;">
                 <div class="form-group row justify-content-center">
                      <form action="boardList.do" method="get" style="float:left">
			<div class="" style="float:left;">
				<select class="form-control form-control-sm" name="selectoption" id="selectoption">
					<option value="BOARDTITLE">제목</option>
				</select>
			</div>
			<div class="" style="float:left;">
				<input type="text" class="form-control form-control-sm" name="searchtext" id="searchtext" style="width: 252px;
    height: 31px;">
			</div>
			<input type="submit" value="검색" class="btn btn-sm btn-primary" style="height: 31px;">
		</form>
		
    		<nav aria-label="..." style="text-align: center">
        		 <ul class="pagination justify-content-center" style="float:left; padding-left: 150px;">
					<li class="page-item"><a class="page-link" href="boardList.do?page=1&selectoption=${commonPage.selectoption}&searchtext=${commonPage.searchtext}">|◁</a></li>
						<c:if test="${(commonPage.beginPage-commonPage.pageSize)<= 1}">
							<li class="page-item"><a class="page-link" href="boardList.do?page=1&selectoption=${commonPage.selectoption}&searchtext=${commonPage.searchtext}"><i class="fa fa-backward" aria-hidden="true"></i></a></li>
						</c:if>
						<c:if test="${ (commonPage.beginPage-commonPage.pageSize) > 1}">
							<li class="page-item"><a class="page-link" href="boardList.do?page=${commonPage.beginPage-commonPage.pageSize}&selectoption=${commonPage.selectoption}&searchtext=${commonPage.searchtext}"><i class="fa fa-backward" aria-hidden="true"></i></a></li>
						</c:if>
						<c:forEach var="p" begin="${commonPage.beginPage }" end="${commonPage.endPage }">
							<c:if test="${p == commonPage.currentPage }">
								<li class="page-item active"><a class="page-link" href="boardList.do?page=${p}&selectoption=${commonPage.selectoption}&searchtext=${commonPage.searchtext}">${p}</a></li>
							</c:if >
							<c:if test="${p != commonPage.currentPage }">
								<li class="page-item"><a class="page-link" href="boardList.do?page=${p}&selectoption=${commonPage.selectoption}&searchtext=${commonPage.searchtext}"  >${p}</a></li>
							</c:if>
						</c:forEach>
							<c:if test="${(commonPage.endPage+commonPage.pageSize) > commonPage.maxPage }">
								<li class="page-item"><a class="page-link" href="boardList.do?page=${commonPage.maxPage }&selectoption=${commonPage.selectoption}&searchtext=${commonPage.searchtext}"><i class="fa fa-forward" aria-hidden="true"></i></a></li>
							</c:if>
							<c:if test="${(commonPage.endPage+commonPage.pageSize) <= commonPage.maxPage }">
								<li class="page-item"><a class="page-link" href="boardList.do?page=${commonPage.beginPage + commonPage.pageSize}&selectoption=${commonPage.selectoption}&searchtext=${commonPage.searchtext}"><i class="fa fa-forward" aria-hidden="true"></i></a></li>
							</c:if>
								<li class="page-item"><a class="page-link" href="boardList.do?page=${commonPage.maxPage }&selectoption=${commonPage.selectoption}&searchtext=${commonPage.searchtext}">▷|</a></li>
					</ul>
				</nav>
				<div class="btn-list mt-4 text-right">
                        <button type="button" class="btn btn-primary btn-space" onclick = "location.href = '/first/boardWrite.do'">글쓰기</button>
                      </div>
                      </div>
                      	</div>
                      </div>
        </div>
      </div>
 
      <jsp:include page="../common/footer.jsp" />
    </div>
</body>
</html>