<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>🪵in</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.css" rel="stylesheet"/>
</head>
<body>

  <div id = "login_from" style = "text-align: center;display: flex;justify-content: center; align-items: center; background-color: mistyrose; width : 400px; height: 200px">
    <form action="LoginTry.jsp" method="post">
      <div>
        <div style = "float : left;">
          <div><input type="text" placeholder="아이디" name="id"></div>
          <div><input type="password" placeholder="비밀번호" name="password"></div>
        </div>
      </div>
      <div style = "float : right">
        <input type="submit" value="로그인"><br/>
      </div>
    </form>
  </div>

</body>
</html>