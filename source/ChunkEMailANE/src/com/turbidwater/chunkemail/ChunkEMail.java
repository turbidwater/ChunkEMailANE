package com.turbidwater.chunkemail;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class ChunkEMail implements FREExtension {

	@Override
	public FREContext createContext( String arg0 ) {
		return new ChunkEMailContext();
	}

	@Override
	public void dispose() {
	}

	@Override
	public void initialize() {
	}

}
