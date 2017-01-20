<!DOCTYPE HTML>
<html>
    <head>
        <title>Getting Started: Serving Web </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>

    <body>
        <p>
            "Hello ${name!World} FTL"
            ${ app.user.groups[0].roles![]?join(", ")}
        </p>
    </body>
</html>