public class Estudiante {
    private String nombre;
    private int edad;
    private String[] materias;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.materias = new String[5]; // Crear un arreglo para las materias
    }

    public void agregarMateria(String materia) {
        for (int i = 0; i < materias.length; i++) {
            if (materias[i] == null) {
                materias[i] = materia;
                break;
            }
        }
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Materias:");
        for (String materia : materias) {
            if (materia != null) {
                System.out.println("- " + materia);
            }
        }
    }

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Edenilson", 20);
        estudiante.agregarMateria("Matemáticas");
        estudiante.agregarMateria("Historia");
        estudiante.agregarMateria("Algebra");
        estudiante.mostrarInformacion();
    }
}
