# Dragon Quest - Mini Proyecto 1

### Integrantes:
- **Kevin** – Implementación de clases base (`Personaje`, `Heroe`, `Enemigo`, `Habilidad`, etc.)
- **Jhon** – Implementación de la lógica del combate (`Combate.java`, `DragonQuest.java`)

---

##  Descripción general
**Dragon Quest** es un juego de combate por turnos desarrollado en **Java**.  
El jugador controla un grupo de héroes que se enfrentan a enemigos en batallas por rondas.  
Cada héroe y enemigo posee estadísticas (vida, ataque, defensa, velocidad y magia) y habilidades especiales.

---

##  Funcionamiento del juego

1. El programa muestra un **menú interactivo** en consola:
   - `1. Iniciar combate`
   - `2. Mostrar héroes`
   - `3. Mostrar enemigos`
   - `0. Salir`

2. Si eliges *iniciar combate*:
   - Los personajes se ordenan por **velocidad**.
   - Cada héroe puede **atacar, defender o usar habilidades**.
   - Los enemigos atacan automáticamente.
   - El combate termina cuando todos los enemigos o todos los héroes han caído.

3. El resultado se muestra en consola con mensajes narrativos:
   - Daños causados 
   - Habilidades usadas 
   - Personajes derrotados 
   - Victoria o derrota 

---

##  Clases principales

| Clase | Descripción |
|-------|--------------|
| `Personaje` | Clase base con los atributos comunes (vida, ataque, defensa, etc.) |
| `Heroe` | Hereda de `Personaje`, representa a los personajes controlados por el jugador |
| `Enemigo` | Hereda de `Personaje`, representa a los oponentes |
| `Habilidad` | Define las acciones especiales con tipo, costo de MP y efecto |
| `Combate` | Controla la lógica de los turnos, ataques y finalización del combate |
| `DragonQuest` | Contiene el método `main` y el menú interactivo |

---

## 🕹️ Ejemplo de ejecución
=== MENÚ PRINCIPAL ===

Iniciar Combate

Mostrar Héroes

Mostrar Enemigos

Salir
Elige una opción: 1

 ¡Comienza la batalla! ️
 Turno de Andres
HP: 120 | MP: 50

1. Atacar
2. Defender
3. Usar habilidad

Elige: 1

Andres ataca a Slime Azul causando 25 de daño.

Slime Azul ha sido derrotado.

¡Victoria! Los héroes ganaron.
