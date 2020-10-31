package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String acro = "";
		acro += phrase.charAt(0);
		
		for (int i = 1; i < phrase.length(); i++) {
			if (Character.isWhitespace(phrase.charAt(i))) {
				acro = acro + phrase.charAt(i);
				acro += phrase.charAt(i+1);
			}
		}
		
		acro.replaceAll("\\s+","").toUpperCase();
		return acro;
		
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if((sideOne == sideTwo) && (sideOne == sideThree)) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isIsosceles() {
			if(((sideOne == sideTwo) && (sideOne != sideThree)) || ((sideTwo == sideThree) && (sideTwo != sideOne))
					|| ((sideThree == sideOne) && (sideThree != sideTwo))) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isScalene() {
			if((sideOne != sideTwo) && (sideOne != sideThree)) {
				return true;
			}
			else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		char sScore[] = new char[string.length()];
		int sScoreNum[] = new int [string.length()];
		int totalScore = 0;
		for(int p = 0, e = string.length(); p < e; p++)  {
			sScore[p] = string.charAt(p);
		}
		for(int r = 0, q = sScore.length; r < q; r++)  {
			switch(sScore[r]) {
			case 'a': sScoreNum[r] = 1;
			case 'A': sScoreNum[r] = 1;
			case 'e': sScoreNum[r] = 1;
			case 'E': sScoreNum[r] = 1;
			case 'f': sScoreNum[r] = 1;
			case 'F': sScoreNum[r] = 1;
			case 'i': sScoreNum[r] = 1;
			case 'I': sScoreNum[r] = 1;
			case 'l': sScoreNum[r] = 1;
			case 'L': sScoreNum[r] = 1;
			case 'n': sScoreNum[r] = 1;
			case 'N': sScoreNum[r] = 1;
			case 'o': sScoreNum[r] = 1;
			case 'O': sScoreNum[r] = 1;
			case 'r': sScoreNum[r] = 1;
			case 'R': sScoreNum[r] = 1;
			case 's': sScoreNum[r] = 1;
			case 'S': sScoreNum[r] = 1;
			case 't': sScoreNum[r] = 1;
			case 'T': sScoreNum[r] = 1;
			case 'u': sScoreNum[r] = 1;
			case 'U': sScoreNum[r] = 1;
			break;
			case 'b': sScoreNum[r] = 3;
			case 'B': sScoreNum[r] = 3;
			case 'c': sScoreNum[r] = 3;
			case 'C': sScoreNum[r] = 3;
			case 'm': sScoreNum[r] = 3;
			case 'M': sScoreNum[r] = 3;
			case 'p': sScoreNum[r] = 3;
			case 'P': sScoreNum[r] = 3;
			break;
			case 'd': sScoreNum[r] = 2;
			case 'D': sScoreNum[r] = 2;
			case 'g': sScoreNum[r] = 2;
			case 'G': sScoreNum[r] = 2;
			break;
			case 'h': sScoreNum[r] = 4;
			case 'H': sScoreNum[r] = 4;
			case 'v': sScoreNum[r] = 4;
			case 'V': sScoreNum[r] = 4;
			case 'w': sScoreNum[r] = 4;
			case 'W': sScoreNum[r] = 4;
			case 'y': sScoreNum[r] = 4;
			case 'Y': sScoreNum[r] = 4;
			break;
			case 'j': sScoreNum[r] = 8;
			case 'J': sScoreNum[r] = 8;
			case 'x': sScoreNum[r] = 8;
			case 'X': sScoreNum[r] = 8;
			break;
			case 'k': sScoreNum[r] = 5;
			case 'K': sScoreNum[r] = 5;
			break;
			case 'q': sScoreNum[r] = 10;
			case 'Q': sScoreNum[r] = 10;
			case 'z': sScoreNum[r] = 10;
			case 'Z': sScoreNum[r] = 10;
			break;
			default: continue;
			}
		}
		for(int x = 0; x < sScoreNum.length; x++ ) {
			sScoreNum[x] += totalScore;
		}
		if(totalScore != 0) {
			return totalScore;
		}
		else {
			return 0;
		}
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		char nanpNums[] = new char[string.length()];
		char numsOnly[];
		for(int i = 0; i < nanpNums.length; i++) {
			if(string.charAt(0) == 1) {
				continue;
			}
			

		}
		

		return null;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		String[] splitPhrase = string.split(" ");
		int duplicate = 0;
		
		Map<String, Integer> pair = new Map<String, Integer>();
		
		for(int i = 0; i < splitPhrase.length; i++) {
			if(splitPhrase != null) {
				pair.put(" ", i);
			}
		}
		return pair;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			
			int low = 0; 
			int high = sortedList.size() -1;
					
			while(high >= low) {
				int mid = (high - low) / 2 + low;
				if(mid == 0) {
					return mid;
				}
				if(mid < 0 ) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		 int strSize = string.length(); 
		    int index = -1; 
		    for (int i = 0; i < 3; i++) //chose 3 due to the first letters not being accounted for.
		    { 
		        if ( ('A') == (string.charAt(i))) { 
		        	index = i; 
		        	break; 
		        }
		        if(('a') == (string.charAt(i))) {
		        	index = i;
		        	break;
		        }
		        if(('e') == (string.charAt(i))) {
		        	index = i;
		        	break;
		        }
		        if(('E') == (string.charAt(i))) {
		        	index = i;
		        	break;
		        }
		        if(('i') == (string.charAt(i))) {
		        	index = i;
		        	break;
		        }
		        if(('I') == (string.charAt(i))) {
		        	index = i;
		        	break;
		        }
		        if(('o') == (string.charAt(i))) {
		        	index = i;
		        	break;
		        }
		        if(('O') == (string.charAt(i))) {
		        	index = i;
		        	break;
		        }
		        if(('u') == (string.charAt(i))) {
		        	index = i;
		        	break;
		        }
		        if(('U') == (string.charAt(i))) {
		        	index = i;
		        	break;
		        }
		        if(index == -1 ) {
		        	String way = string.substring(index) + 
		        			string.substring(0, index) + "way";
		        	return way;
		        }
		        String ay = string.substring(index) + 
		                string.substring(0, index) + "ay";
		        return ay;
		        
		         
		    } 

	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int d = input;
		int amMaybe1 = d; //while loop digit check.
		int amMaybe2 = d;//
		int sum = 0;//Armstrong Number check.
		int sValue = 0;// Sentential Value of the for while loop as well as digit check on the for loop.
		
		while(amMaybe1 >= 0) { 
			amMaybe1 = amMaybe1 / 10;
			sValue++;
		}
		
		for(int t = 0; t < sValue; t++) {
			sum += Math.pow(amMaybe2, sValue);
			amMaybe2 = amMaybe2 / 10;
		}
		if(sum == d) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		long x = l;
		while(x % 2 == 0) {
			x /= 2;
		}
		for(long i = 3L; i <= Math.sqrt(i); i += 2) {
			while(x % i ==0) {
				x /= i;
			}
			if(x > 2) {
				return x;
			}
		}
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String cipher = new String();
			String sub = string;
			for(int i = 0; i < sub.length(); i++) {
				char ch = (char)(((int)sub.charAt(i) + 
                        key - 97) % 26 + 97);
				cipher.charAt(i) = sub.charAt(i);
			}
			
			return cipher;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		int countOfPrimes = i;
		int currentNum = 2;
		
		
		while(currentNum < countOfPrimes ) {
			for(int divisor = 2; divisor <= currentNum / 2; divisor++ ) {
				if(currentNum % divisor == 0) { 
					continue;
				}
			}
			currentNum++;
		}
		return currentNum;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			char preCipher[] = new char[string.length()];
			for(int i = 0, q = string.length(); i < q; i++) {
				preCipher[i] = string.charAt(i);
			}
			for(int x = 0; x < preCipher.length; x++) {
				switch(preCipher[x]) {
				case 'a': preCipher[x] = 'z';
				case 'A': preCipher[x] = 'Z';
				break;
				case 'b': preCipher[x] = 'y';
				case 'B': preCipher[x] = 'Y';
				break;
				case 'c': preCipher[x] = 'x';
				case 'C': preCipher[x] = 'X';
				break;
				case 'd': preCipher[x] = 'w';
				case 'D': preCipher[x] = 'W';
				break;
				case 'e': preCipher[x] = 'v';
				case 'E': preCipher[x] = 'V';
				break;
				case 'f': preCipher[x] = 'u';
				case 'F': preCipher[x] = 'U';
				break;
				case 'g': preCipher[x] = 't';
				case 'G': preCipher[x] = 'T';
				break;
				case 'h': preCipher[x] = 's';
				case 'H': preCipher[x] = 'S';
				break;
				case 'i': preCipher[x] = 'r';
				case 'I': preCipher[x] = 'R';
				break;
				case 'j': preCipher[x] = 'q';
				case 'J': preCipher[x] = 'Q';
				break;
				case 'k': preCipher[x] = 'p';
				case 'K': preCipher[x] = 'P';
				break;
				case 'l': preCipher[x] = 'o';
				case 'L': preCipher[x] = 'O';
				break;
				case 'm': preCipher[x] = 'n';
				case 'M': preCipher[x] = 'N';
				break;
				case 'n': preCipher[x] = 'm';
				case 'N': preCipher[x] = 'M';
				break;
				case 'o': preCipher[x] = 'l';
				case 'O': preCipher[x] = 'L';
				break;
				case 'p': preCipher[x] = 'k';
				case 'P': preCipher[x] = 'K';
				break;
				case 'q': preCipher[x] = 'j';
				case 'Q': preCipher[x] = 'J';
				break;
				case 'r': preCipher[x] = 'i';
				case 'R': preCipher[x] = 'I';
				break;
				case 's': preCipher[x] = 'h';
				case 'S': preCipher[x] = 'H';
				break;
				case 't': preCipher[x] = 'g';
				case 'T': preCipher[x] = 'G';
				break;
				case 'u': preCipher[x] = 'f';
				case 'U': preCipher[x] = 'F';
				break;
				case 'v': preCipher[x] = 'e';
				case 'V': preCipher[x] = 'E';
				break;
				case 'w': preCipher[x] = 'd';
				case 'W': preCipher[x] = 'D';
				break;
				case 'x': preCipher[x] = 'c';
				case 'X': preCipher[x] = 'C';
				break;
				case 'y': preCipher[x] = 'b';
				case 'Y': preCipher[x] = 'B';
				break;
				case 'z': preCipher[x] = 'a';
				case 'Z': preCipher[x] = 'A';
				break;
				default: continue;
				}
				char[] letterswap = preCipher;
			}
			return letterswap;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			char deCipher[] = new char[string.length()];
			for(int i = 0, q = string.length(); i < q; i++) {
				deCipher[i] = string.charAt(i);
			}
			
			for(int x = 0; x < deCipher.length; x++) {
				switch(deCipher[x]) {
				case 'a': deCipher[x] = 'z';
				case 'A': deCipher[x] = 'Z';
				break;
				case 'b': deCipher[x] = 'y';
				case 'B': deCipher[x] = 'Y';
				break;
				case 'c': deCipher[x] = 'x';
				case 'C': deCipher[x] = 'X';
				break;
				case 'd': deCipher[x] = 'w';
				case 'D': deCipher[x] = 'W';
				break;
				case 'e': deCipher[x] = 'v';
				case 'E': deCipher[x] = 'V';
				break;
				case 'f': deCipher[x] = 'u';
				case 'F': deCipher[x] = 'U';
				break;
				case 'g': deCipher[x] = 't';
				case 'G': deCipher[x] = 'T';
				break;
				case 'h': deCipher[x] = 's';
				case 'H': deCipher[x] = 'S';
				break;
				case 'i': deCipher[x] = 'r';
				case 'I': deCipher[x] = 'R';
				break;
				case 'j': deCipher[x] = 'q';
				case 'J': deCipher[x] = 'Q';
				break;
				case 'k': deCipher[x] = 'p';
				case 'K': deCipher[x] = 'P';
				break;
				case 'l': deCipher[x] = 'o';
				case 'L': deCipher[x] = 'O';
				break;
				case 'm': deCipher[x] = 'n';
				case 'M': deCipher[x] = 'N';
				break;
				case 'n': deCipher[x] = 'm';
				case 'N': deCipher[x] = 'M';
				break;
				case 'o': deCipher[x] = 'l';
				case 'O': deCipher[x] = 'L';
				break;
				case 'p': deCipher[x] = 'k';
				case 'P': deCipher[x] = 'K';
				break;
				case 'q': deCipher[x] = 'j';
				case 'Q': deCipher[x] = 'J';
				break;
				case 'r': deCipher[x] = 'i';
				case 'R': deCipher[x] = 'I';
				break;
				case 's': deCipher[x] = 'h';
				case 'S': deCipher[x] = 'H';
				break;
				case 't': deCipher[x] = 'g';
				case 'T': deCipher[x] = 'G';
				break;
				case 'u': deCipher[x] = 'f';
				case 'U': deCipher[x] = 'F';
				break;
				case 'v': deCipher[x] = 'e';
				case 'V': deCipher[x] = 'E';
				break;
				case 'w': deCipher[x] = 'd';
				case 'W': deCipher[x] = 'D';
				break;
				case 'x': deCipher[x] = 'c';
				case 'X': deCipher[x] = 'C';
				break;
				case 'y': deCipher[x] = 'b';
				case 'Y': deCipher[x] = 'B';
				break;
				case 'z': deCipher[x] = 'a';
				case 'Z': deCipher[x] = 'A';
				break;
				default: continue;
				}
				deCipher.toString().toLowerCase().replaceAll("(.{5})(?!$)", "$1\s");
			}
			return deCipher;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		char[] charToStringArray = string.toCharArray();
		int[] placeholder = new int[string.length()];
		int isbnAlgoSum = 0;
		
		for(int i = 0; i < charToStringArray.length; i++) {
			placeholder[i] = (int)charToStringArray[i];
		}
		for(int j = 9; j < placeholder[0]; j-- ) {
			placeholder[j] = placeholder[j] * (j + 1);
			isbnAlgoSum += placeholder[j];
		}
		if(isbnAlgoSum % 10 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		Boolean[] alphabet = new Boolean[26]; 
		int index = 0;
		string = string.toUpperCase();
		
		if (string == null) {
			return false;
		}
		
		 for (int i = 0; i < string.length(); i++) {
		        if ('A' <= string.charAt(i) && string.charAt(i) <= 'Z') {
		            index = string.charAt(i) - 'A';
		        }
		        alphabet[index] = true;
		        return true;
		 } 
		 for (int j = 0; j <= 25; j++) {
		      if (alphabet[j] == false)
		    	  return false;
	}
}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		if(given.isSupposed(ChronoUnit.seconds)) {
			return given.plus(amountToAdd: 1_000_000_000, ChronoUnit.Seconds);
		}
		else {
			Local_Date date = LocalDate.from(given);
			LocalDateTime dateTime = date.atStartOfDay();
			return dateTime.plus(amountToAdd: 1_000_000_000, ChronoUnit.Seconds);
		}
		return given;
	

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int totalMultiple;
		
		for(int x = 1; x < i; x++) {
			for(int j = 0; j < set.length; j++) {
				if(x%set[j]==0) {
					totalMultiple+=x;
					break;
				}
			}
		}
		return totalMultiple;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		char[] charLuhnAlgo = string.toCharArray();
		int[]luhnNum  = new int[string.length()];
		int luhnCheck = 0;
		int luhnDouble; 
		
		for(int i = 0; i < charLuhnAlgo.length; i++) {
			[i] = (int)charToStringArray[i];
		}
		for(j = 0; j < luhnNum.length; j++) {
			if((luhnNum[j] == 0) && (luhnNum[j] % 2)) {
				luhnNum[j] = luhnNum[j] * 2;
				luhnCheck += luhnNum[j];
			}
		}
		if(luhnCheck % 10 == 0) { 
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String change = string;
		String numOnly = string.replaceAll("[^\\d.]", "");
		String numsOnly = numOnly.replaceAll("\\s+","");
			switch(change) {
			case "Plus": 
			break;
			case "Substraction":
			break;
			case "Multiplication":
			break;
			case "Division":
			break;
			}
		
		return 0;
	}
	}

