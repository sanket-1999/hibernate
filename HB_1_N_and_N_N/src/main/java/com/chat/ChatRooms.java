
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
@Table(name="CHATROOMS")
public class ChatRooms {
	private long chatRoomId;
	private String chatRoomName;
	private List<Message> messages = new ArrayList<Message>();
	private Set<User> userList = new TreeSet<User>();
	public ChatRooms() {}
	public ChatRooms(String chatRoomName) {
		this.chatRoomName = chatRoomName;	
	}
	public ChatRooms(String chatRoomName, List<Message> messages) {
		this.chatRoomName = chatRoomName;
		this.messages = messages;
	}
	public ChatRooms(String chatRoomName,Set<User> userList) {
		this.chatRoomName = chatRoomName;
		this.userList = userList;
	}
	
	public ChatRooms(String chatRoomName, List<Message> messages, Set<User> userList) {
		this.chatRoomName = chatRoomName;
		this.messages = messages;
		this.userList = userList;
	}
	@Id
	@GeneratedValue
	@Column(name="CHATROOM_ID")
	public long getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(long chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	@Column(name="CHATROOM_NAME", nullable=false)
	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CHATROOM_MESSAGE", 
				joinColumns = { @JoinColumn(name = "CHATROOM_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "MESSAGE_ID")  })
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CHATROOM_USER", 
				joinColumns = { @JoinColumn(name = "CHATROOM_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "USER_ID")})
	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "ChatRooms [chatRoomId=" + chatRoomId + ", chatRoomName=" + chatRoomName + "]";
	}
	


	

}
