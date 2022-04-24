package com.example.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PlayerDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * vid
     */
    private String id;


    private String name;

    private Long age;

}
