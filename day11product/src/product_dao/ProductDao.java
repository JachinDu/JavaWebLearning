package product_dao;

import product_entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
* 该类中存放对Product对象的方法
* */
public class ProductDao {

    //模拟数据库
    private static List<Product> data = new ArrayList<Product>();
    /*
    * 初始化商品数据
    * */
    static {
        //只执行一次
        for (int i = 1; i <= 10; i++) {
            data.add(new Product(""+ i, "笔记本" + i, "LN00"+i, 34.0 + i));
        }

    }

    /*
    * 提供查询所有商品的方法
    * */
    public List<Product> finaAll() {
        return data;
    }

    /*
     * 根据编号查询商品的方法
     * */
    public Product findById(String id) {
        for (Product p : data) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
