<!DOCTYPE html>
<!-- Template by Quackit.com -->
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Portal 1</title>

<!-- Bootstrap 4 CSS. This is for the alpha 3 release of Bootstrap 4. This should be updated when Bootstrap 4 is officially released. -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/css/bootstrap.min.css"
	integrity="sha384-MIwDKRSSImVFAZCVLtU0LMDdON6KVCrZHyVQQj6e8wIEJkW4tvwqXrbMIya1vriY"
	crossorigin="anonymous">

<!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
<link href="css/custom.css" rel="stylesheet">

<!-- For icons -->
<link href="css/font-awesome-4.6.3/css/font-awesome.min.css"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<!-- Navigation -->
	<nav id="topNav"
		class="navbar navbar-full navbar-static-top navbar-dark bg-inverse m-b-1">
		<button class="navbar-toggler hidden-md-up pull-right" type="button"
			data-toggle="collapse" data-target="#navbar">&#9776;</button>
		<a class="navbar-brand" href="#">BET250</a>
		<div class="collapse navbar-toggleable-sm" id="navbar">
			<!-- Search -->
			<form class="form-inline pull-xs-right">

				<button class="btn btn-secondary" type="submit">
					<a href="index.jsp">Return</a>
				</button>

			</form>
			</ul>
		</div>
	</nav>

	<div class="container-fluid">

		<!-- Left Column -->
		<div class="col-sm-
		12">

			<div class="row">
				<article class="col-xs-12">
					<div class="card-block">
						<hr>
						<form action="/ProjectWeb/BetMatchController" method="POST">
							<h2>Your Information provided are wrong</h2>
						</form>
						<hr>
					</div>
				</article>
			</div>

		</div>
	</div>
	<!--/container-fluid-->
	<footer>
		<div class="small-print">
			<div class="container">
				<p>
					<a href="#">Terms &amp; Conditions</a> | <a href="#">Privacy
						Policy</a> | <a href="#">Contact</a>
				</p>
				<p>Copyright &copy; Example.com 2016</p>
			</div>
		</div>
	</footer>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"
		integrity="sha384-THPy051/pYDQGanwU6poAc/hOdQxjnOEXzbT+OuUAFqNqFjL+4IGLBgCJC3ZOShY"
		crossorigin="anonymous"></script>
	<!-- Tether -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"
		integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB"
		crossorigin="anonymous"></script>
	<!-- Bootstrap 4 JavaScript. This is for the alpha 3 release of Bootstrap 4. This should be updated when Bootstrap 4 is officially released. -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/js/bootstrap.min.js"
		integrity="sha384-ux8v3A6CPtOTqOzMKiuo3d/DomGaaClxFYdCu2HPMBEkf6x2xiDyJ7gkXU0MWwaD"
		crossorigin="anonymous"></script>
	<!-- Initialize Bootstrap functionality -->
	<script>
		// Initialize tooltip component
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
		})

		// Initialize popover component
		$(function() {
			$('[data-toggle="popover"]').popover()
		})
	</script>
	<!-- Placeholder Images -->
	<script src="js/holder.min.js"></script>
</body>

</html>
