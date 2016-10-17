package answer;

public class SingleAnswer extends Answer {

	public SingleAnswer(String answerString){
		_answerString = new String[1];
		_answerString[0] = answerString;
	}

	@Override
	protected String[] getAnswer(){
		return _answerString;
	}

	@Override
	public void setAnswer(String[] answerString){
		_answerString = answerString;
	}

}
