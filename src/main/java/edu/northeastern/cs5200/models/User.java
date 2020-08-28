package edu.northeastern.cs5200.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String phone;
	private String userDtype;
	
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

//    @Transient
//    private List<UserRole> userRoles;

    @Transient
    private Address address;
	
	public User() {}
	
	public User(String firstName, String lastName, String password, String email, String phone, String userDtype) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.userDtype = userDtype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
//
//	@Override
//    public String toString() {
//        return "ExceptionOutput{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", password=" + password +
//                ", phone=" + phone + 
//                ",email="+ email +
//                '}';
//    }
	
	
	

	public String getUserDtype() {
		return userDtype;
	}

	public void setUserDtype(String userDtype) {
		this.userDtype = userDtype;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

//	public List<UserRole> getUserRoles() {
//		return userRoles;
//	}
//
//	public void setUserRoles(List<UserRole> userRoles) {
//		this.userRoles = userRoles;
//	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
	

}
