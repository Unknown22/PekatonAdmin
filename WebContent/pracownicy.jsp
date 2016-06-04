<!-- start: BEGINNING -->
	<%@ include file="WEB-INF/beginning.jsp"%>
	<!-- start: BEGINNING -->


			<!-- start: Content -->
			<div id="content" class="span10">
			
				<ul class="breadcrumb">
					<li><i class="icon-user"></i> <a href="#">Pracownicy</a></li>
				</ul>

				<div class="row-fluid sortable">
					<div class="box span12">
					
						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>Pracownicy
							</h2>
						</div>
						
						<div class="box-content">
							<table class="table table-striped table-bordered bootstrap-datatable datatable">
								<thead>
									<tr>
										<th>ID</th>
										<th>Login</th>
										<th>Haslo</th>
										<th>Stanowisko</th>
										<th>Doswiadczenie</th>
										<th>Akcje</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pracownicy}" var="pracownik">
									<tr>
										<td>1</td>
										<td class="center"><c:out value="${pracownik.id}" /></td>
										<td class="center"><c:out value="${pracownik.login}" /></td>
										<td class="center"><c:out value="${pracownik.haslo}" /></td>
										<td class="center"><c:out value="${pracownik.stanowisko}" /></td>
										<td class="center"><c:out value="${pracownik.exp}" /></td>
										<td class="center">
											<a class="btn btn-success" href="#">
												<i class="halflings-icon white zoom-in"></i>
											</a> 
											<a class="btn btn-info" href="#"> 
												<i class="halflings-icon white edit"></i>
											</a> 
											<a class="btn btn-danger" href="PracownikController?action=deletePracownik&id=<c:out value="${pracownik.id}"/>" >
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
	<%@ include file="WEB-INF/javascript.jsp"%>
	<!-- end: JavaScript-->

</body>
</html>
