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
            </div>
        </div>
    </div>

    <!-- Footer -->
    <jsp:include page="footer/footer.jsp"/>

</body>

</html>
