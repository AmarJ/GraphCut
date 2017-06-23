![Alt text](logoNew1.png?raw=true "Kaptur_Logo")

Kaptur GraphCut is an image segmentation tool. At the heart of Kaptur GraphCut lies a graph theory model that overlays an image with a graph. That foreground is then segmented from the image using a graph cut algorithm based off Boykov-Kolmogorov algorithm from the [Graph Cuts and Efficient N-D Image Segmentation](http://www.csd.uwo.ca/~yuri/Papers/pami04.pdf) paper by researchers Dr. Boykov and Dr. Kolmogorov.

I am developing Kaptur GraphCut to use with my Kaptur logo detection tool as a way to extract foreground elements in an image. I would then run all these extracted foreground elements through Kaptur to determine whether there exists a logo. This is used instead of the conventional [sliding window approach](https://courses.engr.illinois.edu/cs543/sp2011/lectures/Lecture%2019%20-%20Sliding%20Window%20Detection%20-%20Vision_Spring2011.pdf). This way I am only running a handful of images (the foreground) through my CNN instead of the hundreds generated through the sliding window approach. 

The approach where I merge Kaptur and Kaptur GraphCut into one really neat tool is in a private repo. Please email me at amarjasarbasic@gmail.com if you would like me to send you the contents of that repo. 
