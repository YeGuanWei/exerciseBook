package com.hesc.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.hesc.easypoi.modle.excel.ExportDemo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    public static void main(String[] args) throws IOException {
       System.out.println(exportExcel());
    }

    public static String exportExcel() {
        // 文件输出路径
        String excelPath = "D:\\";
        // 模板导出
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            HashMap<String, String> lm = new HashMap<>();
            lm.put("name", "姓名" + i);
            lm.put("age", "年龄" + i);
            list.add(lm);
        }
        map.put("list", list);
        map.put("time", System.currentTimeMillis());

        TemplateExportParams params = new TemplateExportParams(
                "src/main/java/com/hesc/easypoi/template/模板导出.xlsx");  // 模板路径
        // 纵向还是横向 默认横向
        // params.setColForEach(true);
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File(excelPath);
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        String path = excelPath + "测试.xlsx";    // 文件输出路径
        try {
            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<ExportDemo> getExcelList() {
        List<ExportDemo> excelList = new ArrayList<>();

        ExportDemo list1 = new ExportDemo();
        list1.setId("1");
        list1.setName("啊哈1");
        excelList.add(list1);

        return excelList;
    }

}