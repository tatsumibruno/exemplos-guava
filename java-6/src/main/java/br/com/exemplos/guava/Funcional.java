package br.com.exemplos.guava;

import br.com.exemplos.models.Talhao;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * Exemplos de utilização de programação funcional
 * Created by bruno on 20/07/17.
 */
public class Funcional {

    private static final Function<Talhao, String> TALHAO_POR_CODIGO = new Function<Talhao, String>() {
        public String apply(Talhao talhao) {
            return talhao.getCodigo();
        }
    };

    private static final Predicate<Talhao> TALHAO_AREA_MAIOR_QUE_ZERO = new Predicate<Talhao>() {
        public boolean apply(Talhao talhao) {
            return talhao.getArea().compareTo(BigDecimal.ZERO) > 0;
        }
    };

    /**
     * Exemplo de criação de um mapa de talhão por código
     */
    private static void exemploGeracaoMapaTalhaoPorCodigo() {
        final List<Talhao> talhoes = Lists.newArrayList(
                new Talhao("1", BigDecimal.ZERO, "1"),
                new Talhao("2", BigDecimal.ZERO, "2"),
                new Talhao("3", BigDecimal.ZERO, "3")
        );

        final ImmutableMap<String, Talhao> talhoesPorCodigo = FluentIterable
                .from(talhoes)
                .uniqueIndex(TALHAO_POR_CODIGO);

        System.out.println(talhoesPorCodigo.get("2"));
    }

    /**
     * Exemplo de filtro para encontrar o primeiro talhão que tenha área maior que zero, retornando zero caso não encontre
     */
    private static void exemploFiltroTalhoes() {
        final List<Talhao> talhoes = Lists.newArrayList(
                new Talhao("1", BigDecimal.ZERO, "1"),
                new Talhao("2", BigDecimal.TEN, "2"),
                new Talhao("3", BigDecimal.ZERO, "3")
        );

        final Talhao talhaoComAreaMaiorQueZero = FluentIterable.from(talhoes)
                .filter(TALHAO_AREA_MAIOR_QUE_ZERO)
                .first()
                .orNull();

        System.out.println(talhaoComAreaMaiorQueZero);
    }

    public static void main(String[] args) {
        exemploGeracaoMapaTalhaoPorCodigo();
        exemploFiltroTalhoes();
    }
}
