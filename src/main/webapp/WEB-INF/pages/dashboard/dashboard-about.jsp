<!DOCTYPE html>
<html lang="en">

<body>

	<div id="wrapper">

		<jsp:include page="dashboard-header/dashboard-header.jsp"/>

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h2>About Content</h2>
						<form enctype="application/json" action="updateAbout" name="data" method="post">
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" required data-validation-required-message="Cannot be empty"
										name="title" placeholder="About Title" aria-invalid="false" value="${about.title }"> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control"
										name="subTitle" placeholder="About Subtitle" required value="${about.subTitle }"> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							<textarea required name="content" id="content" rows="900px" cols="80">${about.content }</textarea>
							<hr>
							
							<a class="btn btn-default" id="menu-toggle">Toggle</a>
							<div style="float: right">
								<input type="submit" id="saveTextAndSubmit" value="Update About" class="btn btn-default"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js"></script>
	
	<!-- Menu Toggle Script -->
	<script>
		$(document).ready(function() {
			CKEDITOR.replace('content');
			CKEDITOR.config.autoGrow_maxHeight = 600;
		});
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
		$("#alert-me").click(function(e) {
			e.preventDefault();
			Prism.highlightAll();
		});
	</script>

</body>

</html>
