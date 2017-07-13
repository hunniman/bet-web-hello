<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<h3 class="page-header">所有用户列表44433334</h3>

<input type="hidden" id="txtProPath" value="<%=request.getContextPath()%>">
<table class="table table-bordered">
    <thead>
    <tr>
        <th>#</th>
        <th>用户名</th>
        <th>真名</th>
        <th>电话</th>
        <th>角色</th>
        <th>创建时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${user_info}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.realName}</td>
            <td>${user.mobile}</td>
            <td>${user.role}</td>
            <td>${user.createAt}</td>
        </tr>

    </c:forEach>
    </tbody>
</table>


