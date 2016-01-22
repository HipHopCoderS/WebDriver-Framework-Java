package Excel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Excel放在项目新建data文件夹下 Excel命名方式：建议 测试类名.xls Excel的sheet命名方式：建议 测试方法名
 * Excel第一行为Map键值，每一列存储为list,获取数据时根据key值，锁定列，然后根据下标获取值（仅供参考）
 */

public class Excel {

	// 初始化 参数
	static Workbook rbook = null;
	static Sheet rsheet = null;
	static WritableWorkbook wbook = null;
	static WritableSheet wsheet = null;

	// 声明Excel对象，读取一个excel文件
	public static Map<String, List<String>> reExcel(String FileName,
			String SheetName) {

		// 初始化参数
		int rowNum = 0;
		int columnNum = 0;
		int currentColumn = 0;
		String[] columnnName = null;
		Cell[] rowData = null;
		Cell[] columnData = null;
		boolean isNull = true;
		Map<String, List<String>> readData = new HashMap<String, List<String>>(); // 初始化Map

		// 读取Excel文件
		try {

			// 在项目文件夹下，新建data 文件夹，放入Excel文件
			String path = "/data/" + FileName + ".xls";
			File reFile = new File(System.getProperty("user.dir") + path);
			rbook = Workbook.getWorkbook(reFile);

			// 读取Excel文件中的Sheet
			rsheet = rbook.getSheet(SheetName);
			
			// 获取有效数据的行数
			rowNum = rsheet.getRows(); 
			
			//获取第一行的数据
			rowData = rsheet.getRow(0);
			
			// 存储列名
			columnnName = new String[rowData.length]; 
			
			// 获取有效数据的列数
			columnNum = rowData.length; 

			for (int i = 0; i < rowData.length; i++) { // 获取第一行的数据，存入数组作为键值
				columnnName[i] = rowData[i].getContents().toString();
			}
			// 遍历Excel
			while (isNull) {

				// 判断列是否为空,为空返回False
				if (columnNum == 0 || currentColumn >= columnNum) {

					try {
						rbook.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					isNull = false;
					continue;
				} else {
					// 判定内容是否为空
					if ((rsheet.getColumn(currentColumn))[0].getContents()
							.equals("")) {
						isNull = false;
						continue;
					} else {

						columnData = rsheet.getColumn(currentColumn); // 获取当前列的数据，存入数组
						List<String> listString = new ArrayList<String>(); // 初始化数据存储列
						// 按照列读取每一行数据
						for (int i = 1; i < rowNum; i++) {
							try {
								// 读取数据存入list
								listString.add(columnData[i].getContents());
								// 存入Map<String, List<String>>
								readData.put(columnnName[currentColumn],
										listString);
							} catch (Exception ex) {

							}
						}
					}
				}

				currentColumn++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unable to read Excel data");

		}
		return readData;
	}

	// 写入Excel文件
	public static List<List<String>> wrExcel(String FileName, String SheetName) {
		// 初始化
		rbook = null;
		wbook = null;
		wsheet = null;

		// 声明一个list 用于存放读取的数据
		List<List<String>> xyList = new ArrayList<List<String>>();

		// 获取已有的 Excel文件,修改Excel里面的值
		try {

			String rPath = "./data/" + FileName + ".xls";
			String wPath1 = "./data/" + FileName + "_Tested.xls";
			String wPath2 = "./data/" + FileName + "_Tested.xls";

			// 判断测试结果文件是否存在
			if (new File(wPath1).exists()) {
				File reFile = new File(System.getProperty("user.dir") + wPath1);
				File wrFile = new File(System.getProperty("user.dir") + wPath2);
				rbook = Workbook.getWorkbook(reFile);
				wbook = Workbook.createWorkbook(wrFile, rbook);
				wsheet = wbook.getSheet(SheetName); // 读取Excel
			} else {
				File reFile = new File(System.getProperty("user.dir") + rPath);
				File wrFile = new File(System.getProperty("user.dir") + wPath1);
				rbook = Workbook.getWorkbook(reFile);
				wbook = Workbook.createWorkbook(wrFile, rbook);
				wsheet = wbook.getSheet(SheetName); // 读取Excel
			}

			// 获取有效的行数
			int CaseNum = wsheet.getRows();

			// 获取有效的Title
			Cell[] Title = wsheet.getRow(0);

			// 定义空字符串，存值
			String rowValue = "";

			// 遍历Excel数据，存入 List<List<String>> 外层代表行数，内层代表每行的值
			for (int i = 0; i < CaseNum; i++) {

				// 新建list,用于存储每列的值
				List<String> xyLoctor = new ArrayList<String>();
				Cell[] columnNum = wsheet.getRow(i);
				if (columnNum.length < Title.length) {
					for (int j = 0; j < columnNum.length; j++) {

						rowValue = columnNum[j].getContents();
						xyLoctor.add(rowValue);
					}

					// Actual,Result 留空
					xyLoctor.add("");
					xyLoctor.add("");

				} else {
					for (int j = 0; j < columnNum.length; j++) {

						rowValue = columnNum[j].getContents();
						xyLoctor.add(rowValue);
					}

				}

				if (xyLoctor.get(0).equals("")) {
					continue;
				}
				xyList.add(xyLoctor);

				// System.out.println(xyList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unable to read Excel data");
		}
		System.out.println(xyList);
		return xyList;
	}
	
/*	
	public static void main(String[] args) {
		reExcel("ask_case", "SelfSearch");	
		System.out.println("ok");
	}
	*/
}
