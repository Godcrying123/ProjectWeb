<!DOCTYPE html>
<!-- Template by Quackit.com -->
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
<!-- loading user information -->
<%
	LoginController logController = new LoginController();
	MatchesController matchesController = new MatchesController();
	String username = logController.getUserNameValidate();
	String email = logController.getEmailValidate();
	List<Matches> matchList1 = new ArrayList<Matches>();
	UserDao userDao = new UserDao();
	String[] betChoice = new String[1000];
	Double[] betAmount = new Double[1000];

	RegistractionController registerController = new RegistractionController();
	String userRegister = registerController.getUserNameRegister();
	String emailRegister = registerController.getEmailResgister();
	String emailUser = "";

	if (username != null) {
		session.setAttribute("userNameValidate", username);
		session.setAttribute("emailValidate", email);
		User user = (User) userDao.search(email);
		Double amount = user.getAccount_Amount();
		session.setAttribute("amount", amount);
		emailUser = email;
	} else if (userRegister != null) {
		session.setAttribute("userNameValidate", userRegister);
		session.setAttribute("emailValidate", emailRegister);
		User user = (User) userDao.search(emailRegister);
		Double amount = user.getAccount_Amount();
		session.setAttribute("amount", amount);
		emailUser = emailRegister;
	}
%>
<%
	User user = (User) userDao.search(emailUser);
	List<UserMatches> betList =user.getBettingList();
	
	int ii = 1;
	for (UserMatches betOrder : betList) {
		matchList1.add(betOrder.getMatches());
		betAmount[ii-1] = betOrder.getBetAmount();
		if(betOrder.getBet()==1){
		betChoice[ii-1] = "HomeTeam Win";
		}else if(betOrder.getBet()==2){
		betChoice[ii-1] = "Draw";	
		}else{
	betChoice[ii-1] = "AwayTeam Win";
		}
		ii=ii+1;

	}
	if (matchList1 != null) {
		StringBuffer betHistory = new StringBuffer();
		String bet = "";
		int j = 1;
		for (Matches matches : matchList1) {

	bet = bet + "<br/><hr>";
	
	String homeTeam1 = matchesController.searchTeam(matches.getHometeam()).getTeamname();
	String awayTeam1 = matchesController.searchTeam(matches.getAwayteam()).getTeamname();
	bet = bet + "<a class=\"list-group-item list-group-item-action\">";
	bet = bet  + "You bet "+"	"+betChoice[j-1]+"	"+String.valueOf(betAmount[j-1])+"	"+"for match";
	bet = bet +"<br/>"+	homeTeam1 + "	" + "VS" + "	" + awayTeam1 + "	";
	bet = bet + "<input type=\"button\" name=\"cancel" + String.valueOf(j) + "\"value=\"Cancel\""
	+ "\"></a>";
	bet = bet + "<hr>";
	betHistory.append(bet);
	j = j + 1;
	bet = "";
		}
		betHistory.append("</div>");
		session.setAttribute("matchHistory", betHistory);
	}
