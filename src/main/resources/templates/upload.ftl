<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<link rel="icon" type="image/x-icon" href="/static/img/favicon.ico">
<body>

<h2>单一文件上传示例</h2>
<div>
    <form method="POST" enctype="multipart/form-data" action="/upload/upload1">
        <p>
            文件1：<input type="file" name="file"/>
            <input type="submit" value="上传"/>
        </p>
    </form>
</div>

<hr/>
<h2>批量文件上传示例</h2>

<div>
    <form method="POST" enctype="multipart/form-data"
          action="/upload/upload2">
        <p>
            文件1：<input type="file" name="file"/>
        </p>
        <p>
            文件2：<input type="file" name="file"/>
        </p>
        <p>
            <input type="submit" value="上传"/>
        </p>
    </form>
</div>

<hr/>
<h2>Base64文件上传</h2>
<div>
    <form method="POST" action="/upload/upload3">
        <p>
            BASE64编码：<textarea name="base64" rows="10" cols="80"></textarea>
            <input type="submit" value="上传"/>
        </p>
    </form>
</div>

</body>
</html>