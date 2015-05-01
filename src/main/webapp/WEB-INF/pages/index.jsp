<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<body>

    <!-- Navigation -->
	<jsp:include page="header/header.jsp"/>    

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('resources/img/home-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading">
                        <h1>Kode Hidup</h1>
                        <hr class="small">
                        <span class="subheading">Kisah Sang Developer</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            	<c:forEach items="${postList}" var="post" varStatus="loop">
            		<div class="post-preview">            			
            			<a href="<%=request.getContextPath()%>/post/${post.title}">
            				<h2 class="post-title">
            					${post.title }
            				</h2>
            				<h3 class="post-subtitle">
            					${post.subTitle }
            				</h3>
            			</a>
            			<div class="disqus-comment-count post-meta" data-disqus-url="${url.full}/post/${post.title}"></div>
            			<p class="post-meta">Posted by ${post.user } on ${post.dateStr} </p>
            			
            		</div>
            		<hr>
            	</c:forEach>
                <!-- Pager -->
                <ul class="pager">
                    <li class="next">
                        <a href="#">Older Posts &rarr;</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    
    <jsp:include page="footer/footer.jsp"/>
    <!-- Disqus Count -->
	<script type="text/javascript">
		/* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
		var disqus_shortname = 'blogharunalfatcom'; // required: replace example with your forum shortname

		/* * * DON'T EDIT BELOW THIS LINE * * */
		(function() {
			var s = document.createElement('script');
			s.async = true;
			s.type = 'text/javascript';
			s.src = '//' + disqus_shortname + '.disqus.com/count.js';
			(document.getElementsByTagName('HEAD')[0] || document
					.getElementsByTagName('BODY')[0]).appendChild(s);
		}());
	</script>

</body>

</html>
