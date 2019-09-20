package findRepeatNumbersInArray;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ###找出数组中重复的数字
 * 在一个长度为n的数组里，所有的数字都在0~n-1之间
 * 1.找出任意一个重复数字，要快
 * 2.找出所有重复的数字，以及对应的次数
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

    /**
     * 使用map统计各个出现的次数，然后按照value排序输出
     * 内存足够
     * @param array
     * @param topK
     */
    public void getTopKByTreeSet(Integer[] array, Integer topK){
        Map<Integer ,Integer> map=new HashMap<>();
        for (Integer num:array       ) {
            if(map.get(num)!=null){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        List<Map.Entry<Integer,Integer>> entryList=new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());//降序
//                return o1.getValue().compareTo(o2.getValue());//升序
            }
        });
        int count=0;
        for (Map.Entry<Integer,Integer> entry:entryList  ) {
            if(count>topK){
                break;
            }
            System.out.println(entry.getKey()+":"+entry.getValue());
            count++;
        }
    }

    /**
     * 查询大文件中的topk,
     * n内存不够用的情况
     * @param filePath
     * @param topK
     * @throws IOException
     */
    public void getByBigFile(String filePath,int topK) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
        Map<String, FileWriter> map=new HashMap<>();
        String str=null;
        while (null!=(str=bufferedReader.readLine())){
//            按照哈希将每行字符串分为100个，这样同样的字符串会被分到一个上
            int tmp= Math.abs(str.hashCode()%100);
            String path="D:/file/"+tmp+".txt";
            FileWriter fw = null;
            if (map.containsKey(path)) {
                fw = map.get(path);
            } else {
                fw = new FileWriter(path, true);
                map.put(path, fw);
            }
            fw.write(str);
        }
//        文件分好，关闭流
        bufferedReader.close();
        for (FileWriter ff : map.values()) {
            ff.close();
        }

    }

    /**
     * 获取每个文件中的数据
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private  List<Model> countEverySmallFile() throws FileNotFoundException, IOException {
        List<Model> list = new ArrayList<Model>();
        for (int i = 0; i < 100; i++) {
            File file = new File("D:/file/" + i + ".txt");
            if (file.exists()) {
                long startTime = System.currentTimeMillis();
                BufferedReader br1 = new BufferedReader(new FileReader(file));
                String ip1 = "";
                HashMap<String, Integer> hm = new HashMap<String, Integer>();
//                每个文件的字符countByKey
                while ((ip1 = br1.readLine()) != null) {
                    if (!hm.containsKey(ip1)) {
                        hm.put(ip1, 1);
                    } else {
                        hm.put(ip1, hm.get(ip1) + 1);
                    }
                }

                Model[] ips = new Model[hm.size()];
                int index = 0;
                for (String temp : hm.keySet()) {
                    ips[index] = new Model(temp, hm.get(temp));
                    index++;
                }
                int max = 0;
                for (int j = 1; j < ips.length; j++) {
                    if (ips[j].getCount() > ips[max].getCount()) {
                        max = j;
                    }
                }
//                TODO,每个文件中最大的值，【这块存在逻辑缺陷，可能一个文件中有两个能排上全局topk】这块需换成获取每个文件中的topk
                list.add(ips[max]);
                long endTime = System.currentTimeMillis();
                System.out.println("已经统计文件：" + "D:/file/" + i + ".txt，用时：" + (endTime - startTime) + " 毫秒");
            }
        }
        return list;
    }
    public class Model{
        private String number;

        private Integer count;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Model() {
        }

        public Model(String number, Integer count) {
            this.number = number;
            this.count = count;
        }
    }

}
