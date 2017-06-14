![Alt text](logoNew1.png?raw=true "Kaptur_Logo")

Kaptur GraphCut is an image segmentation tool. At the heart of Kaptur GraphCut lies a graph theory model that overlays an image with a graph. That graph is then segmented into foreground and background using a graph cut algorithm. [Here](http://www.csd.uwo.ca/~yuri/Papers/ijcv06.pdf) is a really awesome paper published by Dr. Boykov and Dr. Funka-Lea on the subject of graph cuts and efficient N-D image segmentation. 

I am developing Kaptur GraphCut to use with my Kaptur logo detection tool as a way to quickly extract foreground objects in an image. I would then all these objects through Kaptur to see if they are indeed logos. This would be used instead of the conventional [sliding window approach](https://courses.engr.illinois.edu/cs543/sp2011/lectures/Lecture%2019%20-%20Sliding%20Window%20Detection%20-%20Vision_Spring2011.pdf).

The approach where I merge Kaptur and Kaptur GraphCut into one really neat tool is in a private repo. Please email me at amarjasarbasic@gmail.com if you would like me to send you the contents of that repo. 
