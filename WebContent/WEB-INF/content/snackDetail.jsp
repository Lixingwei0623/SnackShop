<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>零食详情</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="width: 60%;margin-left: 20%;margin-right: 20%;" >			
		
	        <div class="thumbnail" style="height:730px;" align="center">	            
            	<img style="height:50%;margin-left:1%;margin-top:3%;" height="25%" src="${snack.picture }" alt="${snack.sname }">
            	            	
	            <div class="caption" align="left" style="margin-left:45%;margin-top:-38%;">
		            <div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">零食名</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${snack.sname}" readonly>							
					</div>
					<div class="input-group" style="width:35%;margin-left:55%;margin-top:-44px;margin-bottom:10px;">
						<span class="input-group-addon">价格</span>									
						<input type="number" class="form-control" id="price" name="price" 
					   		value="${snack.price}" readonly>							
					</div>
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">产家</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${snack.producers}" readonly>							
					</div>
					
					<div class="input-group" style="width:35%;margin-left:55%;margin-top:-44px;margin-bottom:10px;">
						<span class="input-group-addon">类别</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${snack.category}" readonly>							
					</div>
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">库存</span>									
						<input type="text" class="form-control" id="num" name="num" 
					   		value="${snack.num}" readonly>							
					</div>
					
					<div class="input-group" style="width:50%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">生产日期</span>									
						<input type="text" class="form-control" id="bname" name="bname" 
					   		value="${snack.dateinproduced}" readonly>							
					</div>
					
					<div class="input-group" style="width:90%;margin-top:10px;margin-bottom:10px;">
						<span class="input-group-addon">简介</span>									
						<textarea class="form-control" id="intro" name="intro" 
			   				 readonly>${snack.intro}</textarea>							
					</div>
					
					
		            	
		                
	            </div>
	            <form action="order">
	            
	            <input name="sid" value="${snack.sid }" type="hidden">
	            <div  style="padding:3px;width:48%;height:120px;margin-left:40%;margin-top:0px;margin-bottom:10px;border:2px solid #F00;">
		            <div class="input-group">
						<span class="input-group-addon">购买数量</span>									
						<input type="number" class="form-control" id="num1" name="num1" oninput="if(value>${snack.num })value=${snack.num};if(value<0)value=1;"
					   		onkeyup="priceSum(this)"
					   		value="1" style="width:80%;height:100%;">
					   	<span class="input-group-addon">金额￥</span>									
						<input type="number" class="form-control" id="priceSum" name="priceSum"
					   		value="${snack.price}" style="width:80%;height:100%;" readonly>	
					   					
					</div>
					<div class="button_div" style="margin-right:0%;width:100%;height:50%;margin-top:10px;">
							<button type="submit" class="btn btn-success" style="algin:left;text-algin:left;width:100%;height:100%;">
								<h4>立即购买&nbsp;&nbsp;&nbsp;&nbsp;￥&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4>
						   	</button>
					</div>		
				</div>
				</form>
	            <div class="button_div" style="margin-bottom:10px;margin-right:-90%;margin-top:-420px;">
					<a href="index"><button type="button" class="btn btn-warning" style="width: 80px;algin:center;">返回</button></a>
				</div>
				<script type="text/javascript">
	            	$('input[name="num1"]').change(
	            			function(){
	            				var price=document.getElementById("price").value;
	    	            		var num=document.getElementById("num1").value;
	    	            		document.getElementById("priceSum").value = num*price;
	            			})
	            		
	            	
	            </script>
	        </div>
	   		
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>