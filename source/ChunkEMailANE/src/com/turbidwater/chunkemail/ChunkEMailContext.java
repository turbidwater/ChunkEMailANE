package com.turbidwater.chunkemail;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.turbidwater.chunkemail.functions.InitFunction;
import com.turbidwater.chunkemail.functions.SendMailFunction;

public class ChunkEMailContext extends FREContext {

	@Override
	public void dispose() {
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
	    functions.put("init", new InitFunction() );
	    functions.put("sendMail", new SendMailFunction() );
	    
	    return functions;
	}

}
