
package com.mycompany.Actividades_Ignacio;

import java.util.Scanner;

/**
 *
 * @author ignac
 */

public class Pokedex {

    static String[] pokemon = new String[5];

    public static void main(String[] args) {
        int opc;
        Scanner sc = new Scanner(System.in);
        do {
            mostrarMenu();
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1:
                    fillAuto();
                    break;
                case 2:
                    addPokemon();
                    break;
                case 3:
                    addPokemonAtPosition();
                    break;
                case 4:
                    deletePokemon();
                    break;
                case 5:
                    deletePokemonAtPosition();
                    break;
                case 6:
                    findPokemon();
                    break;
                case 7:
                    showAll();
                    break;
                case 8:
                    getPokemonAtPosition();
                    break;
                case 9:
                    countPokemon();
                    break;
                case 10:
                    hackPokedex();
                    break;
                case 11:
                    erasePokedex();
                    break;
            }
        } while (opc != 12);
    }

    public static void mostrarMenu() {
        System.out.println("1. Llenar Pokemon");
        System.out.println("2. Añadir Pokemon");
        System.out.println("3. Añadir pokemon en una posicion");
        System.out.println("4. Borrar pokemon");
        System.out.println("5. Borrar pokemon en una posicion");
        System.out.println("6. Buscar Pokemon");
        System.out.println("7. Mostrar todos los Pokemon");
        System.out.println("8. Poner Pokemon en una posicion");
        System.out.println("9. Contar Pokemon");
        System.out.println("10. Hack Pokedex");
        System.out.println("11. Borrar Pokedex info");
        System.out.println("12. Salir");
    }

    public static void fillAuto() {
        String[] autoFill = {"Pikachu", "Charmander", "Bulbasaur", "Squirtle", "Eevee"};
        int count = 0;
        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] == null) {
                pokemon[i] = autoFill[i];
                count++;
            }
        }
        System.out.println("Pokedex llenada automáticamente. Pokemons añadidos: " + count);
    }

    public static void addPokemon() {

        // pedir pok
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String name = sc.nextLine();

        // buscar si existe
        for (String p : pokemon) {
            if (p != null && p.equals(name)) {
                System.out.println("El pokemon ya existe");
                return;
            }
        }
        // buscar posicion libre
        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] == null) {
                pokemon[i] = name;
                System.out.println("Pokemon añadido en " + i);
                return;
            }
        }

        System.out.println("Pokedex llena");
    }

    public static void addPokemonAtPosition() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Posicion: ");
        int pos = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String name = sc.nextLine();

        if (pos < 0 || pos >= pokemon.length) {
            System.out.println("Posición inválida");
            return;
        }

        for (String p : pokemon) {
            if (p != null && p.equalsIgnoreCase(name)) {
                System.out.println("El Pokemon ya existe");
                return;
            }
        }

        if (pokemon[pos] == null) {
            pokemon[pos] = name;
            System.out.println("Pokemon añadido en posición " + pos);
        } else {
            System.out.println("Posición ocupada");
        }
    }

    public static void deletePokemon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String name = sc.nextLine();

        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] != null && pokemon[i].equals(name)) {
                pokemon[i] = null;
                System.out.println("Pokemon eliminado");
                return;
            }
        }
        System.out.println("Pokemon no encontrado");
    }

    public static void deletePokemonAtPosition() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Posicion ");
        int pos = sc.nextInt();

        if (pos < 0 || pos >= pokemon.length) {
            System.out.println("Posición inválid");
            return;
        }

        if (pokemon[pos] != null) {
            pokemon[pos] = null;
            System.out.println("Pokemon eliminado en posición " + pos);
        } else {
            System.out.println("No hay Pokemon en esa posición");
        }
    }

    public static void findPokemon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame un pokemon: ");
        String name = sc.nextLine();

        for (int i = 0; i < pokemon.length; i++) {
            if (pokemon[i] != null && pokemon[i].equals(name)) {
                System.out.println("Encontrado en posición " + i + ": " + pokemon[i]);
                return;
            }
        }
        System.out.println("Pokemon no encontrado");
    }

    public static void showAll() {
        boolean empty = true;
        for (String p : pokemon) {
            if (p != null) {
                System.out.println(p);
                empty = false;
            }
        }
        if (empty) {
            System.out.println("No hay pokemon en la pokedex");
        }
    }

    public static void getPokemonAtPosition() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame una posicion: ");
        int pos = sc.nextInt();

        if (pos < 0 || pos >= pokemon.length) {
            System.out.println("Posicion no invalida");
            return;
        }

        if (pokemon[pos] != null) {
            System.out.println("Posicion " + pos + ": " + pokemon[pos]);
        } else {
            System.out.println("no hay Pokemon en esa posicion");
        }
    }

    public static void countPokemon() {
        int count = 0;
        for (String p : pokemon) {
            if (p != null) count++;
        }
        System.out.println("Cantidad de Pokemon: " + count);
    }

    public static void hackPokedex() {
        for (int i = 0; i < pokemon.length; i++) {
            pokemon[i] = "Ditto";
        }
        System.out.println("Todos los pokemon ahora son Ditto");
    }

    public static void erasePokedex() {
        for (int i = 0; i < pokemon.length; i++) {
            pokemon[i] = null;
        }
        System.out.println("Pokedex borrada");
    }
}
