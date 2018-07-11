<%@ include file="/WEB-INF/include/head.jspf"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign in</title>
<tag:css />
</head>
<body>
	<div class="wrapper">
		<tag:header/>
		<div class="contentR">
			<div class="container-sign-in">
				<div class="row main-form">
					<form method="post" action="Controller">

						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Login</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="login" id="name"
										placeholder="Enter your Login" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
										type="password" class="form-control" name="password"
										id="password" placeholder="Enter your Password" />
								</div>
							</div>
						</div>


						<div class="form-group ">
							<input name="command" value="Sign in" target="_blank"
								type="submit" id="button"
								class="btn btn-primary btn-lg btn-block 	login-button" />

						</div>

					</form>
				</div>
			</div>
		</div>
		<tag:footer />
	</div>

</body>
</html>