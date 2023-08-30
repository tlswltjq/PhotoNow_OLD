<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="DAO.UserDAO" %>
<%@ page import="DAO.User" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" type= "DAO.User" scope="page"></jsp:useBean>
<jsp:setProperty name="userId" property="id"></jsp:setProperty>
<jsp:setProperty name="userPw" property="password"></jsp:setProperty>
<!DOCTYPE html>
<html>
<head>
    <title>🪵in</title>

</head>
<body>
    <%
//        user.setId(request.getParameter("id"));
//        user.setPassword(request.getParameter("password"));
        UserDAO da = new UserDAO();
        int result = da.signIn(user.getId(), user.getPassword());
//        int result = da.signIn(request.getParameter("id"), request.getParameter("password"));
        if (result ==1){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("location.href = main.jsp");
            script.println("</script>");
        }else if (result ==0){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('pw check.');");
            script.println("history.back()");
            script.println("</script>");
        }else if (result ==-1){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('id check.');");
            script.println("history.back()");
            script.println("</script>");
        }else if (result == -2){
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('db Error');");
            script.println("history.back()");
            script.println("</script>");
        }
    %>

</body>
</html>
