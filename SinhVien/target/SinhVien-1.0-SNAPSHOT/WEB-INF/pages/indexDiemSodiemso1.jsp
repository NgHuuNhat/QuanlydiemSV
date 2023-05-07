<%-- 
    Document   : diemso1
    Created on : May 7, 2023, 11:45:12 AM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h3 style="text-align: center">Điểm số chi tiết</h3>

<form:form method="POST" action="${action}" modelAttribute="diemsochitiet">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="diemgiuaky" placeholder="diemgiuaky..." path="diemgiuaky" name="diemgiuaky"/>
        <label for="diemgiuaky">diemgiuaky</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="diemcuoiky" placeholder="diemcuoiky..." path="diemcuoiky" name="diemcuoiky"/>
        <label for="diemcuoiky">diemcuoiky</label>
    </div>
    
    

    <div class="form-floating" style="margin-top: 20px">

        <c:choose>
            <c:when test="${diemsochitiet.id > 0}" >
                <input type="submit" value="Cập nhật điểm" class="btn btn-success" />
            </c:when>
            <c:otherwise>
                <input type="submit" value="Thêm điểm" class="btn btn-success" />
            </c:otherwise>
        </c:choose>
    </div>
</form:form>

