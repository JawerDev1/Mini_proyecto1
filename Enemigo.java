public class Enemigo extends Personaje {
    private TipoEnemigo tipo;

    public Enemigo(TipoEnemigo tipo, String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, mp, ataque, defensa, velocidad);
        this.tipo = tipo;
    }

    public TipoEnemigo getTipo() {
        return tipo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println(nombre + " (" + tipo + ")");
        System.out.println("HP: " + hp + " | MP: " + mp + " | ATK: " + ataque + " | DEF: " + defensa + " | VEL: " + velocidad);
        System.out.println();
    }
}
