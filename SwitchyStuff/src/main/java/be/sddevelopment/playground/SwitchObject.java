package be.sddevelopment.playground;

import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Arrays.stream;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;

public class SwitchObject {

    public static String evaluate(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("You might be born yesterday, but you can't be negative years old");
        }

        return stream(AgeEvaluator.values())
                .map(evaluator -> evaluator.apply(age))
                .flatMap(Optional::stream)
                .collect(joining(" "));
    }

    enum AgeEvaluator {

        KID("kid", age -> age < 18),
        ADULT("adult", age -> age >= 18),
        PARTY_IN_THE_USA("can drink", age -> age >= 21);

        private String denomination;
        private Predicate<Integer> evaluation;

        AgeEvaluator(String denomination, Predicate<Integer> evaluation) {
            this.denomination = denomination;
            this.evaluation = evaluation;
        }

        public Optional<String> apply(int age) {
            return evaluation.test(age) ? ofNullable(denomination) : empty();
        }

    }
}
