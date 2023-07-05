package stringMethods;

import java.util.stream.Collectors;

public class NewStringMethodsExample {
    public static void main(String[] args) {
        String str1 = "";
        System.out.println(str1.isBlank());

        String str2 = "new string methods isBlank";
        System.out.println(str2.isBlank());

        String str3 = "new\nstring\nmethods\nlines";
        System.out.println(str3.lines().collect(Collectors.toList()));

        String str4 = "new string methods repeat ";
        System.out.println(str4.repeat(2));

        String str5 = " new string methods stripLeading";
        System.out.println(str5.stripLeading());

        String str6 = "new string methods stripTrailing ";
        System.out.println(str6.stripTrailing());

        String str7 = " new string methods strip ";
        System.out.println(str7.strip());
    }
}