%>
<%
	int match_week = 20;
	List<Matches> matchList = matchesController.searchMatchList(match_week);
	List<String> matchesList = new ArrayList<String>();
	StringBuffer matchBet = new StringBuffer();
	int i = 1;
	for (Matches matches : matchList) {
		String bet = matches.getStartTime();
		String homeTeam = matchesController.searchTeam(matches.getHometeam()).getTeamname();
		String awayTeam = matchesController.searchTeam(matches.getAwayteam()).getTeamname();
		String homeRate = String.valueOf(matches.getHomeWinRate());
		String drawRate = String.valueOf(matches.getDrawRate());
		String awayRate = String.valueOf(matches.getAwayWinRate());
		bet = bet + "<br/>" + "<hr>";
		bet = bet + homeTeam + "			" + " VS " + "			" + awayTeam;
		bet = bet + "<br/>" + "<br/>";
		bet = bet + "<div><input type=\"radio\" name=\"betTeam" + String.valueOf(i) + "\" value=\"1\">";
		bet = bet + homeTeam;
		bet = bet + "<input type=\"radio\" name=\"betTeam" + String.valueOf(i) + "\" value=\"2\">";
		bet = bet + "Draw";
		bet = bet + "<input type=\"radio\" name=\"betTeam" + String.valueOf(i) + "\" value=\"3\">";
		bet = bet + awayTeam;
		bet = bet + "<input type=\"text\" name =\"bet" + String.valueOf(i) + "\" placeholder=\"0.00\">";
		bet = bet + "<input type=\"submit\" name =\"betMake" + String.valueOf(i) + "\" value=\"Make a Bet\">";
		bet = bet + "<br/>";
		bet = bet + homeRate + "	" + drawRate + "	" + awayRate;
		bet = bet + "<br/>" + "<hr></div>";
		matchBet.append(bet);
		i = i + 1;
	}
	session.setAttribute("matchBet", matchBet);
%>


<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->


<title>Home Page</title>

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
							class="dropdown-item" href="BetHistory.jsp">Bet Order
							Management</a> <a class="dropdown-item" href="#">Top Up Your
							Account</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdownMenuLink"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Popular Team </a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item" href="Team.jsp">Manchester United<%
							session.setAttribute("team", 11);
						%></a> <a class="dropdown-item" href="Team.jsp">Manchester City<%
 	session.setAttribute("team", 10);
 %></a> <a class="dropdown-item" href="Team.jsp">Chelsea<%
 	session.setAttribute("team", 4);
 %></a> <a class="dropdown-item" href="Team.jsp">Arsenal<%
 	session.setAttribute("team", 2);
 %></a>
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
		<!-- Center Column -->
		<div class="col-sm-7">
			<!-- Articles -->
			<div class="row">
				<article class="col-xs-12">
					<div class="card-block">
						<h2>Please make the bet order</h2>
						<br />
						<hr>
						<form action="/ProjectWeb/BetMatchController" method="POST">
							<%=session.getAttribute("matchBet")%>
						</form>
					</div>
				</article>
			</div>
		</div>
		<!--/Center Column-->


		<!-- Right Column -->
		<div class="col-sm-5">

			<!-- Form -->
			<div class="card">
				<div class="card-header p-b-0">
					<h5 class="card-title">
						<i class="fa fa-sign-in" aria-hidden="true"></i> Your Information
					</h5>
				</div>
				<div class="card-block">
					<form action="/ProjectWeb/InfoController" method="post">
						<div class="list-group list-group-flush">
							<a class="list-group-item list-group-item-action">User Name:
								<%=session.getAttribute("userNameValidate")%>
							</a> <a class="list-group-item list-group-item-action">Email
								Address: <%=session.getAttribute("emailValidate")%>
							</a> <a class="list-group-item list-group-item-action">Account
								Money: <%=session.getAttribute("amount")%></a> <a> <input
								type="text" class="form-control" id="uid" name="betamount"
								placeholder="0"></a>
						</div>
						<br />
						<button type="submit" class="btn btn-primary">Top on</button>
						<button type="submit" class="btn btn-primary">Update</button>
					</form>
				</div>
			</div>

			<!-- Progress Bars -->
			<div class="card">
				<div class="card-header p-b-0">
					<h5 class="card-title">
						<i class="fa fa-tachometer" aria-hidden="true"></i> Latest Bet
						Orders
					</h5>
				</div>
				<div class="card-block">
					<form>
						<%=session.getAttribute("matchHistory")%>
					</form>
				</div>
			</div>
		</div>
		<!--/Right Column -->

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

	<script>
		var count = 1;
		function setColor(btn, color) {
			var property = document.getElementById(btn);
			if (count == 0) {
				property.style.backgroundColor = "#FFFFFF"
				count = 1;
			} else {
				property.style.backgroundColor = "#7FFF00"
				count = 0;
			}
		}
	</script>
</body>

</html>
