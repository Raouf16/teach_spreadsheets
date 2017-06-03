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
public class Generating {
	public static void generateAgregatedFile(){
		SparkSession spark = SparkSession
				  .builder()
				  .appName("Java Spark SQL basic example")
				  .config("spark.master", "local")
				  .getOrCreate();
		Dataset<Row> df = spark.read().option("header", true).csv(Main.preferencesFilePath);
		
		df.show();
		df.select("semester").show();
		df.groupBy("semester").count().show();
	}

	public static void main (String []args){

		Generating.generateAgregatedFile();
	}
}
