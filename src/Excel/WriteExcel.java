package Excel;

import java.util.ArrayList;
import java.util.List;

import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

public class WriteExcel {

	// 写入Actual，与Expect判断后，得到Result
	private static void setExcelValue(List<List<String>> xyList,
			String CaseName, String ActualValue) {

		//声明 ActualL,Result
		Label ActualLabel = null;
		Label resultValue = null;

		//Excel写入属性
		WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 12,
				WritableFont.NO_BOLD);
		WritableCellFormat wcfGreen = new WritableCellFormat(font);
		WritableCellFormat wcfRed = new WritableCellFormat(font);
		try {
			
			//设置表格颜色
			wcfRed.setBackground(Colour.RED);
			wcfRed.setAlignment(Alignment.CENTRE);
			wcfRed.setVerticalAlignment(VerticalAlignment.CENTRE);

			wcfGreen.setBackground(Colour.GREEN);
			wcfGreen.setAlignment(Alignment.CENTRE);
			wcfGreen.setVerticalAlignment(VerticalAlignment.CENTRE);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		//确定Expect,Actual,Result的列数
		int ExpectNum = 0;
		
		for(int i=0;i<xyList.get(0).size();i++){
			if(xyList.get(0).get(i).equals("Expect")){
				ExpectNum = i;
			}
		}
		int ActualNum = ExpectNum+1;
		int ResultNum = ExpectNum+2;
		
		
		
		
		//写入Actual，写入Result
		for (int i = 1; i < xyList.size(); i++) {
			for (int j = 0; j < xyList.get(i).size(); j++) {
				if (xyList.get(i).get(j).equals(CaseName)) {
					xyList.get(i).set(ActualNum, (ActualValue));

					//判断期望值与实际值，并把结果写入Result
					if (xyList.get(i).get(ExpectNum).equals(xyList.get(i).get(ActualNum))) {
						
						xyList.get(i).set(ResultNum, "True");
						resultValue = new Label(ResultNum, i, xyList.get(i).get(ResultNum),
								wcfGreen);

					} else {
						
						xyList.get(i).set(ResultNum, "False");
						resultValue = new Label(ResultNum, i, xyList.get(i).get(ResultNum),
								wcfRed);
					}

					ActualLabel = new Label(ActualNum, i, xyList.get(i).get(ActualNum));
					try {
						//添加数据，并写入Excel
						Excel.wsheet.addCell(ActualLabel);
						Excel.wsheet.addCell(resultValue);
						Excel.wbook.write();
						Excel.wbook.close();
						Excel.rbook.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	
	// 写入Result
	public static void setResult(String FileName, String SheetName,
			String CaseName, String ActualValue) {
		List<List<String>> listTest = new ArrayList<List<String>>();
		listTest = Excel.wrExcel(FileName, SheetName);
		setExcelValue(listTest, CaseName, ActualValue);
	}

}
