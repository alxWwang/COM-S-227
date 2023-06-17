package lab5;

public class NamingAbv {

	public static void nameAbv(String name) {
		String res = name.substring(0,1);
		
		for (int i = 1;i< name.length();i++) {
			
			if(name.substring(i-1, i).equals(" ")) {
				res = res + name.substring(i, i+1);
				
			}
			
		}
		
		System.out.println(res);
	}
	
	public static void indexing( String name) {
		
		String vowel = "aiueoAIUEO";
		int res = -1;
		for ( int i = 0; res == -1; i++) {
			res = name.indexOf(	vowel.substring(i,i+1)	);
		}
		
		System.out.println(res);
	}

}
