<%-- 
    Document   : indexMonHoc
    Created on : May 7, 2023, 5:29:23 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 style="text-align: center">Danh Sách Môn Học</h3>

<section class="container" style="">
    <div class="row">
        <c:forEach items="${monhoc}" var="mon">
        <div class="col-md-3 col-xs-12" style="padding: 1rem;">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">${mon.name}</h4>
                    
                    <c:url value="/monhoc/users" var="detail" />
                    <a href="${detail}" class="btn btn-primary">Xem chi tiet</a>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</section>
