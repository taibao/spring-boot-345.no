<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
freemark 页面

<table border="1" align="center" width="50%">
    <tr>
        <th>Name</th>
        <th>Gender</th>
        <th>Age</th>
    </tr>
    <#list list as user>
    <tr>
        <td>${user.username}</td>
        <td>${user.usersex}</td>
        <td>${user.userage}</td>
    </tr>

    </#list>

</table>

</body>
</html>