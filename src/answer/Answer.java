package answer;

public abstract class Answer implements AnswerInterface {

	public boolean containsAnswer(Answer answer) {
		String[] answerStrings = answer.getAnswer();
		for(int i = 0; i < answerStrings.length; i++){
			if(_answerString[i].equals(answerStrings[i])){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isAnswer(Answer answer) {
		String[] answerStrings = answer.getAnswer();
		for(int i = 0; i < answerStrings.length; i++){
			if(!_answerString[i].equals(answerStrings[i])){
				return false;
			}
		}
		return true;
	}

	@Override
	public void setAnswer(int[] answerIndexes){

	}

	@Override
	public abstract void setAnswer(String[] answerString);

	@Override
	public void setAnswerOptions(String[] answerOptions) {
		_answerOptions = answerOptions;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(String answer: _answerString){
			sb.append(answer);
		}
		return sb.toString();
	}

	protected String[] getAnswer(){
		return _answerString;
	}

	protected String[] _answerString;
	protected String[] _answerOptions;
}
