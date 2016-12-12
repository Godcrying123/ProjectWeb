<!DOCTYPE html>
<%@page import="com.project.webapp.domain.UserMatches"%>
<%@page import="com.project.webapp.controller.BetMatchController"%>
<%@page import="com.project.webapp.model.Matches"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.project.webapp.controller.MatchesController"%>
<%@page import="com.project.webapp.controller.UserDao"%>
<%@page import="com.project.webapp.controller.RegistractionController"%>
<%@page import="com.project.webapp.controller.LoginController"%>
<%@page import="com.project.webapp.domain.User"%>
<%
	MatchesController matchesController = new MatchesController();
	Matches matches = new Matches();
	int match_week = 0;
	StringBuffer matchBet = new StringBuffer();
	for (int i = 19; i >= 1; i--) {
		match_week = i;
		matches = matchesController.searchMatchesByTeamIdAndMatchWeek(4, match_week);
		String bet = matches.getStartTime()+"	"+String.valueOf(i)+"th Week";
		String homeTeam = matchesController.searchTeam(matches.getHometeam()).getTeamname();
		String awayTeam = matchesController.searchTeam(matches.getAwayteam()).getTeamname();
		System.out.println(matches);
		String homeScore = String.valueOf(matches.getHomescore());
		String awayScore = String.valueOf(matches.getAwayscore());

		bet = bet + "<br/>" + "<hr>";
		bet = bet + homeTeam + "			" + " VS " + "			" + awayTeam;
		bet = bet + "<br/>" + "<br/>";
		bet = bet + "<br/>";
		bet = bet + homeScore+"----"+awayScore;
		bet = bet + "<br/>" + "<hr>";
		matchBet.append(bet);
	}

	session.setAttribute("matchBet", matchBet);
%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Team</title>

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
			<ul class="nav navbar-nav">
				<li class="nav-item"><a class="nav-link" href="HomePage.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">About</a></li>
				<li class="nav-item"><a class="nav-link" href="Rank.jsp">Data</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdownMenuLink"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Your Account </a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item" href="#">Your Informations</a> <a
							class="dropdown-item" href="#">Update Informations</a> <a
							class="dropdown-item" href="BetHistory.jsp">Bet Order Management</a> <a
							class="dropdown-item" href="#">Top Up Your Account</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdownMenuLink"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Popular Team </a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item" href="Team.jsp">Manchester United</a> <a
							class="dropdown-item" href="Team1.jsp">Manchester City</a> <a
							class="dropdown-item" href="Team2.jsp">Chelsea</a> <a
							class="dropdown-item" href="Team3.jsp">Arsenal</a>
					</div></li>
			</ul>
			<!-- Search -->
			<form class="form-inline pull-xs-right">
				<button class="btn btn-secondary" type="submit">
					<a href="index.jsp">LOG OFF</a>
				</button>
			</form>
		</div>
	</nav>


	<div class="container-fluid">

		<!-- Left Column -->
		<!-- Center Column -->
		<div class="col-sm-4">
			<!-- Articles -->
			<div class="row">
				<article class="col-xs-12">
					<div class="card-block">
						<h2>Recent Matches History</h2>
						<br />
						<hr>
						<%=session.getAttribute("matchBet")%>
					</div>
				</article>
			</div>
			<hr>
		</div>
		<!--/Center Column-->
		<!--/Left Column -->
		<!-- Right Column -->
		<div class="col-sm-8">

			<!-- Carousel -->
			<h4>
				<i class="fa fa-language" aria-hidden="true"></i> Welcome to BET250
			</h4>
			<div id="side-carousel" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#side-carousel" data-slide-to="0" class="active"></li>
					<li data-target="#side-carousel" data-slide-to="1"></li>
					<li data-target="#side-carousel" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<a href="#"> <img class="img-responsive"
							src="/ProjectWeb/images/Chelsea_1.jpg" alt="">
						</a>
						<div class="carousel-caption">
							
						</div>
					</div>
					<div class="carousel-item">
						<a href="#"> <img class="img-responsive"
							src="/ProjectWeb/images/Chelsea_2.jpg" alt="">
						</a>
						<div class="carousel-caption">
							
						</div>
					</div>
					<div class="carousel-item">
						<a href="#"> <img class="img-responsive"
							src="/ProjectWeb/images/Chelsea_3.jpg" alt="">
						</a>
						<div class="carousel-caption">
							
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#side-carousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#side-carousel"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>

			<!-- Alert -->
			<!-- Articles -->
		</div>
		<!--/Right Column-->




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
