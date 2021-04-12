package springAnnotations;

import org.springframework.stereotype.Component;

@Component("InformeFinancieroTrim1")	//Con esta etiqueta creo otro bean en el proyecto este de tipo InformeFinancieroTrim1 que se inyectar� en la clase que lo solicite, que va a ser ComercialEmpleado
public class InformeFinancieroTrim1 implements CreacionInformeFinanciero {
	
	@Override
	public String getInformeFinanciero() {	
		return "Presentaci�n de informe financiero del trimestre 1";
	}

}
