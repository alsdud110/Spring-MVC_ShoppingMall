<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import = "member.Member" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	 <!-- Preloader Start -->
    <header>
        <!-- Header Start -->
        <div class="header-area">
            <div class="main-header header-sticky">
                <div class="container-fluid">
                    <div class="menu-wrapper">
                        <!-- Logo -->
                        <div class="logo">
                            <a href="index.html"><img src="/img/logo/logo.png" alt=""></a>
                        </div>
                        <!-- Main-menu -->
                        <div class="main-menu d-none d-lg-block">
                            <nav>                                                
                                <ul id="navigation">
									<li><a href="<c:url value = '/main'/>">Main</a></li>
                                    <li><a href="index.html">Best50</a></li>
									<li><a href="<c:url value='/product/viewCategory/TOP'/>">TOP</a></li>
                                    <li><a href="<c:url value='/product/viewCategory/BOTTOM'/>">BOTTOM</a></li>
                                    <li><a href="<c:url value='/product/viewCategory/ETC'/>">ETC</a></li>
                                    <li><a href="#">MY PAGE</a>
                                        <ul class="submenu">
                                            <li><a href="shop.html"> 구매내역</a></li>
                                            <li><a href="<c:url value = '/edit'/>"> 회원정보 수정</a></li>
                                        </ul>
                                    </li>
                                  </ul>
                            </nav>
                        </div>
                        <!-- Header Right -->
                        <div class="header-right">
                            <%
                            Member authInfo = (Member)session.getAttribute("authInfo");
                        	if(authInfo == null){%>
                            <ul>
                                <li> <a href="<c:url value = '/login'/>"><span class="flaticon-user"> login</span></a></li>
                                <!--   <li><a href="<c:url value = '/login'/>"><span class="flaticon-shopping-cart"> cart</span></a> </li>	 -->
                               <li><a href="<c:url value = '/cart'/>"><span class="flaticon-shopping-cart"> cart</span></a> </li>	<!-- 카트 테스트용 추가/ 테스트후 교체 -->
                                <li><a href="<c:url value = '/join'/>"><span class="flaticon-user"> join</span></a> </li>
                            </ul>
                            	<%}else{
                            		String name = authInfo.getM_name() + "님";
                            	
                            	%>
                            <ul>
                            	<li><span class = "flaticon-user"> <%= name %></span></li>
                                <li> <a href="<c:url value = '/logout'/>"><span class="flaticon-user"> logout</span></a></li>
                                <li><a href="<c:url value = '/cart'/>"><span class="flaticon-shopping-cart"> cart</span></a> </li>
                             
                            </ul>
                           <%} %>
                        </div>
                    </div>
                    </div>
                    </div>
             </div>
	</header>
	<hr>

</body>
</html>