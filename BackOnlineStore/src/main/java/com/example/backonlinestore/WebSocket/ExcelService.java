package com.example.backonlinestore.WebSocket;

import com.example.backonlinestore.Dto.ProductDto;
import com.example.backonlinestore.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

//Используя Web Socket, реализовать механизм асинхронной выгрузки списка товаров с ценами и наличием в формате
// (xlsx/csv https://mvnrepository.com/artifact/org.apache.poi/poi)
//Если не выйдет разобраться с экселем, можно просто текстовым файлом с пробелами.
//Вернуть ссылку на сгенерированный бекэндом файл.
@Service
@RequiredArgsConstructor
public class ExcelService {
    private final String path = new File("").getAbsolutePath();
    private final String nameDirectory = path + "/Files";
    private final String fileName = "/productInfo.xlsx ";
    private File excelFile;

    private Workbook productInfo;

    private final ProductService productService;


    private void createDir() throws IOException {
        File dir = new File(nameDirectory);
        dir.mkdir();
        excelFile = new File(dir + fileName);
        excelFile.createNewFile();
    }

    public void createWorkBook() throws IOException {

        productInfo = new XSSFWorkbook();

        Sheet productSheet = productInfo.createSheet("Products");


        CellStyle style = productInfo.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);


        Font font = productInfo.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 14);
        style.setFont(font);
        System.out.println(font);

        Row row1 = productSheet.createRow(0);

        Cell id = row1.createCell(0);
        id.setCellStyle(style);

        Cell title = row1.createCell(1);
        title.setCellStyle(style);

        Cell category = row1.createCell(2);
        category.setCellStyle(style);

        Cell price = row1.createCell(3);
        price.setCellStyle(style);

        Cell inStock = row1.createCell(4);
        inStock.setCellStyle(style);

        id.setCellValue("ID");
        title.setCellValue("TITLE");
        category.setCellValue("CATEGORY");
        price.setCellValue("PRICE");
        inStock.setCellValue("IN STOCK");

        fillExcelFile(productInfo, style);
    }


    public void fillExcelFile(Workbook productInfo, CellStyle style) throws IOException {
        List<ProductDto> productList = productService.findAll().stream().map(ProductDto::new).collect(Collectors.toList());

        for (int i = 0; i < productList.size(); i++) {
            Row row = productInfo.getSheet("Products").createRow(i + 1);

            Cell id = row.createCell(0);
            id.setCellStyle(style);

            Cell title = row.createCell(1);
            title.setCellStyle(style);

            Cell category = row.createCell(2);
            category.setCellStyle(style);

            Cell price = row.createCell(3);
            price.setCellStyle(style);

            Cell isStock = row.createCell(4);
            isStock.setCellStyle(style);

            id.setCellValue(productList.get(i).getId());
            title.setCellValue(productList.get(i).getTitle());
            category.setCellValue(productList.get(i).getCategoryTitle());
            price.setCellValue(productList.get(i).getPrice());
            isStock.setCellValue("true");



            productInfo.getSheet("Products").autoSizeColumn(0,true);
            productInfo.getSheet("Products").autoSizeColumn(1,true);
            productInfo.getSheet("Products").autoSizeColumn(2,true);
            productInfo.getSheet("Products").autoSizeColumn(3,true);
            productInfo.getSheet("Products").autoSizeColumn(4,true);

            createDir();

            productInfo.write(new FileOutputStream(excelFile));
        }


    }


}
