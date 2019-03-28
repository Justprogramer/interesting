package com.tao.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: TAOPENG
 * time ： 2019/3/8
 **/

public class PakageTest {
    @Data
    @AllArgsConstructor
    private class Diamond {
        //diamond id
        private Integer id;
        //diamond price
        private Double price;
        // diamond weight
        private Integer weight;
    }

    List<Diamond> putPackage(List<Diamond> diamonds, Integer m) {
        // 对性价比排序（从高到低排序）
        List<Diamond> sortedDiamonds = diamonds.stream()
                .sorted(Comparator.comparing(diamond -> diamond.getPrice() / diamond.getWeight()))
                .collect(Collectors.toList());
        // 将物体按照性价比从高到低依次加入背包
        int rest = m;// 剩余重量
        int i = 0;
        List<Diamond> results = new ArrayList<>();// 存放结果集
        for (; i < sortedDiamonds.size(); i++) {
            if (rest < sortedDiamonds.get(i).getWeight())
                break;
            Diamond curDiamond = diamonds.get(i);
            results.add(curDiamond);
            rest -= curDiamond.getWeight();
        }
        // 计算最后一个物体能放入的部分
        Diamond lastDiamond = sortedDiamonds.get(i);
        results.add(new Diamond(lastDiamond.id, (lastDiamond.getPrice() * rest / lastDiamond.getWeight()), rest));
        return results;
    }
}
