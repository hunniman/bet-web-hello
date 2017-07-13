<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<ul class="nav nav-sidebar">
    <%--
        <c:if test="${ sessionScope.user.role==1}">
            <li url="<%=request.getContextPath()%>/equipment/ae"><a href="#">农眼</a></li>
            <li url="<%=request.getContextPath()%>/equipment/show_rain_add"><a href="#">新增雨量筒</a></li>
            <li url="<%=request.getContextPath()%>/equipment/show_air_add"><a href="#">新增百叶箱</a></li>
            <li url="<%=request.getContextPath()%>/equipment/show_wind_add"><a href="#">新增风速仪</a></li>
            <li url="<%=request.getContextPath()%>/equipment/show_camera_add"><a href="#">新增摄像头</a></li>
            <li url="<%=request.getContextPath()%>/equipment/show_bind_ae"><a href="#">绑定</a></li>
            <li url="<%=request.getContextPath()%>/equipment/show_replace_gps"><a href="#">更改农眼GPS后处理数据</a></li>

            <li url="<%=request.getContextPath()%>/user/show_register"><a href="#">增加用户</a></li>
            <li url="<%=request.getContextPath()%>/user/all_user"><a href="#">用户列表</a></li>

        </c:if>--%>

    <li url="<%=request.getContextPath()%>/user/show_register"><a href="#">增加用户</a></li>
    <li url="<%=request.getContextPath()%>/user/all_user"><a href="#">用户列表</a></li>

</ul>
