package answer;

import java.util.Arrays;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */

public class SingleAnswer extends Answer {

	public SingleAnswer(String[] answerStrings, int answerIndex) throws IllegalAnswerForm{
		setAnswer(answerStrings, answerIndex);
	}

	public SingleAnswer(String[] answerStrings){
		_answerStrings = Arrays.copyOf(answerStrings, answerStrings.length);
	}

	@Override
	public SingleAnswer duplicateWithoutAnswers(){
		return new SingleAnswer(_answerStrings);
	}

	public void setAnswerIndex(int answerIndex) throws IllegalAnswerForm{
		_answerIndexes = new int[1];
		_answerIndexes[0] = answerIndex;
		setAnswerIndexes(_answerIndexes);
	}

	private void setAnswer(String[] answerStrings, int answerIndex) throws IllegalAnswerForm{
		_answerStrings = Arrays.copyOf(answerStrings, answerStrings.length);
		setAnswerIndex(answerIndex);
	}

}