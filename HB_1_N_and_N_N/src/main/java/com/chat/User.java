package com.chat;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="USER")
public class User {
	private long userId;
	private String userName;
	private String password;
	
	private List<Message> messages = new ArrayList<Message>();
	private List<ChatRooms> chatRoomList = new ArrayList<ChatRooms>();
	public User() {}
	
	public User(String userName, String password) {
		this.userName = userName;	
		this.password=password;
	}
	public User(String userName, List<Message> messages, List<ChatRooms> chatRoomList) {
		this.userName = userName;
		this.messages = messages;
		this.chatRoomList = chatRoomList;
	}
	@Id
	@GeneratedValue
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_MESSAGE", 
				joinColumns = { @JoinColumn(name = "USER_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "MESSAGE_ID")})
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_CHATROOM", 
				joinColumns = { @JoinColumn(name = "USER_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "CHATROOM_ID")})
	public List<ChatRooms> getChatRoomList() {
		return chatRoomList;
	}
	public void setChatRoomList(List<ChatRooms> chatRoomList) {
		this.chatRoomList = chatRoomList;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", messages=" + messages + ", chatRoomList="
				+ chatRoomList + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
