package com.bizi.tools.excel;

import com.bizi.tools.exception.BaseAppException;
import com.bizi.tools.format.FormatUtil;
import com.bizi.tools.validate.ValidateUtil;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;

/**
 * desc：
 * aithor：guofangbi
 * date:2015/4/19
 */
@Ignore
public class ExcelTest {
	@Test
	public void importTarget() {
		File file = new File("C:/excelResult.xls");
		int i=0;
		try {
			Map<String, String[][]> dataMap = ExcelUtil.readExcel(file);
			String[][] data = dataMap.get("list");
//
//insert into table values(1,'bizi',to_date('2012-01-01,'yyyymmmddd''))
			for (String[] row : data) {
				if(i==0){
					i++;
					continue;

				}
				StringBuffer sql = new StringBuffer("Insert into reconcav.t_cbs_recon_billorder_cps values(");
				String id = Long.parseLong(row[0]) + "," + "'" + row[1] + "'," + Long.parseLong(row[2]) + "," + Long.parseLong(row[3]) + "," + Long.parseLong(row[4]) + "," + Float.parseFloat(row[5]) + ","
						+ "'" + row[6] + "'," + Float.parseFloat(row[7]) + "," + Long.parseLong(row[8]) + "," + "'" + row[9] + "'," + "'" + row[10] + "'," + "'" + row[11] + "'," + "'" + row[12] + "'," + "to_date(" + row[13] + ",'yyyymmdd' )',"
						+ "to_date(" + row[14] + ",'hh:mm:ss' )'," + "'" + row[15] + "," + "to_date(" + row[16] + ",'yyyymmdd' )'," + "to_date(" + row[17] + ",'yyyymmdd' )'," + "to_date(" + row[18] + ",'yyyymmdd' )'," + "'" + row[19] + "',"
						+ "'" + row[20] + "'," + "'" + row[21] + "'," + "'" + row[22] + "'," + "'" + row[23] + "'," + "'" + row[24] + "'," + "'" + row[25] + "'," + "'" + row[26] + "'," + Long.parseLong(row[27]) + "," + Long.parseLong(row[28]) + "," +
						"'" + row[29] + "'," + Long.parseLong(row[30]) + "," + Long.parseLong(row[31]) + "," + Long.parseLong(row[32]) + "," + "to_date(" + row[33] + ",'yyyymmdd' )'," + "to_date(" + row[34] + ",'yyyymmdd' )'," + Long.parseLong(row[35]) + "," + Long.parseLong(row[36]) + ")";


				System.out.println(sql.toString());
				sql = null;
			}


		} catch (BaseAppException e) {
			e.printStackTrace();
		}
	}

	@Test
	 public void importCustomer(){
		File file = new File("C:/test.xls");
		int startNum = 14;
		try {
			Map<String, String[][]> dataMap = ExcelUtil.readExcel(file);
			String[][] data = dataMap.get("内部客商");

			for (String[] row : data) {
				StringBuffer sql = new StringBuffer("Insert into customer values(");

				if(ValidateUtil.isBlank(row[1])){
					continue;
				}

				String code = "'C" + FormatUtil.format(new BigDecimal(startNum), 4) + "',";
				String nameCn = "'" + row[1] + "',";
				String nameEn = "'" + row[2] + "',";
				String shortName = "'" + row[3] + "'";
				String type = "'" + row[4] + "',";
				String phone = "'" + row[5] + "',";
				String address = "'" + row[6] + "',";

				sql.append(code).append(nameCn).append(nameEn).append(address).append(phone).append("null,").append(type)
						.append("1,sysdate,'helen',sysdate,'helen',null,null,1,")
						.append(startNum).append(",null,null,null,null,").append(shortName).append(");");
				startNum++;

				System.out.println(sql.toString());
				sql = null;
			}



		} catch (BaseAppException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void importInsurer(){
		File file = new File("C:/test.xls");
		int startNum = 3;
		try {
			Map<String, String[][]> dataMap = ExcelUtil.readExcel(file);
			String[][] data = dataMap.get("保险公司");

			for (String[] row : data) {
				StringBuffer sql = new StringBuffer("Insert into insurer values(");

				if(ValidateUtil.isBlank(row[1])){
					continue;
				}

				String code = "'U" + FormatUtil.format(new BigDecimal(startNum), 4) + "',";
				String nameCn = "'" + row[1] + "',";
				String shortName = "'" + row[2] + "'";
				String nameEn = "'" + row[3] + "',";
				String type = "'" + row[4] + "',";
				String nature = "'" + row[5] + "',";
				String phone = "'" + row[6] + "',";
				String fax = "'" + row[7] + "',";
				String address = "'" + row[8] + "',";

				sql.append(code).append(nameCn).append(nameEn).append(address).append(phone).append(fax).append(nature).append(type)
						.append("null,").append("1,'helen',sysdate,sysdate,'helen',null,1,")
						.append(startNum).append(",null,null,null,").append(shortName).append(");");
				startNum++;

				System.out.println(sql.toString());
				sql = null;
			}



		} catch (BaseAppException e) {
			e.printStackTrace();
		}
	}


}
