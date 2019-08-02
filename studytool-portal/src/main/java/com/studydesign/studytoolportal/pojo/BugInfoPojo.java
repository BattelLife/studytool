package com.studydesign.studytoolportal.pojo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BugInfoPojo {

    @ApiModelProperty(value = "bug描述")
    private String bugComment;
    @ApiModelProperty(value = "bug信息")
    private String bugDetailinfo;
    @ApiModelProperty(value = "是否解决")
    private Boolean bugIsoff;
    @ApiModelProperty(value = "bug的解决方法id多个由,分开")
    private String bugSolutionId;
    @ApiModelProperty(value = "bug类别id")
    private String bugCategoryId;
}
