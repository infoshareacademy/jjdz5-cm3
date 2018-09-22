<!DOCTYPE html>
<html lang="pl-PL" style="width: 100%;
    height: 100%;
    padding: 0;
    margin: 0;">
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Sign in</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../../META-INF/resources/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>

        html{
            display: flex;
            flex-flow: row nowrap;
            justify-content: center;
            align-content: center;
            align-items: center;
            height:100%;
            margin: 0;
            padding: 0;
            background:#eeeeee;
        }
        body {
            margin: 0;
            flex: 0 1 auto;
            align-self: auto;
            width: 100%
            max-width: 900px;
            max-height: 600px;
            background:#ffffff;
            -webkit-box-shadow: 0px 0px 96px 0px rgba(0,0,0,0.75);
            -moz-box-shadow: 0px 0px 96px 0px rgba(0,0,0,0.75);
            box-shadow: 0px 0px 96px 0px rgba(0,0,0,0.75);
        }
        .container-fluid {
            height: 50vh;
            overflow: auto;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .row {
            width: 750px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        p {
            color:gray;
            font-style: italic;
        }

        a {
            text-decoration: none;
            color: #ffffff;
        }

        a:hover {
            text-decoration: none;
            color: #ffffff;
        }
        .container-fluid {
            height: 40vh;
            overflow: auto;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container-fluid2 {
            height: 70vh;
            horiz-align: center;
            overflow: auto;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        img {
            width: 40%;
            height: auto;
            justify-content: center;
            align-items: center;
        }

    </style>
</head>
<body style="vertical-align: center">
<div class="container-fluid">
    <div class="row">
        <div class="te">
            <div class="col">
                <img src="images/globe.jpg" alt="globe" style="horiz-align: center">
            </div>
        </div>
    </div>
</div>
<div class="container-fluid2">
    <div class="row">
            <div class="col-md-12">
                <form action="">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted">Enter Your email</small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        <small id="passwordHelp" class="form-text text-muted">Enter Your password</small>
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">remember my credential</label>
                    </div>
                    <button type="submit" class="btn btn-secondary">Submit</button>
                </form>
            </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>

