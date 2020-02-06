package st.lambda;

/**
 * https://pl.linkedin.com/in/adam-szadkowski-b6242b9a
 */
public interface Short1 {

	default short convertToShort(int value) { return (short)-value;}
}