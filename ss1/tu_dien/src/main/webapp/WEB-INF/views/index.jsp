<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="get" action="/dictionary">
    <div>
        <label>Nhập từ tiếng anh</label>
        <input name="text" type="text">
    </div>
    <button type="submit">Enter</button>
</form>
<label>${result}</label>
</body>
</html>