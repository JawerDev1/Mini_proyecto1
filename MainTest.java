public class MainTest {
    public static void main(String[] args) {

        // Crear un héroe de ejemplo
        Heroe heroe = new Heroe(TipoHeroe.HEROE, "Héroe principal", 120, 50, 20, 15, 12);
        heroe.getHabilidades().add(new Habilidad("Espada del alma", 10, TipoHabilidad.ATAQUE, 30));
        heroe.getHabilidades().add(new Habilidad("Curación ligera", 5, TipoHabilidad.CURACION, 20));

        // Crear un enemigo de ejemplo
        Enemigo slime = new Enemigo(TipoEnemigo.SLIME, "Slime azul", 80, 10, 12, 8, 10);

        // Mostrar información
        System.out.println("=== HEROE ===");
        heroe.mostrarInfo();

        System.out.println("=== ENEMIGO ===");
        slime.mostrarInfo();
    }
}
