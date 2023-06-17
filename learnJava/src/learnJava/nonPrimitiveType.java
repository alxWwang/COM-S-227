package learnJava;

public class nonPrimitiveType {

	public static void main(String[] args) {
		
		
		String name = "susan";
		String name2 = name.toUpperCase(); 
		
		System.out.println(name2);
		
		excPoint(name2); //gaperlu pake println karena udah ada print di method nya
		
		System.out.println("");
		
		String res = quesPoint(name2);
		System.out.println(res);
		
		System.out.println("");
		
		
		//ini import
		// lonte ini jadi nama variable yang dipake di file ini 
		new primitiveType(); 
		
		String kontol = primitiveType.gmnImport();
		System.out.println(kontol);
		
		
		//kalo nonPrimitiveType bisa 
		//dikasi fungsi karena termasuk objek
		
		
		// kalo mau bikin variabel harus tulis type depannya
	}

	
	
	public static void excPoint(String s) { // ini namanya method (fungsi)
		System.out.print(s + "!");
	}
	
	
	public static String quesPoint(String s) {
		return s + "?";
		
		
		
		// ini dibikin return biar bisa dirubah rubah print nya bukan disitu
		// void dirubah jadi String karena mau dikeluarin dalam bentuk string
	}
}
