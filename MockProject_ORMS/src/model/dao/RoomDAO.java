/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Room;

/**
 * RoomDAO.java
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
public class RoomDAO {
	DataAccess da = new DataAccess();
	Connection connection = null;
	Statement stmt = null;
	private int noOfRecords = 0;
	private int num = 0;

	/**
	 * Ham lay danh sach tat ca cac Room
	 * 
	 * @return list
	 * @throws Exception 
	 */
	public ArrayList<Room> getListRoom() throws Exception {
		connection = da.getConnect();
		String sql = "SELECT RoomID, RoomName, RoomSeats, Description, PriceHour, PriceFull, Status FROM  ROOM ";
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			throw new Exception("Error occur: "+ e.getMessage());
		}

		ArrayList<Room> list;
		list = new ArrayList<Room>();
		Room room;
		try {
			room = new Room();
			while (rs.next()) {
				room.setRoomID(rs.getInt("ROOMID"));
				room.setRoomName(rs.getString("ROOMNAME"));
				room.setRoomSeats(rs.getInt("ROOMSEATS"));
				room.setDescription(rs.getString("Description"));
				room.setPriceHour(rs.getFloat("PRICEHOUR"));
				room.setPriceFull(rs.getFloat("PRICEFULL"));
				room.setStatus(rs.getInt("STATUS"));
				list.add(room);
			}
		} catch (SQLException e) {;}
		return list;
	}

	/**
	 * Ham lay danh sach Room tu offset den noOfrecords
	 * 
	 * @param offset
	 * @param noOfRecords
	 * @return list
	 * @throws Exception 
	 */
	public ArrayList<Room> getListRoom(int offset, int noOfRecords) throws Exception {
		String sql = "SELECT RoomID, RoomName, RoomSeats, Description, PriceHour, PriceFull, Status " + " FROM ( SELECT r.*, ROW_NUMBER() over (ORDER BY roomName ) as ct from  ROOM r ) "
				+ "sub WHERE ( ct > " + offset + " AND ct <= " + noOfRecords + " ) ";
		System.out.println(sql);
		ArrayList<Room> list = null;
		list = new ArrayList<Room>();
		Room room = null;
		ResultSet rs = null;
		try {
			connection = da.getConnect();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			list = new ArrayList<Room>();
			room = new Room();
			while (rs.next()) {
				room = new Room();
				room.setRoomID(rs.getInt("ROOMID"));
				room.setRoomName(rs.getString("ROOMNAME"));
				room.setRoomSeats(rs.getInt("ROOMSEATS"));
				room.setDescription(rs.getString("Description"));
				room.setPriceHour(rs.getFloat("PRICEHOUR"));
				room.setPriceFull(rs.getFloat("PRICEFULL"));
				room.setStatus(rs.getInt("STATUS"));
				list.add(room);
			}
			rs.close();
			rs = stmt.executeQuery("select count(*) as num from ROOM");
			if (rs.next())
				this.noOfRecords = rs.getInt("num");
		}
		catch (SQLException e) {;}
		finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {;}
		}

		return list;
	}

	/**
	 * Ham lay thong tin chi tiet cua 1 Room
	 * 
	 * @param roomID
	 * @return room
	 * @throws Exception 
	 */
	public Room getRoomDetail(int roomID) throws Exception {
		connection = da.getConnect();
		String sql = String.format("SELECT RoomID, RoomName, RoomSeats, Description, PriceHour, PriceFull, Status " + " FROM ROOM WHERE ROOMID = %s", roomID);
		ResultSet rs = null;
		Room room =null;
		
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			room = new Room();
			while (rs.next()) {
				
				room.setRoomID(rs.getInt("ROOMID"));
				room.setRoomName(rs.getString("ROOMNAME"));
				room.setRoomSeats(rs.getInt("ROOMSEATS"));
				room.setDescription(rs.getString("DESCRIPTION"));
				room.setPriceHour(rs.getFloat("PRICEHOUR"));
				room.setPriceFull(rs.getFloat("PRICEFULL"));
				room.setStatus(rs.getInt("STATUS"));
			}
		}
		catch (SQLException e) {;}
		finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {;}
		}
		return room;
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
		connection = da.getConnect();
		String sql = String.format(
				"INSERT INTO ROOM(roomName,roomSeats,description,priceHour,priceFull,status) "
						+ " VALUES ( N'%s',%s,N'%s',%s,%s,%s )",
				roomName, roomSeats, description, priceHour, priceFull, status);
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		}
		catch (SQLException e) {;}
		finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {;}
		}
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
		connection = da.getConnect();
		String sql = String.format("UPDATE ROOM "
				+ " SET ROOMNAME = N'%s', ROOMSEATS = %s, DESCRIPTION = N'%s', PRICEHOUR = %s, PRICEFULL = %s, STATUS = 0 "
				+ " WHERE ROOMID = '%s'", roomName, roomSeats, description, priceHour, priceFull, roomID);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Ham xoa 1 Room tu database
	 * 
	 * @param roomID
	 * @throws Exception 
	 */
	public void deleteRoom(int roomID) throws Exception {
		connection = da.getConnect();
		String sql = String.format("DELETE FROM ROOM WHERE ROOMID = %s", roomID);
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Ham kiem tra roomName da ton tai trong database hay chua.
	 * 
	 * @param roomName
	 * @return true neu roomName ton tai, false neu roomName khong ton tai
	 * @throws Exception 
	 */
	public boolean isDuplicateRoomName(String roomName) throws Exception {
		connection = da.getConnect();
		String sql = String.format("SELECT count(RoomName) as num FROM ROOM WHERE roomName = N'%s'", roomName);
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				num = rs.getInt("num");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return (num != 0)?true:false;
	}

	/**
	 * Ham lay noOfRecords
	 * 
	 * @return the noOfRecords
	 */
	public int getNoOfRecords() {
		return noOfRecords;
	}

	/**
	 * Ham gan gia tri cho noOfRecords
	 * 
	 * @param noOfRecords
	 *            the noOfRecords to set
	 */
	public void setNoOfRecords(int noOfRecords) {
		this.noOfRecords = noOfRecords;
	}
}
