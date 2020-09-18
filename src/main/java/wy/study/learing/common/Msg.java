package wy.study.learing.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回的类
 *
 *
 */
@Data
public class Msg
{
	//状态码
	private int code=0;
	//提示信息
	private String message;

	//提示信息
	private String userId;

	//用户要返回给浏览器的数据
	private Map<String, Object> data = new HashMap<>();
	//	private Integer status;
	public static Msg success(){
		Msg result = new Msg();
		result.setCode(0);
//        result.setStatus(200);
		return result;
	}
	/**
	 * fail
	 * @Description  fail
	 * @Author liuzemin
	 * @Date 2019/12/19 20:59
	 * @param errMsg
	 * @l
	 */
	public static Msg fail(String errMsg){
		Msg result = new Msg();
		result.setCode(-1);
		result.setMessage(errMsg);
//        result.setStatus(100);
		return result;
	}

	/**
	 * @Description
	 * @Author liuzemin
	 * @Date 2019/12/19 21:00
	 * @param ncode  ,errMsg
	 * @return
	 */
	public static Msg Return_Ext(int ncode, String errMsg){
		Msg result = new Msg();
		result.setCode(ncode);
		result.setMessage(errMsg);
//        result.setStatus(100);
		return result;
	}


	/**
	 * @Description
	 * @Author liuzemin
	 * @Date 2019/12/19 21:00
	 * @param ncode  ,errMsg
	 * @return
	 */
	public static Msg Return_Ext_Msg(int ncode, String errMsg, String userId){
		Msg result = new Msg();
		result.setCode(ncode);
		result.setMessage(errMsg);
		result.setUserId(userId);
//        result.setStatus(100);
		return result;
	}

	public Msg add(String key, Object value){
		this.getData().put(key, value);
		return this;
	}



}
