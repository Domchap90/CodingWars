package com.problems.CodeWarsSolutions;

import java.util.regex.Pattern;

public class BinaryRegexp {
	public static Pattern multipleOf3() {
		// String regex = "(11)*(1(010||00)*1)*0*";
		String regex = "(0*(11)*1((00)*0(1)*(00)*0)*(11)*1)+(0)*";
		return Pattern.compile(regex);

//		int state = 0;
//
//		for (int i=0;i<binaryString.length();i++) {
//			int digit = Integer.parseInt(String.valueOf(binaryString.charAt(i)));
//			switch(state) {
//			case(0):
//				if (digit==1) state=1;
//				break;
//			case(1):
//				if (digit==1) state=0;
//				else state=2;
//			case(2):
//				if (digit==1) state=2;
//				else state =1;
//			}
//		}
//			if (state ==0) return true;
//			return false;
//

//		int len = binaryString.length() - 1;
//		System.out.println(len + "\n");
//		int arr[] = new int[binaryString.length()];
//		for (int i = len; i > -1; i--) {
//			arr[len - i] = Integer.parseInt(String.valueOf(binaryString.charAt(i)));
//	    }
//		double powRaise2 = 0.0;
//		double sum = 0;
//		for (int element : arr) {
//			System.out.print(element + " ");
//			sum+=element*(pow(2.0,powRaise2));
//			powRaise2++;
//		}
//		System.out.println("\n" + sum);
//		if (sum % 3 == 0) {
//			return true;
//		}
//		return false;
	  }

	public static void main(String[] args) {
		// multipleOf3().matcher("110").matches();// TODO Auto-generated method stub
		System.out.println(multipleOf3().matcher("1111").matches());// true
		System.out.println(multipleOf3().matcher("101").matches());// false
		System.out.println(multipleOf3().matcher("110101").matches());// false
		System.out.println(multipleOf3().matcher("10010").matches());// true
		System.out.println();
		System.out.println(multipleOf3().matcher("111").matches());// false
		System.out.println(multipleOf3().matcher("1000").matches());// false
		System.out.println();
		System.out.println(multipleOf3().matcher(" 0").matches());// false
		System.out.println(multipleOf3().matcher("abc").matches());
		System.out.println(multipleOf3().matcher("000").matches());
		System.out.println(Integer.toBinaryString(12345678));
		System.out.println(multipleOf3().matcher(Integer.toBinaryString(12345678)).matches());
	}

}
