<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    System.out.println(path);
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    System.out.println(basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>订单提交</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <script type="text/javascript" src="<%--<%=basePath%>--%>resources/js/jquery-1.11.0.min.js"></script>

    <script type="application/javascript">
        function send() {
           alert('<%=basePath%>myController/dealOrder');
            $.ajax({
                type:'post',
                url:'<%=basePath%>myController/dealOrder',
                dataType:'json',
                data:{'orderId':'1','number':'1'},
                success:function(data)
                {
                    if(data.number!=null){
                        alert("提交成功！");
                    }else{
                        alert("提交失败！");
                    }
                },
                error:function(data){
                    alert(data.number);
                }

            });
        }

    </script>
</head>
<body>
<h1>确认提交订单</h1>
<div id="producer">
    商品编号：<input type="text" name="orderId" id="orderId">
    <br>
    订单数量：<input type="text" name="number" id="number">
    <br>
    <button onclick="send()">确认</button>
    <br>
</div>
</body>
</html>
