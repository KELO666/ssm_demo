<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<% pageContext.setAttribute("path", request.getContextPath()); %>
<html>
<head>
    <title>Paper列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="${path}/static/js/jquery-1.12.4.min.js"></script>
    <!-- 引入 Bootstrap -->
    <script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
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

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/add.jsp">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>库存数量</th>
                    <th>书籍描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="paper" items="${pageInfo.list}" varStatus="status">
                    <tr>
                        <th>${paper.paperId}</th>
                        <th>${paper.name}</th>
                        <th>${paper.number}</th>
                        <th>${paper.detail}</th>
                        <th>
                            <a id="update_a" class="btn btn-primary" href="${path}/paper/toUpdate/${paper.paperId}">修改</a> |
                            <a id="delete_a" class="btn btn-danger" href="${path}/paper/delete/${paper.paperId}">删除</a>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <%--分页条--%>
    <div class="row">
        <%--分页文字信息--%>
        <div class="col-md-6">
            当前第${pageInfo.pageNum}页, 总共${pageInfo.pages}页, 总${pageInfo.total}本书籍
        </div>
        <%--分页条信息--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${path}/paper/findAll?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${path}/paper/findAll?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                        <c:if test="${page_Num == pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum}">
                            <li><a href="${path}/paper/findAll?pn=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${path}/paper/findAll?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${path}/paper/findAll?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>