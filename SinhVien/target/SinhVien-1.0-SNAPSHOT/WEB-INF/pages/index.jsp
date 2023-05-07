<%-- 
    Document   : index
    Created on : Mar 23, 2023, 9:37:33 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 style="text-align: center">Danh Sách Sinh Viên</h3>

<section class="container" style="">
    <div class="row">
        <c:forEach items="${users}" var="u">
        <div class="col-md-3 col-xs-12" style="padding: 1rem;">
            <div class="card">
                <img class="card-img-top" src="${u.avatar}" alt="Card image" style="width: 245px; height: 167.33px; object-fit: contain;">
                <div class="card-body">
                    <h4 class="card-title">${u.fullname}</h4>
                    <h6 class="card-title">Role: ${u.roleId.description}</h6>
                    <h6 class="card-title">Lớp học: ${u.lophocId.name}</h6>
                    <h6 class="card-title">MSSV: ${u.mssv}</h6>
                    
                    <c:url value="/users/${u.id}" var="detail" />
                    <a href="${detail}" class="btn btn-primary">Xem chi tiet</a>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</section>

