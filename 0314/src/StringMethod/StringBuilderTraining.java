package StringMethod;

public class StringBuilderTraining {
    public static void main(String[] args) {
        StringBuilderTraining title = new StringBuilderTraining();

        String[] sources = new String[] {
                "Welcome", "to", "nhn", "academy.",
            "you", "are", "learning", "java", "now."
        };
        StringBuilder result = new StringBuilder();
        for(String source : sources) {
            result.append(source);
            result.append(" ");
        }

        System.out.println(result);
    }
}
