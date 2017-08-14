package demo.entity;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "user")
public class User {
	private Long id;
	private String userName;
	private String password;
	private String passwordConfirm;
	private List<Role> roles;

//	public User(String string, String string2, String string3, List<GrantedAuthority> authorities) {
//		// TODO Auto-generated constructor stub
//	}
//	public User(String userName, String password, String passwordConfirm,List<GrantedAuthority> authorities) {
//		this.setUserName(userName);
//		this.password = password;
//		this.passwordConfirm = passwordConfirm;
//		this.roles = roles;
//	}
	
	   private List<GrantedAuthority> buildUserAuthority(String role) {
	        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	        setAuths.add(new SimpleGrantedAuthority(role));
	        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(
	                setAuths);
	        return result;
	    }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
