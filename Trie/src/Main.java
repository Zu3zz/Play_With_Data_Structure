import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        String fileName = "pride-and-prejudice.txt";
        if (FileOperation.readFile(fileName, words)) {
            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();

            for (String word : words) {
                set.add(word);
            }

            for (String word:words){
                set.contains(word);
            }

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 10000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: "+time+" s");

            // 下面开始测试Trie字典树
            startTime = System.nanoTime();

            Trie trie = new Trie();

            for (String word : words) {
                trie.add(word);
            }

            for (String word:words){
                trie.contains(word);
            }

            endTime = System.nanoTime();
            time = (endTime - startTime) / 10000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: "+time+" s");
        }
    }
}
