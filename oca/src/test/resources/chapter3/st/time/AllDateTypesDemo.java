package st.time;

/**
 * <br/>javac "./st/time/AllDateTypesDemo.java"
 * <br/>java -ea st.time.AllDateTypesDemo
 */
public class AllDateTypesDemo
{
	
	public static void main(String[] arg)
	{
		LocalTime lt = LocalTime.now();
		LocalDate ld = LocalDate.now();
		LocalDateTime ldt = LocalDateTime.now();
		printAllDates(lt, ld, ldt);
		
		lt = LocalTime.of(13, 54, 27, 100);
		ld = LocalDate.of(2013, 9, 1);
		ldt = LocalDateTime.of(1987, 7, 5, 11, 32, 8, 300);
		printAllDates(lt, ld, ldt);
		
		//ZonedDateTime
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("zdt: " + zdt);
	}
	
	private static void printAllDates(LocalTime lt, LocalDate ld, LocalDateTime ldt)
	{
		System.out.println("localTime : " + lt);
		System.out.println("localDate : " + ld);
		System.out.println("localDateTime : " + ldt);
	}
	
}