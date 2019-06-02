package com.asciiraider.g710.model.utilities;

public class Score {
	private int points;

	public Score(int points) throws  IllegalArgumentException{
		if(points < 0)
			throw new IllegalArgumentException("points cant be negative");
		this.points = points;
	}

	public int getPoints(){
		return this.points;
	}

	public char[] pointsToArray3() throws IllegalConversionException {
		String number = String.valueOf(this.points);
		char[] digits = number.toCharArray();
		char[] result = {'0', '0', '0'};
		switch (digits.length){
			case 1:
				result[2] = digits[0];
				break;
			case 2:
				result[1] = digits[0];
				result[2] = digits[1];
				break;
			case 3:
				result[0] = digits[0];
				result[1] = digits[1];
				result[2] = digits[2];
				break;
			case 4:
				result[2] = 'M';
				result[1] = digits[0];
				break;
			case 5:
				result[0] = digits[0];
				result[1] = digits[1];
				result[2] = 'M';
				break;
			default:
				throw new IllegalConversionException("Can't convert number higher than 99999 to length 3 array");
		}

		return result;
	}

	@Override
	public String toString() {
		return ""+points;
	}
}
