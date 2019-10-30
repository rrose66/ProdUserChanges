package etl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LoadToOne 
{

	public static void main(String[] args) 
	{
		String inputData=null;
//		fileSource = new File("Y:\\ARCHIVES\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\SOURCE_OF_TRUTH_DATA\\CDSID_"  + GetStringTodayYYYYMMDD() + ".csv");
		File fileSource = new File("Y:\\ARCHIVES\\ORACLE\\CDSID_"  + GetStringTodayYYYYMMDD() + ".csv");
		FileWriter fwCleaned = null;
		try 
		{
//			fwCleaned = new FileWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\SOURCE_OF_TRUTH_DATA\\ORACLE_CDSID.TXT",false);
			fwCleaned = new FileWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\ORACLE\\ORACLE_CDSID.TXT",false);
		} 
		catch (IOException e3) 
		{
			e3.printStackTrace();
		}

		BufferedWriter bwSource = new BufferedWriter(fwCleaned);
		PrintWriter pwSource = new PrintWriter(bwSource);

		Scanner sc = null;
		try 
		{
			sc = new Scanner(fileSource);
		} 
		catch (FileNotFoundException e2) 
		{
			e2.printStackTrace();
		}
		sc.nextLine();
		while (sc.hasNextLine())
		{
			inputData=sc.nextLine();
			pwSource.println(inputData.replace("\"", ""));						

		}
		pwSource.close();
		

//		------------------------------------
		
		String strCdsidRoleinputData=null;
//		fileSource = new File("Y:\\ARCHIVES\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\SOURCE_OF_TRUTH_DATA\\CDSID_ROLE_" + GetStringTodayYYYYMMDD() + ".csv");
		fileSource = new File("Y:\\ARCHIVES\\ORACLE\\CDSID_ROLE_" + GetStringTodayYYYYMMDD() + ".csv");
		FileWriter fwCleanedRoleCDSID = null;
		try 
		{
//			fwCleanedRoleCDSID = new FileWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\CREDENTIAL_MANAGEMENT\\SEGREGATION_OF_DUTIES\\SOURCE_OF_TRUTH_DATA\\ORACLE_CDSID_ROLE.TXT",false);
			fwCleanedRoleCDSID = new FileWriter("C:\\PROJECTS\\DATA\\FEDEBOM\\ORACLE\\ORACLE_CDSID_ROLE.TXT");
		} 
		catch (IOException e3) 
		{
			e3.printStackTrace();
		}

		BufferedWriter bwRoleCDSID = new BufferedWriter(fwCleanedRoleCDSID);
		PrintWriter pwRoleCDSID = new PrintWriter(bwRoleCDSID);
		pwRoleCDSID.println("CDSID,ROLE");	

		Scanner scRoleCDSID = null;
		try 
		{
			scRoleCDSID = new Scanner(fileSource);
		} 
		catch (FileNotFoundException e2) 
		{
			e2.printStackTrace();
		}
		scRoleCDSID.nextLine();
		while (scRoleCDSID.hasNextLine())
		{
			inputData=scRoleCDSID.nextLine();
			pwRoleCDSID.println(inputData.replace("\"", ""));						

		}
		pwRoleCDSID.close();
		

	}
	public static String GetStringTodayYYYYMMDD()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date dateFile = new Date();
		return dateFormat.format(dateFile);
	}

}
