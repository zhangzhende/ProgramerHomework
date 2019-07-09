package findRepeatNumbersInArray;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description find repeat numbers in array ,like [1,2,3,4,5,6,1,2,3,4]==>{(1,2),(2,2),(3,2),(4,2)},find the most repeat top K
 * @ClassName FindRMInArray
 * @Author zzd
 * @Create 2019/7/9 14:23
 * @Version 1.0
 **/
public class FindRMInArray {
    /**
     * 使用java8 的stream方式，类似wordcount然后将结果逆序排列
     * @param array
     * @param topK
     */
    public void getTopKByStream(Integer[] array, Integer topK) {
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, array);
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.<Integer>counting()));
        Map<Integer, Long> finalMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        int n = 1;
        for (Map.Entry<Integer, Long> entry : finalMap.entrySet()) {
            if (n > topK) break;
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }
    }

    public void getTopKByTreeSet(Integer[] array, Integer topK){
        for (Integer num:array
             ) {
            
        }
    }

}
