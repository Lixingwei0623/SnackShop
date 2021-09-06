<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />
<script src="./js/jquery-1.11.1.js"></script>
<script src="./bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid" style="height: 600px;">
			<div style="width: 20%;" align="left">
			<c:set var="recom"  value="recom"/>
			<c:set var="baokan"  value="果干"/>
			<c:set var="xiaoshuo"  value="熟食"/>
			<c:set var="jiaocai"  value="膨化食品"/>
			<c:set var="keji"  value="饮料"/>			
				<ul class="list-group">
					<a href="index?cate=recom"><li class="list-group-item  <c:if test="${cate.equals(recom) }" var="an"> active</c:if>" style="height:80px;"><h4>猜你想吃</h4></li></a>
					<li class="list-group-item" style="height:400px;"><h4>分类</h4>					
						<ul class="list-group"  style="margin-top:30px;">
							<a href="index?cate=果干"><li class="list-group-item <c:if test="${cate==baokan }" var="an"> active</c:if>" style="height:60px;"><h5>果干</h5></li></a>
							<a href="index?cate=熟食"><li class="list-group-item <c:if test="${cate.equals(xiaoshuo) }" var="an"> active</c:if>" style="height:60px;"><h5>熟食</h5></li></a>
							<a href="index?cate=膨化食品"><li class="list-group-item <c:if test="${cate==jiaocai }" var="an"> active</c:if>" style="height:60px;"><h5>膨化食品</h5></li></a>
							<a href="index?cate=饮料"><li class="list-group-item <c:if test="${cate==keji }" var="an"> active</c:if>" style="height:60px;"><h5>饮料</h5></li></a>
						</ul>
					</li>					
				</ul>
			</div>
			<div style="width: 70%;margin-left: 25%;margin-top: -500px;" >
				<div class="row">
					<c:forEach items="${snacks }" var="snack">
					
						<div class="col-sm-6 col-md-3 abc">
					        <div class="thumbnail" style="height:460px;">
					            <a href="snackDetail?sid=${snack.sid }">
					            	<img style="height:220px;" height="350px"  src="${snack.picture }" alt="${snack.sname }">
					            	
				            	</a>
					            <div class="caption">
					                <h3>${snack.sname}</h3>
					                <h4>${snack.price}&nbsp;元</h4>
					                <p>产家：${snack.producers}</p>
					                <p>生产日期：${snack.dateinproduced}</p>
					                <p>保质期：${snack.expirationdate}个月&nbsp;&nbsp;&nbsp;</p>
					                <p>${snack.intro==''?"精选零食":snack.intro}</p>
					            </div>
					        </div>
					    </div>
					</c:forEach>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		

</body>

</html>