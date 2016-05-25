package com.softserve.edu.rs.entity;

import java.sql.Date;

public class UserDB implements IEntity {

    public static enum UserDBQueries {
        INSERT("INSERT INTO users (account_non_expired, account_non_locked, attempts, credentials_non_expired, date_of_accession, email, enabled, first_name, last_modified, last_name, login, middle_name, password, phonenumber, status, role_id, territorialCommunity_id) VALUES (%s, %s, %s, %s, %s, '%s', %s, '%s', %s, '%s', '%s', '%s', '%s', '%s', '%s', %s, %s);"),
        GET_BY_ID("SELECT user_id, account_non_expired, account_non_locked, attempts, credentials_non_expired, date_of_accession, email, enabled, first_name, last_modified, last_name, login, middle_name, password, phonenumber, status, role_id, territorialCommunity_id FROM users WHERE user_id = '%s';"),
        GET_BY_FIELD("SELECT user_id, account_non_expired, account_non_locked, attempts, credentials_non_expired, date_of_accession, email, enabled, first_name, last_modified, last_name, login, middle_name, password, phonenumber, status, role_id, territorialCommunity_id FROM users WHERE %s = '%s';"),
        GET_ALL("SELECT user_id, account_non_expired, account_non_locked, attempts, credentials_non_expired, date_of_accession, email, enabled, first_name, last_modified, last_name, login, middle_name, password, phonenumber, status, role_id, territorialCommunity_id FROM users;"),
        UPDATE_BY_FIELD("UPDATE users SET %s = '%s';"),
        DELETE_BY_ID("DELETE users WHERE user_id = '%s';");
        //DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE '%s%%';");
        private String query;

        private UserDBQueries(String query) {
            this.query = query;
        }

        @Override
        public String toString() {
            return query;
        }
    }
    
    private Long userId;
    private Long accountNonExpired; 
    private Long accountNonLocked;		// May be null
    private Long attempts;				// May be null
    private Long credentialsNonExpired;	// May be null
    private Date dateOfAccession;
    private String email;
    private Long enabled;
    private String firstname;
    private Date lastModified;
    private String lastname;
    private String login;
    private String middlename;
    private String password;
    private String phonenumber;			// May be null
    private String status;
    private Long roleId;
    private Long territorialCommunityId;
    
    // TODO Create Factory, Builder
	public UserDB(Long userId, Long accountNonExpired, Long accountNonLocked, Long attempts, Long credentialsNonExpired,
			Date dateOfAccession, String email, Long enabled, String firstname, Date lastModified, String lastname,
			String login, String middlename, String password, String phonenumber, String status, Long roleId,
			Long territorialCommunityId) {
		this.userId = userId;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.attempts = attempts;
		this.credentialsNonExpired = credentialsNonExpired;
		this.dateOfAccession = dateOfAccession;
		this.email = email;
		this.enabled = enabled;
		this.firstname = firstname;
		this.lastModified = lastModified;
		this.lastname = lastname;
		this.login = login;
		this.middlename = middlename;
		this.password = password;
		this.phonenumber = phonenumber;
		this.status = status;
		this.roleId = roleId;
		this.territorialCommunityId = territorialCommunityId;
	}

    // setters - - - - -
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setAccountNonExpired(Long accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(Long accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setAttempts(Long attempts) {
		this.attempts = attempts;
	}

	public void setCredentialsNonExpired(Long credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setDateOfAccession(Date dateOfAccession) {
		this.dateOfAccession = dateOfAccession;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setTerritorialCommunityId(Long territorialCommunityId) {
		this.territorialCommunityId = territorialCommunityId;
	}

    // getters - - - - -

	public Long getId() {
		return getUserId();
	}

	public Long getUserId() {
		return userId;
	}

	public Long getAccountNonExpired() {
		return accountNonExpired;
	}

	public Long getAccountNonLocked() {
		return accountNonLocked;
	}

	public Long getAttempts() {
		return attempts;
	}

	public Long getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public Date getDateOfAccession() {
		return dateOfAccession;
	}

	public String getEmail() {
		return email;
	}

	public Long getEnabled() {
		return enabled;
	}

	public String getFirstname() {
		return firstname;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public String getLastname() {
		return lastname;
	}

	public String getLogin() {
		return login;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getPassword() {
		return password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getStatus() {
		return status;
	}

	public Long getRoleId() {
		return roleId;
	}

	public Long getTerritorialCommunityId() {
		return territorialCommunityId;
	}

}
