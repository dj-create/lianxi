<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>项目登记</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/form.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	
  </head>
	<body>
	<form action="/tiangou_dj/addproduct" method="post" class="basic-grey" enctype="multipart/form-data">
		<label> 
			<span>商品标题：</span><input id="title" type="text" name="title" placeholder="请输入商品标题" /><br/>
		</label> 
	    <label> 
			<span>商品原价格 ：</span>
			<input id="oldMoney" type="text" name="oldMoney" placeholder="请输入商品原价格 " /><br/>
		</label> 
		<label> 
			<span>商品现价格 ：</span>
			<input id="money" type="text" name="money" placeholder="商品现价格" /><br/>
		</label> 
		<label> 
			<span>商品编号 ：</span>
			<input id="goodNumber" type="text" name="goodNumber" placeholder="请输入商品编号" /><br/>
		</label> 
		<label> 
			<span>商品信息 ：</span>
			<input id="goodIntroduction" type="text" name="goodIntroduction" placeholder="请输入商品信息" /><br/>
		</label> 
		<label> 
			<span>售出数量：</span>
			<input id="sellNumber" type="text" name="sellNumber" placeholder="请输入商品售出数量" /><br/>
		</label> 
		<label> 
			<span>商品图片</span> 
			<input id="images" name="images" type="file" />
		</label>
		<label> 
			<span>&nbsp;</span> 
			<input type="submit"  value="保存" />
			
		</label>
	</form>
	<!-- <script type="text/javascript">
	$(function() {
		// 弹出项目信息表单
		$(".writerInfo").on("click", function() {
			popWin.showWin("500", "400", "项目信息录入", "project.jsp");
		});
		// 绑定保存按钮的点击事件
		$(".save").on("click",function(){
			// 校验数据 id选择器
			var title = $("#title").val(); //商品标题
			var oldMoney = $("#oldMoney").val(); // 商品原价
			var money = $("#money").val(); // 商品现价
			var goodNumber = $("#goodNumber").val(); // 商品编号
			var goodIntroduction = $("#goodIntroduction").val(); // 商品信息
			var sellNumber = $("#sellNumber").val(); // 售出数量
			var images = $("#images").val(); // 商品图片
			if(title.length<=0) {
				alert("商品名称不能为空");
				$("#title").focus();
				return false;
			}
			if(money.length<=0) {
				alert("商品价格不能为空");
				$("#money").focus();
				return false;
			}
			if(goodNumber.length<=0) {
				alert("商品编号不能为空");
				$("#goodNumber").focus();
				return false;
			}
			if(goodIntroduction.length<=0) {
				alert("商品信息不能为空");
				$("#goodIntroduction").focus();
				return false;
			}
			
			// 数据提交后台
			$.ajax({
				url:"/tiangou_dj/addproduct",  // 请求后台的地址
				type:"get",
				data:{
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
					if(data.status=='1') {
						window.location.href = "product";
						window.close();
					} else {
						alert("项目信息录入失败!");
					}
				},
				error:function(){
					alert("ajax参数校验异常!");
				}
			})
		});

		
	});
	</script> -->
</body>
</html>
