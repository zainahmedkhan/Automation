package stepdefinitions;

import java.util.List;
import java.util.Map;

import dataTransformation.ExcelConfiguration;
import dataTransformation.ExcelDataReader;
import dataTransformation.IDataReader;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;

public class ConvertExcelToDataTable {
	
	@Given("The excel filename and location is given as")
	public void the_excel_filename_and_location_is_given_as(IDataReader dataTable) {
			
		List<Map<String,String>> data = dataTable.getAllRows();
		
		Map<String,String> data2 = dataTable.getSingleRow();
		System.out.println(data2);
	}
	
	@DataTableType
	public IDataReader excelToDataTable(Map<String, String> entry)
	{
		ExcelConfiguration config = new ExcelConfiguration.ExcelConfigurationBuilder()
				.setFileName(entry.get("Excel"))
				.setFileLocation(entry.get("Location"))
				.setsheetName(entry.get("Sheet"))
				.setIndex(Integer.valueOf(entry.getOrDefault("Index", "0")))
				.build();		
		return new ExcelDataReader(config);
	}
	

}
