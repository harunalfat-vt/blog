<!DOCTYPE html>
<html lang="en">

<body>

    <!-- Navigation -->
    <jsp:include page="header/header.jsp"/>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('resources/img/contact-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="page-heading">
                        <h1>${about.title }</h1>
                        <hr class="small">
                        <span class="subheading">${about.subTitle }</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
            	${about.content}

				<!-- Facebook Like & Share -->
				<div class="fb-like"
					data-href="javascript:$(location).attr('href');"
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

    <!-- Footer -->
    <jsp:include page="footer/footer.jsp"/>

</body>

</html>
