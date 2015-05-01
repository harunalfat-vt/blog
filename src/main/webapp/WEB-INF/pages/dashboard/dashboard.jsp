<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<c:if test="${status == 'add' }">
							<h2>Add New Post</h2>
							<form enctype="application/json" action="newPost" name="data" method="post">
						</c:if>
						<c:if test="${status == 'update' }">
							<h2>Update Post</h2>
							<form enctype="application/json" action="updatePost" name="data" method="post">
						</c:if>						
							<div class="form-group">
								<div class="input-group">
									<c:if test="${status == 'add' }">
										<input type="text" class="form-control" required
											data-validation-required-message="Cannot be empty"
											name="title" placeholder="Post Title" aria-invalid="false">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-asterisk"></span></span>
									</c:if>
									<c:if test="${status == 'update' }">
										<input disabled="disabled" value="${post.title }" type="text" class="form-control" required
											data-validation-required-message="Cannot be empty"
											name="title" placeholder="Post Title" aria-invalid="false">
										<input type="hidden" name="title" value="${post.title }"/>
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-asterisk"></span></span>
									</c:if>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="text" value="${post.subTitle}" class="form-control"
										name="subTitle" placeholder="Post Subtitle" required > <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							<textarea required name="content" id="content" rows="900px" cols="80">${post.content}</textarea>
							<hr>
							
							<a class="btn btn-default" id="menu-toggle">Toggle</a>
							<div style="float: right">
								<c:if test="${status == 'add' }">
									<input type="submit" id="saveTextAndSubmit" value="Post" class="btn btn-default"/>
								</c:if>
								<c:if test="${status == 'update' }">
									<input type="submit" id="saveTextAndSubmit" value="Save Update" class="btn btn-default"/>
								</c:if>
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
