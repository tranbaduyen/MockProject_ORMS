<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>EditRoom</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/Validation.css"/>
    <script src="js/jquery-1.12.3.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/additional-methods.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/validation.js"></script>
    <link rel="stylesheet" href="css/quanlynhanvien.css"/> 
</head>
<body>
<div class="container">
	<div class= "menu-background">
		<div class="menu">
			<nav id="primary_nav_wrap">
				<ul>
					<li class="current-menu-item"><a href="#">Home</a></li>
					<li class="current-menu-item"><a href="#">Create order</a></li>
					<li class="current-menu-item"><a href="#">Partner Management</a></li>
					<li class="current-menu-item"><a href="#">Account Management</a></li>
					<li class="current-menu-item"><a href="room-list.do">Room Management</a></li>
					<li class="current-menu-item"><a href="#">Order Management</a></li>
					<li class="current-menu-item"><a href="#">Payment Management</a></li>
					<li class="current-menu-item"><a href="#">Report</a></li>
					<li class="current-menu-item"><a href="#">About</a></li>
				</ul>
			</nav>
		</div>
	</div>

    <div class="qlnv-title col-md-12" style="margin-bottom:15px;">
		<h4>UPDATE ROOM</h4>			
	</div>
	<html:form styleId="updateForm" action="/update-room.do" method="post" style="background-color:#f1ddcb;">
		<div class="row form-group">
		<div class="col-sm-6" >
			<html:hidden property="roomID" styleClass="form-control"></html:hidden>
			<div class="row form-group">
			    <label class="col-sm-3 require">RoomName</label>
			    <div class="col-sm-8">
			        <html:text styleId="txtRoomName" property="roomName" styleClass="form-control ui-dform-text" maxlength="50" errorStyleClass="errorT"
                errorKey="org.apache.struts.action.ERROR" tabindex="1" onfocus=""></html:text>
			        <span style="color:red;" ><html:errors  property="roomNameError" /></span>
			   	</div>
		    </div>
		    <div class="row form-group ">
		       	<label class="col-sm-3 require">RoomSeats</label>
		        <div class="col-sm-8">
					<html:text styleId="txtRoomSeats" property="roomSeats" styleClass="form-control ui-dform-text" errorStyleClass="errorT"
                errorKey="org.apache.struts.action.ERROR" tabindex="2">
					</html:text><span style="color:red;"><html:errors  property="roomSeatsError"/></span>
						
		        </div>
		    </div>
		    <div class="row form-group">
		        <label class="col-sm-3 require">Description</label>
		        <div class="col-sm-8">
		            <html:textarea styleId="txtDescription" property="description" styleClass="form-control ui-dform-text" rows="2" errorStyleClass="errorT"
                errorKey="org.apache.struts.action.ERROR" tabindex="3"></html:textarea>
		            <span style="color:red;"><html:errors  property="descriptionError"/></span>
		        </div>	            
		    </div>
		    <div class="row form-group">
		        <label class="col-sm-3 require">PriceHour</label>
		        <div class="col-sm-8">
					<html:text styleId="txtPriceHour" property="priceHour" styleClass="form-control ui-dform-text" errorStyleClass="errorT"
                errorKey="org.apache.struts.action.ERROR" tabindex="4"></html:text>
					<span style="color:red;"><html:errors  property="priceHourError"/></span>
		       	</div>
		    </div>
			<div class="row form-group">
		        <label class="col-sm-3 require">PriceFull</label>
		        <div class="col-sm-8" >
					<html:text styleId="txtPriceFull" property="priceFull" styleClass="form-control ui-dform-text" errorStyleClass="errorT"
                errorKey="org.apache.struts.action.ERROR" tabindex="5"></html:text>
					<span style="color:red;"><html:errors  property="priceFullError"/></span>
		        </div>
		    </div>
		</div>	           
        <div class="row form-group" style="margin-top:10px;">
            <div class="col-sm-12">
            	
	            <div class="col-sm-6">
	            	<div class="col-sm-3">
	            	</div>
	            	<div class="col-sm-8" style="padding-left:0px;padding-bottom:15px;">
	            		<html:submit styleId="btnSubmit" style="padding:6px 17px" styleClass="btn btn-danger" property="submit" value="Save"></html:submit>
		            	<button class="btn btn-primary" style="padding:6px 17px" onclick="history.go(-1);">Cancel</button>
	            	</div>	            	
	            </div>            	
            </div>
        </div>
        </div>
    </html:form>
    <br>
</div>
</body>
<script >
$(function() {
	  $("#txtRoomName").focus();
});
</script>
<script>
jQuery.extend(jQuery.expr[':'], {
    focusable: function (el, index, selector) {
        return $(el).is('a, button, :input, [tabindex]');
    }
});

$(document).on('keydown', ':focusable', function (e) {
    if (e.which == 13) {
        e.preventDefault();
        // Get all focusable elements on the page
        var $canfocus = $(':focusable');
        var index = $canfocus.index(this) + 1;
        if (index >= $canfocus.length) index = 0;
        $canfocus.eq(index).focus();
    }
});
</script>
<script language='javascript' type='text/javascript'>
function setFocus()
{
	$('#createForm').submit();
}
</script>
</html>

