package answer;

import java.util.Arrays;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */

public class MultiAnswer extends Answer{

	public MultiAnswer(String[] answerStrings, int[] answerIndex) throws IllegalAnswerForm{
		setAnswer(answerStrings, answerIndex);
	}

	public MultiAnswer(String[] answerStrings){
		_answerStrings = Arrays.copyOf(answerStrings, answerStrings.length);
	}

	@Override
	public MultiAnswer duplicateWithoutAnswers(){
		return new MultiAnswer(_answerStrings);
	}

	private void setAnswer(String[] answerStrings, int[] answerIndexes) throws IllegalAnswerForm{
		_answerStrings = Arrays.copyOf(answerStrings, answerStrings.length);
		setAnswerIndexes(answerIndexes);
	}

}
