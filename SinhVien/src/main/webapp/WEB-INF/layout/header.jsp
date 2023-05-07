<%-- 
    Document   : header
    Created on : Apr 7, 2023, 7:57:39 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="javascript:void(0)"><img src="https://s.memehay.com/files/posts/20200814/2bd533e3987f4555c09434b30da0cdf8chuot-jerry-cam-dong-rot-nuoc-mat.jpg" alt="logo" style="border-radius: 20px; width: 30px; height: 30px"/></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <c:url value="/" var="home"/>
                        <a class="nav-link" href="${home}" style="color: #f8f9fa">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <c:url value="/admin/users" var="admin"/>
                        <a class="nav-link" href="${admin}" style="color: #f8f9fa">Giáo Vụ</a>
                    </li>
                    <%--<c:forEach items="${role}" var="r">--%>
                        <%--<c:url value="/" var="url">--%>
                            <%--<c:param name="roleId" value="${r.id}"/>--%>
                        <%--</c:url>--%>
                        <!--<li class="nav-item">-->
                            <!--<a class="nav-link" href="${url}" style="color: #f8f9fa">${r.name}</a>-->
                        <!--</li>-->
                    <%--</c:forEach>--%>

                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name == null}">
                            <li class="nav-item">
                                <a class="nav-link text-danger" href="<c:url value="/login"/>">Đăng nhập</a>
                            </li>
                        </c:when>
                        <c:when test="${pageContext.request.userPrincipal.name != null}">
                            <li class="nav-item">
                                <a class="nav-link text-danger" href="<c:url value="/"/>">Chào ${pageContext.request.userPrincipal.name}</a>
                            </li>
                            <c:if test="${pageContext.request.userPrincipal != null}">
                                <li class="nav-item">
                                    <a class="nav-link text-danger" href="<c:url value="/logout"/>">Đăng xuất</a>
                                </li>
                            </c:if>
                        </c:when> 
                    </c:choose>
                </ul>

                <c:url value="/" var="action" />
                <form class="d-flex" action="${action}">
                    <input class="form-control me-2" type="text" name="kw" placeholder="Search">
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
