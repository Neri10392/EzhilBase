package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sample {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		File file = new File("C:\\Users\\Welcome\\Desktop\\ARun\\Framework.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Data");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int type = cell.getCellType();
				
				if(type==1) {
					String data = cell.getStringCellValue();
					System.out.println(data);
				}
				if(type==0) {
					if(DateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat dateformat = new SimpleDateFormat("dd.mm.yyyy");
						String dates = dateformat.format(date);
						System.out.println(dates);
					}
					else {
						double d = cell.getNumericCellValue();
						long l = (long)d;
						String data1 = String.valueOf(l);
					}
				}
					
			}
		}

	}

}