<%@ include file="/WEB-INF/include/head.jspf"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Registration</title>
<tag:css />
</head>
<body>
	<div class="wrapper">
			<tag:header />
			<form method="post" action="Controller">
			<div class="content">
				<div class="container">
					<div class="row main-form">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your
								first name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="firstName" id="name"
										placeholder="Enter your first name" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your
								last name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="lastName" id="name"
										placeholder="Enter your last name" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your
								Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="email" id="email"
										placeholder="Enter your Email" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Login</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-users fa" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="login" id="username"
										placeholder="Enter your login" />
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

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirm
								Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
										type="password" class="form-control" name="confirm"
										id="confirm" placeholder="Confirm your Password" />
								</div>
							</div>
						</div>

						<div class="form-group ">
							<input name="command" value="Register" target="_blank"
								type="submit" id="button"
								class="btn btn-primary btn-lg btn-block login-button" />

						</div>
					</div>
				</div>
			</div>
			</form>
			<tag:footer />
	</div>
</body>
</html>