package test2;

import java.util.ArrayList;

public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(blankVowels("volume"));
		
		int[] arr = {5,4,5,6,4,2};
		System.out.println(removeDuplicates(arr));

	}
	
	public static String blankVowels(String str) {
		
		char[] chars = str.toCharArray();
		String res = "";
		
		for (char i : chars) {
			if( 	i == 'a' ||
					i == 'i'||
					i == 'u'||
					i == 'e'||
					i == 'o') {
				res += '_';
				
			}else {
				res += i;
			}
		}
		
		return res;
		
	}
	
	public static int[] removeDuplicates (int[] arr) {
		
		ArrayList <Integer> checked = new ArrayList<>();
		
		for(int i : arr) {
			if(checked.contains(i)) {
				continue;
			}
			else {
				checked.add(i);
			}
		}
		
		
		int[] res = new int[checked.size()];
		
		for( int x = 0; x< checked.size();x++) {
			res[x] = checked.get(x);
		}
		
		return res;
		
	}
	

}
