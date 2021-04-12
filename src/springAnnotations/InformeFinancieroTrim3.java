package springAnnotations;

import org.springframework.stereotype.Component;

@Component("InformeFinancieroTrim3")
public class InformeFinancieroTrim3 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		
		return "Presentación del informe financiero del trimestre 3";
	}

}
