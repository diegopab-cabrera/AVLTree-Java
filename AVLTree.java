
public class AVLTree {
    AVLNode raiz;

    int altura(AVLNode nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    int getFactorBalance(AVLNode nodo) {
        return (nodo == null) ? 0 : altura(nodo.izquierda) - altura(nodo.derecha);
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    AVLNode rotarDerecha(AVLNode y) {
        AVLNode x = y.izquierda;
        AVLNode T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    AVLNode rotarIzquierda(AVLNode x) {
        AVLNode y = x.derecha;
        AVLNode T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    public AVLNode insertar(AVLNode nodo, int valor) {
        if (nodo == null) return new AVLNode(valor);

        if (valor < nodo.valor)
            nodo.izquierda = insertar(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = insertar(nodo.derecha, valor);
        else
            return nodo;

        nodo.altura = 1 + max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = getFactorBalance(nodo);

        // Rotaciones
        if (balance > 1 && valor < nodo.izquierda.valor)
            return rotarDerecha(nodo);

        if (balance < -1 && valor > nodo.derecha.valor)
            return rotarIzquierda(nodo);

        if (balance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    public void printTree() {
        printTree(raiz, 0);
    }

    private void printTree(AVLNode nodo, int nivel) {
        if (nodo == null)
            return;

        printTree(nodo.derecha, nivel + 1);
        System.out.println(" ".repeat(4 * nivel) + nodo.valor);
        printTree(nodo.izquierda, nivel + 1);
    }
}
