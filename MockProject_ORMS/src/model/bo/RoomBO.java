/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.Room;
import model.dao.RoomDAO;

/**
 * RoomBO.java
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
public class RoomBO {
	RoomDAO roomDAO = new RoomDAO();

	/**
	 * Ham lay danh sach tat ca cac Room
	 * 
	 * @return
	 */
	public ArrayList<Room> getListRoom() {
		return roomDAO.getListRoom();
	}

	/**
	 * Ham lay danh sach Room tu offset den noOfrecords
	 * 
	 * @param offset
	 * @param noOfRecords
	 * @return
	 */
	public ArrayList<Room> getListRoom(int offset, int noOfRecords) {
		return roomDAO.getListRoom(offset, noOfRecords);
	}

	/**
	 * Ham lay thong tin chi tiet cua 1 Room
	 * 
	 * @param roomID
	 * @return
	 */
	public Room getRoomDetail(int roomID) {
		return roomDAO.getRoomDetail(roomID);
	}

	/**
	 * Ham them moi 1 Room vao database
	 * 
	 * @param roomName
	 * @param roomSeats
	 * @param description
	 * @param priceHour
	 * @param priceFull
	 * @param status
	 */
	public void addRoom(String roomName, int roomSeats, String description, float priceHour, float priceFull,
			int status) {
		// TODO Auto-generated method stub
		roomDAO.addRoom(roomName, roomSeats, description, priceHour, priceFull, status);
	}

	/**
	 * Ham cap nhat thong tin 1 Room vao database
	 * 
	 * @param roomID
	 * @param roomName
	 * @param roomSeats
	 * @param description
	 * @param priceHour
	 * @param priceFull
	 * @param status
	 */
	public void updateRoom(int roomID, String roomName, int roomSeats, String description, float priceHour,
			float priceFull, int status) {
		// TODO Auto-generated method stub
		roomDAO.updateRoom(roomID, roomName, roomSeats, description, priceHour, priceFull, status);
	}

	/**
	 * Ham xoa 1 Room tu database
	 * 
	 * @param roomID
	 */
	public void deleteRoom(int roomID) {
		roomDAO.deleteRoom(roomID);
	}

	/**
	 * Ham kiem tra roomName da ton tai trong database hay chua.
	 * 
	 * @param roomName
	 * @return true neu roomName ton tai, false neu roomName khong ton tai
	 */
	public boolean isDuplicateRoomName(String roomName) {
		return roomDAO.isDuplicateRoomName(roomName);
	}
}
