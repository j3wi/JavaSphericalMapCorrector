cd Java Spherical Map Corrector
======================
Introduction
--------------

I was searching for a way for texture sphere without too much deformation.

Googling around I found two solutions:
The first one was a plugin for photoshop called **SphericalMappingCorrector**

http://www.creativecrash.com/photoshop/downloads/plug-ins/c/photoshop-spherical-mapping-corrector

The second was a Lua script found in this page:
http://www.thebest3d.com/dogwaffle/lua/polar/

At first I tried with the *gluas plugin* for *gimp* but the script didn't compile.
So, finally I decided to implement the algorithm used in the Lua script in Java.

The program is a simple swing application that loads and process an image to be projected correctly into a sphere. Later you can save the image (*or compare it with the loaded image by pressing the mouse*).
 
This is a fast implementation, by now (and probably never) there is no zoom or scale options. This could be little troublesome if you work with big images. If thats the case you can email me and we can try to solve it.
But independently that you can see the result you can save it through the menu. 

Use
----
You only need to open the image you want to process and save it later. All done with the menu interface.

You can also compare the result by pressing the mouse button.


Set up
-----------
This is a maven project  (just the structure, there are no dependencies). It's quite easy to set up if you know a little about maven. If it isn't the case I suggest you google some of the good guides you can find on the net.

But if you wan't to try it you can easily import a maven project in eclipse/netbeans/intelliJ without problem.
 
Results
-------
I had quite expectations with this algorithm but finally I am a little disapointed.

The main problem is that the result isn't seamless. But It somehow works depending of the texture used, so I suggest you give it a try and decide by yourselves. 