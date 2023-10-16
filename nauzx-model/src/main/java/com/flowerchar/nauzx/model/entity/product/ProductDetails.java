package com.flowerchar.nauzx.model.entity.product;

import com.flowerchar.nauzx.model.entity.base.BaseEntity;
import lombok.Data;

@Data
public class ProductDetails extends BaseEntity {

	private Long productId;
	private String imageUrls;

}