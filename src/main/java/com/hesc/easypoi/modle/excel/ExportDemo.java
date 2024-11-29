package com.hesc.easypoi.modle.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * 走访测评
 **/
@Data
public class ExportDemo {

    @Excel(name = "主键", orderNum = "1")
    private String id;

    @Excel(name = "名称", orderNum = "2")
    private String name;

    public static final String[] MUST_FILL = new String[]{};

}