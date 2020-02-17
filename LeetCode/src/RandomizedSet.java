/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/24 20:35
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

public class RandomizedSet {

    /** Initialize your data structure here. */
    private HashMap<Integer,Integer> map;
    private List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val); // 这里要先add后put，不然就会出现map value为-1的情况
            map.put(val, list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int position = map.get(val);
            if(position != list.size()-1) {
                int last = list.get(list.size()-1);
                list.set(position, last);
                map.put(last, position); // hashmap的put方法，当key相同时，更新value
            }
            // ArrayList的remove默认删除完要移动元素，为了达到O(1),我们只能把末尾元素赋给要删除的元素，然后删除末尾元素
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

    }

    /** Get a random element from the set. */
    public int getRandom() {
        int position = (int)Math.floor((Math.random() * list.size()));
        return list.get(position);
    }

}
