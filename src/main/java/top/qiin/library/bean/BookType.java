package top.qiin.library.bean;

/**
 * @program: library
 * @description:
 * @author: qin
 * @create: 2019-11-13 20:44
 **/

public class BookType {
    private int type;
    private String typeName;

    @Override
    public String toString() {
        return "BookType{" +
                "type=" + type +
                ", typename='" + typeName + '\'' +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typename) {
        this.typeName = typename;
    }
}
