# Connected Object Counter Project

A Java console application that uses dfs to count number of connected objects in an image based on a provided color.

## Mac iOS (Tested)

### How to build
```
javac -d build $(find . -name "*.java")
```

### How to run
```
java -cp build App resources/img_4.jpg
```

## Windows (Not Tested)

### How to build
```
javac -d build App.java core\ConnectedObjectCounter.java core\ImageObject.java core\ImageObjectCounter.java image\ImageLoader.java processors\VerticalLineProcessor.java processors\HorizontalLineProcessor.java
```

### How to run
```
java -cp build App resources/img_4.jpg
```