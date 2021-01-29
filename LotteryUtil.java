package testPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不同概率抽奖工具包
 *
 * @author Shunli
 */
public class LotteryUtil {
    /**
     * 随机抽奖
     *
     * @param orignalRatesInsort 原始的概率列表，保证已排序,且顺序和实际物品对应
     * @return 物品的索引
     */
    public static int lottery(List<Double> orignalRatesInsort) {
        if (orignalRatesInsort == null || orignalRatesInsort.isEmpty()) {
            return -1;
        }
 
        int size = orignalRatesInsort.size();
 
        // 计算总概率，这样可以保证不一定总概率是1
        double sumRate = 0d;
        for (double rate : orignalRatesInsort) {
            sumRate += rate;
        }
 
        // 计算每个物品在总概率的基础下的概率情况
        List<Double> sortOrignalRates = new ArrayList<Double>(size);
        Double tempSumRate = 0d;
        for (double rate : orignalRatesInsort) {
            tempSumRate += rate;
            sortOrignalRates.add(tempSumRate / sumRate);
        }
 
        // 根据区块值来获取抽取到的物品索引
        double nextDouble = Math.random();
        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);
 
        return sortOrignalRates.indexOf(nextDouble);
    }
    
	/*
    *//**
     * 随机抽奖
     *
     * @param orignalRatesInsort 原始的概率列表，保证已排序,且顺序和实际物品对应
     * @return 物品的索引
     *//*
    public static int lottery2(List<Integer> orignalRatesInsort) {
        if (orignalRatesInsort == null || orignalRatesInsort.isEmpty()) {
            return -1;
        }
 
        int size = orignalRatesInsort.size();
 
        // 计算总概率，这样可以保证不一定总概率是1
        int sumRate = 0;
        for (int rate : orignalRatesInsort) {
            sumRate += rate;
        }
 
        // 计算每个物品在总概率的基础下的概率情况
        List<Integer> sortOrignalRates = new ArrayList<Integer>(size);
        int tempSumRate = 0;
        for (int rate : orignalRatesInsort) {
            tempSumRate += rate;
            sortOrignalRates.add(tempSumRate);
        }
 
        Random rnd = new Random();
        
        // 根据区块值来获取抽取到的物品索引
        int nextInt = rnd.nextInt(sumRate);
        sortOrignalRates.add(nextInt);
        Collections.sort(sortOrignalRates);
 
        return sortOrignalRates.indexOf(nextInt);
    }
    
    public static void main(String[] args) {
    	List<Integer> l = new ArrayList();
    	l.add(1);
    	l.add(3);
    	l.add(4);
    	l.add(2);
    	Collections.sort(l);
    	System.out.println(l);
	}*/
}