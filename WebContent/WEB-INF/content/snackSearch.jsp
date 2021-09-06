<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索零食</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
<style>
	.list-group-horizontal .list-group-item {
		display: inline-block;
	}
	.list-group-horizontal .list-group-item {
		margin-bottom: 0;
		margin-left:-4px;
		margin-right: 0;
		width:130px;	
		
	}	
	.list-group-horizontal .list-group-item:first-child {
		border-top-right-radius:0;
		border-bottom-left-radius:4px;
	}
	.list-group-horizontal .list-group-item:last-child {
		border-top-right-radius:4px;
		border-bottom-left-radius:0;
	}
	
	</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="margin-left:10%;margin-bottom:40px; width:60%;">
	<form class="bs-example bs-example-form" role="form">		
		<div class="input-group">
			<input type="text" class="form-control" name="wd"  placeholder="零食名/产家">
			<span class="input-group-btn">
				<button class="btn btn-default" type="submit">
					搜索
				</button>
			</span>
		</div>			
	</form>
</div>
	<c:if test="${snacks!=null }">
		<div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:5%;">       
			<p class="list-group-item active" style="width:90px;">零食号</p>
			<p class="list-group-item active" style="width:150px;">零食名</p>         
	        <p class="list-group-item active" style="width:100px;">产家</p>
	         
	        <p class="list-group-item active">生产日期</p>
	        <p class="list-group-item active">保质期</p>
	        <p class="list-group-item active" style="width:100px;">零食分类</p> 
	        <p class="list-group-item active" style="width:230px;">简介</p>
	        <p class="list-group-item active" style="width:70px;">购买</p>
	        <c:if test="${customer!=null&&customer.isAdmin()}">
	        <p class="list-group-item active">推荐 &nbsp;&nbsp; 数量</p>        
	        <p class="list-group-item active">修改 &nbsp;&nbsp; 删除</p>        
        </c:if>         
    </div>
    </c:if>
    <c:set var="Yes"  value="是"/>
	<c:set var="No"  value="否"/>
    <c:forEach items="${snacks }" var="snack">
	    <div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:5%;margin-bottom:0px;">       
			<p class="list-group-item " style="width:90px;">${snack.getSid() }</p>
			<p class="list-group-item " style="width:150px;"><a href="snackDetail?sid=${snack.sid }">${snack.getSname() }</a></p>         
	        <p class="list-group-item " style="width:100px;">${snack.getProducers() }</p>
	         
	        <p class="list-group-item ">${snack.getDateinproduced() }</p>
	        <p class="list-group-item ">${snack.getExpirationdate() }个月</p>	        
	        <p class="list-group-item " style="width:100px;">${snack.getCategory() }</p> 
	        <p class="list-group-item " style="width:230px;">${snack.getIntro() }</p>
	        <p class="list-group-item " style="width:70px;"><a href="snackDetail?sid=${snack.sid }">购买</a></p>
	        <c:if test="${customer!=null&&customer.isAdmin()}">
	        <p class="list-group-item "> ${snack.getRecommed()==1?Yes:No}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${snack.getNum() }  </p> 
	        <p class="list-group-item "><a href="modifiySnack?sid=${snack.sid }">修改</a> &nbsp;&nbsp; <a href="snackList?sid=${snack.sid }">删除</a></p>    
	        </c:if>   
	    </div>
    
    </c:forEach>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>