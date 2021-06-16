package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "login")
public class LoginEntity {
	
	@Id
	@NotEmpty(message="Please enter your userid")
	private String userId;
	@NotEmpty(message="Please enter your password")
	private String password;
    private boolean isLoggedIn = false;
    private String userRole;
    
    @JsonIgnore
	@OneToOne(mappedBy="login")
	private UserEntity user;
}
