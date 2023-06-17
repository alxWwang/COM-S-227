package mini;

/**
 * Utility class with static methods for loop practice.
 */
public class LoopsInfinityAndBeyond {

	/**
	 * Private constructor to disable instantiation.
	 */
	public LoopsInfinityAndBeyond() {
		
		
	}

	/**
	 * Define a flying saucer as the following string pattern: one ‘(‘, followed by
	 * zero to many ‘=’, followed by one ‘)’. Write a Java method that, given a
	 * string find the first instance of a flying saucer (starting from the left)
	 * and return its length. If no flying saucer exists return 0.
	 * <p>
	 * For example: Given: "(==)" Return: 4
	 * <p>
	 * Given: "***()**(===)" Return: 2
	 * <p>
	 * Given: "****(***)" Return: 0
	 * 
	 * @param source input string
	 * @return the length
	 * 
	 * 
	 */
	
	public static int flyingSaucerLength(String s) {
		
		int count = 0;
		int start = -1;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					count += 1;
					start = i;
					
				} else if (s.charAt(i) == ')') {
						if (start >= 0) {
						count ++;
						start = -1;
						break;
					}
					
				} else if (s.charAt(i) == '=' && start >=0) {
					count++;
				
				} 
				
				if(s.charAt(i) == '*' && start >=0) {
					count = -1;
				}
			}
		return count;
	}

			

	/**
	 * Write a Java method that, given a string which many contain a flying saucer
	 * broken into two parts with characters in between, return a string where the
	 * flying is fixed by removing the in between characters. Look for the two parts
	 * of the flying saucer from left to right and fix the saucer with the first
	 * available parts.
	 * <p>
	 * For example:
	 * Given: ***(==****===)***
	 * Return: ***(=====)***
	 * <p>
	 * Given: ***(==****)**=)*
	 * Return: ***(==)**=)*
	 * <p>
	 * Given: ***(==)**
	 * Return: ***(==)**
	 * 
	 * @param s
	 * @return
	 */
	public static String fixFlyingSaucer(String s) {
		int count = 0;
		int start = -1;
		int end = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count = 0;
				start = i;
			} else if (s.charAt(i) == ')') {
				if (count > 0 && start != -1) {
					end = i;
					break;
				} else {
					start = -1;
				}
			} else if (s.charAt(i) == '=') {
				count++;
			}
		}
		if (start != -1 && end != -1) {
			String firstPart = s.substring(0, start);
			String secondPart = s.substring(end + 1);
			String fixedSaucer = firstPart + "(" + "=".repeat(count)
			+ ")" + secondPart;
			return fixedSaucer;
		} else {
			return s;
		}
		
		
	}

	/**
	 * Write a Java method that, given a string which many contain many flying
	 * saucers, return the number of flying saucers. For this problem a flying
	 * saucer may wrap around from the right side of the string to the left.
	 * <p>
	 * For example:
	 * Given: ***(===)***
	 * Return: 1
	 * <p>
	 * Given: =)**(==)**(
	 * Return: 2
	 * <p>
	 * Given: ***(=*=)**
	 * Return: 0
	 * 
	 * @param s
	 * @return
	 */
	public static int countFlyingSaucers(String s) {
		int count = 0;
		int openCount = 0;
		int equalCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				openCount++;
			} else if (s.charAt(i) == ')') {
				if (openCount >= 0) {
					openCount=-1;
					count++;
				}
			} else if (s.charAt(i) == '=') {
				equalCount++;
			}
			
			if(s.charAt(i) == '*' && openCount >0) {
				count -=1;
			}
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ')') {
				int wrappedEqualCount = s.length() - i - 2 - equalCount;
				if (openCount > 0 && wrappedEqualCount >= openCount) {
					count += openCount;
					openCount = 0;
				} else if (wrappedEqualCount >= 0) {
					equalCount += wrappedEqualCount;
				}
			} else if (s.charAt(i) == '(') {
				openCount--;
			} else if (s.charAt(i) == '=') {
				equalCount--;
			}
		}
		return count;
	}

	/**
	 * Write a Java method that, given a string which many contain many flying
	 * saucers, shifts all of the saucers one character to the right. For this
	 * problem a flying saucer may wrap around from the right side of the string to
	 * the left. The returned string should have the same number of characters as
	 * the given string. This is achieved by moving the character to the right of a
	 * saucer to its left. It can be assumed that saucers will never be touching
	 * each other (i.e., there will always be at least one character between any two
	 * saucers). Also, a saucer will not touch itself (e.g., "=)(=").
	 * <p>
	 * For example:
	 * Given: ***(===)***
	 * Return: ****(===)**
	 * <p>
	 * Given: =)**(==)**(
	 * Return: (=)***(==)*
	 * <p>
	 * Given: a()bcde(=*=)fg
	 * Return: ab()cde(=*=)fg
	 * 
	 * @param s
	 * @return
	 */
	
	public static String flyingSaucersFly(String s) {
		/*
		char[]arr = s.toCharArray();		
		int lengthIs = arr.length-1;
		int countStart = 0;
		int equalCount =0;
		int closedAt = 0;
		
		
		for (int i = 0; i <= lengthIs; i++) {
			
			
			if(arr[i] == '(') {
				countStart = i;
			}
			if (arr[i] == '=') {
				equalCount ++;
			}
			
			if (arr[i] == ')') {
				closedAt = i;
				if(equalCount == closedAt - countStart -1) {
					char tempL = arr[closedAt + 1];
					arr[end+1].pop();
				}
				countStart = 0;
				equalCount = 0;
			}
			
		*/
			
		
		char[] arr = s.toCharArray();
		
		int lengthIs = arr.length-1;
		int countStart = 0;
		boolean countStarted = false;
		int equalCount =0;
		
		
		for (int i = 0; i <= lengthIs; i++) {
			
			
			if(arr[i] == '(') {
				countStart = i;
				countStarted = true;
				
			}
			if (arr[i] == '=') {
				equalCount ++;
			}
			
			if (arr[i] == ')') {
				if (equalCount == i-1-countStart) {
					//parse front
					for(int j = i ; j> countStart-1 ; j--) {
						
						char temp = 0;
						
						
							if(j!= lengthIs) {
								temp = arr[j+1];                
								arr[j+1] = arr[j];
								arr[j] = temp;
							}else {
								temp = arr[0];                
								arr[0] = arr[j];
								arr[j] = temp;
								
							}
						}
			
					} 
				else if (!countStarted) {
					//parse back
					for(int z = lengthIs; z>=0 ; z--) {
						if(arr[z] == '(' ) {
							int found = z;
							char temp =0;
							
							while (true) {
								if(found == z) {
									
									for ( int b = i; b >=0 ; b--) {
										temp =arr[b+1]; 
										arr[b+1] = arr[b];
										arr[b] = temp;
									}
									
									char temp2 =arr[0];
									arr[0] = arr[lengthIs];
									arr[lengthIs] = temp2;
									
									for(int a = lengthIs; a>found; a--) {
										char temp3 = arr[a];
										arr[a] = arr[a-1];
										arr[a-1] = temp3;
										
										
									}
									
									
									
									break;
								}
									
								
								else{
									temp = arr[z-1];                
									arr[z+1] = arr[z];
									arr[z] = temp;
								}
							} break;
						}
					}
				}

				countStart = 0;
				equalCount = 0;
				countStarted = false;
				i+=1;
			}
			
			
			
		}		
		return new String(arr);
	

		
	}
}
