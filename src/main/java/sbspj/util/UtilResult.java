package sbspj.util;

import java.util.HashMap;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
public class UtilResult extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 1L;
	
	private static final String CODE_TAG="code";
	private static final String MSG_TAG="msg";
	private static final String DATA_TAG="object";
	
	public UtilResult() {
		
	}
	public UtilResult(int code,String msg) {
		super.put(CODE_TAG,code);
		super.put(MSG_TAG,msg);
	}
	public UtilResult(int code,String msg,Object data) {
		super.put(CODE_TAG,code);
		super.put(MSG_TAG,msg);
		if(data!=null) {
			super.put(DATA_TAG,data);
		}
	}
	
}
