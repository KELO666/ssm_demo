<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<script type="text/javascript" src="${path}/static/js/jquery-1.12.4.min.js"></script>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h3>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h3>
            </div>
        </div>
    </div>
</div>
<br><br>
<h3>
    <a id="test" href="${path}/paper/findAll?pn=1">点击进入管理页面</a>
</h3>
<script type="text/javascript">
    <%--$("#test").click(function () {--%>
    <%--    $.ajax({--%>
    <%--        url:"${path}/paper/findAll?pn=1",--%>
    <%--        method:"GET",--%>
    <%--        success:function () {--%>
    <%--            window.location.href=""--%>
    <%--        }--%>
    <%--    });--%>
    <%--    //alert("test");--%>
    <%--});--%>
</script>
</body>
</html>
