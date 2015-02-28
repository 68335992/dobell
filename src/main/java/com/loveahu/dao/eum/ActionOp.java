package com.loveahu.dao.eum;

/**
 * 操作类型
 * @author bowensun
 *
 */
public enum ActionOp {

	/**
	 * UserController
	 */
	USER_INFO(1,"查看用户信息")
	;
	
	private ActionOp(int op,String tip){
		this.op = op;
		this.tip = tip;
	}
	
	public int op;
	public String tip;
	
	public static ActionOp getOp(int op){
		ActionOp[] types = ActionOp.values();
		for(ActionOp type:types){
			if (op==type.op) {
				return type;
			}
		}
		return null;
	}
}
