package cn.noload.chapter_6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 广度优先查找
 * @author hao.caosh@ttpai.cn
 * @date 2020-06-23 17:34
 */
public class BreadthFirstSearch {

    private static final Map<String, String[]> map = new HashMap<>();

    public static void main(String[] args) {
        init();
        // me -> anuj
        LinkedList<String> queue = new LinkedList<>();
        String root = "me";
        Stream.of(map.get(root)).forEach(queue::push);
        while (!root.equals("anuj")) {
            if(queue.isEmpty()) {
                System.err.println("找不到 claire");
            }
            Stream.of(map.get(root)).forEach(queue::push);
            root = queue.pop();
        }
    }

    private static void init() {
        map.put("anuj", new String[]{});
        map.put("peggy", new String[]{});
        map.put("thom", new String[]{});
        map.put("jonny", new String[]{});
        map.put("bob", new String[]{"peggy", "anuj"});
        map.put("me", new String[]{"alice", "bob", "claire"});
        map.put("claire", new String[]{"jonny", "thom"});
    }
}
