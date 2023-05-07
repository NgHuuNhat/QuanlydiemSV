<%-- 
    Document   : indexDiem
    Created on : May 7, 2023, 6:09:14 AM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h3 style="text-align: center">Điểm số</h3>

<section class="container" style="">
    <div class="row">
        <c:forEach items="${diemso}" var="d">
        <div class="col-md-3 col-xs-12" style="padding: 1rem;">
            <div class="card">
                <div class="card-body">
                    <h6 class="card-title">Điểm giữa kỳ: ${d.diemgiuaky}</h6>
                    <h6 class="card-title">Điểm giữa kỳ: ${d.diemgiuaky}</h6>
                    
                    <c:url value="/diemso/${d.id}" var="detail" />
                    <a href="${detail}" class="btn btn-primary">Xem chi tiet</a>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</section>



