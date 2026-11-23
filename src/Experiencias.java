import java.util.ArrayList;
import java.util.List;

/**
 * ATAD 2026/27 - Laboratorio 5
 *
 * Experiencias sobre o modelo de memoria da JVM.
 * Corre o programa para confirmar (ou corrigir) as previsoes que
 * escreveste em notas.md.
 *
 * Nao alteres os metodos: o objetivo e prever o resultado.
 */
public class Experiencias {

    // ---------------------------------------------------------------
    // 1. Primitivos: a atribuicao copia o valor
    // ---------------------------------------------------------------
    static void e1() {
        int x = 5;
        int y = x;
        y = 9;
        System.out.println("e1: x=" + x + "  y=" + y);
    }

    // ---------------------------------------------------------------
    // 2. Arrays: a atribuicao copia a referencia
    // ---------------------------------------------------------------
    static void e2() {
        int[] a = {1, 2, 3};
        int[] b = a;
        b[1] = 7;
        System.out.println("e2: a[1]=" + a[1] + "  b[1]=" + b[1]);
    }

    // ---------------------------------------------------------------
    // 3. Objetos: duas referencias, um objeto
    // ---------------------------------------------------------------
    static void e3() {
        Conta c1 = new Conta(1, 100.0);
        Conta c2 = c1;
        c2.depositar(50.0);
        System.out.println("e3: c1=" + c1.getSaldo() + "  c2=" + c2.getSaldo());
    }

    // ---------------------------------------------------------------
    // 4. Passar um primitivo
    // ---------------------------------------------------------------
    static void alteraInt(int x) {
        x = 99;
    }

    static void e4() {
        int x = 1;
        alteraInt(x);
        System.out.println("e4: x=" + x);
    }

    // ---------------------------------------------------------------
    // 5. Passar um array: alterar os elementos
    // ---------------------------------------------------------------
    static void alteraArray(int[] a) {
        a[0] = 99;
    }

    static void e5() {
        int[] a = {1, 2};
        alteraArray(a);
        System.out.println("e5: a[0]=" + a[0]);
    }

    // ---------------------------------------------------------------
    // 6. Passar um array: reatribuir o parametro
    // ---------------------------------------------------------------
    static void reatribuiArray(int[] a) {
        a = new int[]{99, 99};
    }

    static void e6() {
        int[] a = {1, 2};
        reatribuiArray(a);
        System.out.println("e6: a[0]=" + a[0]);
    }

    // ---------------------------------------------------------------
    // 7. Listas: atribuicao (alias)
    // ---------------------------------------------------------------
    static void e7() {
        List<Conta> l1 = new ArrayList<>();
        l1.add(new Conta(1, 100.0));

        List<Conta> l2 = l1;
        l1.add(new Conta(2, 200.0));

        System.out.println("e7: l1=" + l1.size() + "  l2=" + l2.size());
    }

    // ---------------------------------------------------------------
    // 8. Listas: copia do contentor (superficial)
    // ---------------------------------------------------------------
    static void e8() {
        List<Conta> l1 = new ArrayList<>();
        l1.add(new Conta(1, 100.0));

        List<Conta> l2 = new ArrayList<>(l1);
        l1.add(new Conta(2, 200.0));

        System.out.println("e8: l1=" + l1.size() + "  l2=" + l2.size());

        l1.get(0).depositar(50.0);
        System.out.println("e8: saldo da conta 1 em l2 = " + l2.get(0).getSaldo());
    }

    // ---------------------------------------------------------------
    // 9. Trocar valores (nao funciona)
    // ---------------------------------------------------------------
    static void trocaValores(int a, int b) {
        int t = a;
        a = b;
        b = t;
    }

    static void e9() {
        int x = 1;
        int y = 2;
        trocaValores(x, y);
        System.out.println("e9: x=" + x + "  y=" + y);
    }

    // ---------------------------------------------------------------
    // 10. Trocar elementos de um array (funciona)
    // ---------------------------------------------------------------
    static void trocaElementos(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void e10() {
        int[] v = {1, 2};
        trocaElementos(v, 0, 1);
        System.out.println("e10: v[0]=" + v[0] + "  v[1]=" + v[1]);
    }

    public static void main(String[] args) {
        e1();
        e2();
        e3();
        e4();
        e5();
        e6();
        e7();
        e8();
        e9();
        e10();
    }
}
