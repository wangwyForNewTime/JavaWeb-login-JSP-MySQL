<%--
  Created by IntelliJ IDEA.
  User: 大喵喵
  Date: 2023/2/24
  Time: 23:28

  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>index</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/index.css">

</head>
<body>

<div class="mainbac">
  <h1>MayBe Something System </h1>
  <!-- <div class="lii">Please Choose Your Operation</div> -->
  <div class="duzi" >
    <ul class="nav nav-tabs nav-justified">
      <li style="border-top: 3px solid lightgray;border-right: 3px solid lightgray;border-bottom: none;font-size: 17px;"><a href="#" style="border-bottom: none;">登&nbsp;&nbsp;&nbsp;&nbsp;录</a></li>
    </ul>


      <div class="one" id="one">


        <form action="index" method="post" id="loginForm" class="bs-example bs-example-form">
          <div class="input-group" style="margin-top: 20px;">
            <span class="input-group-addon">&nbsp; ID&nbsp;</span>
            <input type="text" class="form-control" name="uname" value="${messageModel.object.userName}">
          </div>
          <br>
          <div class="input-group" style="margin-top: 20px;">
           <span class="input-group-addon" >密码</span>
            <input type="password" class="form-control" name="upwd" value="${messageModel.object.userPwd}">
         </div>

             <span id="msg" >${messageModel.msg}</span>
         <div class="input-group" style="margin-top: 50px;">
             <button type="submit" class="btn btn-primary" style="width: 240px;position: relative;left: 50%;margin-left: -20px;" id="loginBtn">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
         </div>
       </form>

      </div>
  </div>


</div>
</body>
</html>