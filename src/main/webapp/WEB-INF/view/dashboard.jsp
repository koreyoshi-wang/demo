<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.info-box {
	margin-top: 20px;
    margin-bottom: 20px;
}
.info-box i {
	line-height:90px;
}
</style>
<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      Test
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
        	<div id="successMsg" class="alert alert-success" role="alert" style="display:none;font-weight:18px"></div>
			<button type="button" onclick = "" data-toggle="modal" data-target="#addModal" class="btn btn-success pull-right">添加用户</button>
        </div>
        <div class="box-body">
			<table style="width: 100%"
			class="table table-striped table-bordered table-hover"
			id="userTable">
			<thead>
				<tr>
					<th style="width:4%">Delete</th>
					<th>Name</th>
					<th>Password</th>
				</tr>
			</thead>
		</table>       	        
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  
<!-- Add Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
					<span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="addModalLabel">添加用户</h4>
				<br>
				<div id="addErrorMsg" class="alert alert-success" role="alert" style="display:none;font-weight:bold;text-align:center"></div>			
			</div>
			<div class="modal-body">
        		<div class="row">
					<form role="form" action="${contextPath}/dashboard/addUser" method="post" id="addUserForm">
						<div class="col-lg-12">
								<div class="form-group">
									<label>用户名:</label>
									<div class="form-group">
					                  <input type="text" class="form-control" id ="username" name="username">
					                </div>
								</div>
								<div class="form-group">
									<label>密码:</label>
									<div class="form-group">
					                  <input type="password" class="form-control" id="password" name="password"></input>
					                </div>
								</div>
								<div class="form-group">
									<label>确认密码:</label>
									<div class="form-group">
					                  <input type="password" class="form-control" id="password2" name="password2"></input>
					                </div>
								</div>
							</div>
						</form>
					</div>
				</div>
			<div class="modal-footer">
				<button id="addCancel" type="button" class="btn btn-default pull-left" data-dismiss="modal">Cancel</button>
				<button id="addSave" type="button" onclick="addUser()" class="btn btn-success pull-right">Add</button>
			</div>
		</div>
	</div>
</div>
<!-- End Add Line Item Modal -->

<script src="${contextPath}/js/jquery.dataTables.min.js"></script>
<script src="${contextPath}/js/dataTables.buttons.min.js"></script>
<script src="${contextPath}/js/buttons.flash.min.js"></script>
<script src="${contextPath}/js/dataTables.bootstrap.min.js"></script>
<script src="${contextPath}/js/dataTables.responsive.js"></script>  

<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery('#userTable').DataTable({
			"bLengthChange" : false, //Disable change row length 
			"bFilter" : false,//Disable search filter
			"bSort" : false, //Disable sort
			"pageLength" : 10,
			"Processing": true,
			"serverSide": true,
	        "ajax" : {
	            "dataType" : 'json',
	            "type" : "post",
	            "cache" : false,
	            "url" : "${contextPath}/dashboard/json"
	        },
	        "columns": [
	        	{data: "",
    				render: function (data, type, full, meta){
    					var username = full.username;
    					return " <button class = \"btn btn-default btn-sm\" onclick=\"deleteUser('"+ username + "')\" title=\"Delete User\"><i class=\"fa fa-trash\"></i></button>";
    				}
    			},
                {data: "username"	
                },
    			{data: "password"}
    		],
    		"fnDrawCallback" : function() {
				jQuery('#userTable_next').css({"float":"left"});//Ficed defect:Next button in new line
			}
		});	
	});
</script>

<script>
function addUser(){
	var successMsg = jQuery("#successMsg");
	var table = jQuery("#userTable").DataTable();
	var form = jQuery("#addUserForm");
	var username = jQuery("#username").val();
	var password = jQuery("#password").val();
	var password2 = jQuery("#password2").val();
	var errMsg = jQuery("#addErrorMsg");
	if (password != null && password == password2 && username != null){
		jQuery("button").attr("disabled","disabled");
		jQuery.ajax({
			type:"post",
			dataType:"text",
			url: form.attr("action"),
	        data: form.serialize(),
	        success: function(data) {
	        	jQuery("button").removeAttr("disabled");
	        	console.log(data);
	        	if(data == "1"){
	        		errMsg.hide();
	        		jQuery("#addModal").modal('hide');
	        		successMsg.show();
		        	successMsg.text("Add User successfully.");
		        	setTimeout('jQuery("#successMsg").hide()',1000);
	        		table.ajax.url('${contextPath}/dashboard/json').load();
	        	}else if (data=="0"){
	        		errMsg.show();
	        		errMsg.text("用户已存在，请尝试其他用户名");
	        	}
	        },
	        error: function() {
	        	errMsg.show();
	        	jQuery("button").removeAttr("disabled");
	        	errMsg.text("Server connection timed out, please try to sign in again.");
	        }
		})
	}
}

function deleteUser(username){
	var table = jQuery('#userTable').DataTable();
	var successMsg = jQuery("#successMsg");
	if (!confirm("是否删除用户?")) {
		return;
	}
	jQuery("button").attr("disabled","disabled");
	successMsg.show().html('<i class="fa fa-refresh fa-spin" style="font-size: 15px"></i><p>Please wait while system is processing</p>');
	jQuery.ajax({
        type: "post",
        dataType: "text",
        url: "${contextPath}/dashboard/deleteUser?username="+username,
        success: function(data) {
    		jQuery("button").removeAttr("disabled");
    		successMsg.hide();
        	if(data == "1"){
	        	table.ajax.url('${contextPath}/dashboard/json').load();
	        	successMsg.show();
	        	successMsg.text("Delete User successfully.");
        	}else if (data=="0"){
        		successMsg.show();
        		successMsg.text("Delete User failed, please try again later!");
        	}
        	setTimeout('jQuery("#successMsg").hide()',1000);
        },
        error: function() {
        	jQuery("button").removeAttr("disabled");
    		successMsg.hide();
            alert("Server connection timed out, please try again.");
        }
    });
}
</script>
