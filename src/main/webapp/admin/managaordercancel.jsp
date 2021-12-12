<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="layout/head.jsp"></jsp:include>

</head>
<body>
	<div id="main-wrapper">
		<!-- Thêm phần tiêu đề trang -->
		<jsp:include page="layout/header.jsp"></jsp:include>
		<!-- Xong phần tiêu đề trang -->
		<div class="content-body">
			<div class="container-fluid">
				<div class="row page-titles mx-0">
					<div class="col-sm-6 p-md-0">
						<div class="welcome-text">
							<h4>Xin chào bạn</h4>
							<span class="ml-1">Đơn Đặt Hàng</span>
						</div>
					</div>
					<div
						class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="javascript:void(0)">Quản trị</a></li>
							<li class="breadcrumb-item active"><a
								href="javascript:void(0)">Đơn Hàng</a></li>
						</ol>
					</div>
				</div>
				<!-- row -->


				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Datatable</h4>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table id="datatable-order" class="display"
										style="width: 100%;color: black; font-size: 13px">
										<thead>
											<tr>
												<th>stt</th>
												<th>Người nhận</th>
												<th>Địa chỉ</th>
												<th>Thành phố</th>
												<th>SDT</th>
												<th>Email</th>
												<th>Ghi chú</th>
												<th>Thời gian</th>
												<th>Trạng thái</th>
												<th>Tổng tiền</th>
												<th>#</th>
												<th>#</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Thêm chân trang -->
		<jsp:include page="layout/footer.jsp"></jsp:include>
		<!-- Xong thêm chân trang -->

	</div>
		<script type="text/javascript">
    	var jsonOrder=<%=request.getAttribute("jsonOrderCancel")%>;
    	$('#datatable-order').DataTable({
    	    data: jsonOrder,
    	    columns: [
    	    	 { data: 'id' },
     	        { data: 'nameRecevie' },
     	        { data: 'numberHouse' },
     	        { data: 'address' },
     	        { data: 'numberPhone' },
     	        { data: 'email' },
     	        { data: 'note' },
     	        { data: 'datePay' },
     	        { data: 'total' },
    	        
    	        	  
    	       { data: 'id',
        	        	render: function(data){
        	        		return     "<button type='button' class='btn btn-sm btn-primary' onclick='transport("+data+")'>Vận Chuyển</button>";
        	        	}},
        	         	  
        	    { data: 'id',
        	        	 render: function(data){
        	        	        		return     "<button type='button' class='btn btn-sm btn-primary' onclick='cancelOrder("+data+")'>Xóa</button>";
        	        }},
        	        	
    	    ],
    	    "pageLength": 15
    	});
    	function transport(id){
			if(confirm("Bạn muốn vận chuyển đơn hàng này này"))
    		$.ajax({
    			url:"AdminOrderController?id="+id,
    			type:'GET',
    			success: function (reponse){
    				console.log(reponse);
    				alert("Đã vận chuyện thành công  thành công ");
    				window.location.href="AdminManageOrderController";
    			}
    		
    		})
    	}
    	function cancelOrder(id){
			if(confirm("Bạn muốn hủy đơn hàng này"))
    		$.ajax({
    			url:"AdminOrderController?idD="+id,
    			type:'GET',
    			data:id,
    			success: function (reponse){
    				console.log(reponse);
    				alert("Đã Hủy thành công ");
    				window.location.href="AdminManageOrderController";			}
    		})
    		
    	}
      
    </script>
	
</body>
</html>