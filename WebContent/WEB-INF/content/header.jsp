<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7/dist/css/bootstrap.css"/><link />

<script src="../../bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
<script src="../../js/jquery-1.11.1.js"></script>

</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">网上书店</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					
					<c:set var="index"  value="index"/>
					<c:set var="login"  value="login"/>
					<c:set var="register"  value="register"/>
					<c:set var="snackList"  value="snackList"/>
					<c:set var="snackSearch"  value="snackSearch"/>
					<c:set var="addSnack"  value="addSnack"/>
					<c:set var="customerList"  value="customerList"/>
					<c:set var="addCustomer"  value="addCustomer"/>
					<c:set var="orderManage"  value="orderManage"/>
					<c:set var="personalCenter"  value="personalCenter"/>					
					
					<c:if test="${url==index }" var="an">
					<li class="active"><a href="index">首页</a></li>					
					</c:if>
					<c:if test="${url!=index }" var="an">
					<li><a href="index">首页</a></li>					
					</c:if>
					
											
					<c:if test="${customer!=null&&customer.isAdmin()}">				
						<li class="dropdown <c:if test="${url==snackList||url==snackSearch||url==addSnack }" var="an">active</c:if>">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								图书管理
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								
								<li <c:if test="${url==snackList }" var="an">class="active"</c:if>><a href="snackList">零食清单</a></li>		
								<li class="divider"></li>
								<li <c:if test="${url==snackSearch }" var="an">class="active"</c:if>><a href="snackSearch">零食查询</a></li>				
								<li class="divider"></li>
								<li <c:if test="${url==addSnack }" var="an">class="active"</c:if>><a href="addSnack">添加零食</a></li>				
								
							</ul>
						</li>
						<li class="dropdown <c:if test="${url==customerList||url==addCustomer }" var="an">active</c:if>" >
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								顾客管理
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								
								
								<li <c:if test="${url==customerList }" var="an">class="active"</c:if>><a href="customerList">顾客列表</a></li>				
								
													
															
								<li class="divider"></li>
								
								
								<li <c:if test="${url==addCustomer }" var="an">class="active"</c:if>><a href="addCustomer">添加顾客</a></li>				
								
								
								
							</ul>
						</li>
						
						<li <c:if test="${url==orderManage }" var="an">class="active"</c:if>><a href="orderManage">订单管理</a></li>				
						
						
						
					</c:if>
					<c:if test="${customer!=null&&!customer.isAdmin()}">						
						
						<li <c:if test="${url==orderManage }" var="an">class="active"</c:if>><a href="orderManage">订单信息</a></li>				
						
						
						<li class="dropdown <c:if test="${url==snackList||url==snackSearch||url==addSnack }" var="an">active</c:if>">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								图书管理
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">							
								<li <c:if test="${url==snackList }" var="an">class="active"</c:if>><a href="snackList">零食清单</a></li>		
								<li class="divider"></li>
								<li <c:if test="${url==snackSearch }" var="an">class="active"</c:if>><a href="snackSearch">零食查询</a></li>							
							</ul>
						</li>
					</c:if>
				</ul>
			</div>
			<ul class="nav navbar-nav navbar-right">
			<c:if test="${customer==null}">
				
				<li <c:if test="${url==register }" var="an">class="active"</c:if>><a href="register"><span class="glyphicon glyphicon-user"></span> 注册</a></li>				
				
				
				
				<li <c:if test="${url==login }" var="an">class="active"</c:if>><a href="login"><span class="glyphicon glyphicon-user"></span> 登录</a></li>				
				
				
						 
				
			</c:if>
			<c:if test="${customer!=null}">
				<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
				
				
				<li <c:if test="${url==personalCenter }" var="an">class="active"</c:if>><a href="personalCenter"><span class="glyphicon glyphicon-user"></span>&nbsp;<c:out value="${customer.getAccount()}"></c:out> </a></li>				
				
								
			</c:if>			
			</ul>
			</div>
		</nav>

</body>
</html>