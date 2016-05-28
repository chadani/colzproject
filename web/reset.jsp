

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
      
         <script type="text/javascript">
            function checkmatch(form){
           
                var returnvalue=true;
              var pass=document.frmname.pass.value;
              var pass1=document.frmname.pass1.value;
              if(pass.length<8){
                  alert("pass less than 8 characters");}
                if(pass!=pass1){
                    alert("Passwords don't match");}
                
            }
        </script>
        <title>Reset Password</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h3 class="col-sm-offset-4">Reset Password</h3>
        <form class="form-horizontal " name="frmname"onsubmit="return checkmatch()" action="reset" method="POST" >
            <div class="column">
                
                 <input class="form-control" type="hidden" name="email" value="${mail}">

  <div class="col-sm-offset-4 col-xs-2">
    <input type="password" class="form-control" placeholder="Enter Password" name="pass" required>
  </div>
                <br> <br>
    <div class="col-sm-offset-4 col-xs-2">
    <input type="password" class="form-control"  placeholder="Re-Enter Password" name="password" required>
  </div>
                <br> <br>
   <div class="col-sm-offset-4  col-sm-10">
                    <button type="submit" name="reset" class="btn btn-success"  > Reset Password</button>
                </div>
            </div>
        </form>
    </body>
</html>
