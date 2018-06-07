package RankingCoach;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Teest {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String value = getCellData(2, 2);
		System.out.println(value);
		String value1 = getCellData(5, 0);
		System.out.println(value1);

		// System.out.println(value);
	}

	public static String getCellData(int rownum, int col) throws IOException {
		fis = new FileInputStream("C:\\Files\\Content.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Content");
		row = sheet.getRow(5);
		cell = row.getCell(0);
		return cell.getStringCellValue();

	}
}
