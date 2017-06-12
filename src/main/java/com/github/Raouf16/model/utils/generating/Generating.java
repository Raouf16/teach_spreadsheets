package com.github.Raouf16.model.utils.generating;


import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.github.Raouf16.model.main.Main;

/***
 * 
 * @author Sonia & katia
 * Classe ayant pour but de générer les fichiers agrégés
 *
 */
public class Generating 
{
	public static void generateAgregatedFile(){
		/***SparkSession spark = SparkSession
				  .builder()
				  .appName("Java Spark SQL basic example")
				  .config("spark.master", "local")
				  .getOrCreate();
		Dataset<Row> preferences = spark.read().option("header", true).csv(Main.preferencesFilePath);
		Dataset<Row> teachers = Main.teachers.select("numen","firstName", "lastName");
		teachers = teachers.join(preferences, "numen");
		teachers.show();
		teachers = teachers.groupBy("numen").sum("nbTD");
		teachers.show();**/

		
	}

	public static void main (String []args){

		Generating.generateAgregatedFile();
	}
}
