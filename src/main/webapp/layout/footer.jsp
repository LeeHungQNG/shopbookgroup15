<%@ page pageEncoding="utf-8"%>
<%@page import="dao.CartDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Chân trang</title>
</head>
<style>
</style>
<body>
	<!-- Bắt đầu phần liên hệ -->
	
	<!-- Xong phần liên hệ -->

	<!-- Bắt đầu chân trang -->
	    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.html"><img src="img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: 60-49 Road 11378 New York</li>
                            <li>Phone: +65 11.188.888</li>
                            <li>Email: hello@colorlib.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Useful Links</h6>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">About Our Shop</a></li>
                            <li><a href="#">Secure Shopping</a></li>
                            <li><a href="#">Delivery infomation</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Our Sitemap</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Who We Are</a></li>
                            <li><a href="#">Our Services</a></li>
                            <li><a href="#">Projects</a></li>
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">Innovation</a></li>
                            <li><a href="#">Testimonials</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Join Our Newsletter Now</h6>
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
	<!-- Xong phần chân trang -->
  <script src="viewroot/js/jquery-3.3.1.min.js"></script>
    <script src="viewroot/js/bootstrap.min.js"></script>
    <script src="viewroot/js/jquery.nice-select.min.js"></script>
    <script src="viewroot/js/jquery-ui.min.js"></script>
    <script src="viewroot/js/jquery.slicknav.js"></script>
    <script src="viewroot/js/mixitup.min.js"></script>
    <script src="viewroot/js/owl.carousel.min.js"></script>
    <script src="viewroot/js/main.js"></script>
   <script type="text/javascript">
   function addProductToCart(id) {
var url="HomeCartServlet?status=add&id_product="+id;
		$.ajax({
			url : url,
			type : "get",
			success : function(response) {
				console.log(response);
		           var count= $("#count").text();
		           var a = parseInt(count); 
			    var carts=a+1;
			    $("#count").html(""+carts+"");
				alert("Thêm vào giỏ hành thành công" +count);
			},
			error : function(xhr) {
				console.log("ERROR: ", e);
			}
		});
	};
</script>
    <script type="text/javascript">
        function loadDistrict(id) {
            $.ajax({
    			url :  "HomeCheckoutServlet?status=district&id_province=" + id + "",
    			type : "get",
    			success : function(response) {
    				$('#district').html(response);
    		        
    			},
    			error : function(xhr) {
    				console.log("ERROR: ", e);
    			}
    		});
         
        }
        function load_town_ward(id) {
        	 $.ajax({
     			url :  "HomeCheckoutServlet?status=town_ward&id_dictricst=" + id + "",
     			type : "get",
     			success : function(response) {
     				$('#town_ward').html(response);
     		        
     			},
     			error : function(xhr) {
     				console.log("ERROR: ", e);
     			}
     		});
        }orderBook
        function load_village(id) {
       	 $.ajax({
    			url :  "HomeCheckoutServlet?status=village&id_ward=" + id + "",
    			type : "get",
    			success : function(response) {
    				$('#village').html(response);
    		        
    			},
    			error : function(xhr) {
    				console.log("ERROR: ", e);
    			}
    		});
       }
        function orderBook() {
          	 $.ajax({
       			url :  "HomeBillServlet?status=addbill",
       			type : "get",
       			success : function(response) {
       				alert("Bạn đã Thành Toán Thành công !XIn mời sử dụng dịch vụ");       		        
       			},
       			error : function(xhr) {
       				console.log("ERROR: ", e);
       			}
       		});
          }
        

        //Xự kiện chỉ nhập số
        function keyPhone(e) {
            var keyword = null;
            if (window.event) {
                keyword = window.event.keyCode;
            } else {
                keyword = e.which;
            }

            if (keyword<48 || keyword>57) {
                if (keyword == 8 || keyword == 48 || keyword == 127) {
                    return true;
                }
                return false;
            }
        }
    </script>
<script>
		$(document).ready(function() {
			var readURL = function(input) {
				if (input.files && input.files[0]) {
					var reader = new FileReader();
					reader.onload = function(e) {
						$('.avatar').attr('src', e.target.result);
					}
					reader.readAsDataURL(input.files[0]);
				}
			}
			var fileValidation = function() {
				var fileInput = document.getElementById('file-up-avatar');
				var filePath = fileInput.value;//lấy giá trị input theo id
				var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;//các tập tin cho phép
				//Kiểm tra định dạng
				if (!allowedExtensions.exec(filePath)) {
					swal({
						type : 'error',
						title : 'Rất tiết...',
						text : 'Tệp tải lên có định dạng không được hổ trợ!',
					});

					fileInput.value = '';
					return false;
				}
			}
			$(".file-upload").on('change', function() {
				fileValidation();
				readURL(this);
			});
		});
		
	</script>
	<script type="text/javascript">
	function updatepass(){
		
		alert("vui lòng không để trống ")

		var pass=$('#pass-old).val();
		var pass_new=$('#pass_new).val();
		var pass_confirm=$('#pass_confirm).val();
		if(pass==null || pass_new==null && pass_confirm==null){
			alert("vui lòng không để trống ")
			return ;
		}
		if(pass_new!=pass_confirm){
			alert("Mật khẩu không trùng khớp")
			return ;

		}
	}
	</script>
</body>
</html>