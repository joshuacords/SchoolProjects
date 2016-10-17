package answer;

/**
 * @author Joshua Cords
 * CS 356 Object Oriented Programming - Project 1
 */
public class IllegalAnswerForm extends Exception{

	public IllegalAnswerForm() {
	}

	public IllegalAnswerForm(String msg) {
		_msg = msg;
	}

	@Override
	public String toString(){
		return "IllegalAnswerForm: " + _msg;
	}

	private String _msg;
	private static final long serialVersionUID = 1L;
}