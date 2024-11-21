import java.util.regex.Pattern;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		randomAnagram("hello");
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		//wanna get rid of the spaces to not mess with the length of the strings
		str1 = str1.replace(" ", "");
		str2 = str2.replace(" ", "");

		if (str1.length() != str2.length()) {
			return false;
		}
		
		for (int i = 0; i < str1.length(); i++) {
				char c = str1.charAt(i);
				if (str2.indexOf(c) == -1) {
					return false;
				} else {
					str2 = str2.replaceFirst(String.valueOf(c), "");
				}
			}
			return true;
		}
	
	//this seems very compact and efficient i like it
	public static String preProcess(String str) {
		int i = 0;
		String forbiddenCharacters = "0123456789`~!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";
		StringBuilder result = new StringBuilder();

		while (i < str.length()) {
			char c = str.charAt(i);
			if (Character.isUpperCase(c)) {
				c = Character.toLowerCase(c);
			}
			
			if (forbiddenCharacters.indexOf(c) == -1) {
				result.append(c);
			}

			i++;
		}

		return result.toString();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		str = str.replace(" ", "");
		StringBuilder result  = new StringBuilder();
		while (str.length() > 0){
			int i = (int) (Math.random() * str.length());
			result.append(str.charAt(i));
			str = str.substring(0, i) + str.substring(i + 1);
		}

		return result.toString();
	}
}
