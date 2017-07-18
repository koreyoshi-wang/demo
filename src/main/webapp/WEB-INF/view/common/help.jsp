<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
.banner:hover .tb-arrow a {
    opacity: 1;
}
.tb-arrow a{
    width: 64px;
    height: 64px;
    opacity: 0;
}
.tb-arrow a.prev {
    background: url(images/icon-prev.png) no-repeat;
}
.tb-arrow a.next {
    background: url(images/icon-next.png) no-repeat;
}
.tb-btn a {
	background-color:red;
}

.banner{
	width: 932px;height: 400px;
}

</style>
<!-- 模态框（Modal） -->
<div class="modal fade" id="helpModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:886px">
    	<div class="modal-header">
    		<div style="top: 9%; left: 97%; position: absolute; z-index:999;">
    			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    		</div>
        </div>
        <div class="modal-content" id="helpWizard">
            <div class="tab-content">
               <div class="banner">
				    <ul style="margin-left:-63px;">
				        <li style="list-style-type:none;"><img src="${contextPath}/images/step1.PNG"></li>
				        <li style="list-style-type:none;"><img src="${contextPath}/images/step2.PNG"></li>
				        <li style="list-style-type:none;"><img src="${contextPath}/images/step3.PNG"></li>
				        <li style="list-style-type:none;"><img src="${contextPath}/images/step4.PNG"></li>
				        <li style="list-style-type:none;"><img src="${contextPath}/images/step5.PNG"></li>
				    </ul>
				</div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<script type="text/javascript" src="${contextPath}/js/jquery.terseBanner.min.js"></script>

<script>
jQuery(document).ready(function (){
	jQuery('.banner').terseBanner({
	    arrow: true,
	    auto:0,
	    before: function ($banner, $item, currentIndex) {
	    	if (currentIndex == 0) {
	    		jQuery('.prev').css({display:"none"});
	    	} else {
	    		jQuery('.prev').css({display:"block"});
	    	}
	    	if (currentIndex == 4) {
	    		jQuery('.next').css({display:"none"});
	    	} else {
	    		jQuery('.next').css({display:"block"});
	    	}
	    },
	    after: function ($banner, $item, currentIndex) {
	        if (currentIndex == 0) {
	    		jQuery('.prev').css({display:"none"});
	    	} else {
	    		jQuery('.prev').css({display:"block"});
	    	}
	    	if (currentIndex == 4) {
	    		jQuery('.next').css({display:"none"});
	    	} else {
	    		jQuery('.next').css({display:"block"});
	    	}
	    }
	});
 });
</script>
