<!DOCTYPE html>
<html lang="en">
	
<head>
	<link href="<%=request.getContextPath()%>/resources/css/prism.css" rel="stylesheet">
</head>	

<body>

    <!-- Navigation -->
    <jsp:include page="header/header.jsp"/>
	
    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('<%=request.getContextPath()%>/resources/img/fireworks2.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="post-heading">
                        <h1>${post.title }</h1>
                        <h2 class="subheading">${post.subTitle }</h2>
                        <span class="meta">Posted by ${post.user} on ${post.dtcreated }</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Post Content -->
    <article>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                	${post.content }
                </div>
            </div>
        </div>
    </article>

    <!-- Footer -->
    <jsp:include page="footer/footer.jsp"/>
    <script src="<%=request.getContextPath()%>/resources/js/prism.js"/>
    <script>
    	$(document).ready(function(){
    		Prism.highlightAll();
    	});
    </script>

</body>

</html>
