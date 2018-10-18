package com.skilrock.dge.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReusableStaticMethods {
	
	
	private static Logger logger = LoggerFactory.getLogger(ReusableStaticMethods.class);
	
    public static List<Integer> randomNumber(int lowerbound, int upperbound, int numcount) {
        List<Integer> random = new ArrayList<Integer>();
        final int[] ints = new Random().ints(lowerbound, upperbound + 1).distinct().limit(numcount).toArray();
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
            random.add(ints[i]);
        }
        logger.info(random.toString());
        return random;
    }

}
