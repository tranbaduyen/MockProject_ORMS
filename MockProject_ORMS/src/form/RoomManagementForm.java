/**
 * 
 */
package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Room;

/**
 * @author HCD-Fresher204
 *
 */
public class RoomManagementForm extends ActionForm{
	private ArrayList<Room> listRoom;
	private int noOfPages;
	private int currentPage;
	private String submit;
	private String action;
	private ArrayList<Integer> listPage;
	
	public ArrayList<Room> getListRoom() {
		return listRoom;
	}
	public void setListRoom(ArrayList<Room> listRoom) {
		this.listRoom = listRoom;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ArrayList<Integer> getListPage() {
		return listPage;
	}
	public void setListPage(ArrayList<Integer> listPage) {
		this.listPage = listPage;
	}
	
}
