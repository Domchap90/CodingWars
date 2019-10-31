package com.problems.CodeWarsSolutions;

public class DnaStrand {

		  public static String makeComplement(String dna) {
		return dna.chars().map(c -> swapChars((char) c))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		// This method doesn't require a second method to call.
		// dna = dna.replaceAll('A','Z');
		// dna = dna.replaceAll('T','A');
		// dna = dna.replaceAll('Z','T');
		// dna = dna.replaceAll('G','D');
		// dna = dna.replaceAll('C','G');
		// dna = dna.replaceAll('D','C');

		  }

	public static char swapChars(char c) {
		if (c == 'A') {
			return 'T';
		}
		if (c == 'T') {
			return 'A';
		}
		if (c == 'C') {
			return 'G';
		}
		if (c == 'G') {
				return 'C';
			} else {
			return c;
			}
		}


	public static void main(String[] args) {
	   System.out.println(makeComplement("AAAA")); // "TTTT"
       System.out.println(makeComplement("ATTGC"));//"TAACG"
       System.out.println(makeComplement("GTAT"));//"CATA"

	}

}
