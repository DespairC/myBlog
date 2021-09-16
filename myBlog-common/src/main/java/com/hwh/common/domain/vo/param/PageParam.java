package com.hwh.common.domain.vo.param;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author HwH
 * @date 2021/9/13 0:28
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageParam {
    private int page;

    private int pageSize;

    private Long categoryId;

    private Long tagId;

    private String year;

    private String month;

    public String getMonth() {
        // 月份不足位填充
        if(this.month != null && this.month.length() == 1){
            return "0" + month;
        }
        return month;
    }
}
