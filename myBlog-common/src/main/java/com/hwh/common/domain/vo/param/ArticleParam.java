package com.hwh.common.domain.vo.param;

import com.hwh.common.domain.dto.ArticleBody;
import com.hwh.common.domain.vo.CategoryVo;
import com.hwh.common.domain.vo.TagVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/15 22:58
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleParam {
    private String title;

    private Long id;

    private ArticleBody body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;


}
