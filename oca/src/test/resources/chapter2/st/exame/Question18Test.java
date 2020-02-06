package st.exame;

/**
 * <br/>javac "./st/exame/Question18Test.java"
 * <br/>java "st.exame.Question18Test"
 */
public class Question18Test {

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