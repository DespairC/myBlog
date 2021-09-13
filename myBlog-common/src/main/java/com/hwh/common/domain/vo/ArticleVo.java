package com.hwh.common.domain.vo;

import com.hwh.common.domain.dto.Article;
import com.hwh.common.domain.dto.ArticleBody;
import com.hwh.common.domain.dto.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/12 20:53
 * @description 前台展示的文章数据结构
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVo {
    private Long id;
    private int commentCounts;
    private String summary;
    private String title;
    private int viewCounts;
    private int weight;

    /**
     * 创建时间
     * */
    private String createDate;
    /**
     * 作者名字
     * */
    private String author;
    /**
     * 文章内容
     * */
    private ArticleBody articleBody;
    /**
     * 标签集合
     * */
    private List<TagVo> tags;
    /**
     * 类别集合
     * */
    private List<Category> categories;


}
