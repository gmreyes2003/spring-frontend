<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>

<div class="container">
    <h2 style="color: blue;">${tittle}</h2>

    <h2>${msg}</h2>

    <form id="loginForm">
        <div class="form-group">
            <label for="mail">Email address</label>
            <input type="email" class="form-control" id="mail" aria-describedby="emailHelp" placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password">
        </div>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="check">
            <label class="form-check-label" for="check">Check me out</label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>

<script>


    $("#loginForm").submit(function (event) {
        console.log("Handler for loginForm .submit() called.");
        event.preventDefault();

        var urlName = "/test/form";

        var vMail = $('#mail').val();
        var vPassword = $('#password').val();
        var vCheck = $('#check').val();

        console.log("mail: " + vMail);
        console.log("password: " + vPassword);
        console.log("check: " + vCheck);

        var sendData = "{\"mail\":\"" + vMail + "\",\"password\":\"" + vPassword + "\",\"check\":\""+vCheck+"\"}";
        console.log("sendData: "+ sendData);

        $.ajax({
            url: urlName,
            type: "POST",
            data: sendData,
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data) {
                console.log("resposeJsonObject " + data);
                console.log("New mail: " + data.mail);

                $('#mail').val(data.mail);
            },
            error:function(data,status,er) {
                console.log("error: "+data+" status: "+status+" er:"+er);
            }
        });
    });


</script>

</html>