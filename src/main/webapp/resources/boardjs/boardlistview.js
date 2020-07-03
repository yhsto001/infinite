         		/* <%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%> */  
				$(function () {
                  viewBoardTable();
                  $(".showhide2").hide();
                  $(".showhide3").hide();
           /*        $(".page-link").click(function(){
                	  viewBoardTable2();
                  }); */
                });

                function showview(boardno) {
                  $("#showhide" + boardno).toggle();
                  $("#showhideinput" + boardno).toggle();
                }
                
                
                function showview2(replyno) {
                  $("#showhideinput2" + replyno).toggle();
                }
                
                
                function replyenroll(boardno) {
                  $.ajax({
                    url: "boardReplyEnroll.do",
                    data: {
                      BOARDNO: boardno,
                      REPLYCONTENT: $("#reinput" + boardno).val(),
                      USERNO: $("#USERNO").val(),
                      REPLYNAME: $("#USERNAME").val()
                    },
                    type: "get",
                    contentType: "application/json",
                    success: function (data) {
                      location.reload();
                    },
                    error: function (e) {
                      console.log(e.responseText);
                    }
                  });
                }
                
                
                function replyenroll2(replyno) {
                  $.ajax({
                    url: "boardReplyEnroll2.do",
                    data: {
                      REPLYNO: replyno,
                      REPLYCONTENT: $("#reinput2" + replyno).val(),
                      USERNO: $("#USERNO").val(),
                      REPLYNAME: $("#USERNAME").val()
                    },
                    type: "get",
                    contentType: "application/json",
                    success: function (data) {
                      location.reload();
                    },
                    error: function (e) {
                      console.log(e.responseText);
                    }
                  });
                }
                
                
                function replyDelete(replyno) {
                  $.ajax({
                    url: "boardReplyDelete.do",
                    data: {
                      REPLYNO: replyno
                    },
                    type: "get",
                    contentType: "application/json",
                    success: function (data) {
                      location.reload();
                    },
                    error: function (e) {
                      console.log(e.responseText);
                    }
                  });
                }
                
                
                function boardReplyWrite(boardno) {
                  location.href = 'boardReplyWrite.do?BOARDNO=' + boardno;
                }

                
                function  viewBoardTable(page2,selectoption2,searchtext2){
                	console.log(page2,selectoption2,searchtext2);
                $.ajax({
                	url : "boardListTable.do",
                	data : {
       					page : page2,
       					selectoption : selectoption2,
						searchtext : searchtext2 
                	},
           		   type : "post",
        		   datatype : "json",
                	success : function (data){
                		console.log(data);
                		var table = " <tr>";
                		    table += "	<th class='no'>NO</th>";
                		    table += "	<th class='title'>제목</th>";
                		    table += "	<th class='name'>글쓴이</th>";
                		    table += "	<th class='date'>등록일</th>";
                		    table += "	<th style='text-align:center;'>조회수</th>";
                		    table += "</tr>";
                		for(i = 0; i < data.length; i++){
                			table += "<tr>"
                			table += "	<td>"+data[i].boardtotalno+"</td>";
                			table += "	<td>";
                			if(data[i].boarddeletestate == 'N'){
                				if(data[i].boardtitle2 != null){
                			table += "		<div style='display : inline-table; margin-left:"+(30*data[i].boarddepth)+"px;'>";
                			table += "			<i class='fe fe-corner-down-right'></i>RE "+data[i].boardtitle2+":";
                			table += "		</div>";
                				}
                			table += "		<a href='boardView.do?boardno="+data[i].boardno+"'>";
                			table += 		data[i].boardtitle;
                			table += "		</a>";
                			table += "		<a href='#a' style='float:right;' onclick='boardReplyWrite("+data[i].boardno+")'>리플";
                			table += "			<i class='fe fe-edit' style='color: #87abf3;'></i>";
             				table += "		</a>";
                			}
                			if(data[i].boarddeletestate == 'Y'){
                				if(data[i].boardtitle2 != null){
                			table += "		<div style='display: inline-table; margin-left:"+(30*data[i].boarddepth)+"px;'>";
                			table += "			<i class='fe fe-corner-down-right'></i>RE "+data[i].boardtitle2+":";
                			table += "		</div>";
                				}
                			table += "			<i class='fe fe-delete' style='color:red;'></i>";
                			table += "				삭제된 리플입니다.";
                			}
                			table += "	</td>";
                			table += "	<td>"+data[i].username+"</td>";
                			table += "	<td>"+data[i].boarddate+"</td>";
                			table += "	<td style='text-align:center;'>"+data[i].boardreadcount+"</td>";
                			table += "</tr>";

                		}   
                	$("#boardtable").html(table);
                	viewBoardTable2(page2,selectoption2,searchtext2);
                	},
                	error : function (e){
                		console.log(e.responseText);
                	}
                });
                }
		
                
				function viewBoardTable2(page2,selectoption2,searchtext2){
					var a = 1;
            	   $.ajax({
            		   url : "boardListTable2.do",
            		   data : {
						page : page2,
						selectoption : selectoption2,
						searchtext : searchtext2 
            		   },
            		   type : "post",
            		   datatype : "json",
            		   success : function (data){
            			   console.log(data);
            			if(data.selectoption == ""){
            				data.selectoption = null;
            				data.searchtext = null;
            			}
            			   
            		   var paging =  "<div class='container' style='padding-left: 23px; padding-right: 23px;'>";
            		   	   paging += "		<div class='form-group row justify-content-center'>";
            		   	   paging += "			<form action='' id='listlist' method='get' style='float:left'>";
            		   	   paging += "				<div class='' style='float:left;'>";
            		   	   paging += "					<select class='form-control form-control-sm' name='selectoption' id='selectoption'>";
            		   	   paging += "						<option value='BOARDTITLE' selected>제목</option>";
            		   	   paging += "						<option value='USERNAME'>글쓴이</option>";
            		   	   paging += "					</select>";
            		   	   paging += "				</div>";
            		   	   paging += "				<div class='' style='float:left;'>";
            		   	   paging += "					<input type='text' class='form-control form-control-sm' name='searchtext' id='searchtext' style='width: 252px; height: 31px;'>";
            		   	   paging += "				</div>";
            		   	   paging += "				<button type='button' class='btn btn-sm btn-primary' style='height: 31px;' onclick='viewBoardTable3();'>검색</button>";
            		   	   paging += "			</form>";
            		   	   paging += "			<nav aria-label='...' style='text-align: center'>";
            		   	   paging += "				<ul class='pagination justify-content-center' style='float:left; padding-left: 150px;'>";
            		       paging += "					<li class='page-item'>";
            		       paging += "						<button class='page-link' type='button' onclick='viewBoardTable("+a+",\""+data.selectoption+"\",\""+data.searchtext+"\");'>|◁</button>";
            		       paging += "					</li>";
            		       if(data.currentPage > 1){
            		       paging += "					<li class='page-item'>";
            		       paging += "						<button class='page-link' type='button' onclick='viewBoardTable("+data.currentPage+"-1,\""+data.selectoption+"\",\""+data.searchtext+"\");'>";
						   paging += "							<i class='fa fa-backward' aria-hidden='true'></i>";
						   paging += "						</button>";
						   paging += "					</li>";
            		       }
           
            		for(var i = data.beginPage; i <= data.endPage; i++){
            		   if(i == data.currentPage){
            		   	   paging += "					<li class='page-item active'>";
            		   			  /*  paging += "<a class='page-link' href='boardListTable.do?page="+i+"&selectoption=${commonPage.selectoption}&searchtext=${commonPage.searchtext}'>"+i+"</a>"; */
            		   	   paging += "						<button class='page-link' type='button' onclick='viewBoardTable("+i+",\""+data.selectoption+"\",\""+data.searchtext+"\");'>"+i+"</button>";
            		   	   paging += "					</li>";
            		   		   } 
            		   		   if(i != data.currentPage){
            		   	   paging += "					<li class='page-item'>";
            		   	   paging += "						<button class='page-link' type='button' onclick='viewBoardTable("+i+",\""+data.selectoption+"\",\""+data.searchtext+"\");'>"+i+"</button>";
            		   	   paging += "					</li>";
            		   		   }
            		   	   }
            		    	   if(data.currentPage < data.maxPage){
            		       paging += "					<li class='page-item'>";
            		       paging += "						<button class='page-link' type='button' onclick='viewBoardTable("+data.currentPage+"+1,\""+data.selectoption+"\",\""+data.searchtext+"\");'>";
            		       paging += "							<i class='fa fa-forward' aria-hidden='true'></i>";
            		       paging += "						</button>";
            		       paging += "					</li>";
            		    	   }
            		       paging += "					<li class='page-item'>";
            		       paging += "						<button class='page-link'  type='button' onclick='viewBoardTable("+data.maxPage+",\""+data.selectoption+"\",\""+data.searchtext+"\");'>▷|</button>";
            		       paging += "					</li>";
            		       paging += "				</ul>";
            		       paging += "			</nav>";
            		       paging += "			<div class='btn-list mt-4 text-right'>";
            		       paging += "				<button type=\"button\" class=\"btn btn-primary btn-space\" onclick='location.href = \"boardWrite.do\"'>글쓰기</button>";
            		       paging += "			</div>";
            		       paging += "		</div>";
            		       paging += "</div>";
            		     $("#pageing").html(paging);
            		   },
            		   error : function (e){
            			   console.log(e.responseText);
            		   }
            	   });
               }
				
				
				function viewBoardTable3(){
					var aa = 1;
					var bb = document.getElementById("selectoption").value;
					var cc = document.getElementById("searchtext").value;
					viewBoardTable(aa,bb,cc);
				}
				