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
* @Description: bug_info
* @author autogen
* @date 2019-06-20
* @version
*
*/
@Data
@Entity
@Table(name = "bug_info", schema = "")
@SuppressWarnings("serial")
public class BugInfo implements java.io.Serializable {

	/*@GeneratedbugInfo(strategy = GenerationType.IDENTITY)*/
	@Id
	@Column(name ="[id]",nullable=false,length=50)
	@ApiModelProperty(value = "id")
	private String id;


	@Column(name ="[bug_category_id]",nullable=true,length=255)
	@ApiModelProperty(value = "bug类别id")
	private String bugCategoryId;


	@Column(name ="[bug_comment]",nullable=true,length=255)
	@ApiModelProperty(value = "bug描述")
	private String bugComment;


	@Column(name ="[bug_detailinfo]",nullable=true,length=65535)
	@ApiModelProperty(value = "bug信息")
	private String bugDetailinfo;


	@Column(name ="[bug_creator]",nullable=true,length=255)
	@ApiModelProperty(value = "bug创建人")
	private String bugCreator;


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name ="[bug_create_time]",nullable=true)
	@ApiModelProperty(value = "bug创建时间")
	private Timestamp bugCreateTime;


	@Column(name ="[bug_solution_id]",nullable=true,length=255)
	@ApiModelProperty(value = "bug的解决方法id多个由,分开")
	private String bugSolutionId;


	@Column(name ="[bug_isoff]",nullable=true,precision=1)
	@ApiModelProperty(value = "是否解决")
	private Boolean bugIsoff;


}
