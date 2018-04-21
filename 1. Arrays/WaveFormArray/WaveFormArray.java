package com.androidians.interviewarraymath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nithin on 18/03/18.
 */

public class WaveFormArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        List<Integer> res = waveform(list);
        for (Integer i: res) {
            System.out.println(i);
        }
    }

    public static List<Integer> waveform(List<Integer> list) {
        Collections.sort(list);

        for (int i=0;i<list.size()-1;i=i+2) {
            int temp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, temp);
        }

        return list;
    }

}
