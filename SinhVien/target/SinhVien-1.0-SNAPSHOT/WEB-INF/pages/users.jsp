<%-- 
    Document   : users
    Created on : Apr 13, 2023, 6:33:55 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-info text-center">GIÁO VỤ</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<c:url value="/admin/users" var="action" />

<h4>Tạo tài khoản</h4>

<form:form method="POST" action="${action}" modelAttribute="u" enctype="mutipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="fullname" placeholder="fullname..." path="fullname" name="fullname"/>
        <label for="fullname">Fullname</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="email" placeholder="email..." path="email" name="email"/>
        <label for="email">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="username" placeholder="username..." path="username" name="username"/>
        <label for="username">Username</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="password" placeholder="password..." path="password" name="password"/>
        <label for="password">Password</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="active" placeholder="TRUE..." path="active" name="active"/>
        <label for="active">Active_TRUE</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="mssv" placeholder="mssv..." path="mssv" name="mssv"/>
        <label for="mssv">Mssv</label>
    </div>
        
    <div class="form-floating">
        <form:select class="form-select" id="roleId" name="roleId" path="roleId">
            <c:forEach items="${role}" var="r">
                <c:choose>
                    <c:when test="${u.roleId.id == r.id}" >
                        <option value="${r.id}" selected>${r.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${r.id}">${r.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="roleId" class="form-label">Danh mục Role</label>
    </div>
   
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="avatar" path="avatar" name="avatar"/>
        <label for="avatar">Avatar</label>
        <c:if test="${u.avatar != null && u.avatar != ''}" >
            <img src="${u.avatar}" width="120"/>
        </c:if>
    </div>
        
    <div class="form-floating" style="margin-top: 20px">

        <c:choose>
            <c:when test="${u.id > 0}" >
                <form:hidden path="id" />
                <form:hidden path="avatar" />
                <input type="submit" value="Cập nhật tài khoản" class="btn btn-success" />
            </c:when>
            <c:otherwise>
                <input type="submit" value="Tạo tài khoản" class="btn btn-success" />
            </c:otherwise>
        </c:choose>
    </div>
</form:form>

<table class="table">
    <tr>
        <th></th>
        <th>Id</th>
        <th>FullName</th>
        <th>Username</th>
        <th>MSSV</th>
        <th>Lớp</th>
        <th>Role</th>
        <th></th>
    </tr>
    <c:forEach items="${users}" var="u" >
        <tr id="user${u.id}">
            <td>
                <img src="${u.avatar}" width="120"/>
            </td>
            <td>${u.id}</td>
            <td>${u.fullname}</td>
            <td>${u.username}</td>
            <td>${u.mssv}</td>
            <td>${u.lophocId.name}</td>
            <td>${u.roleId.description}</td>
            <td>
                <a href="<c:url value="/admin/users/${u.id}" />" class="btn btn-info" >Cập nhật</a>
                <div id="spinner${u.id}" style="display: none" class="spinner-border text-primary"></div>
                <c:url value="/api/users/${u.id}" var="endpoint" />
                <input type="button" onclick="deleteUser('${endpoint}', ${u.id})" value="Xóa" class="btn btn-danger"/>
            </td>
        </tr>
    </c:forEach>
</table>

<script src=" <c:url value="/js/user.js" /> " ></script>
