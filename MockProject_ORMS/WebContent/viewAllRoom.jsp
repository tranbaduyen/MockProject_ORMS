<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>RoomManagement</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link href="css/dataTables.bootstrap.css" rel="stylesheet">
		<link href="css/dataTables.responsive.css" rel="stylesheet">
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/quanlynhanvien.css" />
		<script src="js/jquery-1.12.3.js"></script>
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="js/dataTables.responsive.min.js"></script>
		<script src="js/dataTables.bootstrap.js"></script>
	</head>
	<body>
		<div class="container" style="background-color: #f1ddcb; padding-right: 0px;padding-left: 0px;">
			<div class= "menu-background">
						<div class="menu">
							<nav id="primary_nav_wrap">
								<ul>
									<li class="current-menu-item" ><a href="#" >Home</a></li>
									<li class="current-menu-item"><a href="#">Create order</a></li>
									<li class="current-menu-item"><a href="#">Partner Management</a></li>
									<li class="current-menu-item"><a href="#">Account Management</a></li>
									<li class="current-menu-item"><a href="#">Room Management</a></li>
									<li class="current-menu-item"><a href="#">Order Management</a></li>
									<li class="current-menu-item"><a href="#">Payment Management</a></li>
									<li class="current-menu-item"><a href="#">Report</a></li>
									<li class="current-menu-item"><a href="#">About</a></li>
								</ul>
							</nav>
						</div>
			</div>
			<div style="background-color:#eccdb1;">
				<table>
					<tr >
						<td style="padding-left:5px">
							<label style="color:#5b656d">Room Name:</label>
						</td>
						<td style="padding:5px">
							<input type="text" name="roomName" class="form-control"  />
						</td>
						<td style="padding-right:5px">
							<button type="button" class="btn btn-info">Load Records</button>
						</td>
						<td style="padding-right:5px">
							<button type="button" class="btn btn-info">Export to Excel</button>
						</td>
						<td style="float:right;margin: 10px 0px 10px 480px;">
							<html:link styleClass="btn btn-danger" action="/create-room">Add a New Room</html:link>
						</td>
					</tr>
				</table>
			</div>
			<div class="qlnv-title ">
				<p style="padding: 5px">THE ROOM LIST</p>
			</div>
			<div>
				<table id="example" class="table table-striped table-bordered" style="border: 1px solid;">
					<thead class="headerTable">
						<tr>
							<td>RoomName</td>
							<td>RoomSeats</td>
							<td>Description</td>
							<td>PriceHour</td>
							<td>PriceFull</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<logic:iterate name="roomManagementForm" property="listRoom" id="ro">
			            	<tr>
				                <td scope="row">
				                	<bean:write name="ro" property="roomName"/>
								</td>
				                <td>
				                	<bean:write name="ro" property="roomSeats"/>
				                </td>
				                <td>
				                	<bean:write name="ro" property="description"/>
								</td>
				                <td>
				                	<bean:write name="ro" property="priceHour"/>
				                </td>
				                <td>
				                	<bean:write name="ro" property="priceFull"/>
				                </td>
				                <td>
				                	<bean:define id="roomID" name="ro" property="roomID"></bean:define>
				                	<html:link action="/update-room?roomID=${roomID}">
				                		<span  class="glyphicon glyphicon-edit iconEdit"></span>
				                	</html:link>
				                	<html:link action="/delete-room?roomID=${roomID}" style="margin-left: 30px;" onclick="return confirm('This record will be deleted. Are you sure?');">
				                		<span  class="glyphicon glyphicon-remove iconDelete"></span>
				                	</html:link>
				                </td>
			            	</tr>
			            </logic:iterate>
					</tbody>
				</table>
			    <div style="">
			    	<ul class = "pagination" style="margin-left: 40%;">
						<bean:define id="currentPage" name="roomManagementForm" property="currentPage"></bean:define>
			    		<p id="activeCP" hidden>${currentPage}</p>
			    		<c:if test="${currentPage != 1}">
			    			<li><html:link styleClass="linkPag" href="room-list.do?page=${currentPage-1}" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;">« Previous Page</html:link></li>
			            </c:if>
			            <logic:iterate name="roomManagementForm" property="listPage" id="pag">
			            	<li class="${pag}"><html:link styleClass="${pag}" href="room-list.do?page=${pag}" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;"><bean:write name="pag"/></html:link></li>
			            </logic:iterate>
			            <bean:define id="noOfPages" name="roomManagementForm" property="noOfPages"></bean:define>
			            <c:if test="${currentPage < noOfPages}">
			                <li><html:link styleClass="linkPag" href="room-list.do?page=${currentPage+1}" style="color: #ffffff;margin-left: 3px;background-color: #8fc6ff;border-radius: 4px;">Next Page »</html:link></li>
			            </c:if>
			            
			        </ul>
			    </div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable( {
				"bPaginate" : false,
				"bSort":true,
				"bFilter" : false,
				"bInfo" : true,
				"paging" : false,
				"bLengthChange" : false,
				"pagingType" : "simple_numbers",
				"iDisplayLength": 10
			});
	
		});
	</script>
	<script type="text/javascript">
		$(".iconEdit").hover(function() {
	        $(this).css('cursor','pointer').attr('title', 'Edit Room');
	    }, function() {
	        $(this).css('cursor','auto');
	    });
		$(".iconDelete").hover(function() {
	        $(this).css('cursor','pointer').attr('title', 'Delete Room');
	    }, function() {
	        $(this).css('cursor','auto');
	    });
		var activeCP = $("#activeCP").text();
		$("."+activeCP+"").addClass('active');
		$("."+activeCP+"").css('background-color','#337ab7');
	</script>​
</html>
