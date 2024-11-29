package com.hesc.easypoi.modle.excel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author YeGuanWei
 * @since 2021-11-09
 */
@Data
public class ExcelError {

    @ApiModelProperty(value = "行数")
    private int row;

    @ApiModelProperty(value = "消息")
    private String msg;

}