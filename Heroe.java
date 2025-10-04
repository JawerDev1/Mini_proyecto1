public class Heroe extends Personaje {
    private TipoHeroe tipo;

    public Heroe(TipoHeroe tipo, String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, mp, ataque, defensa, velocidad);
        this.tipo = tipo;
    }

    public TipoHeroe getTipo() {
        return tipo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("🔥 " + nombre + " (" + tipo + ")");
        System.out.println("HP: " + hp + " | MP: " + mp + " | ATK: " + ataque + " | DEF: " + defensa + " | VEL: " + velocidad);
        System.out.println("Habilidades:");
        for (Habilidad h : habilidades) {
            System.out.println(" - " + h);
        }
        System.out.println();
    }
}
