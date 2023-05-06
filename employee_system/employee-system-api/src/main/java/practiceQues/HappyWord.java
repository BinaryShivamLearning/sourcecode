package practiceQues;

import java.util.Scanner;

public class HappyWord {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter any word :");
		try {
			byte[] wrd2BA = in.next().toUpperCase().getBytes();
			String values = "";
			for (int i = 0; i<wrd2BA.length;i++) {
				values = values + (wrd2BA[i] - 64);
			}			
			if(getResult(getIntArray(values)) == 1){
				System.out.println("A Happy Word");
			}else {
				System.out.println("Not A Happy Word");
			}
		}catch(Exception e) {
			System.err.println("Not a valid entry");
		}
		finally {
			in.close();
		}
	}
	
	static int getResult(int[] word) {
		for (int i : word) {
			System.out.print(i+" ");
		}
		System.out.println();
		int sum = 0;
		for (int i : word) {
			sum = sum + (int)Math.pow(i, 2);
		}
		if(sum>=10) {
			sum = getResult(getIntArray(sum+""));
		}
		return sum;
	}
	
	static int[] getIntArray(String word) {
		char[] numbs = word.toCharArray();
		int[] intArr = new int[numbs.length];
		for(int i = 0; i < numbs.length; i++) {
			intArr[i] = Integer.parseInt(numbs[i]+"");
		}
		return intArr;
	}
	
}
