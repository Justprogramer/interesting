package com.tao.swordoffer;

import java.util.HashMap;

/**
 * @author: Penger
 * @time: 2019/9/16
 * @description: <p>
 * </p>
 **/
public class FirstAppearenceOnce {
    public HashMap<Character, Integer> map = new HashMap<>();
    public StringBuffer sb = new StringBuffer();

    //Insert one char from stringstream
    public void Insert(char ch) {
        map.merge(ch, 1, Integer::sum);
        sb.append(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }

}
