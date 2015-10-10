
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h4 class="modal-title">Login</h4>
	</div>
	<!-- /modal-header -->
	<form action="login" method="POST">
		<div class="modal-body">
			<div style="display: none" id="login-alert"
				class="alert alert-danger col-sm-12"></div>

			<form id="loginform" class="form-horizontal" role="form">

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input id="login-username"
						type="text" class="form-control" name="username" value=""
						placeholder="username or email">
				</div>

				<div style="margin-bottom: 25px" class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
						type="password" class="form-control" name="password"
						placeholder="password">
				</div>



				<div class="input-group">
					<div class="checkbox">
						<label> <input id="login-remember" type="checkbox"
							name="remember" value="1"> Remember me
						</label>
					</div>
				</div>



			</form>
		</div>
		<!-- /.modal-body -->

		<div class="modal-footer">
			<div style="margin-top: 10px" class="form-group">
				<!-- Button -->

				<div class="col-sm-12 controls">
					<a id="btn-login" href="#" class="btn btn-success">Login </a> <a
						id="btn-fblogin" href="#" class="btn btn-primary">Login with
						Facebook</a>

				</div>
			</div>
		</div>
		<!-- /.modal-footer -->
	</form>