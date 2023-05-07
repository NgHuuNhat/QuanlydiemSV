<%-- 
    Document   : product-detail
    Created on : Apr 9, 2023, 8:09:24 AM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row" style="margin-top: 10px;">
    <div class="col-md-5 col-xs-12">
        <img src="${u.avatar}" class="img-fluid" style="border-radius: 5px;"/>
    </div>
    <div class="col-md-7 col-xs-12">

        <h3 style="text-align: center">THÔNG TIN CHI TIẾT</h3>

        <h6>Full Name: ${u.fullname}</h6>
        <h6>Role: ${u.roleId.description}</h6>
        <h6>Username: ${u.username}</h6>  
        <h6>MSSV: ${u.mssv}</h6>
        <h6>Email: ${u.email}</h6>
        <br>
        <h6>Lớp: ${u.lophocId.name}</h6>
        <h6>Môn: ${u.lophocId.monhocId.name}</h6>

        <c:url value="/userdiemso/diem" var="detail" />
        <a href="${detail}" class="btn btn-primary">Xem chi tiet</a>
    </div>


</div>
