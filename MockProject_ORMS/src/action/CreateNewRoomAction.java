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

import common.StringProcess;
import form.RoomForm;
import model.bo.RoomBO;

/**
 * @author HCD-Fresher204
 *
 */
public class CreateNewRoomAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RoomForm roomForm = (RoomForm) form;
		RoomBO roomBO = new RoomBO();
		//validate du lieu
		if("submit".equals(roomForm.getSubmit())){
			ActionErrors actionErrors = new ActionErrors();
			if(StringProcess.isEmpty(roomForm.getRoomName())){
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.trong"));
			}
			if(roomBO.isDuplicateRoomName(roomForm.getRoomName())){
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.trung"));
			}
			if(StringProcess.isAllNumber(roomForm.getRoomName())){
				actionErrors.add("roomNameError", new ActionMessage("error.roomName.so"));
			}
			
			if(!StringProcess.isNumberOnly(String.valueOf(roomForm.getRoomSeats()))){
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.chuoi"));
			}
			if(StringProcess.isEmpty(roomForm.getRoomSeats())){
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.trong"));
			}
			if(StringProcess.isMoreThan500Seats(roomForm.getRoomSeats())){
				actionErrors.add("roomSeatsError", new ActionMessage("error.roomSeats.more500Seats"));
			}
			System.out.println("Str = "+String.valueOf(roomForm.getRoomSeats()) + " + " + StringProcess.isNumberOnly(String.valueOf(roomForm.getRoomSeats())));
			
			
			if(StringProcess.isEmpty(roomForm.getDescription())){
				actionErrors.add("descriptionError", new ActionMessage("error.description.trong"));
			}
			
			if(StringProcess.isEmpty(roomForm.getPriceHour())){
				actionErrors.add("priceHourError", new ActionMessage("error.priceHour.trong"));
			}
			if(StringProcess.isEmpty(roomForm.getPriceFull())){
				actionErrors.add("priceFullError", new ActionMessage("error.priceFull.trong"));
			}
				saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("createError");
			}
		}
		if("submit".equals(roomForm.getSubmit())){		//nhan nut Submit o trang Create New Room
			String roomName = roomForm.getRoomName();
			int roomSeats = roomForm.getRoomSeats();
			String description= roomForm.getDescription();
			float priceHour = roomForm.getPriceHour();
			float priceFull = roomForm.getPriceFull();
			int status = 0;
			
			roomBO.addRoom(roomName, roomSeats, description, priceHour, priceFull, status);
			return mapping.findForward("createSuccess");
		} else {											//chuyen sang trang Create New Room
			return mapping.findForward("create");
		}
	}
}
