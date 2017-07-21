package br.com.exemplos.guava;

import br.com.exemplos.models.Talhao;
import com.google.common.collect.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Exemplos de utilizações das operações com collections
 * Created by bruno on 20/07/17.
 */
public class Collections {

    /**
     * Exemplo de criação de um set imutável (também existem outras fábricas estáticas de objetos imutáveis como List, Map, etc)
     */
    private static void exemploImutabilidade() {
        final ImmutableSet<Integer> setImutavel = ImmutableSet.of(1, 2, 3);
        try {
            setImutavel.add(4);
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao tentar incluir um item em uma lista imutável");
        }
    }

    /**
     * Exemplo de utilização do MultiMap, uma alternativa para não precisar criar um mapa de lista,
     * se for chamado um put passando uma chave já existente, será adicionado mais um item para a mesma chave.
     */
    private static void exemploMultiMap() {
        final HashMultimap<String, Talhao> multiMap = HashMultimap.create();

        multiMap.put("1", new Talhao("1", BigDecimal.ZERO, "1"));
        multiMap.put("1", new Talhao("2", BigDecimal.ZERO, "2"));
        System.out.println(multiMap.get("1"));
    }

    /**
     * Exemplo de utilização do BiMap, que pode ser utilizado para indexar valores tanto pela chave quanto pelo valor
     */
    private static void exemploBiMap() {
        final HashBiMap<String, Talhao> biMap = HashBiMap.create();
        final Talhao talhao1 = new Talhao("1", BigDecimal.ZERO, "1");
        final Talhao talhao2 = new Talhao("2", BigDecimal.ZERO, "2");
        biMap.put("1", talhao1);
        biMap.put("2", talhao2);
        System.out.println("Talhão com código 2: " + biMap.get("2"));
        System.out.println("Código do segundo talhão: " + biMap.inverse().get(talhao2));
    }

    /**
     * RangeSet, utilizado para fazer operações com range de valores.
     * Também existe o RangeMap, onde um valor pode ser atribuído a um range como chave
     */
    private static void exemploRangeSet() {
        final Range<Integer> range = Range.closed(1, 10);
        System.out.println(range.contains(5));
    }

    /**
     * Exemplos de operações com o Iterables
     */
    private static void exemplosIterables() {
        List<Integer> lista1 = Lists.newArrayList(1, 2, 3);
        List<Integer> lista2 = Lists.newArrayList(3, 4, 5, 6);
        final Iterable<Integer> listaConcatenada = Iterables.concat(lista1, lista2);
        System.out.println("Lista concatenada: " + listaConcatenada);
        System.out.println("Número de vezes em que o número 3 aparece na nova lista: " + Iterables.frequency(listaConcatenada, 3));
        System.out.println("Lista particionada em listas de até 2 elementos: " + Iterables.partition(listaConcatenada, 2));
        System.out.println("Primeiro item da lista: " + Iterables.getFirst(listaConcatenada, null));
        System.out.println("ùltimo item da lista: " + Iterables.getLast(listaConcatenada, null));
    }

    public static void main(String[] args) {
        exemploImutabilidade();
        exemploMultiMap();
        exemploBiMap();
        exemploRangeSet();
        exemplosIterables();
    }
}
