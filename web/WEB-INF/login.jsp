<%@page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <h1>Login</h1>
    <form method="POST">
      <p>
        <label for="username">Username:</label>
        <input id="username" name="username" type="text" value="${username}" autofocus>
      </p>
      <p>
        <label for="password">Password:</label>
        <input id="password" name="password" type="password" value="${password}">
      </p>
      <p>
        <input type="submit" value="Log in">
      </p>
    </form>
    <p>${message}</p>
  </body>
</html>