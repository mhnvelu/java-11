/*
1.  use of "var" in parameters of implicitly typed lambda expressions.
2.  If a variable is to be annotated, the annotation must be placed at the type – an explicit type or "var".
    An annotation is not permitted to be placed on the variable name.
    Using the var keyword allows us to use annotations like @NotNull or @Nullable with the parameters.
3.  The different notations must not be mixed. That means we must either specify the type for all variables, omit all types, or use "var" for all variables.
 */
package lambdaParameters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LocalVariableSyntaxExample {
    public static void main(String[] args) {
        List<String> sample = Arrays.asList("local", "variable", "syntax","for", "lambda","parameters");
        String output = sample.stream()
                .map((var x) -> {
                    return x.toUpperCase();
                })
                .collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
