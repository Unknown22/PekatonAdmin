<!-- start: BEGINNING -->
	<%@ include file="WEB-INF/beginning.jsp"%>
	<!-- start: BEGINNING -->




			<!-- start: Content -->
			<div id="content" class="span10">

				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header" data-original-title>
							<h2>
								<i class="icon-plus-sign"></i><span class="break"></span> Dodaj Zadanie
							</h2>
							
						</div>
						<div class="box-content" >
						
							<form class="form-horizontal" action="ZadanieController" method="post">
								<fieldset>
									<div class="control-group">
										<label class="control-label" >Opis</label>
										<div class="controls">
											<input class="input-xlarge focused" name="opis" id="focusedInput" type="text" rows="2" value="...">
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label" >Doswiadczenie</label>
										<div class="controls">
											<input class="input-xlarge focused" name="doswiadczenie" id="focusedInput" type="number" min="0" max="20" value="0">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" >Zleceniodawca</label>
										<div class="controls">
											<input class="input-xlarge focused" name="zleceniodawca" id="focusedInput" type="text" value="...">
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label" for="selectError3">Pracownik</label>
										<div class="controls">
											<select id="selectError3" name="pracownikID">
											<option></option>
											<c:forEach items="${pracownicy}" var="pracownik">
												<option value="${pracownik.id}">${pracownik.login}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label" for="selectError3">Sprint</label>
										<div class="controls">
											<select id="selectError3" name="sprint">
											<c:forEach items="${sprinty}" var="sprint">
												<option>${sprint.id}: ${sprint.poczatek} - ${sprint.koniec} </option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="form-actions">
										<button type="submit" class="btn btn-primary">Zapisz</button>
										<button class="btn">Anuluj</button>
										
									</div>
								</fieldset>
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
