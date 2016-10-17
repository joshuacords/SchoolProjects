import answer.Answer;
import answer.SingleAnswer;

public class SimulationDriver {

	public static void main(String[] args) {

		Student s1 = new Student(1);
		s1.setAnswer(new SingleAnswer("A"));

		Student s2 = new Student(2);
		s2.setAnswer(new SingleAnswer("B"));

		IVote iVote = new IVote();
		Answer a1 = new SingleAnswer("B");

		iVote.setAnswer(a1);

		s1.submitAnswer(iVote);
		s2.submitAnswer(iVote);

		iVote.displayAnswerStats();
	}

}
