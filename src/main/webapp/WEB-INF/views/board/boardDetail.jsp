<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!DOCTYPE html>
		<html>
			<head>
				<meta charset="UTF-8">
					<title>Insert title here</title>
					<%@ include file="../common/jscsspath.jsp"%>
						<style type="text/css">
							.page-header {
								place-content: center;
							}
							
							.detail1 {
								width: 100%;
							}
							
							.card-title {
								width: 100%;
								text-align: center;
							}
							
							#ofile {
								color: cornflowerblue;
							}
							.boardLabel {
								height: 25px;
								padding-top: 7px;
								padding-left: 20px;
								padding-right: 20px;
								width: 110px;
							}
						</style>
						<script type="text/javascript">
							var no2 = ${no};
							<%@ include file="/resources/boardjs/boardDetail.js"%>
						</script>
					</head>
					<body>

					<div class="page">
	<jsp:include page="../common/header.jsp"/>
	<div class="page-main">
		<div class="my-3 my-md-5">
			<div class="container">
				<div class="page-header">				
					<h1 class="page-title">상세보기</h1>
				</div>
				<div class="row">
					<div class="detail1">
						<div class="card">
							<div class="card-header">
								<input type="hidden" id="no" value="${no }">
									<h3 class="card-title" id="title"></h3>
							</div>
							<div class="card-body">
								<div class="form-group">
									<div class="row align-items-center">
										<label class="col-sm-2">글쓴이:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="username" style="background-color: #fff;" readonly="readonly"></div>
										</div>
									</div>
									<div class="form-group">
										<div class="row align-items-center">
											<label class="col-sm-2">파일:</label>
											<div class="col-sm-10">
												<h4 id="ofile"></h4>
											</div>
										</div>
									</div>
									<textarea rows="10" class="form-control" id="content" style="background-color: #fff;" readonly="readonly"></textarea>
									<div class="btn-list mt-4 text-right">
										<button class="btn btn-primary btn-space" onclick="update_click();">수정</button>
										<button class="btn btn-secondary btn-space" onclick="delete_click();">삭제</button>
										<button class="btn btn-primary btn-space" onclick="comment_click();">답글</button>
										<button class="btn btn-secondary btn-space" id="boarList" onclick="boardList_click();">목록</button>
									</div>
								</div>
							</div>
							<form action="commentAdd.do" method="post">
								<div class="card" id="showhide">
									<div class="card-body" style="padding: 0.5rem;">
										<div class="form-group">
											<div class="row align-items-center">
												<label class="boardLabel">답글 :</label>
															
												<div class="col-sm-10" style="padding-top: 3px;">
													<input type="text" class="form-control" style="background-color: #dee2e6;" id="COMMENTCONTENT" name="COMMENTCONTENT">
												</div>
												<button type="button" class="btn btn-primary btn-space" onclick="commentAdd_click();">작성</button>
												<input type="hidden" value="${no }" id="BOARDNO" name="BOARDNO">
												<input type="hidden" value="${sessionScope.user.USERNAME }" id="COMMENTNAME" name="COMMENTNAME">
												<input type="hidden" value="${sessionScope.user.USERNO }" id="USERNO" name="USERNO">
											</div>
										</div>
									</div>
								</div>
							</form>
			
						<div id="cmt">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</div>
												</body>
											</html>
