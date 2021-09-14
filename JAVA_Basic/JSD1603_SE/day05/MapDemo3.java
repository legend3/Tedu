package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * 存入键值为对象时，key为Key对象
 */
public class MapDemo3 {
    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<Key, String>();
        map.put(new Key(34,"男"), "小明");
        map.put(new Key(17,"女"), "小丽");
        System.out.println(map.toString());

    }
}