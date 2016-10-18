package components;
import java.util.HashMap;

import answer.Answer;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */

public class IVote {

	public IVote(){
		_answerMap = new HashMap<Integer, Answer>();
		_idCounter = 0;
	}

	/**
	 * Sizes internal elements to expected classSize
	 * @param classSize
	 */
	public IVote(int classSize){
		_answerMap = new HashMap<Integer, Answer>((int) (classSize * 1.5));
		_idCounter = 0;
	}

	/**
	 * Resets all answers which were entered
	 */
	public void clearAnswers(){
		_answerMap.clear();
	}

	/**
	 * Displays Students Polled, Correct Answers, and % Correct
	 */
	public void displayAnswerStats(){
		int students = 0;
		int correctAnswers = 0;
		int[] answers = new int [_answer.getNumIndexes()];

		for(Answer a : _answerMap.values()){
			students++;

			for(int i = 0; i < answers.length; i++){
				if(a.hasAnswerIndex(i)){
					answers[i]++;
				}
			}

			if(a.isAnswer(_answer)){
				correctAnswers++;
			}
		}

		for(int i = 0; i < answers.length; i++){
			System.out.print(_answer.getAnswerStrings()[i] + "\t" + answers[i]);

			if(_answer.hasAnswerIndex(i)){
				System.out.print("\tCorrect");
			}

			System.out.println();
		}

		System.out.println(students + " Students Polled");
		System.out.println(correctAnswers + " Correct Answers");
		System.out.println((float)correctAnswers*100/students + "% Correct");
	}

	public Answer getAnswer(){
		return _answer.duplicateWithoutAnswers();
	}

	/**
	 * Assigns a fresh student id
	 * @return
	 */
	public int getNewId() {
		return _idCounter++;
	}

	/**
	 * Sets the master answer for use in duplicating to students and for determining correctness
	 * @param answer
	 */
	public void setAnswer(Answer answer){
		_answer = answer;
		clearAnswers();
	}

	/**
	 * Stores student submission
	 * @param student
	 */
	public void studentSubmit(Student student){
		//testPrint(student);
		_answerMap.put(student.getId(), student.getAnswer());
	}

	@SuppressWarnings("unused")
	private void testPrint(Student student){
		System.out.print("Student id: " + student.getId() + " Answer: " );

		for(int index : student.getAnswer().getAnswerIndexes()){
			System.out.print(index + ", ");
		}

		System.out.println();
	}

	private Answer _answer;
	private HashMap<Integer, Answer> _answerMap;
	private int _idCounter;

}
