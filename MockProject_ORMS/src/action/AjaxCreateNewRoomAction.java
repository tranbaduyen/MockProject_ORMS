/**
 * 
 */
package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AjaxCreateNewRoomForm;
import model.bo.RoomBO;

/**
 * @author admin
 *
 */
public class AjaxCreateNewRoomAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AjaxCreateNewRoomForm ajaxCreateNewRoomForm =(AjaxCreateNewRoomForm) form;
		String roomName = ajaxCreateNewRoomForm.getRoomName();
		String description = ajaxCreateNewRoomForm.getDescription();
		int roomSeats = ajaxCreateNewRoomForm.getRoomSeats();
		float priceHour = ajaxCreateNewRoomForm.getPriceHour();
		float priceFull = ajaxCreateNewRoomForm.getPriceFull();
		RoomBO roomBO = new RoomBO ();
		roomBO.addRoom(roomName, roomSeats, description, priceHour, priceFull,0);
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		out.println("Hello"+roomName);
		out.flush();
		return null;
	}
}
