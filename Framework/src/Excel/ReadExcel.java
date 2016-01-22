package Excel;

import java.util.List;
import java.util.Map;

public class ReadExcel {

	// 只读取第一行数据
	public static String getSingleRowData(Map<String, List<String>> map,
			String columnName) {
		String value = null;
		value = map.get(columnName).get(0); // str 为列名
		return value;

	}

	// 读取任意一列多行数据
	public static List<String> getMultiRowData(Map<String, List<String>> map,
			String K) {
		List<String> mList = map.get(K);
		return mList;
	}

	// 读取CaseName
	public static List<String> getCaseNameList(Map<String, List<String>> map) {
		List<String> listdata = map.get("CaseName");
		return listdata;
	}

	// 读取Expect
	public static List<String> getExpectList(Map<String, List<String>> map) {
		List<String> listdata = map.get("Expect");
		return listdata;
	}

	// 读取Actual
	public static List<String> getActualList(Map<String, List<String>> map) {
		List<String> listdata = map.get("Actual");
		return listdata;
	}

	// 读取Result
	public static List<String> getResultList(Map<String, List<String>> map) {
		List<String> listdata = map.get("Result");
		return listdata;
	}

	
	// 读取表格内指定的数据
	public static String getValue(Map<String, List<String>> map,
			List<String> list, String caseNameStr) {
		String value = "";
		int y = 0;
		List<String> caseNmaelist = map.get("CaseName");
		for (int i = 0; i < caseNmaelist.size(); i++) {
			if (caseNmaelist.get(i).equals(caseNameStr)) {
				y = i;
				break;
			}
		}

		value = list.get(y);
		return value;
	}

}
