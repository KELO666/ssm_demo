<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<% pageContext.setAttribute("path", request.getContextPath()); %>
<html>
<head>
    <title>修改</title>
    <script type="text/javascript" src="${path}/static/js/jquery-1.12.4.min.js"></script>
    <!-- 引入 Bootstrap -->
    <script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        p {
            color: red;
        }
    </style>
</head>
<body>
<form action="${path}/paper/update" method="post">
    <input type="hidden" name="paperId" value="${paper.paperId}">
        <div class="form-group">
            <label for="bookName">书籍名称</label>
            <input type="text" class="form-control" id="bookName" name="name" value="${paper.name}" placeholder="请输入书籍名称" onblur="validateName(this)">
            <p class="help-block1" id="Msg1"></p>
        </div>
        <div class="form-group">
            <label for="bookNumber">书籍库存</label>
            <input type="text" class="form-control" id="bookNumber" name="number" value="${paper.number}" placeholder="请输入纯数字" onblur="validateNum(this)">
            <p class="help-block2" id="Msg2"></p>
        </div>
        <div class="form-group">
            <label for="bookDetail">书籍描述</label>
            <input type="text" id="bookDetail" class="form-control" name="detail" value="${paper.detail}" placeholder="简单描述一下书籍内容" onblur="validateDeatil(this)">
            <p class="help-block3" id="Msg3"></p>
        </div>
        <input type="button" class="btn btn-info" value="校验信息" id="check" onclick="cl()"/>
        <button type="submit" class="btn btn-primary" disabled="disabled" id="sub_btn">提交</button>

</form>
<script type="text/javascript">
    var name = null;
    var number = null;
    var detail = null;
    /*校验书籍名称长度*/
    function checkBookNameLength(strVal) {
        var reg = /[\u4e00-\u9fa5a-zA-Z0-9]{4,12}/;
        return reg.test(strVal);
    }
    /*校验库存数量格式*/
    function checkNumLength(intVal) {
        var reg = /^\d{1,4}$/;/*1-4位数字*/
        return reg.test(intVal);
    }
    /*校验描述长度*/
    function checkDetailLength(strVal) {
        var reg = /[\u4e00-\u9fa5a-zA-Z0-9]{10,50}/;
        return reg.test(strVal);
    }

    function validateName(e) {
        $("#Msg1").empty();
        name = e.value;
        //alert(name);
        if(name == ""||name == null){
            $("#Msg1").html("书名不能为空！");
            if($("#sub_btn").attr("disabled")==null){
                $("#sub_btn").attr("disabled","disabled");
            }
            return false;
        }
        if(checkBookNameLength(name)==false){
            $("#Msg1").html("书籍名称长度为4-12位中英文数字组合！");
            if($("#sub_btn").attr("disabled")==null){
                $("#sub_btn").attr("disabled","disabled");
            }
            return false;
        }
        return true;
    }

    function validateNum(e) {
        $("#Msg2").empty();
        number = e.value;
        if(number == ""||number == null||number == 0){
            $("#Msg2").html("库存不能为空或0！");
            if($("#sub_btn").attr("disabled")==null){
                $("#sub_btn").attr("disabled","disabled");
            }
            return false;
        }
        if(checkNumLength(number)==false){
            $("#Msg2").html("库存范围为1~9999！");
            if($("#sub_btn").attr("disabled")==null){
                $("#sub_btn").attr("disabled","disabled");
            }
            return false;
        }
        return true;
    }
    function validateDeatil(e) {
        $("#Msg3").empty();
        detail = e.value;
        if(detail == ""||detail == null){
            $("#Msg3").html("描述不能为空！");
            if($("#sub_btn").attr("disabled")==null){
                $("#sub_btn").attr("disabled","disabled");
            }
            return false;
        }
        if(checkDetailLength(detail)==false){
            $("#Msg3").html("描述内容至少10字，不得超过50字!");
            if($("#sub_btn").attr("disabled")==null){
                $("#sub_btn").attr("disabled","disabled");
            }
            return false;
        }
        return true;
    }

    function cl() {
        var name = $("#bookName").val();
        var number = $("#bookNumber").val();
        var detail = $("#bookDetail").val();
        if(checkBookNameLength(name)&&checkNumLength(number)&&checkDetailLength(detail)){
            //alert("成功！");
            $("#sub_btn").removeAttr("disabled");
        }
    }
</script>
</body>
</html>
