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
* @Description: bug_solution
* @author autogen
* @date 2019-06-20
* @version
*
*/
@Data
@Entity
@Table(name = "bug_solution", schema = "")
@SuppressWarnings("serial")
public class BugSolution implements java.io.Serializable {

	/*@GeneratedbugSolution(strategy = GenerationType.IDENTITY)*/
	@Id
	@Column(name ="[id]",nullable=false,length=50)
	@ApiModelProperty(value = "id")
	private String id;


	@Column(name ="[bug_solution_info]",nullable=true,length=65535)
	@ApiModelProperty(value = "bug解决方法")
	private String bugSolutionInfo;


}
