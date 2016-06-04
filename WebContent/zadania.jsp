<!-- start: BEGINNING -->
	<%@ include file="WEB-INF/beginning.jsp"%>
	<!-- start: BEGINNING -->


			<!-- start: Content -->
			<div id="content" class="span10">
			

				<div class="row-fluid sortable">
					<div class="box span12">

					
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>Zadania
							</h2>
						</div>
						
						<div class="box-content">
							<table class="table table-striped table-bordered bootstrap-datatable datatable">
								<thead>
									<tr>
										<th>ID</th>
										<th>Opis</th>
										<th>Doswiadczenie</th>
										<th>Zleceniodawca</th>
										<th>Osoba odpowiedzialna</th>
										<th>Poczatek Sprintu</th>
										<th>Koniec Sprintu</th>
										<th>Status</th>
										<th>Akcje</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${zadania}" var="zadanie">
									<tr>
										<td class="center"><c:out value="${zadanie.id}" /></td>
										<td class="center"><c:out value="${zadanie.opis}" /></td>
										<td class="center"><c:out value="${zadanie.doswiadczenie}" /></td>
										<td class="center"><c:out value="${zadanie.zleceniodawca}" /></td>
										<c:if test="${zadanie.ipPracownika == ''}">
											<td class="center"><c:out value="BRAK" /></td>
										</c:if>
										<c:if test="${zadanie.ipPracownika != ''}">
											<td class="center"><c:out value="${zadanie.pracownik}" /></td>
										</c:if>
										
										<td class="center"><c:out value="${zadanie.poczatekSprintu}" /></td>
										<td class="center"><c:out value="${zadanie.koniecSprintu}" /></td>
										
										<c:if test="${zadanie.status == 0}">
										<td class="label-pill label-warning"><c:out value="Niewykonane" /></td>
										</c:if>
										
										<c:if test="${zadanie.status == 1}">
										<td class="label-info"><c:out value="Do weryfikacji" /></td>
										</c:if>
										
										<c:if test="${zadanie.status == 2}">
										<td class="label-success"><c:out value="Wykonane" /></td>
										</c:if>
										
										<td class="center">
											<a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
											</a> 
											<a class="btn btn-info" href="#"> 
												<i class="halflings-icon white edit"></i>
											</a> 
											<a class="btn btn-danger" href="ZadanieController?action=deleteZadanie&id=<c:out value="${zadanie.id}"/>" > 
											<i class="halflings-icon white trash"></i>
											</a>
										</td>
									</tr>
								</c:forEach>
																		
								</tbody>
							</table>
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
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery-migrate-1.0.0.min.js"></script>
	<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src='js/jquery.dataTables.min.js'></script>
	<script src="js/jquery.chosen.min.js"></script>
	<script src="js/jquery.uniform.min.js"></script>
	<script src="js/jquery.cleditor.min.js"></script>
	<script src="js/jquery.elfinder.min.js"></script>
	<script src="js/jquery.raty.min.js"></script>
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<script src="js/retina.js"></script>
	<script src="js/custom.js"></script>
	<!-- end: JavaScript-->

</body>
</html>
