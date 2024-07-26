public class Perro extends Animal {


    private String colorPelaje;

    public Perro(String nombre, String raza, String alimento, String colorPelaje) {
        super(nombre, raza, alimento);
        this.colorPelaje = colorPelaje;
    }
}
