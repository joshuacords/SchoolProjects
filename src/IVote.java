import java.util.HashMap;

import answer.Answer;

public class IVote {

	public IVote(){
		_answerMap = new HashMap<Integer, Answer>();
	}

	public void clearAnswers(){
		_answerMap.clear();
	}

	public void displayAnswerStats(){
		int students = 0;
		int correctAnswers = 0;

		for(Answer a : _answerMap.values()){
			students++;
			if(a.isAnswer(_answer)){
				correctAnswers++;
			}
		}

		System.out.println(students + " Students Polled");
		System.out.println(correctAnswers + " Correct Answers");
		System.out.println((float)correctAnswers*100/students + "% Correct");
	}

	public Answer getAnswer(){
		return _answer;
	}

	public void setAnswer(Answer answer){
		_answer = answer;
	}

	public void studentSubmit(Student student){
		_answerMap.put(student.getId(), student.getAnswer());
	}

	private HashMap<Integer, Answer> _answerMap;
	private Answer _answer;
}
