import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
    protected String nombre;
    protected int hp;
    protected int mp;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected Estado estado;
    protected List<Habilidad> habilidades;

    public Personaje(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.hp = hp;
        this.mp = mp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.estado = Estado.VIVO;
        this.habilidades = new ArrayList<>();
    }

    public boolean estaVivo() {
        return estado == Estado.VIVO;
    }

    public void recibirDanio(int danio) {
        hp -= danio;
        if (hp <= 0) {
            hp = 0;
            estado = Estado.MUERTO;
        }
    }

    public void curar(int cantidad) {
        if (estado == Estado.VIVO) {
            hp += cantidad;
        }
    }

    public abstract void mostrarInfo();

    // Getters
    public String getNombre() { return nombre; }
    public int getHp() { return hp; }
    public int getMp() { return mp; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getVelocidad() { return velocidad; }
    public Estado getEstado() { return estado; }
    public List<Habilidad> getHabilidades() { return habilidades; }
}
