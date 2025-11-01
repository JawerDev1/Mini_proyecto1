import java.util.Scanner;

public class DragonQuest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creamos los heroes
        Heroe[] heroes = new Heroe[4];
        heroes[0]= new Heroe(TipoHeroe.HEROE, "Andres", 120, 50, 20, 15, 12);
        heroes[1]= new Heroe(TipoHeroe.HEROE, "Yangus", 150, 20, 25, 10, 8);
        heroes[2]= new Heroe(TipoHeroe.HEROE, "Jessica", 100, 80, 15, 10, 14);
        heroes[3]= new Heroe(TipoHeroe.HEROE, "Angelo", 110, 60, 18, 12, 13);

        // Añadimos algunas habilidades
        heroes[0].getHabilidades().add(new Habilidad("Espada del Alma", 10, TipoHabilidad.ATAQUE, 30));
        heroes[2].getHabilidades().add(new Habilidad("Fuego Magico", 12, TipoHabilidad.ATAQUE, 25));
        heroes[3].getHabilidades().add(new Habilidad("Curacion Divina", 8, TipoHabilidad.CURACION, 20));
        
        // Creamos los enemigos 
        Enemigo[] enemigos = new Enemigo[4];
        enemigos[0] = new Enemigo(TipoEnemigo.SLIME, "Slime Azul", 80, 10, 12, 8, 10);
        enemigos[1] = new Enemigo(TipoEnemigo.GOBLIN, "Goblin", 100, 15, 14, 9, 11);
        enemigos[2] = new Enemigo(TipoEnemigo.BRUJO, "Brujo", 90, 40, 10, 7, 13);
        enemigos[3] = new Enemigo(TipoEnemigo.DRAGON, "Dragon", 200, 30, 25, 18, 6);

        int opcion = 0;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Iniciar Combate");
            System.out.println("2. Mostrar Heroe");
            System.out.println("3. Mostrar Enemigos");
            System.out.println("0. Salir");

            System.out.println("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Combate combate = new Combate(heroes, enemigos);
                    combate.iniciarCombate();                    
                    break;
                case 2:
                    for (Heroe heroe : heroes) {
                        heroe.mostrarInfo();
                    }
                    break;
                case 3:
                    for (Enemigo enemigo : enemigos) {
                        enemigo.mostrarInfo();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del juego....");
                    break;            
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (opcion != 0);

    }
    
}