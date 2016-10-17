package answer;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */

public interface AnswerInterface {
	public Answer duplicateWithoutAnswers();
	public boolean isAnswer(Answer answer);
	public String[] getAnswerStrings();
	public int getNumIndexes();
	@Override
	public String toString();
}