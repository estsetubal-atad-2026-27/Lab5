# ATAD 2026/27 · Laboratório 5 — Consolidação: memória e tradução

| | |
|---|---|
| **Unidade curricular** | Algoritmos e Tipos Abstratos de Dados |
| **Semana** | 6 (consolidação) |
| **Duração** | 1 h 45 min |
| **Meio** | IntelliJ IDEA, JDK 21 (ou o disponível na sala) |
| **Conteúdo de suporte** | Tópicos 5–18 (complexidade, pesquisa, ordenação, contratos, memória e referências) |
| **Trabalho** | Individual ou em grupo de 2 (à escolha dos estudantes) |

---

## 1. Objetivos

Este laboratório não introduz matéria nova. Serve para:

1. **Prever** o comportamento de código que envolve primitivos, arrays e objetos;
2. Explicar **aliasing**, passagem de argumentos, âmbito e tempo de vida;
3. Implementar **cópia defensiva** onde é necessária;
4. Traduzir **pseudo-código** para Java num algoritmo mais elaborado;
5. Consolidar a relação entre memória, contratos e os algoritmos das semanas anteriores.

> [!IMPORTANT]
> O método requerido é sempre o mesmo: **escrever a previsão antes de executar**. Um laboratório em que se corre primeiro e se lê o output depois não treina nada.

---

## 2. O que é fornecido

| Ficheiro            | Estado                                                       |
| ------------------- | ------------------------------------------------------------ |
| `Conta.java`        | classe **mutável** de apoio (`numero`, `saldo`, `depositar`) |
| `Experiencias.java` | dez experiências prontas; **não alterar**                    |
| `MergeSort.java`    | esqueleto para a conversão da Parte 5                        |

Cria tu o ficheiro `Turma.java` na Parte 4 e o ficheiro `notas.md` na raiz do projeto.

---

## 3. Plano da sessão

| Parte | Tarefa                                     | Tempo  |
| :---: | ------------------------------------------ | :----: |
|   1   | Criar o projeto e executar as experiências | 10 min |
|   2   | Primitivos, arrays e objetos               | 25 min |
|   3   | Passagem de argumentos                     | 25 min |
|   4   | Mutabilidade partilhada e cópia defensiva  | 20 min |
|   5   | Consolidação: converter o *merge sort*     | 25 min |

---

## 4. Parte 1 — Criar o projeto através de `git clone` (10 min)

> [!TIP]
> Se no *wizard* indicar que o `Git` não está instalado na máquina, podes instalar através da opção indicada.

> [!IMPORTANT]
> Se o projeto não compilar, vai a `File` → `Project Structure` e seleciona uma JDK existente na máquina.

1. Clica no botão 🟩 `<> Code` na página do repositório e copia o URL.
2. `File` → `New` → `Project from Version Control…`;
3. Escolhe a pasta onde será criado o projeto e cola o URL no campo indicado;
4. Executa `Experiencias.main`.

O programa imprime dez linhas. **Não leias o output ainda** — a Parte 2 pede a previsão primeiro.

---

## 5. Parte 2 — Primitivos, arrays e objetos (25 min)

Antes de executar, escreve em `notas.md` o que esperas de `e1`, `e2` e `e3`. Depois corre e compara.

**a)** Para cada experiência, indica quantas **variáveis** e quantos **objetos ou arrays** existem no fim.

| Experiência | Variáveis | Objetos/arrays |
| :---------: | :-------: | :------------: |
|    `e1`     |     2     |                |
|    `e2`     |     2     |                |
|    `e3`     |     2     |                |

**b)** Desenha a *stack* e o *heap* de `e3`, como nos slides.

**c)** Em `e2`, porque é que alterar `b` se vê em `a`, mas em `e1` alterar `y` não se vê em `x`?

**d)** Em `e3`, quantas vezes apareceu `new`? Quantos objetos existem no fim?

---

## 6. Parte 3 — Passagem de argumentos (25 min)

Prevê os *outputs* de `e4`, `e5`, `e6`, `e9` e `e10`. Depois executa.

**a)** Preenche a tabela.

| Experiência | O que o método altera | O chamador vê? |
| :---------: | --------------------- | :------------: |
|    `e4`     |                       |                |
|    `e5`     |                       |                |
|    `e6`     |                       |                |
|    `e9`     |                       |                |
|    `e10`    |                       |                |

**b)** Explica, em duas frases, porque `e5` e `e6` se comportam de forma diferente, apesar de ambos receberem um array.

**c)** Porque é que `e9` não troca `x` com `y`, mas `e10` troca `v[0]` com `v[1]`?

**d)** Um colega afirma: «em Java, os objetos são passados por referência». Corrige a afirmação, dizendo o que é realmente copiado numa chamada.

---

## 7. Parte 4 — Mutabilidade partilhada e cópia (20 min)

### 7.1. Aliasing de listas

Prevê o *output* de `e7` e `e8`, executa e responde:

1. Em `e7`, porque é que `l2` «cresceu» sem lhe termos acrescentado nada?
2. Em `e8`, porque é que `l2` não cresceu, mas o saldo da conta 1 mudou nas duas listas?
3. Que tipo de cópia é `new ArrayList<>( l1 )` — superficial ou profunda?

### 7.2. Implementar classe `Turma`

