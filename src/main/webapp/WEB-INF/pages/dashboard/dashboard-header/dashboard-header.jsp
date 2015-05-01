<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>My DashBoard</title>
	
	<!-- Bootstrap Core CSS -->
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="<%=request.getContextPath()%>/resources/css/simple-sidebar.css" rel="stylesheet">
	
	<link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
    
</head>

<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> DASHBOARD </a></li>
				<li><a href="<%=request.getContextPath()%>/dashboard/post">New Entry</a></li>
				<li><a href="<%=request.getContextPath()%>/dashboard/postList">Post List</a></li>
				<li><a href="<%=request.getContextPath()%>/dashboard/updateAbout">About</a></li>
				<li><a href="<%=request.getContextPath()%>/dashboard/logout">Logout</a></li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->