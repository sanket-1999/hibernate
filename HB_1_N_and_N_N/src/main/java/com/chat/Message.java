package com.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGE")
public class Message {
	private long messageId;
	private String message;
	private Set<User> userList = new TreeSet<User>();
	private List<ChatRooms> chatRoomList = new ArrayList<ChatRooms>();
	public Message() {}
	public Message(String message) {
		this.message = message;	
	}
	public Message(String message,Set<User> userList, List<ChatRooms> chatRoomList) {
		this.message = message;
		this.userList=userList;
		this.chatRoomList = chatRoomList;
	}
	@Id
	@GeneratedValue
	public long getMessageId() {
		return messageId;
	}
	
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "MESSAGE_USER", 
				joinColumns = { @JoinColumn(name = "MESSAGE_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "USER_ID")})
	public Set<User> getUserList() {
		return userList;
	}
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "MESSAGE_CHATROOM", 
				joinColumns = { @JoinColumn(name = "MESSAGE_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "CHATROOM_ID")})
	public List<ChatRooms> getChatRoomList() {
		return chatRoomList;
	}
	public void setChatRoomList(List<ChatRooms> chatRoomList) {
		this.chatRoomList = chatRoomList;
	}
	
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + ", userList=" + userList + ", chatRoomList="
				+ chatRoomList + "]";
	}

}

