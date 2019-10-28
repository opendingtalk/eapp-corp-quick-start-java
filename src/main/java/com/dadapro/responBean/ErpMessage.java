package com.dadapro.responBean;


import lombok.Data;

import java.io.Serializable;

/**
 * @Description: erp审批消息查询
 * @Author: Zhao
 * @Date:   2019-10-22
 * @Version: V1.0
 */
@Data
public class ErpMessage implements Serializable {


	private static final long serialVersionUID = -2453532058857335669L;

	/**id*/
	private Integer id;
	/**审批人*/
	private String approver;
	/**提交人*/
	private String submitter;
	/**消息标题*/
	private String title;
	/**消息内容*/
	private Object taskexpl;
}
