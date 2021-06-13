<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

 
<div class="row" style="margin-left: 15px;margin-right: 15px">
<!-- <div class="panel panel-default" style="margin-left: 15px;margin-right: 15px"> -->

<div class="panel panel-default" >
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/addPositionalResearch">Add Positional Research</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<span class="btn-primary btn-md">Stock List</span>
		</div>
		<div class="panel-body">
			<table class="table table-striped table-bordered responsive table-hover table-condensed">
				<thead class="small text-left">
					<tr class="medium">
						<th class="text-center">Stock Name</th>
						<th class="text-center">Analysis Date</th>
						<th class="text-center">Buy Price</th>
						<th class="text-center">Quantity</th>
						<th class="text-center">Invested Amount</th>
						<th class="text-center">Target Price</th>
						<th class="text-center">Exit Price</th>
						<th class="text-center">Expected % Gain</th>
						<th class="text-center">Support</th>
						<th class="text-center">Resistance</th>
						<th class="text-center">Comments</th>	
						<th class="text-center">Image</th>												
						<th class="text-center">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${researchList}" var="todo">
						<tr>
							<td class="text-center">${todo.stockName}</td>
							<td class="text-center"><fmt:formatDate value="${todo.researchDate}" pattern="dd/MM/yyyy" /></td>
							<td class="text-center">${todo.buyPrice}</td>
							<td class="text-center">${todo.quantity}</td>
							<td class="text-center">${todo.quantity * todo.buyPrice}</td>
							<td class="text-center">${todo.targetPrice}</td>
							<td class="text-center">${todo.exitPrice}</td>
							<td class="text-center"><fmt:formatNumber value="${(todo.targetPrice-todo.buyPrice)*100/todo.buyPrice}" maxFractionDigits="2" /></td>
							<td class="text-center">${todo.support}</td>
							<td class="text-center">${todo.resistance}</td>
							<td class="text-center">${todo.comments}</td>
							<td class="text-center"><span><img id="${todo.id}" src="data:image/jpg;base64,${todo.image}" style="width: 50px; height: 20px" onclick="openImage(this);"></img></span></td>
							<td class="text-center"><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a>
							<a type="button" class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			<div >

		</div>
	</div>

</div>
		<!--  	<div class="panel-body col-lg-4">
			<table class="table table-striped table-bordered responsive table-hover table-condensed">
				<thead class="small text-left">
					<tr class="medium">
						<th class="text-center">Total Invested Amount</th>
						<th class="text-center">Total Expected Amount</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							
							<td class="text-center">${todo.buyPrice + todo.buyPrice}</td>
							<td class="text-center">${todo.targetPrice+ todo.targetPrice}</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
		</div>-->

</div>



<%@ include file="common/footer.jspf"%>