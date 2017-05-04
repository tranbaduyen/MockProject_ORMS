/**
 * 
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.RoomForm;
import model.bean.Room;
import model.bo.RoomBO;

/**
 * @author HCD-Fresher204
 *
 */
public class UpdateRoomAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RoomForm roomForm = (RoomForm) form;
		RoomBO roomBO = new RoomBO();
		//update Room
		int roomID = roomForm.getRoomID();
		if("submit".equals(roomForm.getSubmit())){					
			String roomName= roomForm.getRoomName();
			String description = roomForm.getDescription();
			int roomSeats = roomForm.getRoomSeats();
			float priceHour = roomForm.getPriceHour();
			float priceFull = roomForm.getPriceFull();
			int status = 0;
		
			roomBO.updateRoom(roomID, roomName, roomSeats, description, priceHour, priceFull, status);
			return mapping.findForward("updateSuccess");
		} else {														

			Room room = roomBO.getRoomDetail(roomID);
			roomForm.setRoomName(room.getRoomName());
			roomForm.setRoomSeats(room.getRoomSeats());
			roomForm.setDescription(room.getDescription());
			roomForm.setPriceHour(room.getPriceHour());
			roomForm.setPriceFull(room.getPriceFull());
			return mapping.findForward("update");
		}
		
	}
}
