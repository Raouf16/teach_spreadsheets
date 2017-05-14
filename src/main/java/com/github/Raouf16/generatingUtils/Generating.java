package com.github.Raouf16.generatingUtils;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

/***
 * 
 * @author Sonia ASSAM
 * Classe ayant pour but de générer les fichier agrégés
 *
 */
public class Generating 
{
	public static void generateAgregatedFile()
	{
		SparkConf conf = new SparkConf().setAppName("Workshop").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(sc);
		DataFrame df = sqlContext.read()
		    .format("com.databricks.spark.csv")
		    .option("inferSchema", "true")
		    .option("header", "true")
		    .load("test.txt");
		df.show();
	}

	public static void main (String []args)
	{
		Generating.generateAgregatedFile();
	}
}
