import java.util.ArrayList;
import java.util.Scanner;

public class Combate {
    private Heroe[] heroes;
    private Enemigo[] enemigos;
    private Scanner sc;

    public Combate(Heroe[] heroes, Enemigo[] enemigos) {
        this.heroes = heroes;
        this.enemigos = enemigos;
        this.sc = new Scanner(System.in);
    }

    public void iniciarCombate() {
        System.out.println(" ¡Comienza la batalla! ");

        // Mientras ambos equipo tengan personajes vivos
        while (!todosMuertos(heroes) && !todosMuertos(enemigos)) {
            // Creamos una lista con todos los personajes vivos
            List<Personaje> todos = new ArrayList<>();

            for (Heroe h : heroes) {
                if (h.estaVivo()) {
                    todos.add(h);
                }
            }
            for (Enemigo e : enemigos) {
                if (e.estaVivo()) {
                    todos.add(e);
                }
            }

            // Ordenamos por velocidad el mas rapido va primero
            Collections.sort(todos, (a, b) -> b.getVelocidad() - a.getVelocidad());

            // Cada personaje hace su turno
            for (Personaje personaje : todos) {
                if (!personaje.estaVivo()) {
                    continue;
                }

                if (personaje instanceof Heroe) {
                    turnoHeroe((Heroe) personaje);
                } else {
                    turnoEnemigo((Enemigo) personaje);
                }

                // Revisamos si alguien gano despues de cada accion
                if (todosMuertos(heroes) || todosMuertos(enemigos)) {
                    break;
                }
            }
        }

        // Al salir del bucle, mostramos quien gano
        if (todosMuertos(enemigos)) {
            System.out.println("¡Victoria! Los heroes ganaron.");
        } else {
            System.out.println("Derrota... Los enemigos ganaron");
        }
    }

    private boolean todosMuertos(Personaje[] grupo) {
        for (Personaje personaje : grupo) {
            if (personaje.estaVivo()) return false;
            }
        return true;
    }

    private void turnoHeroe(Heroe heroe){
        System.out.println("\n Turno de " + heroe.getNombre());
        System.out.println("HP: " + heroe.getHp() + " | MP: " + heroe.getMp());

        System.out.println("Elige accion: ");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Usar Habilidad");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                Enemigo objetivo = elEnemigo();
                if (objetivo != null) {
                    ejecutarAtaque(heroe, objetivo);
                }
                break;
            case 2:
                System.out.println(heroe.getNombre() + " se defiende este turno.");
                heroe.defensa +=5;
                break;
            case 3:
                if (heroe.getHabilidades().isEmpty()) {
                    System.out.println("No tiene habilidades.");
                } else {
                    System.out.println("Elige habilidad: ");
                    for(int i = 0; i < heroe.getHabilidades().size(); i++){
                        System.out.println(i+1 + ". " + heroe.getHabilidades().get(i));
                    }
                    int hab = sc.nextInt() - 1;
                    if (hab >= 0 && hab < heroe.getHabilidades().size()) {
                        Habilidad habilidad = heroe.getHabilidades().get(hab);
                        if (heroe.getMp() >= habilidad.getCostoMP()) {
                            heroe.mp -= habilidad.getCostoMP();
                            if (habilidad.getTipo() == TipoHabilidad.ATAQUE) {
                                Enemigo obj = elEnemigo();
                                if(obj != null){
                                    System.out.println(heroe.getNombre() + " usa " + habilidad.getNombre() + " contra " + obj.getNombre());
                                    obj.recibirDanio(habilidad.getEfecto());
                                }
                            }else if (habilidad.getTipo() == TipoHabilidad.CURACION) {
                                System.out.println(heroe.getNombre() + " usa " + habilidad.getNombre() + " y se cura " + habilidad.getEfecto());
                                heroe.curar(habilidad.getEfecto());
                            }
                        }else {
                                System.out.println("No tienes suficiente MP.");
                        }
                    }
                }
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }

    private void turnoEnemigo(Enemigo enemigo){
        Random r = new Random();
        Heroe objHeroe = heroes[r.nextInt(heroes.length)];
        while (!objHeroe.estaVivo()) {
            objHeroe = heroes[r.nextInt(heroes.length)];
        }
        ejecutarAtaque(enemigo, objHeroe);
    }

    private void ejecutarAtaque(Personaje atacante, Personaje objetivo){
        int danio = atacante.getAtaque() - objetivo.getDefensa();
        if (danio < 0 ){
            danio = 0;
        }
        System.out.println(atacante.getNombre() + " ataca a " + objetivo.getNombre() + " causando " + danio + " de daño.");
        objetivo.recibirDanio(danio);
        if (!objetivo.estaVivo()) {
            System.out.println(objetivo.getNombre() + " ha sido derrotado.");
        }
    }

    private Enemigo elEnemigo(){
        System.out.println("Elige enemigo: ");
        for (int i = 0; i < enemigos.length; i++) {
            if (enemigos[i].estaVivo()) {
                System.out.println((i+1) + ". " + enemigos[i].getNombre() + " (HP: " + enemigos[i].getHp() + ")");
            }
        }

        int elecion = sc.nextInt() -1;
        if (elecion >= 0 && elecion < enemigos.length && enemigos[elecion].estaVivo()) {
            return enemigos[elecion];
        }
        System.out.println("Enemigo invalido");
        return null;
    }

}