public class Animal {

    private String nombre;
    private String raza;
    private String alimento;

    public Animal(String nombre, String raza, String alimento) {
        this.nombre = nombre;
        this.raza = raza;
        this.alimento = alimento;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Alimento: " + alimento);
    }

}