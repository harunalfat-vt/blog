<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>My DashBoard</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/simple-sidebar.css" rel="stylesheet">

<!-- Summernote CSS -->
<link href="resources/css/summernote.css" rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> Start Bootstrap </a></li>
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Shortcuts</a></li>
				<li><a href="#">Overview</a></li>
				<li><a href="#">Events</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h2>Add New Post</h2>
						<form action="newPost" name="data" method="post">
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" 
										name="title" placeholder="Post Title" required> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control"
										name="subTitle" placeholder="Enter Email" required> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							<div id="summernote"></div>
							<div style="float: right">
								<input type="submit" id="saveTextAndSubmit" value="Post" class="btn btn-default"/>
								<a class="btn btn-default" id="alert-me">Toggle Menu</a>
							</div>
							<input type="hidden" name="content" id="content"></input>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<!-- Summernote JS -->
	<script src="resources/js/summernote.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$(document).ready(function() {
			$("#summernote").summernote({
				height : "300",
				minHeight : "280",
				maxHeight : "320"
			});
		});
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
		$("#alert-me").click(function(e) {
			e.preventDefault();
			alert($("#summernote").code());
		});
		$("#saveTextAndSubmit").click(function(e){
			e.preventDefault();
			$("#content").val($("#summernote").code());
			$("form").submit();
		});
	</script>

</body>

</html>
