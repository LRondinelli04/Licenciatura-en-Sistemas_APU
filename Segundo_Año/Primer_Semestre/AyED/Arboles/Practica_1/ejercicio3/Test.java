package tp1.ejercicio3;

public class Test {

	public static void main(String[] args) {
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];

		estudiantes[0] = new Estudiante();
		estudiantes[0].setNombre("Juan");
		estudiantes[0].setApellido("Perez");
		estudiantes[0].setComision("A");
		estudiantes[0].setEmail("juan.perez@example.com");
		estudiantes[0].setDireccion("Calle 123");

		estudiantes[1] = new Estudiante();
		estudiantes[1].setNombre("Maria");
		estudiantes[1].setApellido("Gomez");
		estudiantes[1].setComision("B");
		estudiantes[1].setEmail("maria.gomez@example.com");
		estudiantes[1].setDireccion("Avenida 456");

		profesores[0] = new Profesor();
		profesores[0].setNombre("Carlos");
		profesores[0].setApellido("Lopez");
		profesores[0].setEmail("carlos.lopez@example.com");
		profesores[0].setCatedra("Matemáticas");
		profesores[0].setFacultad("Ingeniería");

		profesores[1] = new Profesor();
		profesores[1].setNombre("Ana");
		profesores[1].setApellido("Martinez");
		profesores[1].setEmail("ana.martinez@example.com");
		profesores[1].setCatedra("Física");
		profesores[1].setFacultad("Ciencias");

		profesores[2] = new Profesor();
		profesores[2].setNombre("Luis");
		profesores[2].setApellido("Garcia");
		profesores[2].setEmail("luis.garcia@example.com");
		profesores[2].setCatedra("Programación");
		profesores[2].setFacultad("Informática");

		System.out.println("Estudiantes:");
		for (Estudiante e : estudiantes) {
			System.out.println(e.tusDatos());
		}

		System.out.println("Profesores:");
		for (Profesor p : profesores) {
			System.out.println(p.tusDatos());
		}

	}

}
