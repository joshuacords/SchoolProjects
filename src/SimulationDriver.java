import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import answer.IllegalAnswerForm;
import answer.MultiAnswer;
import components.IVote;
import components.Student;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */

public class SimulationDriver {

	public static void main(String[] args) {

		/*int numStudents = 10;



		//create answer with Strings and Correct Answers
		String[] answerStrings = {"1. A", "2. B"};
		Answer answer1 = null;
		try{
			//answer1 = new SingleAnswer(answerStrings, 0);
			int[] answerIndexes = {0, 1};
			answer1 = new MultiAnswer(answerStrings, answerIndexes);
		}catch(IllegalAnswerForm e){
			System.out.println(e);
		}

		System.out.println(answer1);

		//submit to iVote and start poll
		iVote.setAnswer(answer1);*/
		//create iVote

		IVote iVote = new IVote();

		Teacher teacher = new Teacher(iVote);

		//create students
		List<Student> studentList = new ArrayList<Student>();
		for(int i = 0; i < teacher.getNumStudents(); i++){
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
		boolean multiple = (iVote.getAnswer().getClass() == MultiAnswer.class);
		for(Student student: studentList){
			int[] indexes = getRandomIndexes(student.getAnswer().getNumIndexes(), multiple);

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

	private static int[] getRandomIndexes(int numAnswers, boolean multiple){
		int[] indexes = null;
		if(!multiple){
			indexes = new int[1];
			indexes[0] = ThreadLocalRandom.current().nextInt(0, numAnswers);
			return indexes;
		}

		int answers = ThreadLocalRandom.current().nextInt(1, numAnswers + 1);
		Set<Integer> set = new TreeSet<Integer>();

		for(int i = 0; i < answers; i++){
			set.add(ThreadLocalRandom.current().nextInt(0, numAnswers));
		}

		indexes = new int[set.size()];

		int i = 0;
		for(int num : set){
			indexes[i++] = num;
		}

		return indexes;
	}

}
