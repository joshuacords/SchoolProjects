import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import answer.Answer;
import answer.IllegalAnswerForm;
import answer.MultiAnswer;
import answer.SingleAnswer;
import components.IVote;

public class Teacher {

	public Teacher(IVote iVote){
		_iVote = iVote;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of students: ");
		_numStudents = scanner.nextInt();

		System.out.println("Enter number of possible answers: ");
		_numAnswers = scanner.nextInt();

		System.out.println("Muliple answers allowed? (y/n): ");
		String multiple = scanner.next();

		_multiple = (multiple.equals("y") || multiple.equals("Y"));

		_answerStrings = new String[_numAnswers];

		scanner.nextLine();

		for(int i = 0; i < _numAnswers; i++){
			System.out.println("Enter possible answer " + (i+1) + ": ");
			_answerStrings[i] = scanner.nextLine();
		}

		if(_multiple){
			setMultiple(scanner);
		} else {
			setSingle(scanner);
		}

		scanner.close();

		setAnswer();

	}

	public int getNumStudents(){
		return _numStudents;
	}

	private void setAnswer() {
		Answer answer1 = null;
		try{
			if(_multiple){
				answer1 = new MultiAnswer(_answerStrings, _answerIndexes);
			} else {
				answer1 = new SingleAnswer(_answerStrings, _answerIndexes[0]);
			}

		}catch(IllegalAnswerForm e){
			System.out.println(e);
		}

		System.out.println(answer1);

		//submit to iVote and start poll
		_iVote.setAnswer(answer1);
	}

	private void setMultiple(Scanner scanner){
		List<Integer> intList = new ArrayList<Integer>();
		int temp = 0;

		for(int i = 0; i < _numAnswers; i++){
			System.out.println("Enter correct answer index (0 when finished): ");
			temp = (scanner.nextInt() - 1);
			if(temp < 0){
				break;
			}
			intList.add(temp);
		}

		_answerIndexes = new int[intList.size()];
		for(int i = 0; i < _answerIndexes.length; i++){
			_answerIndexes[i] = intList.get(i);
		}
	}

	private void setSingle(Scanner scanner){
		_answerIndexes = new int[1];
		System.out.println("Enter correct answer index: ");
		_answerIndexes[0] = (scanner.nextInt() - 1);
	}

	private int[] _answerIndexes;
	private String[] _answerStrings;
	private IVote _iVote;
	private boolean _multiple;
	private int _numAnswers;
	private int _numStudents;
}
