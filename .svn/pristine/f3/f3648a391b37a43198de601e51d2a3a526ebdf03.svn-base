<!DOCTYPE HTML>
<html>
<head>
<title>Register</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Raleway'
	rel='stylesheet' type='text/css'>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	var $ = jQuery.noConflict();
	$(function() {
		$('#activator').click(function() {
			$('#box').animate({
				'top' : '0px'
			}, 500);
		});
		$('#boxclose').click(function() {
			$('#box').animate({
				'top' : '-700px'
			}, 500);
		});
	});
	$(document).ready(function() {

		//Hide (Collapse) the toggle containers on load
		$(".toggle_container").hide();

		//Switch the "Open" and "Close" state per click then slide up/down (depending on open/close state)
		$(".trigger").click(function() {
			$(this).toggleClass("active").next().slideToggle("slow");
			return false; //Prevent the browser jump to the link anchor
		});

	});
</script>
</head>
<body>
	<div class="index-banner1">
		<div class="header-top">
			<div class="wrap">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt="" /></a>
				</div>
				<div class="menu">
					<a href="#" class="right_bt" id="activator"><img
						src="images/nav_icon.png" alt=""></a>
					<div class="box" id="box">
						<div class="box_content_center1">
							<div class="menu_box_list1">
								<ul>
									<li><a href="index.html">Home</a></li>
									<li class="active"><a href="about.html">About</a></li>
									<li><a href="blog.html">Blog</a></li>
									<li><a href="gallery.html">Gallery</a></li>
									<li><a href="contact.html">Contact</a></li>
									<li><a href="404.html">404</a></li>
								</ul>
							</div>
							<a class="boxclose" id="boxclose"><img src="images/close.png"
								alt=""></a>
						</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>

	<div class="main">
		<div class="register_account">
			<div class="wrap">
				<h4 class="title">Create an Account</h4>
				<br>
				<form action="/ProjectWeb/RegistractionController" method="post">
					<div>
						User Name: <input type="text" name="username" value="Username"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Username';}">
					</div>
					<div>
						Name: <input type="text" name="name" value="Name"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Name';}">
					</div>
					<div>
						Surname: <input type="text" name="surname" value="Surname"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Surname';}">
					</div>
					<div>
						Email: <input type="email" name="email" value="E-Mail"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'E-Mail';}">
					</div>
					<div>
						Password: <input type="password" name="password" value="123"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '123';}">
					</div>
					<div>
						Confirm Password<input type="password" name="confirmpassword" value="123"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '123';}">
					</div>
					<div>
						Favourite Team: <select id="teams" name="chooseteam"
							onchange="change_team(this.value)" class="frm-field required">
							<option value="null">Select Your Favourite Team</option>
							<option value="AB">AFC Bournemouth</option>
							<option value="AR">Arsenal</option>
							<option value="BU">Burnley</option>
							<option value="CH">Chelsea</option>
							<option value="CP">Crystal Palace</option>
							<option value="ET">Everton</option>
							<option value="HC">Hull City</option>
							<option value="LC">Leicester City</option>
							<option value="LV">Liverpool</option>
							<option value="MC">Manchester City</option>
							<option value="MU">Manchester United</option>
							<option value="ML">Middlesbrough</option>
							<option value="SH">Southampton</option>
							<option value="SC">Stoke City</option>
							<option value="SL">Sunderland</option>
							<option value="SW">Swansea City</option>
							<option value="TH">Tottenham Hotspur</option>
							<option value="WF">Watford</option>
							<option value="WB">West Bromwich Albion</option>
							<option value="WH">West Ham United</option>
						</select>
					</div>
					<div>
						Age: <input type="text" name="age" value="DD/MM/YYYY"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'DD/MM/YYYY';}">
					</div>

					<button class="grey">Submit</button>
					<p class="terms">
						By clicking 'Create Account' you agree to the <a href="#">Terms
							&amp; Conditions</a>.
					</p>
					<div class="clear"></div>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="wrap">
			<div class="copy">
				<p>
					Copyright &copy; 2014.Company name All rights reserved.<a
						target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
				</p>
			</div>

		</div>
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>