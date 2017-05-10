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
	 * Ham lay danh sach Room tu offset den noOfrecords
	 * 
	 * @param offset
	 * @param noOfRecords
	 * @return roomDAO.getListRoom(offset, noOfRecords)
	 * @throws Exception 
	 */
	public ArrayList<Room> getListRoom(int indexStart, int indexEnd) throws Exception {
		return roomDAO.getListRoom(indexStart, indexEnd);
	}

	/**
	 * Ham lay thong tin chi tiet cua 1 Room
	 * 
	 * @param roomID
	 * @return roomDAO.getRoomDetail(roomID)
	 * @throws Exception 
	 */
	public Room getRoomDetail(int roomID) throws Exception {
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
	 * @throws Exception 
	 */
	public void addRoom(String roomName, int roomSeats, String description, float priceHour, float priceFull,
			int status) throws Exception {
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
	 * @throws Exception 
	 */
	public void updateRoom(int roomID, String roomName, int roomSeats, String description, float priceHour,
			float priceFull, int status) throws Exception{
		// TODO Auto-generated method stub
		roomDAO.updateRoom(roomID, roomName, roomSeats, description, priceHour, priceFull, status);
	}

	/**
	 * Ham xoa 1 Room tu database
	 * 
	 * @param roomID
	 * @throws Exception 
	 */
	public void deleteRoom(int roomID) throws Exception {
		roomDAO.deleteRoom(roomID);
	}

	/**
	 * Ham kiem tra roomName da ton tai trong database hay chua.
	 * 
	 * @param roomName
	 * @return true neu roomName ton tai, false neu roomName khong ton tai
	 * @throws Exception 
	 */
	public boolean isDuplicateRoomName(String roomName) throws Exception {
		return roomDAO.isDuplicateRoomName(roomName);
	}

	/**
	 * Ham lay noOfRecords
	 * 
	 * @return roomDAO.getNoOfRecords()
	 */
	public int getNoOfRecords() {
		return roomDAO.getNoOfRecords();
	}

	
}
