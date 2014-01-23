=== ChunkEMail ANE ===
ChunkEMail is an AIR Native Extension designed to use the Android email composer to send emails. You could do this with a mailto: link in 
a navigateToURL call, but there are character limits for doing things that way. If you want to prepopulate with a big chunk of email, this
ANE aims to help you do it.

=== Projects ===
*ChunkEMailLib*
Flex Library project that contains the AS3 API for the ANE.
*ChunkEMailDefault*
Default implementation of API that should allow this ANE to work on desktop simulators. Should, but doesn't at the moment
*ChunkEMailAndroid*
Android project in Java used to generate the jar for the ANE