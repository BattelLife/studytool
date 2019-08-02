package com.studydesign.studytoolbasic.util;

import java.io.Serializable;

public class PageQueryUtil<BusinessBean> implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    BusinessBean businessBean;

    PageQuery pageQuery;

    public BusinessBean getBusinessBean() {
        return businessBean;
    }

    public void setBusinessBean(BusinessBean businessBean) {
        this.businessBean = businessBean;
    }

    public PageQuery getPaging() {
        return pageQuery;
    }

    public void setPaging(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
    }


}
