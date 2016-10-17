import answer.Answer;

public class Student {

	public Student(int id){
		_id = id;
	}

	public Answer getAnswer(){
		return _answer;
	}

	public int getId(){
		return _id;
	}

	public void setAnswer(Answer answer){
		_answer = answer;
	}

	public void setAnswerOptions(String[] answerOptions){
		_answer.setAnswerOptions(answerOptions);
	}

	public void submitAnswer(IVote iVote){
		iVote.studentSubmit(this);
	}

	private int _id;
	private Answer _answer;
}
