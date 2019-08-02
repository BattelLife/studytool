package com.studydesign.studytoolbusiness.entity.entitis;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
* @Title: Entity
* @Description: user_info
* @author autogen
* @date 2019-06-20
* @version
*
*/
@Data
@Entity
@Table(name = "user_info", schema = "")
@SuppressWarnings("serial")
public class UserInfo implements java.io.Serializable {

	/*@GenerateduserInfo(strategy = GenerationType.IDENTITY)*/
	@Id
	@Column(name ="[id]",nullable=false,length=50)
	@ApiModelProperty(value = "id")
	private String id;


	@Column(name ="[user_name]",nullable=true,length=255)
	@ApiModelProperty(value = "userName")
	private String userName;


	@Column(name ="[user_password]",nullable=true,length=255)
	@ApiModelProperty(value = "userPassword")
	private String userPassword;


	@Column(name ="[user_nickname]",nullable=true,length=255)
	@ApiModelProperty(value = "userNickname")
	private String userNickname;


	@Column(name ="[user_workspace]",nullable=true,length=255)
	@ApiModelProperty(value = "userWorkspace")
	private String userWorkspace;


	@Column(name ="[user_level]",nullable=true,length=255)
	@ApiModelProperty(value = "userLevel")
	private String userLevel;


}
