# ChunkEMail ANE
ChunkEMail is an AIR Native Extension designed to use the Android email composer to send emails. You could do this with a mailto: link in 
a navigateToURL call, but there are character limits for doing things that way. If you want to prepopulate with a big chunk of email, this
ANE aims to help you do it.

This extension is Android only (with desktop simulator support). There is no intention of supporting iOS. Instead try https://github.com/pkoscierzynski/NativeMailExtension.


## Projects
* **ChunkEMailLib**
Flex Library project that contains the AS3 API for the ANE.
* **ChunkEMailDefault**
Flex Library project. Default implementation of API that should allow this ANE to work on desktop simulators. Should, but doesn't at the moment
* **ChunkEMailANE**
Android project in Java used to generate the jar for the ANE
* **ChunkEMailTest**
Flex Project. Sample implementation project.

## Build the ANE
To build the ANE, 
1. go to the build directory in console 
2. put in the following command:
adt -package -target ane ChunkEMail.ane extension.xml -swc ChunkEMailLib.swc -platform Android-ARM -C android . -platform default -C default .
3. copy the ChunkEMail.ane into the libs folder of ChunkEmailTest

This assumes you have adt installed. If you don't, follow the instructions in this tutorial, which is how I got my start:
http://www.adobe.com/devnet/air/articles/building-ane-ios-android-pt1.html
Part 5 of that article tells how to structure your build files for the ANE.
