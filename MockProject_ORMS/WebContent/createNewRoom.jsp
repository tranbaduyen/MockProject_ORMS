<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>CreateRoom</title>
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
		<h4>+ CREATE NEW ROOM</h4>			
	</div>
	<html:form styleId="createForm" action="/create-room.do" method="post" style="background-color:#f1ddcb;">
		<div class="row form-group">
			<div class="col-sm-6" >
				<bean:define id="errorFirst" name="roomForm" property="errorFirst"></bean:define>
				<html:hidden styleId="errorFirst" property="errorFirst" styleClass="form-control"></html:hidden>
		        <table id="table-products">
		        <tbody>
		        	<tr>
		        		<td>
		        			<html:text styleId="txtRoomName" property="roomName" styleClass="form-control ui-dform-text" maxlength="50" tabindex="1" onfocus="" ></html:text>
		        		</td>
		        		<td>
		        			<html:text styleId="txtRoomSeats" property="roomSeats" styleClass="form-control ui-dform-text" tabindex="2" maxlength="4">
						</html:text>
		        		</td>
		        		<td>
		        			<html:textarea styleId="txtDescription" property="description" styleClass="form-control ui-dform-text" rows="2" tabindex="3" ></html:textarea>
		        		</td>
		        		<td>
		        			<html:text styleId="txtPriceHour" property="priceHour" styleClass="form-control ui-dform-text"  tabindex="4" maxlength="11"></html:text>
		        		</td>
		        		<td>
		        			<html:text styleId="txtPriceFull" property="priceFull" styleClass="form-control ui-dform-text"  tabindex="5" maxlength="11"></html:text>
		        		</td>	
		        	</tr>
		        	<tr>
		        		<td>
		        			<html:text styleId="txtRoomName" property="roomName" styleClass="form-control ui-dform-text" maxlength="50" tabindex="1" onfocus="" ></html:text>
		        		</td>
		        		<td>
		        			<html:text styleId="txtRoomSeats" property="roomSeats" styleClass="form-control ui-dform-text" tabindex="2" maxlength="4">
						</html:text>
		        		</td>
		        		<td>
		        			<html:textarea styleId="txtDescription" property="description" styleClass="form-control ui-dform-text" rows="2" tabindex="3" ></html:textarea>
		        		</td>
		        		<td>
		        			<html:text styleId="txtPriceHour" property="priceHour" styleClass="form-control ui-dform-text"  tabindex="4" maxlength="11"></html:text>
		        		</td>
		        		<td>
		        			<html:text styleId="txtPriceFull" property="priceFull" styleClass="form-control ui-dform-text"  tabindex="5" maxlength="11"></html:text>
		        		</td>	
		        	</tr>
		        </tbody>
		        </table>
			</div>	
		</div>                
        <div class="row form-group" style="margin-top:10px;">
            <div class="col-sm-12">
            	
	            <div class="col-sm-6">
	            	<div class="col-sm-3">
	            	</div>
	            	<div class="col-sm-8" style="padding-left:0px;padding-bottom:15px;">
	            		<html:submit styleId="btnSubmit" style="padding:6px 17px" styleClass="btn btn-danger" tabindex="6" property="submit" value="Save" onfocus="setFocus();"></html:submit>
		            	<button class="btn btn-primary" style="padding:6px 17px" tabindex="7" onclick="history.go(-1);">Cancel</button>
	            	</div>	            	
	            </div>            	
            </div>
        </div>
		
    </html:form>
	
    <br>
</div>
</body>
<script>
$('#btnSubmit').click(function () {
	var rowCount = $('#table-products >tbody tr').length;
	if(rowCount == 0){
		alert("Giỏ hàng trống");
			return false;	
		}else{
			alert("rowCount:"+rowCount);
			for(i=1; i <= rowCount; i++){
			 	var roomName = $(this).closest('tr').find('td:eq(0)').find('input').val()
			 	alert(roomName);
                var roomSeats = $("table").find("tr").eq(i).find("td").find("input").eq(1).val();
                var roomSeats = $("table").find("tr").eq(i).find("td").find("input").eq(2).val();
                var priceHour = $("table").find("tr").eq(i).find("td").find("input").eq(3).val();
                var priceFull = $("table").find("tr").eq(i).find("td").find("input").eq(4).val();
		
				alert("roomName:"+roomName + ",roomSeats: " + roomSeats + ",description:" + description +",priceHour:"+ priceHour +",priceFull:"+ priceFull);
				doAjaxPost(roomName, roomSeats, description, priceHour, priceFull);
			}      
		}
});
function doAjaxPost(roomName, roomSeats, description, priceHour, priceFull) {
 	alert(roomName);
    $.ajax({
        type: "POST",
        url: "ajaxCreateNewRoom.do",
        data: {roomName: roomName, roomSeats: roomSeats, description: description, priceHour: priceHour, priceFull: priceFull},
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(response){  
          
        },
        error: function(e){
            alert('Error: ' + e);
        }
    });
} 
</script>
<script >
$(function() {
	  $("#txtRoomName").focus();
	  var errorFirst = ${errorFirst};
	  switch (errorFirst) {
		case 1:
			break;
		case 2:
			$("#txtRoomName").blur();
			$("#txtRoomSeats").focus();
			break;
		case 3:
			$("#txtRoomName").blur();
			$("#txtDescription").focus();
			break;
		case 4:
			$("#txtRoomName").blur();
			$("#txtPriceHour").focus();
			break;
		case 5:
			$("#txtRoomName").blur();
			$("#txtPriceFull").focus();
			break;
		}
	  
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

