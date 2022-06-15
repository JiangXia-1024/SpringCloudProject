package com.jiangxia.entity.vos;

import java.util.List;

/**
 * @author jiangxia
 * @date 2022年06月15日 21:39
 * des:用来接受集合类型参数的对象
 */
public class CollectionVO {
    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
