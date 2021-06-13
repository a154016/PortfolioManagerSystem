<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Position</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="todo" enctype="multipart/form-data">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="stockName">Stock Name</form:label>
							<form:input path="stockName" type="text" class="form-control" required="required" />
							<form:errors path="stockName" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="purchaseDate">Purchase Date</form:label>
							<form:input path="purchaseDate" type="text" class="form-control" required="required" />
							<form:errors path="purchaseDate" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="buyPrice">Buy Price</form:label>
							<form:input path="buyPrice" type="text" class="form-control" required="required" />
							<form:errors path="buyPrice" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="ltp">LTP</form:label>
							<form:input path="ltp" type="text" class="form-control"/>
							<form:errors path="ltp" cssClass="text-warning" />
						</fieldset>
					
					    <fieldset class="form-group">
							<form:label path="quantity">Quantity</form:label>
							<form:input path="quantity" type="text" class="form-control" required="required" />
							<form:errors path="quantity" cssClass="text-warning" />
						</fieldset>

                       <%--  <fieldset class="form-group">
							<form:label path="investedAmount">Invested Amount</form:label>
							<form:input path="investedAmount" type="text" class="form-control" required="required" />
							<form:errors path="investedAmount" cssClass="text-warning" />
						</fieldset> --%>
                       
                        <fieldset class="form-group">
							<form:label path="targetPrice">Target Price</form:label>
							<form:input path="targetPrice" type="text" class="form-control"/>
							<form:errors path="targetPrice" cssClass="text-warning" />
						</fieldset>
                       
                       
                        <fieldset class="form-group">
							<form:label path="exitPrice">Exit Price</form:label>
							<form:input path="exitPrice" type="text" class="form-control"/>
							<form:errors path="exitPrice" cssClass="text-warning" />
						</fieldset>
                       
                       
                      <%--   <fieldset class="form-group">
							<form:label path="expectedGain">Expected % Gain</form:label>
							<form:input path="expectedGain" type="text" class="form-control" required="required" />
							<form:errors path="expectedGain" cssClass="text-warning" />
						</fieldset> --%>
                       
                          <fieldset class="form-group">
							<form:label path="comments">Comments</form:label>
							<form:input path="comments" type="text" class="form-control"/>
							<form:errors path="comments" cssClass="text-warning" />
						</fieldset>
						
					 <%--  <fieldset class="form-group">
							<form:label path="files">Upload Image</form:label>
							<form:input path="files" type="file" class="form-control" required="required" />
							<form:errors path="files" cssClass="text-warning" />
						</fieldset>  --%>
						<fieldset class="form-group">
						
						<form:input path="files"  type="file"  class="form-control"/>
						<!--  <input  type="file" name="files" multiple >-->
						<form:errors path="files" cssClass="text-warning" />
						</fieldset>


						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>