Cria `Turma.java` com:

- um campo `private final int[] notas`;
- um construtor que guarda uma **cópia** do array recebido;
- um getter `getNotas()` que devolve uma **cópia**;
- um método `double media()`.

Testa com:

```java
int[] n = {10, 12};
Turma t = new Turma(n);

n[0] = 0;                    // alterar o array original
System.out.println(t.media());   // deve continuar 11.0

t.getNotas()[0] = 0;         // alterar o array devolvido
System.out.println(t.media());   // deve continuar 11.0
```

<small>

:warning: Se `media()` mudar depois de `n[0] = 0`, o construtor não está a copiar. Se mudar depois de `t.getNotas()[0] = 0`, o getter está a devolver o array interno.

</small>

**Responde:** o campo `notas` é `final`. Isso, sozinho, torna a `Turma` imutável? E a cópia que fizeste é superficial ou profunda? Para `int[]`, a distinção tem consequências práticas?

---

## 8. Parte 5 — Consolidação: *merge sort* (25 min)

Este exercício **não é avaliado**. O objetivo é traduzir pseudo-código, não descobrir o algoritmo.

A versão é **iterativa** (*bottom-up*): começa com blocos de tamanho 1 e vai duplicando. Não usa recursividade, que é o tópico seguinte.

### 8.1. Pseudo-código

```pascal
Algorithm mergeSort
    input:  a - array of integers
            n - natural
    output: (a ordenado crescentemente)

BEGIN
    largura <- 1
    WHILE largura < n DO
        esq <- 0
        WHILE esq < n DO
            meio <- MIN(esq + largura, n)
            dir  <- MIN(esq + 2 * largura, n)
            merge(a, esq, meio, dir)
            esq <- esq + 2 * largura
        END WHILE
        largura <- largura * 2
    END WHILE
END
```

```pascal
Algorithm merge
    input:  a - array of integers
            esq, meio, dir - indices, esq <= meio <= dir
    output: (a[esq..dir-1] ordenado, juntando os dois blocos)

BEGIN
    temp <- new array of size (dir - esq)
    i <- esq
    j <- meio
    k <- 0

    WHILE i < meio AND j < dir DO
        IF a[i] <= a[j] THEN
            temp[k] <- a[i]
            i <- i + 1
        ELSE
            temp[k] <- a[j]
            j <- j + 1
        END IF
        k <- k + 1
    END WHILE

    WHILE i < meio DO
        temp[k] <- a[i]
        i <- i + 1
        k <- k + 1
    END WHILE

    WHILE j < dir DO
        temp[k] <- a[j]
        j <- j + 1
        k <- k + 1
    END WHILE

    FOR p <- 0 TO (dir - esq) - 1 DO
        a[esq + p] <- temp[p]
    END FOR
END
```

### 8.2. Implementar

Traduz os dois métodos em `MergeSort.java`. O `main` já testa cinco casos.

O resultado deve ser:

```text
[] -> []
[5] -> [5]
[5, 2] -> [2, 5]
[5, 2, 8, 1, 9, 3] -> [1, 2, 3, 5, 8, 9]
[4, 4, 2, 2, 1, 1] -> [1, 1, 2, 2, 4, 4]
```

<small>

:warning: O `<=` no `merge` é o que torna a ordenação **estável**. Com `<`, elementos iguais podem trocar de ordem.

</small>

### 8.3. Observação (opcional)

Se terminares, conta as comparações do *merge sort* e do *Bubble Sort* para $n = 200$ e $n = 400$. O *merge sort* faz cerca de $n \log_2 n$; o Bubble, cerca de $n^2/2$.

**Isto é uma observação, não matéria avaliada.** Não é preciso saber analisar o algoritmo *merge sort*.

---

## 9. Fecho

- [ ] As dez experiências foram **previstas** antes de executadas;
- [ ] O `notas.md` tem as previsões e as respostas;
- [ ] A `Turma` protege o array interno (os dois testes dão 11.0);
- [ ] O `MergeSort` ordena os cinco casos;
- [ ] Consegues explicar, sem hesitar, a diferença entre «alterar o objeto» e «reatribuir a variável».

---

## 10. Erros comuns

| Erro | Efeito | Como detetar |
| --- | --- | --- |
| Prever depois de correr | o exercício perde o sentido | escrever a previsão primeiro |
| `b = a` como cópia do array | o alias explica outputs «estranhos» | desenhar a stack e o heap |
| Achar que o parâmetro reatribuído afeta o chamador | `e6` e `e9` parecem erros | rever o modelo de passagem |
| `new ArrayList<>(lista)` como cópia total | elementos partilhados | testar `e8` |
| `merge` sem copiar `temp` de volta | o array não muda | comparar com o output esperado |
| Limites `meio`/`dir` fora do intervalo | `ArrayIndexOutOfBoundsException` | usar `MIN` com `n` |
| Esquecer `largura = largura * 2` | ciclo infinito | o programa não termina |
| Getter a devolver o array interno | estado alterável por fora | teste da `Turma` |

---

## 11. Referências

- Slides do bloco 5 (semana 5) — disponíveis no Moodle;
- Exercícios de aula da semana 5 — disponíveis no Moodle;
- Especificação da JVM, cap. 2 — <https://docs.oracle.com/javase/specs/>.
