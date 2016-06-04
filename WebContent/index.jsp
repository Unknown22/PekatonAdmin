<!-- start: BEGINNING -->
	<%@ include file="WEB-INF/beginning.jsp"%>
	<!-- start: BEGINNING -->


			<!-- start: Content -->
			<div id="content" class="span10">

				<ul class="breadcrumb">
					<li><i class="icon-bar-chart"></i> <a href="#">Ogolne</a></li>
				</ul>

				<div class="row-fluid">

					<div class="span3 statbox purple" onTablet="span6"
						onDesktop="span3">
						<div class="boxchart">5,6,7,2,0,4,2,4,8,2,3,3,2</div>
						<div class="number"> 2 <i class="icon-group"></i>
						</div>
						<div class="title">Pracownikow</div>
						<div class="footer">
							<a href="indexPracownicy.jsp"> Przegladaj</a>
						</div>
					</div>
					<div class="span3 statbox green" onTablet="span6" onDesktop="span3">
						<div class="boxchart">1,2,6,4,0,8,2,4,5,3,1,7,5</div>
						<div class="number"> 123 <i class="icon-th-list"></i>
						</div>
						<div class="title">wszystkich zadan</div>
						<div class="footer">
							<a href="indexZadania.jsp">Zobacz</a>
						</div>
					</div>
					<div class="span3 statbox blue noMargin" onTablet="span6"
						onDesktop="span3">
						<div class="boxchart">5,6,7,2,0,-4,-2,4,8,2,3,3,2</div>
						<div class="number"> 10 <i class="icon-ok"></i>
						</div>
						<div class="title">wykonanych zadan</div>
						<div class="footer">
							<a href="#"> Zobacz</a>
						</div>
					</div>
					<div class="span3 statbox yellow" onTablet="span6"
						onDesktop="span3">
						<div class="boxchart">7,2,2,2,1,-4,-2,4,8,,0,3,3,5</div>
						<div class="number"> 8 <i class="icon-time"></i>
						</div>
						<div class="title">niewykonanych zadan</div>
						<div class="footer">
							<a href="#"> Zobacz</a>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>

	<!-- start: Footer -->
	<%@ include file="WEB-INF/footer.jsp"%>
	<!-- start: Footer -->

	<!-- start: JavaScript-->
	<%@ include file="WEB-INF/javascript.jsp"%>
	<!-- end: JavaScript-->

</body>
</html>
