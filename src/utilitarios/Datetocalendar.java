package utilitarios;

import java.sql.Date;
import java.util.Calendar;

public class Datetocalendar {

	
	public static Calendar converter (Date date){
		
		Calendar calendario= Calendar.getInstance();
		calendario.setTime(date);
		
		return calendario;
		
		
		
		
	} 
	
}
