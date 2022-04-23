package com.example.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 查询边路径
 * @author DAIYI
 * @since 2021-09-10
 */

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class PathDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 起始点
     */
    private String startNode;

    /**
     * 终止点
     */
    private String endNode;
    /**
     * 所有节点
     */
    private List<String> nodes;
    /**
     * 所有边关系
     */
    private List<RelationShip> relationShips;


    @Data
    public static class RelationShip {
        public String src;
        public String dst;
        public long ranking;
    }

}
