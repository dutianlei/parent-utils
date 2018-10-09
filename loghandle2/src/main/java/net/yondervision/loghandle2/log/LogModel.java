/**
 * @Project: cbb-commons
 * @Title: LogModle.java
 * @Package com.yondervision.cbb.commons.log
 * @author liym
 * @date 2014-11-13 下午03:58:12
 * Company:华信永道（北京）科技有限公司
 * @version V1.0
 */
package net.yondervision.loghandle2.log;


/**
 * @ClassName LogModel
 * @Description 模块描述
 * @author Mr.Du
 * @Date 2018-09-20
 */
public enum LogModel {
	/**
	 * DEFAULT_MODEL 默认模块日志
	 */
	DEFAULT_MODEL("def_model");

	private String value;
	
	LogModel(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
