
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree arbol = new AVLTree();
        System.out.println("Ingrese números para insertar en el árbol AVL. Escriba 'exit' o -1 para salir.");

        while (true) {
            System.out.print("Número: ");
            String entrada = sc.nextLine();
            if (entrada.equalsIgnoreCase("exit") || entrada.equals("-1"))
                break;
            try {
                int numero = Integer.parseInt(entrada);
                arbol.insertar(numero);
                System.out.println("Árbol actual:");
                arbol.printTree();
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
            }
        }
        sc.close();
    }
}
