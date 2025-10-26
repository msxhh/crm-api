package com.crm.controller;

import com.crm.common.result.PageResult;
import com.crm.common.result.Result;
import com.crm.entity.Product;
import com.crm.query.ProductQuery;
import com.crm.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author crm
 * @since 2025-10-12
 */
@Tag(name = "商品管理接口")
@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {
    @Resource
    private ProductService productService;

    /**
     * 商品列表分页查询
     * @param query
     * @return
     */
    @PostMapping("page")
    @Operation(summary = "商品列表分页查询")
    public Result<PageResult<Product>> getProductPage(@RequestBody @Validated ProductQuery query) {
        return Result.ok(productService.getProductPage(query));
    }

    @PostMapping("saveOrEdit")
    @Operation(summary = "保存或修改商品")
    public Result saveOrEdit(@RequestBody @Validated Product product) {
        productService.saveOrEdit(product);
        return Result.ok();
    }

}
