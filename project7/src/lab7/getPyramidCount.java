package lab7;
import java.io.File;
import java.lang.Math;

public class getPyramidCount {
	private static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] test = {3, 10, 5, 1, 121212, 10, 2};
		int len = test.length -1;
	    
		File f = new File("../project6");
		
		System.out.println(numberBalls(3));
		System.out.println(maxInt(test, len));
		
		System.out.println(countfiles(f));
		
		System.out.println(countPatterns(5));
		
		
		
	}
	
	public static int numberBalls( int  levels) {
		
		if(levels != 0) {
			return numberBalls(levels -1) + levels*levels;
		}
		else {
			return 0;
		}
		
	}
	
	public static int maxInt(int[]arr, int len ) { //binary search
		// math.max(a,b)  ex a win
		// math.max(a,b+1)

		
		if(len ==0) {
			return (arr[0]);
		}else {
			int res =  Math.max(arr[len],arr[len-1]);
			len -=1;
			return Math.max(maxInt(arr, len), res);
			
		}
		
	}
	
	public static int countfiles(File f) {
		
		if(f.isDirectory()) {
			File[] arr = f.listFiles();
			return arr.length;
			
		}else {
			return 1;
		}
		
	}
	
	public static int countPatterns(int n) {
		
		
		if (n == 0) {
	        return 1; // one way to lay out 0 feet
	    } else if (n < 0) {
	        return 0; // can't lay out negative feet
	    }
	    // recursive cases
	    return countPatterns(n - 1) + countPatterns(n - 3);
	
		
		
		
	}
	
	
	

}
