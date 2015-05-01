<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="<%=request.getContextPath()%>/resources/css/simplePagination.css" rel="stylesheet">
</head>
<body>
	
	<div id="wrapper">

		<jsp:include page="dashboard-header/dashboard-header.jsp"/>

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h2>Post List</h2>
						<c:forEach items="${postList}" var="post" varStatus="loop">
							<div class="list-group">
								<a href="<%=request.getContextPath()%>/dashboard/post?postId=${post.id}" class="list-group-item">
									<h4 class="list-group-item-heading">${post.title }</h4>
									<p class="list-group-item-text">${post.subTitle }. Last updated on ${post.dateStr}</p>
									<p class="list-group-item-text"></p>
								</a>
							</div>
						</c:forEach>	
						
						<ul id="pagination" class="pagination-sm"></ul>
						<hr>
						<a class="btn btn-default" id="menu-toggle">Toggle</a>
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
	
	<script src="<%=request.getContextPath()%>/resources/js/jquery.simplePagination.js"></script>
	<!-- Menu Toggle Script -->
	<script>
		$(document).ready(function() {
			
			$(function() {
			    $("#pagination").pagination({
			        items: "${pageAttr.total}",
			        itemsOnPage: "${pageAttr.pageLimit}",
			        cssStyle: 'light-theme',
			        currentPage: "${pageAttr.currentPage}",
			        onPageClick : function(pageNum){
			        	window.location.href = "<%=request.getContextPath()%>?page="+pageNum;
			        }
			    });
			});
		});
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
		$("#alert-me").click(function(e) {
			e.preventDefault();
			Prism.highlightAll();
		});
		$("#test").click(function(e){
			$("#pagination").pagination('selectPage',1);
		});
	</script>

</body>

</html>
