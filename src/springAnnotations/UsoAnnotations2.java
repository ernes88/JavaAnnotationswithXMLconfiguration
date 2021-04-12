package springAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations2 {

	public static void main(String[] args) {
		
		//Leer el xml de configuracion.
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
		
		//Pedir el bean utilizando una Java Annotation
		Empleados antonio= contexto.getBean("ComercialEmpleado",Empleados.class);
		
		Empleados lucia= contexto.getBean("ComercialEmpleado",Empleados.class);
		
		//Apuntan al mismo objeto en memoria?
		if(antonio==lucia){
			System.out.println("Apuntan al mismo lugar en la memoria");
			System.out.println(antonio+ "\n" + lucia);
		}
		else{
			System.out.println("No apuntan a la misma posición de memoria");
			System.out.println(antonio+ "\n" + lucia);
		}
		
		//cerrar el contexto
		contexto.close();
	}

}
