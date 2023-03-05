package servicos;

import java.text.ParseException;

public interface ServicoBitCoin { 
 double calcularConta();
 double getValorAGanhar();
 double getTotal();
 double getMesesRestantes();
String format() throws ParseException;
	    
	    
}
