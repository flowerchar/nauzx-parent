package com.flowerchar.nauzx.model.vo.h5;

import com.flowerchar.nauzx.model.entity.product.Category;
import com.flowerchar.nauzx.model.entity.product.ProductSku;
import lombok.Data;

import java.util.List;

@Data
public class IndexVo {

    private List<Category> categoryList ;       // 一级分类的类别数据
    private List<ProductSku> productSkuList ;   // 畅销商品列表数据

}