package queue.programs;

import java.util.Arrays;
import java.util.Stack;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if (log.contains("../")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!log.contains("./"))
                stack.push(log);
        }

        return stack.size();
    }

    static void main() {
        String[] ops = new String[]{"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(Arrays.toString(ops));

        int total = new CrawlerLogFolder().minOperations(ops);
        System.out.println("Total = " + total);

        ops = new String[]{"d1/", "../", "../", "../"};
        System.out.println(Arrays.toString(ops));

        total = new CrawlerLogFolder().minOperations(ops);
        System.out.println("Total = " + total);

        ops = new String[]{"d1/", "d2/", "../", "d3/", "../", "d4/", "../", "d5/"};
        System.out.println(Arrays.toString(ops));

        total = new CrawlerLogFolder().minOperations(ops);
        System.out.println("Total = " + total);
    }
}
