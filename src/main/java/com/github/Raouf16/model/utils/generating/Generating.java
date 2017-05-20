package com.github.Raouf16.model.utils.generating;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.RelationalGroupedDataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalog.Column;


/***
 * 
 * @author Sonia ASSAM
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
		Dataset<Row> df = spark.read().option("header", true).csv("src/main/resources/com/github/Raouf16/testpref");
		
		df.show();
		df.select("semester").show();
		df.groupBy("zip_code").count().show();
	}

	public static void main (String []args){

		Generating.generateAgregatedFile();
	}
}
