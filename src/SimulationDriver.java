import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import answer.Answer;
import answer.IllegalAnswerForm;
import answer.SingleAnswer;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */

public class SimulationDriver {

	public static void main(String[] args) {

		int numStudents = 10;

		//create iVote
		IVote iVote = new IVote();

		//create answer with Strings and Correct Answers
		String[] answerStrings = {"1. A", "2. B", "3. C"};
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
		for(int i = 0; i < numStudents; i++){
			studentList.add(new Student());
		}

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
			indexes[0] = ThreadLocalRandom.current().nextInt(0, student.getAnswer().getNumIndexes());
			System.out.println("index[0] = " + indexes[0]);
			try {
				student.setAnswerIndexes(indexes);
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
