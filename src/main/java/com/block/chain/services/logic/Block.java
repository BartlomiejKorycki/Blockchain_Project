import java.util.Date;
import java.util.SplittableRandom;

public class Block {
    private int id;
    private long timeStamp;
    private int magicNumber;
    private String previousHash;
    private String presentHash;
    private long blockGenerationTime;
    private int numberOfZeros;

    public Block(int id, String previousHash, int zeros) {
        this.timeStamp = new Date().getTime();
        this.id = id;
        this.previousHash = previousHash;
        this.numberOfZeros = zeros;
        this.presentHash = magicHashing();
        long timeStampTwo = new Date().getTime();
        this.blockGenerationTime = (timeStampTwo - timeStamp) / 1000;
    }

    public int getId() {
        return id;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getPresentHash() {
        return presentHash;
    }

    public long getBlockGenerationTime() {
        return blockGenerationTime;
    }

    public int getNumberOfZeros() {
        return numberOfZeros;
    }

    private int randomInt() {
        return new SplittableRandom().nextInt(Integer.MAX_VALUE);
    }

    private String magicHashing() {
        int countOfZeros = getNumberOfZeros();
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < countOfZeros; i++) {
            zeros.append("0");
        }

        int magicNumber = randomInt();
        String magicHash = "";

        do {
            magicHash = StringUtil.applySha256(id + timeStamp + ++magicNumber + previousHash);
        }
        while (!magicHash.startsWith(zeros.toString()) && magicNumber > 0);
        this.magicNumber = magicNumber;
        return magicHash;
    }

    @Override
    public String toString() {
        return "\nId: " + id +
                "\nTimestamp: " + timeStamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block: \n" + previousHash +
                "\nHash of the block: \n" + presentHash +
                "\nBlock was generating for " + blockGenerationTime + " seconds";
    }
}
