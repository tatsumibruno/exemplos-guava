package br.com.exemplos.guava;

import br.com.exemplos.models.Talhao;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * Exemplos utilizando métodos utilitários com strings
 * Created by bruno on 20/07/17.
 */
public class Strings {

    private static final Function<Talhao, String> CODIGO_TALHAO = new Function<Talhao, String>() {
        public String apply(Talhao talhao) {
            return talhao.getCodigo();
        }
    };

    /**
     * Exemplo gerando um string com os códigos dos talhões concatenados por vírgula
     */
    private static void exemploJoiner() {
        final List<Talhao> talhoes = Lists.newArrayList(
                new Talhao("1", BigDecimal.ZERO, "1"),
                new Talhao("2", BigDecimal.ZERO, "2"),
                new Talhao("3", BigDecimal.ZERO, "3")
        );

        final String codigosTalhoes = Joiner.on(", ")
                .skipNulls()
                .join(Iterables.transform(talhoes, CODIGO_TALHAO));

        System.out.println(codigosTalhoes);
    }

    /**
     * Exemplo utilizando MoreObjects para verificação de strings
     */
    private static void exemploMoreObjects() {
        System.out.println(MoreObjects.firstNonNull(null, "2"));
    }

    /**
     * Exemplo de utilização do Preconditions, útil para validar parâmetros de métodos, garantindo que não serão nulos
     */
    private static void exemploPreconditions() {
        Preconditions.checkNotNull(null, "Atributo não pode ser nulo!");
        Preconditions.checkState(1 > 0, "Estado inválido!");
    }

    public static void main(String[] args) {
        exemploJoiner();
        exemploMoreObjects();
        exemploPreconditions();
    }
}
