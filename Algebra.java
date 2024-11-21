public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
		System.out.println(div(-15, 3));  // Expected: -5 
		System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(1000));

		   
		  
	}  

	// Returns x1 + x2- DONE!!!!
	public static int plus(int x1, int x2) {
		if (x1 <= 0 && x2 <0){
			for (int i = 0; i < -x2; i++) {
				x1--;
			}
		} 
		else if (x1 >= 0 && x2 <= 0) {
			for (int i = 0; i < -x2; i++) {
				x1--;
			}
		}
		else if (x1 <= 0 && x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
		}
		else if (x1 >= 0 && x2 >= 0){
			for (int i = 0; i < x2; i++) {
				x1++;
		}
		}
		else {
			for (int i = 0; i <= x2; i++) {
				x1++;
		}
	}
		return x1;
	}

	// Returns x1 - x2-- EASYYYY!!!
	public static int minus(int x1, int x2) {
		if (x1 <= 0 && x2 <= 0){
			for (int i = 0; i < -x2; i++) {
				x1++;
			}
		} else {
		for (int i = 0; i < x2; i++) {
			x1 --;
		}
	}
		return x1;
	}

	// Returns x1 * x2- YUHHHH!!!
	public static int times(int x1, int x2) {
		int a = 0;
		if (x1 == 0 || x2 == 0){
			return 0;
		} 
		//if x1 is negative and x2 is negative
		if (x1 < 0 && x2 < 0) {
			for (int i = 0; i < -x2; i++) {
				a = plus(a, -x1);
			}
		} 
		//if x1 is negative and x2 is positive
		else if (x1 < 0 && x2 > 0){
			for (int i = 0; i < x2; i++) {
			a = plus(a, x1);
			}
		} 
		//if x1 is positive and x2 is negative
		else if (x1 > 0 && x2 < 0) {
			for (int i = 0; i < -x2; i++) {
				a = minus(a, x1);
			}
		 } 
		//of both are positive 
		else if (x1 > 0 && x2 > 0) {
		for (int i = 0; i < x2; i++) {
			a = plus(a, x1);
		}
		}
		return a;
	} 

	// Returns x^n (for n >= 0)--- epicccc
	public static int pow(int x, int n) {
		if (n < 0) {
			return -1;
		}
		int y = 1;
		for (int i = 0; i < n; i++) {
			y = times(y, x);
		}
		return y;
	}

	// Returns the integer part of x1 / x2 --- niceeee
	public static int div(int x1, int x2) {
		int a = x1;
		int counter = 0;
		if (x1 >= 0 && x2 >= 0) {
			while (a >= x2) {
				a = minus(a, x2);
				counter++;
			}
		}
		else if (x1 >= 0 && x2 <= 0) {
			while (a >= -x2) {
				a = plus(a, x2);
				counter++;
			}
		}
		//this is not working for some reason (-15 divided by 3)
		else if (x1 <= 0 && x2 >= 0){
			while (a <= -x2) {
				a = plus(a, x2);
				counter--;
			}
		}
		else if (x1 <= 0 && x2 <= 0){
			while (a <= x2){
				a = plus(a, -x2);
				counter++;
			}
		}
		return counter;
	}

	// Returns x1 % x2--- wonderful!
	public static int mod(int x1, int x2) {
		int a = div(x1, x2);
		int b = times(a, x2);
		int mod = minus(x1, b);
		return mod;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int a = 1;
		while (div(x, a) != a){
			if (a > div(x, a)){
				a--;
				return a;
			}
		a++;
		}
			return a;
		}
	}



	