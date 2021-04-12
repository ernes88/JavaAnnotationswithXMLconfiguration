package springAnnotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ComercialEmpleado")							//No tiene porque llamarse igual a la clase y no termina con ; Con esta instrucción le estamos diciendo a Spring que toda la clase que sigue a esta instrucción es la plantilla que debe usar para generarnos el bean de tipo COmercialEmpleado una vez se lo pidamos en nuestra clase UsoAnnotations.
//@Component también es permitido en cuyo caso el id del bean será el nombre de la clase empezando con minusculas, o sea comercialEmpleado. Esta forma de trabajar es más cómoda.
//@Scope("prototype")			//con esta etiqueta establecemos el patrón de diseño prototype para los beans ComercialEmpleado.
public class ComercialEmpleado implements Empleados {
	
	@Override
	public String getTareas() {	
		return "Vender, vender y vender más!!!";
	}
	
	//Este método de la clase ComercialEmpleado permite generar un informe genérico, pero con la inyección de la dependencia gana la potencialidad de generar el informe financiero
	@Override
	public String getInformes() {	
		//return "Esto es un informe genérico generado por el Comercial";
		return nuevoInformeFinanciero.getInformeFinanciero();
	}
	
	
	
	//genero el campo private de tipo objeto CreacionInformeFinanciero que va a contener el bean de tipo CreacionInformeFinanciero que se va a inyectar como dependencia.  
	//Cuando Spring lee estas dos líneas busca en nuestro
	@Autowired
	@Qualifier("InformeFinancieroTrim2")			//Con esta etiqueta le decimos a Spring cual de las clases que implementan la interfaz CreacionInformes va a ausar.
	private CreacionInformeFinanciero nuevoInformeFinanciero;		
	
	
	//Generar un constructor en la clase que solicita la dependencia (o sea esta clase ComercialEmpleado) para poder generar un informe financiero, pues por si sola esta clase no puede hacerlo.
	//La etiqueta @Component sobre la clase InformeFInancieroTrim1 define que esta clase es a la que pertenecerá el bean dependencia. Esta etiqueta le dice a Spring que tiene que mirar en esa clase para buscar un bean de tipo CreacionInformeFinanciero. Esta clase contiene info de la interfaz pues la implementa. Para inyectar la dependencia que ya esta creada y marcada para que Spring pueda encontrarla, incluimos la etiqueta @Autowired, sobre un constructor de la clase a la que se va a inyectar la dependencia, y de esta forma la inyectamos mediante este constructor.Todo esto ocurre de forma automatica o sea no es que tengamos que llamar a este constructor directamente en UsoEmpleado. 
	
	@Autowired																	//Con esta instrucción conseguimos que Spring busque en todo nuestro proyecto a ver si hay alguna clase que implemente la Interfaz CreacionInformeFinanciero, y si la encuentra es de esa clase de donde agarra la dependencia para inyectarla. Pues esa clase es InformeFinancieroTrim1.
	public ComercialEmpleado(@Qualifier("InformeFinancieroTrim2") CreacionInformeFinanciero nuevoInformeFinanciero) {
		this.nuevoInformeFinanciero = nuevoInformeFinanciero;
	}
	
	
	//@Autowired
	//Generación de método setter para inyectar una dependencia de tipo CreacionInformeFinanciero en esta clase ComercialEmpleado. Esta vía funciona exactamennte que la del constructor de arriba.	
	//public void setNuevoInformeFinanciero(CreacionInformeFinanciero nuevoInformeFinanciero) {
	//	this.nuevoInformeFinanciero = nuevoInformeFinanciero;
	//}
	
	//Métodos de ejemplo para probar @PostConstruct y @PreDestroy. Estos no deben recibir argumento, no tiene sentido que retornen nada y pueden ser tanto public, como protected como private. 
	//Método que se llama antes de ejecutarse el bean
	@PostConstruct
	public void ejecutaInit(){
		System.out.println("Ejecutando código previo al uso del bean");
	}
	
	
	
	//Ejecución de código después de apagado el contenedor de Spring
	@PreDestroy
	public void ejecutaDestroy(){
		System.out.println("Ejecutando código posterior al uso del bean");
	}
}
