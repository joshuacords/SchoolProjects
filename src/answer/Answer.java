package answer;

import java.util.Arrays;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */

public abstract class Answer implements AnswerInterface {

	/**
	 * Returns true if this Answer contains an answerIndex the same as the passed answer.
	 * @param answer
	 * @return
	 */
	public boolean containsAnswer(Answer answer) {
		int[] answerIndexes = answer.getAnswerIndexes();
		for(int i = 0; i < answerIndexes.length; i++){
			for(int j = 0; j < _answerIndexes.length; j++){
				if(_answerIndexes[j] == answerIndexes[i]){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Creates duplicate Answer without answerIndexes
	 * @param num
	 * @return
	 */
	@Override
	public abstract Answer duplicateWithoutAnswers();

	public int[] getAnswerIndexes() {
		return _answerIndexes;
	}

	@Override
	public String[] getAnswerStrings(){
		return _answerStrings;
	}

	@Override
	public int getNumIndexes(){
		return _answerStrings.length;
	}

	public boolean hasAnswerIndex(int index){
		for(int answerIndex : _answerIndexes){
			if(index == answerIndex){
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if this Answer contains identical answerIndexes as the passed answer.
	 * @param answer
	 * @return
	 */
	@Override
	public boolean isAnswer(Answer answer) {
		int[] answerIndexes = answer.getAnswerIndexes();

		if(_answerIndexes.length != answerIndexes.length){
			return false;
		}

		for(int i = 0; i < answerIndexes.length; i++){
			if(_answerIndexes[i] != answerIndexes[i]){
				return false;
			}
		}
		return true;
	}

	/**
	 * Sets indexes of selected answers, throws IllegalAnswerForm when index is out of bounds.
	 * @param indexes
	 * @throws IllegalAnswerForm
	 */
	public void setAnswerIndexes(int[] indexes) throws IllegalAnswerForm {
		validate(indexes);
		_answerIndexes = Arrays.copyOf(indexes, indexes.length);
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Answer Choices:\n");
		for(String answer: _answerStrings){
			sb.append(answer + "\n");
		}
		return sb.toString();
	}

	/**
	 * Insures answer indexes stay in bounds
	 * @param answerIndexes
	 * @throws IllegalAnswerForm
	 */
	@SuppressWarnings("unused")
	protected void validate(int[] answerIndexes) throws IllegalAnswerForm{
		try{
			for(int answerIndex: answerIndexes){
				String safeIndex = _answerStrings[answerIndex];
			}
		} catch (IndexOutOfBoundsException e){
			throw new IllegalAnswerForm("AnswerIndex must be from under " +
					"answerString index size, starting with 0");
		}
	}

	protected int[] _answerIndexes;
	protected String[] _answerStrings;
	protected String[] _answerOptions;

}