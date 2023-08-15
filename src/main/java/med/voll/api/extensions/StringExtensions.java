package med.voll.api.extensions;

import java.util.function.Supplier;

public class StringExtensions {
    public static  <T> T atualizarSeNaoNulo(T original, Supplier<T> novoValor) {
        return novoValor.get() != null ? novoValor.get() : original;
    }
}
