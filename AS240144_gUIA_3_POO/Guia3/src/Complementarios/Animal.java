package Complementarios;

public class Animal {
    protected String nombre;
    protected int edad;
    protected String alimento;

    public Animal(String nombre, int edad, String alimento) {
        this.nombre = nombre;
        this.edad = edad;
        this.alimento = alimento;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Alimento: " + alimento);
    }
}

class Gallo extends Animal {
    private String colorPlumas;

    public Gallo(String nombre, int edad, String alimento, String colorPlumas) {
        super(nombre, edad, alimento);
        this.colorPlumas = colorPlumas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Color de plumas: " + colorPlumas);
    }
}

class Perro extends Animal {
    private String colorPelaje;

    public Perro(String nombre, int edad, String alimento, String colorPelaje) {
        super(nombre, edad, alimento);
        this.colorPelaje = colorPelaje;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Color de pelaje: " + colorPelaje);
    }
}

class Gato extends Animal {
    private String colorOjos;

    public Gato(String nombre, int edad, String alimento, String colorOjos) {
        super(nombre, edad, alimento);
        this.colorOjos = colorOjos;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Color de ojos: " + colorOjos);
    }
}

class Hamster extends Animal {
    private int cantidadPulgas;

    public Hamster(String nombre, int edad, String alimento, int cantidadPulgas) {
        super(nombre, edad, alimento);
        this.cantidadPulgas = cantidadPulgas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Cantidad de pulgas: " + cantidadPulgas);
    }
}