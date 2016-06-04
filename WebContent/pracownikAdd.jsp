<!-- start: BEGINNING -->
	<%@ include file="WEB-INF/beginning.jsp"%>
	<!-- start: BEGINNING -->




			<!-- start: Content -->
			<div id="content" class="span10">

				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="icon-plus-sign"></i><span class="break"></span> Dodaj Pracownika
							</h2>
							
						</div>
						<div class="box-content">
						
							<form class="form-horizontal" action="PracownikController" method="post" name="pracownikForm">
									<div class="control-group">
										<label class="control-label" >Login</label>
										<div class="controls">
											<input class="input-xlarge focused" name="login" id="focusedInput" type="text" value="Imie...">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" >Haslo</label>
										<div class="controls">
											<input class="input-xlarge focused" name="haslo" id="focusedInput" type="password" value="">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" >Stanowisko</label>
										<div class="controls">
											<input class="input-xlarge focused" name="stanowisko" id="focusedInput" type="text" value="Stanowisko...">
										</div>
									</div>
									
									
									<!--  
									<div class="control-group">
										<label class="control-label" for="selectError3">Plain Select</label>
										<div class="controls">
											<select id="selectError3">
												<option>Option 1</option>
												<option>Option 2</option>
												<option>Option 3</option>
												<option>Option 4</option>
												<option>Option 5</option>
											</select>
										</div>
									</div>
									-->
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
