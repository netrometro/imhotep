<%@include file="./includes/start.jsp" %>

<div id="m-login">
	<div class="card" id="m-card-login">
		<div class="card-header m-flex-row">
			<span><img alt="logo" src="/imhotep/resources/img/logo.png" style="width: 30px"></span>
			<span><h3>Sign In</h3></span>
		</div>
		<div class="card-body">
			<form method="post" action="login.jsp">
				<div class="input-group form-group">
					<input type="text" class="form-control" placeholder="cpf or crm"
						   name="login" value="${param.login}" />
				</div>
				<div class="input-group form-group">
					<input type="password" class="form-control" placeholder="password"
						   name="senha" />
				</div>
				<div class="m-flex-row">
					<input class=" m-2" type="checkbox"><p>Remember Me</p>
				</div>
				<div class="form-group">
					<input type="submit" value="Login"
						   class="btn btn-primary float-right login_btn">
				</div>
			</form>
		</div>
		<div class="card-footer">
			<div class="d-flex justify-content-center links">
				Don't have an account?<a href="#">Sign Up</a>
			</div>
			<div class="d-flex justify-content-center">
				<a href="#">Forgot your password?</a>
			</div>
		</div>
	</div>

</div>

<%@include file="./includes/end.jsp" %>