<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>项目信息修改页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/form.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<style>
		.basic-grey {
			margin-top: 120px;
		}
	</style>
	<!-- <script type="text/javascript">
		$(function(){
			$("#back_list").on("click",function(){
				location.href = "project";
			});
			
			// 修改保存
			$("#save").on("click",function(){
				var Idd = $("#title").val(); //商品标题
				var title = $("#title").val(); //商品标题
				var oldMoney = $("#oldMoney").val(); // 商品原价
				var money = $("#money").val(); // 商品现价
				var goodNumber = $("#goodNumber").val(); // 商品编号
				var goodIntroduction = $("#goodIntroduction").val(); // 商品信息
				var sellNumber = $("#sellNumber").val(); // 售出数量
				var images = $("#images").val(); // 商品图片
				$.ajax({
					url:"update",
					type:"get",
					data:{
						"id":id,
						"title":title,
						"oldMoney":oldMoney,
						"money":money,
						"goodNumber":goodNumber,
						"goodIntroduction":goodIntroduction,
						"sellNumber":sellNumber,
						"images":images
					},
					dataType:"json",
					success:function(data){
						
						if (data.success== 1) {
							alert("修改成功!");
							location.href = "product";
						} else {
							alert("修改失败!");
						};
					},
					error:function(title){
						alert("ajax参数错误!");
					}
				});
			});
		});
	</script> -->
  </head>
	<body style="background-color:black;">
	<form action="/tiangou_dj/update" id="projectForm" style="width: 800px;" method="post" class="basic-grey" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${projectInfo.id }" id="id" />
		
		
		<label> 
			<span>商品标题：</span><input id="title" type="text" name="title" value="${projectInfo.title }" placeholder="请输入商品标题" /><br/>
		</label> 
		<label> 
			<span>商品原价格 ：</span>
			<input id="oldMoney" type="text" name="oldMoney" placeholder="请输入商品原价格 " value="${projectInfo.oldMoney }"/><br/>
		</label> 
		<label> 
			<span>商品现价格 ：</span>
			<input id="money" type="text" name="money" placeholder="商品现价格" value="${projectInfo.money }" /><br/>
		</label> 
		<label> 
			<span>商品编号 ：</span>
			<input id="goodNumber" type="text" name="goodNumber" placeholder="请输入商品编号" value="${projectInfo.goodNumber }"/><br/>
		</label> 
		<label> 
			<span>商品信息 ：</span>
			<input id="goodIntroduction" type="text" name="goodIntroduction" placeholder="请输入商品信息" value="${projectInfo.goodIntroduction }"/><br/>
		</label> 

		
		<label> 
			<span>售出数量</span>
			<input id="sellNumber" type="text" name="sellNumber" placeholder="请输入商品售出数量" value="${projectInfo.sellNumber }"/><br/>
		</label> 
		<label> 
			<span>商品图片</span> 
			<sapn><img src="${projectInfo.images}" width="100px"></sapn>
			<input id="images" name="images" type="file" /><br>
		</label> 
	
		<label> 
			<span>&nbsp;</span> 
			<input type="submit" class="button" id="save" value="保存" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="button"  id="back_list" value="返回列表" />
		</label>
	</form>
</body>
</html>
