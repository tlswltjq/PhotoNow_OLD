<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>복학생 게시판</title>

</head>
<body>

  <div id = "login_from" style = "text-align: center;display: flex;justify-content: center; align-items: center; background-color: mistyrose; width : 400px; height: 200px">
    <form action="login_try.java" method="post">
      <div>
        <div style = "float : left;">
          <div>아이디</div>
          <div>비밀번호</div>
        </div>
        <div style = "float : left;">
          <div><input type="text" name="id"></div>
          <div><input type="password" name="pw"></div>
        </div>
      </div>
      <div style = "float : right">
        <input type="submit" value="로그인"><br/>
      </div>
    </form>
  </div>

</body>
</html>