package springAnnotations;

import org.springframework.stereotype.Component;

@Component("InformeFinancieroTrim2")
public class InformeFinancieroTrim2 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		
		return "Presentación del informe del trimestre 2";
	}

}
