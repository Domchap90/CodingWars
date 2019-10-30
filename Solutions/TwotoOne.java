//Take 2 strings s1 and s2 including only letters from ato z. Return a new sorted string, the longest possible, containing distinct letters,
//each taken only once - coming from s1 or s2.
//
//Test Example:
//a = "xyaabbbccccdefww"
//b = "xxxxyyyyabklmopq"
//longest(a, b) -> "abcdefklmopqwxy"

package com.problems.CodeWarsSolutions;

public class TwotoOne {

	public static String TwotoOne(String s1, String s2) {
		String s3 = s1 + "" + s2;
		System.out.println(s3);
		return s3.chars().distinct().sorted()
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}

	public static void main(String[] args) {
		String a = "xyaabbbccccdefww", b = "xxxxyyyyabklmopq";
		System.out.println(TwotoOne(a, b));
	}

}
