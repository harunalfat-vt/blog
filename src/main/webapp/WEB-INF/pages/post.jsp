<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	
<head>
	<link href="<%=request.getContextPath()%>/resources/css/prism.css" rel="stylesheet">
</head>	

<body>
	
    <!-- Navigation -->
    <jsp:include page="header/header.jsp"/>
    <!-- Facebook JS -->
    <div id="fb-root"></div>
	<script>	
		window.fbAsyncInit = function() {
			FB.init({
				appId : '1576701875928447',
				xfbml : true,
				version : 'v2.3'
			});
		};

		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	
	<!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('<%=request.getContextPath()%>/resources/img/fireworks2.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="post-heading">
                        <h1>${post.title }</h1>
                        <h2 class="subheading">${post.subTitle }</h2>
                        <c:if test="${post.status == 'new' }"><span class="meta">Posted by ${post.user} on ${post.dateStr }</span></c:if>
                        <c:if test="${post.status == 'edited' }"><span class="meta">Last Edited by ${post.user} on ${post.dateStr }</span></c:if>
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
                	
                	<!-- Facebook Like & Share -->
					<div class="fb-like"
						data-href="${url.full}<%=request.getAttribute("javax.servlet.forward.request_uri")%>"
						data-layout="standard" data-action="like" data-show-faces="false"
						data-share="true"></div>
					<!-- Disqus -->
					<div id="disqus_thread"></div>
					<script type="text/javascript">
						/* * * CONFIGURATION VARIABLES * * */
						var disqus_shortname = 'blogharunalfatcom';

						/* * * DON'T EDIT BELOW THIS LINE * * */
						(function() {
							var dsq = document.createElement('script');
							dsq.type = 'text/javascript';
							dsq.async = true;
							dsq.src = '//' + disqus_shortname
									+ '.disqus.com/embed.js';
							(document.getElementsByTagName('head')[0] || document
									.getElementsByTagName('body')[0])
									.appendChild(dsq);
						})();
					</script>
					<noscript>
						Please enable JavaScript to view the <a
							href="https://disqus.com/?ref_noscript" rel="nofollow">comments
							powered by Disqus.</a>
					</noscript>

				</div>
            </div>
        </div>
    </article>
    

	<!-- Footer -->
    <jsp:include page="footer/footer.jsp"/>

</body>

<script src="<%=request.getContextPath()%>/resources/js/prism.js" />
<script>
	$(document).ready(function() {
		Prism.highlightAll();
	});
</script>

</html>
