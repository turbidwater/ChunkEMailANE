package com.turbidwater.chunkemail;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class ChunkEMail implements FREExtension 
{

	@Override
	public FREContext createContext( String arg0 ) 
	{
		return new ChunkEMailContext();
	}

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize() 
	{
		// TODO Auto-generated method stub

	}
}
