package g_collection_invasion;

import java.util.*;

public class CollData {
    private String[] arrayData;
    private List<String> listData;
    private Set<String> setData;
    private Map<String,String> mapData;
    private Properties properties;

    public String[] getArrayData() {
        return arrayData;
    }

    public void setArrayData(String[] arrayData) {
        this.arrayData = arrayData;
    }

    public List<String> getListData() {
        return listData;
    }

    public void setListData(List<String> listData) {
        this.listData = listData;
    }

    public Set<String> getSetData() {
        return setData;
    }

    public void setSetData(Set<String> setData) {
        this.setData = setData;
    }

    public Map<String, String> getMapData() {
        return mapData;
    }

    public void setMapData(Map<String, String> mapData) {
        this.mapData = mapData;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "\nCollData{" +
                "\narrayData=" + Arrays.toString(arrayData) +
                "\n, listData=" + listData +
                "\n, setData=" + setData +
                "\n, mapData=" + mapData +
                "\n, properties=" + properties +
                '}';
    }
}
