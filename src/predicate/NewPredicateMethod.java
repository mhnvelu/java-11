/*
1.  A static not() method has been added to the Predicate interface in Java 11.
2.  As the name suggests, this method is used to negate a Predicate.
3.  The not() method can also be used with method references.
 */
package predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NewPredicateMethod {
    public static void main(String[] args) {
        Predicate<String> startWithA = s -> s.charAt(0) == 'A';
        Predicate<String> notStartWithA = Predicate.not(startWithA);
        Predicate<String> andPredicate = notStartWithA.and(s -> s.charAt(0) == 'a');
        Predicate<String> orPredicate = notStartWithA.or(s -> s.charAt(0) == 'a');

        List<String> list = Arrays.asList("Ab", "zq", "az", "Aq", "zz");
        List<String> strStartingWithA = list.stream()
                .filter(startWithA)
                .collect(Collectors.toList());
        List<String> strNotStartingWithA = list.stream()
                .filter(notStartWithA)
                .collect(Collectors.toList());

        List<String> andPredicateResult = list.stream()
                .filter(andPredicate)
                .collect(Collectors.toList());

        List<String> orPredicateResult = list.stream()
                .filter(orPredicate)
                .collect(Collectors.toList());

        System.out.println(strStartingWithA);
        System.out.println(strNotStartingWithA);
        System.out.println(andPredicateResult);
        System.out.println(orPredicateResult);
    }
}
