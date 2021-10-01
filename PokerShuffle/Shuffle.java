package PokerShuffle;

import java.util.*;

public class Shuffle {
    private Random rand = new Random();
    private static final int POKERLENGTH = 52;

    public Integer[] fisherYates(Integer[] poker) {
        List<Integer> pokerList = new ArrayList<>(Arrays.asList(poker));
        List<Integer> res = new ArrayList<>();
        while (!pokerList.isEmpty()) {
            int index = this.rand.nextInt(pokerList.size());
            res.add(pokerList.get(index));
            pokerList.remove(index);
        }
        return res.toArray(new Integer[poker.length]);
    }

    public Integer[] knuthDurstenfeld(Integer[] poker) {
        for (int i = poker.length - 1; i >= 0; i--) {
            int index = this.rand.nextInt(i + 1);
            Integer temp = poker[i];
            poker[i] = poker[index];
            poker[index] = temp;
        }
        return poker;
    }

    public static Integer[] getPoker() {
        Integer[] poker = new Integer[POKERLENGTH];
        for (int i = 0; i < POKERLENGTH; i++) {
            poker[i] = i + 1;
        }
        return poker;
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        float[] sum1 = new float[POKERLENGTH];
        float[] sum2 = new float[POKERLENGTH];
        int round = 100000;
        for (int i = 0; i < round; i++) {
            Integer[] poker1 = Shuffle.getPoker();
            poker1 = shuffle.fisherYates(poker1);
            Integer[] poker2 = Shuffle.getPoker();
            poker2 = shuffle.knuthDurstenfeld(poker2);
            for (int j = 0; j < POKERLENGTH; j++) {
                sum1[j] += poker1[j];
                sum2[j] += poker2[j];
            }
        }
        for (int i = 0; i < POKERLENGTH; i++) {
            sum1[i] /= round;
            sum2[i] /= round;
        }
        System.out.println(Arrays.toString(sum1));
        System.out.println(Arrays.toString(sum2));
    }
}
