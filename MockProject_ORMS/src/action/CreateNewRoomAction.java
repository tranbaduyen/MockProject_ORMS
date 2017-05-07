/**
 * 
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.ValidateData;
import form.RoomForm;
import model.bo.RoomBO;

/**
 * CreateNewRoomAction.java
 *
 * Version 1.0
 *
 * Date: 03-05-2017
 *
 * Copyright
 *
 * Modification Logs: 
 * DATE 			AUTHOR 		DESCRIPTION
 * -----------------------------------------------------------------------
 * 03-05-2017 		DuyenTB 	Create
 */
public class CreateNewRoomAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RoomForm roomForm = (RoomForm) form;
		RoomBO roomBO = new RoomBO();
		
		// Validate du lieu
		if ("Save".equals(roomForm.getSubmit())) {
			ActionErrors actionErrors = new ActionErrors();
			if (ValidateData.isEmpty(roomForm.getRoomName())) {
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.trong"));
			}
			if (roomBO.isDuplicateRoomName(roomForm.getRoomName())) {
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.trung"));
			}
			if (ValidateData.isAllNumber(roomForm.getRoomName())) {
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.so"));
			}
			if (ValidateData.isMaxlength50String(roomForm.getRoomName())) {
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.maxlength"));
			}
			if(ValidateData.isSpecialCharacters(roomForm.getRoomName().trim())){
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.kituDB"));
			}
			
			if (!ValidateData.isNumberOnly(roomForm.getRoomSeats())) {
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.chuoi"));
			}
			if (ValidateData.isEmpty(roomForm.getRoomSeats())) {
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.trong"));
			}
			if (ValidateData.isMoreThan500Seats(roomForm.getRoomSeats())) {
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.more500Seats"));
			}
			if (ValidateData.isNegative(roomForm.getRoomSeats())) {
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.negative"));
			}
			
			if (ValidateData.isEmpty(roomForm.getDescription())) {
				actionErrors.add("descriptionError", new ActionMessage("error.description.trong"));
			}
			if(ValidateData.isSpecialCharacters(roomForm.getDescription())){
				actionErrors.add("descriptionError", new ActionMessage("error.description.kituDB"));
			}

			if (ValidateData.isEmpty(roomForm.getPriceHour())) {
				actionErrors.add("priceHourError", new ActionMessage("error.priceHour.trong"));
			}
			if (ValidateData.isNegative(roomForm.getPriceHour())) {
				actionErrors.add("priceHourError", new ActionMessage("error.priceHour.negative"));
			}
			if (!ValidateData.isFloatNumber(roomForm.getPriceHour())) {
				actionErrors.add("priceHourError", new ActionMessage("error.priceHour.chuoi"));
			}
			
			if (ValidateData.isEmpty(roomForm.getPriceFull())) {
				actionErrors.add("priceFullError", new ActionMessage("error.priceFull.trong"));
			}
			if (ValidateData.isNegative(roomForm.getPriceFull())) {
				actionErrors.add("priceFullError", new ActionMessage("error.priceFull.negative"));
			}
			if (!ValidateData.isFloatNumber(roomForm.getPriceFull())) {
				actionErrors.add("priceFullError", new ActionMessage("error.priceFull.chuoi"));
			}
			
			saveErrors(request, actionErrors);
			
			if (actionErrors.size() > 0) {
				return mapping.findForward("createError");
			}
		}
		
		// nhan nut Save o trang Create New Room
		if ("Save".equals(roomForm.getSubmit())) { 
			String roomName = roomForm.getRoomName();
			int roomSeats = roomForm.getRoomSeats();
			String description = roomForm.getDescription();
			float priceHour = roomForm.getPriceHour();
			float priceFull = roomForm.getPriceFull();
			int status = 0;

			roomBO.addRoom(roomName, roomSeats, description, priceHour, priceFull, status);
			return mapping.findForward("createSuccess");
		} else { // chuyen sang trang Create New Room
			return mapping.findForward("create");
		}
	}
}
