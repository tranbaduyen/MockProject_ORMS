/**
 * 
 */
package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Room;

/**
 * RoomManagementForm.java
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
public class RoomManagementForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Room> listRoom;
	private int noOfPages;
	private int currentPage;
	private String submit;
	private String action;
	private ArrayList<Integer> listPage;

	/**
	 * @return
	 */
	public ArrayList<Room> getListRoom() {
		return listRoom;
	}

	/**
	 * @param listRoom
	 */
	public void setListRoom(ArrayList<Room> listRoom) {
		this.listRoom = listRoom;
	}

	/**
	 * @return
	 */
	public String getSubmit() {
		return submit;
	}

	/**
	 * @param submit
	 */
	public void setSubmit(String submit) {
		this.submit = submit;
	}

	/**
	 * @return
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return
	 */
	public int getNoOfPages() {
		return noOfPages;
	}

	/**
	 * @param noOfPages
	 */
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	/**
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return
	 */
	public ArrayList<Integer> getListPage() {
		return listPage;
	}

	/**
	 * @param listPage
	 */
	public void setListPage(ArrayList<Integer> listPage) {
		this.listPage = listPage;
	}

}
