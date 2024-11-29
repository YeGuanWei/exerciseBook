package com.hesc.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 组织机构表 前端控制器
 * </p>
 *
 * @author 叶关伟
 * @since 2024-01-10
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    public static void main(String[] args) throws IOException {
        List<ExportVisit> excelList = getExcelList();
        // 导出
        String sheetName = "sheet";
        String excelName = "政企客户经理走访测评" + ExcelConstant.SUFFIX_XLSX;
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName(sheetName);
        exportParams.setStyle(ExcelStyleUtil.class);
        org.apache.poi.ss.usermodel.Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ExportVisit.class, excelList);
        // 生成文件流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        byte[] workbookBytes = byteArrayOutputStream.toByteArray();
        InputStream workbookInputStream = new ByteArrayInputStream(workbookBytes);

        try {
            Workbook asposeWorkbook = new Workbook(workbookInputStream);
            // 使用Aspose.Cells的API将工作表保存为图像文件
            String imageFilePath = "worksheet_as_image.png";
            asposeWorkbook.save(imageFilePath, SaveFormat.PNG);
            // 如果你需要将图像作为字节数组处理，你可以读取刚刚保存的图像文件
            BufferedImage image = ImageIO.read(new File(imageFilePath));
            byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", byteArrayOutputStream);
            byte[] imageBytes = byteArrayOutputStream.toByteArray();

            saveByteArrayToFile(imageBytes, imageFilePath);
            System.out.println("生成成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveByteArrayToFile(byte[] byteArray, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(byteArray);
        }
    }


    private static List<ExportVisit> getExcelList() {
        List<ExportVisit> excelList = new ArrayList<>();

        ExportVisit visit1 = new ExportVisit();
        visit1.setArea_name("11111111");
        visit1.setMsu_visit_cnt(0);
        visit1.setMsu_eff_cnt(0);
        visit1.setSatisfy_mdr_cnt(0);
        visit1.setMsu_eval_cnt(0);
        visit1.setParticipation_rate("");
        visit1.setSatisfy_fcmy_cnt(0);
        visit1.setSatisfy_my_cnt(0);
        visit1.setSatisfy_yb_cnt(0);
        visit1.setSatisfy_bmy_cnt(0);
        visit1.setSatisfy_fcbmy_cnt(0);
        visit1.setSatisfy_wbf_cnt(0);
        visit1.setWbf_rate("");
        visit1.setMy_rate_xfkj("");
        visit1.setMy_rate_khkj("");
        excelList.add(visit1);


        ExportVisit visit2 = new ExportVisit();
        visit2.setArea_name("2222222");
        visit2.setMsu_visit_cnt(0);
        visit2.setMsu_eff_cnt(0);
        visit2.setSatisfy_mdr_cnt(0);
        visit2.setMsu_eval_cnt(0);
        visit2.setParticipation_rate("");
        visit2.setSatisfy_fcmy_cnt(0);
        visit2.setSatisfy_my_cnt(0);
        visit2.setSatisfy_yb_cnt(0);
        visit2.setSatisfy_bmy_cnt(0);
        visit2.setSatisfy_fcbmy_cnt(0);
        visit2.setSatisfy_wbf_cnt(0);
        visit2.setWbf_rate("");
        visit2.setMy_rate_xfkj("");
        visit2.setMy_rate_khkj("");
        excelList.add(visit2);
        return excelList;
    }

}