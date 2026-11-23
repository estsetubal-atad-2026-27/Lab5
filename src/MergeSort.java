import java.util.Arrays;

/**
 * ATAD 2026/27 - Laboratorio 5
 *
 * Conversao de pseudo-codigo: merge sort iterativo (bottom-up).
 * O pseudo-codigo esta no README, Parte 5.
 *
 * Este exercicio NAO e avaliado. O objetivo e traduzir, nao descobrir.
 */
public class MergeSort {

    public static void mergeSort(int[] a) {
        // TODO: seguir o pseudo-codigo do README.
    }

    // Junta os blocos ordenados a[esq..meio-1] e a[meio..dir-1]
    // num unico bloco ordenado a[esq..dir-1].
    static void merge(int[] a, int esq, int meio, int dir) {
        // TODO: usar um array auxiliar temp de tamanho (dir - esq).
    }

    public static void main(String[] args) {
        int[][] casos = {
            {},
            {5},
            {5, 2},
            {5, 2, 8, 1, 9, 3},
            {4, 4, 2, 2, 1, 1}
        };

        for (int i = 0; i < casos.length; i++) {
            int[] copia = new int[casos[i].length];
            for (int j = 0; j < casos[i].length; j++) {
                copia[j] = casos[i][j];
            }

            mergeSort(copia);
            System.out.println(Arrays.toString(casos[i]) + " -> " + Arrays.toString(copia));
        }
    }
}
