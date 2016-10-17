import java.util.ArrayList;
import java.util.List;

import answer.Answer;
import answer.IllegalAnswerForm;
import answer.SingleAnswer;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */

public class SimulationDriver {

	public static void main(String[] args) {

		//create iVote
		IVote iVote = new IVote();

		//create answer with Strings and Correct Answers
		String[] answerStrings = {"1. A", "2. B"};
		Answer answer1 = null;
		try{
			answer1 = new SingleAnswer(answerStrings, 0);
		}catch(IllegalAnswerForm e){
			System.out.println(e);
		}

		System.out.println(answer1);

		//submit to iVote and start poll
		iVote.setAnswer(answer1);

		//create students
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student());
		studentList.add(new Student());

		//students connect with iVote and is assigned id
		for(Student student: studentList){
			student.connect(iVote);
		}

		//student gets question without answers
		for(Student student: studentList){
			student.retrieveQuestion();
		}

		//student saves answer indexes
		int[] indexes = new int[1];
		indexes[0] = 0;
		for(Student student: studentList){
			Answer answer = student.getAnswer();
			indexes[0] = (indexes[0] + 1) % answer.getNumIndexes();
			try {
				answer.setAnswerIndexes(indexes);
			} catch (IllegalAnswerForm e) {
				System.out.println(e);
			}
		}

		//student submits answer to iVote and iVote stores answers
		for(Student student: studentList){
			student.submitAnswer();
		}

		//teacher gets stats - iVote tallies current answers
		iVote.displayAnswerStats();

	}

}
