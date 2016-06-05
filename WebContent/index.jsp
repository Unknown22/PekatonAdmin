<!-- start: BEGINNING -->
	<%@ include file="WEB-INF/beginning.jsp"%>
	<!-- start: BEGINNING -->

			<!-- start: Content -->
			<div id="content" class="span10">

				<div class="row-fluid">

					<div class="span3 statbox black" >
						<div class="boxchart">5,6,7,2,0,4,2,4,8,2,3,3,2</div>
						<div class="number"> ${liczbaPracownikow} <i class="icon-group"></i>
						</div>
						<div class="title">Pracownikow</div>
						<div class="footer">
							<a href="indexPracownicy.jsp"> Przegladaj</a>
						</div>
					</div>
					<div class="span3 statbox pink" >
						<div class="boxchart">1,2,3,4,0,2,2,4,5,3,1,4,5</div>
						<div class="number"> ${liczbaZadan} <i class="icon-th-list"></i>
						</div>
						<div class="title">wszystkich zadan</div>
						<div class="footer">
							<a href="indexZadania.jsp">Zobacz</a>
						</div>
					</div>
					
					<div class="span3 statbox orange " >
						<div class="boxchart">1,2,6,4,0,8,2,4,5,3,1,7,5</div>
						<div class="number"> ${liczbaSprintow} <i class="icon-fire"></i>
						</div>
						<div class="title">sprintow</div>
						<div class="footer">
							<a href="indexSprinty.jsp">Zobacz</a>
						</div>
					</div>

				</div>


				<div class="row-fluid">

					
					
					<div class="span3 statbox green ">
						<div class="boxchart">5,6,7,2,0,-4,-2,4,8,2,3,3,2</div>
						<div class="number"> ${liczbaZadan2} <i class="icon-ok"></i>
						</div>
						<div class="title">zakonczonych zadan</div>
						
					</div>
					

					
					<div class="span3 statbox blue" >
						<div class="boxchart">7,2,2,5,6,7,-2,4,8,0,3,3,5</div>
						<div class="number"> ${liczbaZadan1} <i class="icon-time"></i>
						</div>
						<div class="title"> zadan do weryfikacji</div>
					</div>


					<div class="span3 statbox red" >
						<div class="boxchart">7,2,5,2,2,4,0,4,8,,0,1,5,6</div>
						<div class="number"> ${liczbaZadan0} <i class="icon-time"></i>
						</div>
						<div class="title">niewykonanych zadan</div>
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
