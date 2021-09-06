<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
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

	<div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:10%;">       
		<p class="list-group-item active" style="width:160px;">书籍名</p>
		<p class="list-group-item active">顾客</p>         
        <p class="list-group-item active">书籍分类</p>
        <p class="list-group-item active">下单时间</p> 
        <p class="list-group-item active" style="width:70px;">数量</p>
        <p class="list-group-item active" style="width:70px;">单价</p>
        <p class="list-group-item active" style="width:70px;">金额</p>
        <p class="list-group-item active" style="width:100px;">状态</p> 
        <p class="list-group-item active" style="width:100px;">操作</p>
        <p class="list-group-item active">再来一单</p>         
    </div>
    <c:set var="Yes"  value="是"/>
	<c:set var="No"  value="否"/>
	<c:set var="fkwc"  value="付款完成"/>
	<c:set var="wfk"  value="未付款"/>
	<c:set var="sqtk"  value="申请退款"/>
	<c:set var="tkcg"  value="退款成功"/>
    <c:forEach items="${orderForms }" var="orderForm">
	    <div class="list-group list-group-horizontal" style="margin-left:10%;margin-right:20%; margin-bottom:0px;">       
			<p class="list-group-item " style="width:160px;">${orderForm.getSname() }</p>
			<p class="list-group-item ">${orderForm.getCname() }</p>         
	        <p class="list-group-item ">${orderForm.getCategory() }</p>
	        <p class="list-group-item ">${orderForm.getOrdertime() }</p> 
	        <p class="list-group-item " style="width:70px;">${orderForm.getNum() }</p>
	        <p class="list-group-item " style="width:70px;">${orderForm.getPrice() }</p>
	        <p class="list-group-item " style="width:70px;">${orderForm.getNum()*orderForm.getPrice() }</p>
	        <p class="list-group-item " style="width:100px;">${orderForm.getFlag()==1?wfk:(orderForm.getFlag()==0?fkwc:(oederForm.getFlag()==2?sqtk:tkcg)) }</p> 
	        <p class="list-group-item " style="width:100px;">
	        	<c:if test="${orderForm.getFlag()==0&&!customer.isAdmin()}"><a href="orderManage?oid=${orderForm.getOid() }&info=1">申请退款</a></c:if>
	        	<c:if test="${orderForm.getFlag()==1&&!customer.isAdmin()}"><a href="orderManage?oid=${orderForm.getOid() }&info=2">付款</a></c:if>
	        	<c:if test="${orderForm.getFlag()==0&&customer.isAdmin()}"><a href="orderManage?oid=${orderForm.getOid() }&info=3">退款</a></c:if>
	        </p>
	        <p class="list-group-item "><a href="snackDetail?sid=${orderForm.getSid() }">再来一单</a></p>         
	    </div>
    
    </c:forEach>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>