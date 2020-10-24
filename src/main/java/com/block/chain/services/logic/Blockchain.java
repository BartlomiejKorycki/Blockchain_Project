import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockchain;
    private int id;

    public Blockchain() {
        this.blockchain = new ArrayList<>();
        this.id = 1;
    }

    public void generate(int lengthOfBlockchain) {
        int zeros = 0;
        for (int i = 0; i < lengthOfBlockchain; i++) {
            String previousHash = blockchain.size() == 0 ? "0" : blockchain.get(id - 2).getPresentHash();
            blockchain.add(new Block(id++, previousHash, zeros));
            if (blockchain.size() > 1 && blockchain.get(i - 1).getBlockGenerationTime() < 3) {
                zeros++;
            } else if (blockchain.size() > 1 && blockchain.get(i - 1).getBlockGenerationTime() > 10) {
                zeros--;
            }
        }
    }

    public Block get(int id) {
       return blockchain.get(id-1);
    }

    public void print() {
        long time = 0;
        int counter = 0;
        for (Block block : blockchain) {
            time += block.getBlockGenerationTime();
            System.out.println(block.toString());
            counter++;
        }
        System.out.println("\n" + time/counter + " seconds per one block");
    }
//    @Override
//    public void run() {
//        this.threadId = Thread.currentThread().getId();
//        for (int i = 0; i < lengthOfBlockchain; i++) {
//            String previousHash = blockchain.size() == 0 ? "0" : blockchain.get(id-2).getPresentHash();
//            blockchain.add(new Block(id++, previousHash, threadId));
//        }
//        System.out.println(blockchain);
//    }
}
