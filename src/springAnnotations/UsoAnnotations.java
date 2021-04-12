package springAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnnotations {

	public static void main(String[] args) {
		
		//Leer el xml de configuracion.
		ClassPathXmlApplicationContext contexto=new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
		
		//Pedir el bean utilizando una Java Annotation
		Empleados fernando= contexto.getBean("ComercialEmpleado",Empleados.class);
		
		//Utilizar el bean
		System.out.println(fernando.getTareas());
		System.out.println(fernando.getInformes());
		
		//cerrar el contexto
		contexto.close();
	}

}
