package com.turbidwater.chunkemail
{
	import flash.events.EventDispatcher;
	import flash.external.ExtensionContext;
	
	public class ChunkEMail extends EventDispatcher
	{
		//-----------------------------------------------------------
		//  DECLARATIONS
		//-----------------------------------------------------------
		protected static var extensionContext:ExtensionContext = ExtensionContext.createExtensionContext( 'com.turbidwater.chunkemail', '' );
		private static var _instance:ChunkEMail;
		
		
		//-----------------------------------------------------------
		//  INIT
		//-----------------------------------------------------------
		public function ChunkEMail( sentry:SingletonSentry )
		{
			super();
		}
		
		public static function getInstance():ChunkEMail
		{
			if( !_instance )
			{
				_instance = new ChunkEMail( new SingletonSentry );
			}
			
			return _instance;
		}
		
		
		//-----------------------------------------------------------
		//  CONTROL
		//-----------------------------------------------------------
		/**
		 * Is ChunkEMail supported?
		 * 
		 * @return	Boolean
		 */
		public static function isSuported():Boolean
		{
			return Boolean( extensionContext );
		}
		
		/**
		 * Open the native composer with prepopulated values.
		 * 
		 * @param	toAddresses	(String) semicolon-separated list of email addresses
		 * @param	subject		(String) subject line for email
		 * @param	body		(String) body of email (Defaults to "")
		 * @param	title		(String) title of email composer window (Defaults to "Send Email")
		 * @param	ccAddresses	(String) semicolon-separated list of email addresses for cc (Defaults to "")
		 * @param	bccAddresses(String) semicolon-separated list of email addresses for bcc (Defaults to "")
		 * 
		 * @return	void
		 */
		public function sendMail( toAddresses:String, subject:String, body:String='', title:String="Send Email", ccAddresses:String='', bccAddresses:String='' ):void
		{
			extensionContext.call( 'sendMail', toAddresses, subject, body, title, ccAddresses, bccAddresses );
		}
	}
}

class SingletonSentry {}