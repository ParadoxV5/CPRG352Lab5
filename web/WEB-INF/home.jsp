<%@page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <h1>Home Page</h1>
    <h2>Hello ${user.username}</h2>
    <a href="login?logout">Log out</a>
  </body>
</html>