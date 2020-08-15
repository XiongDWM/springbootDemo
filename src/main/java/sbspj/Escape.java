package sbspj;

public class Escape {

	public static void main(String[] args) {
		recursionEscape(100.0);		// TODO Auto-generated method stub
		
		

	} 
	public static void recursionEscape(double miles) {
		
		if(miles/50.0<=1) {
			int times=(int) (miles/50);
			System.out.println(times);
		}
		else{
			while(miles-50>50) {
				
			}
		}
		
	}

}
