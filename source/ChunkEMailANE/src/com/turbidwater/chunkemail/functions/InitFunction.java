package com.turbidwater.chunkemail.functions;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class InitFunction implements FREFunction {

	public static final String TAG = "Init_Function";
	
	@Override
	public FREObject call( FREContext arg0, FREObject[] arg1 ) 
	{
		Log.d( TAG, "Init called.");
		return null;
	}

}
