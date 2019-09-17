package utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringToCalendar {

	public static Calendar converter (String dataemtexto){
		
		
		Date data;
		try {
			data = new SimpleDateFormat("dd/MM/yyy").parse(dataemtexto);
		
			Calendar calendario = Calendar .getInstance();
			calendario.setTime(data);
			return calendario;
			
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
		
		
	}
	
	
}
