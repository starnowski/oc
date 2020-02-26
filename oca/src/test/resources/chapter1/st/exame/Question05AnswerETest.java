package st.exame;

/**
 * TODO
 * <br/>javac "./st/exame/Question05AnswerETest.java"
 * <br/>java "st.exame.Question05AnswerETest"
 */
public class Question05AnswerETest {

	public static void main(String []arg) {
		int count = 0;
		MAIN_LOOP:
		for (int row = 1; row <= 3; row++) {
			for (int col = 1; col <= 2; col++) {
				if (row * col % 2 == 0)
					continue MAIN_LOOP;
				count++;
			}
		}
		System.out.println("count:" + count);
	}
}