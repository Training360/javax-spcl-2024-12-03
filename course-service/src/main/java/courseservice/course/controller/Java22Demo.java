package courseservice.course.controller;

public class Java22Demo {

    public sealed interface Part permits Header, Paragraph {}

    public record Header(String text, int size) implements Part {}

    public record Paragraph(String content) implements Part {}

    public static void main(String[] args) {
        Part part = null;
        switch (part) {
//            case Header(var text, var _) -> System.out.println(text);
            case Header(var text, var size) -> System.out.println(text);
            case Paragraph(var content) -> System.out.println(content);
        }
    }
}
