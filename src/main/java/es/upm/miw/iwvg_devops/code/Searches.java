package es.upm.miw.iwvg_devops.code;

import java.util.Objects;
import java.util.stream.Stream;

public class Searches {
    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .allMatch(fraction -> fraction.getNumerator() < 0 || fraction.getDenominator() < 0))
                .map(User::getFamilyName)
                .distinct();
    }

    public Fraction findFractionDivisionByUserId(String userId) {
        return new UsersDatabase().findAll()
                .filter(user -> userId.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream()
                        .filter(Objects::nonNull))
                .reduce((Fraction::divide))
                .orElse(new Fraction());
    }

    public Fraction findFractionAdditionByUserId(String userId) {
        return new UsersDatabase().findAll()
                .filter(user -> userId.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream()
                        .filter(Objects::nonNull))
                .reduce((Fraction::add))
                .orElse(new Fraction());
    }
}
