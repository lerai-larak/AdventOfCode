package org.pesi.despatt.days;

import org.pesi.despatt.utils.tooling.FileManager;

public class Day1 implements Day {

	int [] numArray;
	String numberString;

	public Day1(){
		convertToArray();
	}
	/**
	 * Convert string to single digit array
	 * @return array composed of single digits from the string
	 */
	private void convertToArray() {
		numberString = FileManager.getFileContents("day1");
		numArray = new int[numberString.length()];
		int digitCounter = 1;

		for (int i=0; i < numberString.length(); i++){
			int j = Character.digit(numberString.charAt(i),10);
			this.numArray[i] = j;
			digitCounter ++;
		}
		System.out.println("Digits created: "+digitCounter);
	}

	public void partOne(){
		int sum = 0;
		for (int i = 0; i < numArray.length; i++) {
			if(numArray[i] == numArray[(i + 1) % numArray.length]){
				sum += numArray[i];
			}
		}
		System.out.println("Sum: " + sum);
	}

	public void partTwo() {
		int sum = 0;
		int stepCount = numArray.length / 2;
		for (int x = 0; x < numArray.length; x++) {
			if (numArray[x] == numArray[(x + stepCount) % numArray.length]) {
				sum += numArray[x];
			}
		}
			System.out.println("Sum: " + sum);
	}

}
