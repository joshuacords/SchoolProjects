package answer;

public interface AnswerInterface {
	public boolean isAnswer(Answer answer);
	public void setAnswer(int[] answerIndexes);
	public void setAnswer(String[] answerString);
	public void setAnswerOptions(String[] answerOptions);
	@Override
	public String toString();
}
