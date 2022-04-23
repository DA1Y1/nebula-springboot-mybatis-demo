package com.example.pojo;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author DAIYI
 * @since 2022-04-23
 */

@Data
@Builder
@Accessors(chain = true)
public class FollowDO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 起始点
     */
    private String src;

    /**
     * 终止点
     */
    private String dst;

    private Long degree;

}
