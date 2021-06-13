<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Intraday Research</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="addResearch" enctype="multipart/form-data">
						<form:hidden path="id" />
						<!--<form:hidden path="stockType"  value="I"/>-->
						<fieldset class="form-group">
							<form:label path="stockName">Stock Name</form:label>
							<form:input path="stockName" type="text" class="form-control" required="required" />
							<form:errors path="stockName" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="researchDate">Research Date</form:label>
							<form:input path="researchDate" type="text" class="form-control" required="required" />
							<form:errors path="researchDate" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="buyPrice">Entry Price</form:label>
							<form:input path="buyPrice" type="text" class="form-control" required="required" />
							<form:errors path="buyPrice" cssClass="text-warning" />
						</fieldset>
					
					<%--     <fieldset class="form-group">
							<form:label path="quantity">Quantity</form:label>
							<form:input path="quantity" type="text" class="form-control" required="required" />
							<form:errors path="quantity" cssClass="text-warning" />
						</fieldset>
 --%>
						<fieldset class="form-group">

							<label for="orderType">Order type</label> <select id="orderType"
								class="form-control">
								<option selected>Choose...</option>
								<option>BUY</option>
								<option>SELL</option>
							</select>

						</fieldset>

						<fieldset class="form-group">
							<form:label path="targetPrice">Target Price</form:label>
							<form:input path="targetPrice" type="text" class="form-control"/>
							<form:errors path="targetPrice" cssClass="text-warning" />
						</fieldset>
                       
                       
                        <fieldset class="form-group">
							<form:label path="exitPrice">SL Price</form:label>
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
						</fieldset>



						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>