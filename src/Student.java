import answer.Answer;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */

public class Student {
	public Student(){
	}

	/**
	 * Connects with iVote server and assigns id.
	 * @param iVote
	 */
	public void connect(IVote iVote){
		_iVote = iVote;
		_id = _iVote.getNewId();
	}

	public Answer getAnswer(){
		return _answer;
	}

	public int getId(){
		return _id;
	}

	/**
	 * Retrieves Answer with Question Strings filled from iVote
	 * @param iVote
	 */
	public void retrieveQuestion() {
		_answer = _iVote.getAnswer(_id);
	}

	/**
	 * Submits answer to iVote Server
	 */
	public void submitAnswer(){
		_iVote.studentSubmit(this);
	}

	private Answer _answer;
	private int _id;
	private IVote _iVote;
}
