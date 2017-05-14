package com.github.Raouf16.model.preferenceUtils;

public class Teaching 
{
	private String code;
	private String name;
	private String infosCM;
	private String infosTD;
	private String infosTP;
	private String nbGroups;
	private boolean chooseTP ;
	private boolean chooseTD;
	private boolean chooseCM;
	
	public Teaching(String [] parameters)
	{
		code = parameters[0];
		name = parameters[1];
		//TODO à compléter
	}
}
