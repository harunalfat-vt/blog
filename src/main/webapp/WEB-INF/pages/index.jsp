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
            			<p class="post-meta">Posted by ${post.user } on ${post.dateStr }</p>
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

</body>

</html>
