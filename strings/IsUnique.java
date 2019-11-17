 public class IsUnique{

 	public boolean unique(String str){
 		
 		if(str == null || str.length() == 0)
 			return true;

 		boolean[] arr = new boolean[256];
 		
 		for(int i = 0; i < str.length(); i++){
 			
 			if(arr[str.charAt(i)]){
 				return false;
 			}

 			arr[str.charAt(i)] = true; ; 
 		}

 		return true; 
 		
 	}


 	public static void main(String[] args){

 		String str = "cracking the coding interview";
 		IsUnique obj = new IsUnique();
 		System.out.println("does string have unique characters?: "+obj.unique(str));
 		String str1 = "uniqe";

 		System.out.println("does string have unique characters?: "+obj.unique(str1)); 
 	}

 }