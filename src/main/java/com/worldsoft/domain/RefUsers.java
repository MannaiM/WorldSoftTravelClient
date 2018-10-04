package com.worldsoft.domain;
// Generated 31 mars 2016 10:57:06 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RefUsers generated by hbm2java
 */
@Entity
@Table(name = "REF_USERS")
public class RefUsers implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idUsers;
	private Role role;
	private String nomUser;
	private String userLogin;
	private String userPwd;

	public RefUsers() {
	}

	public RefUsers(BigDecimal idUsers) {
		this.idUsers = idUsers;
	}

	public RefUsers(BigDecimal idUsers, Role role, String nomUser, String userLogin, String userPwd) {
		this.idUsers = idUsers;
		this.role = role;
		this.nomUser = nomUser;
		this.userLogin = userLogin;
		this.userPwd = userPwd;
	}

	@Id

	@Column(name = "ID_USERS", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(BigDecimal idUsers) {
		this.idUsers = idUsers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ROLE")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "NOM_USER", length = 50)
	public String getNomUser() {
		return this.nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	@Column(name = "USER_LOGIN", length = 50)
	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	@Column(name = "USER_PWD", length = 50)
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
