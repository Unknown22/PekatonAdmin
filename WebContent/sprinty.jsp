<!-- start: BEGINNING -->
	<%@ include file="WEB-INF/beginning.jsp"%>
	<!-- start: BEGINNING -->


			<!-- start: Content -->
			<div id="content" class="span10">
			

				<div class="row-fluid sortable">
					<div class="box span12">

					
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>Sprinty
							</h2>
						</div>
						
						<div class="box-content">
							<table class="table table-striped table-bordered bootstrap-datatable datatable">
								<thead>
									<tr>
										<th>ID</th>
										<th>Poczatek Sprintu</th>
										<th>Koniec Sprintu</th>
										<th>Akcje</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${sprinty}" var="sprint">
									<tr>
										<td class="center"><c:out value="${sprint.id}" /></td>
										<td class="center"><c:out value="${sprint.poczatek}" /></td>
										<td class="center"><c:out value="${sprint.koniec}" /></td>

										<td class="center">
											<a class="btn btn-success" href="ZadanieController?action=zeSprintu&idS=${sprint.id}">
												<i class="halflings-icon white zoom-in"></i>
											</a> 
											
											<a class="btn btn-danger" href="SprintController?action=deleteSprint&id=<c:out value="${sprint.id}"/>" > 
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
