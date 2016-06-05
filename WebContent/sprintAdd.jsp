<!-- start: BEGINNING -->
	<%@ include file="WEB-INF/beginning.jsp"%>
	<!-- start: BEGINNING -->




			<!-- start: Content -->
			<div id="content" class="span10">

				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="icon-plus-sign"></i><span class="break"></span> Dodaj Sprint
							</h2>
							
						</div>
						<div class="box-content">
						
							<form class="form-horizontal" action="SprintController" method="post" name="sprintForm">
									<div class="control-group">
										<label class="control-label" >Poczatek</label>
										<div class="controls">
											<input class="input-xlarge focused" name="poczatek" id="focusedInput" type="date" value="2016-06-05">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" >Koniec</label>
										<div class="controls">
											<input class="input-xlarge focused" name="koniec" id="focusedInput" type="date" value="2016-06-05">
										</div>
									</div>
									
									<div class="form-actions">
										<button type="submit" class="btn btn-primary">Zapisz</button>
										<button class="btn">Anuluj</button>
										
									</div>
								
							</form>

						</div>
					</div>
					<!--/span-->

				</div>
				<!--/row-->

			</div>
			<!--/.fluid-container-->
		</div>
		<!--/#content.span10-->
	</div>
	<!--/fluid-row-->

	
	
	<!-- start: Footer -->
	<%@ include file="WEB-INF/footer.jsp"%>
	<!-- start: Footer -->

	<!-- start: JavaScript-->
	<%@ include file="WEB-INF/javascript.jsp"%>
	<!-- end: JavaScript-->

</body>
</html>
