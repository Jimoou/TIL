```java
//String -> Int
//1
String test = "123";
int num = Integer.valueOf(test); 
//2
String test = "123";
int num = Integer.parseInt(test);

//String -> Float
Float.parselFloat();

//String -> Double
Double.parseDouble();

//String -> Long
Long.parseLong();

//Int -> String
//1
int test = 123;
String lang = String.valueOf(test);
//2
int test = 123;
String lang = String.toString(test);

//Double -> Float
//1
Double db = new Double(d);
float f1 = db.floatValue();
//2
float f = (float) d;

//Double -> String
//1
double d = 123.45d;
String str = Double.toString(d);
//2
double d = 123.456d;
String str = String.valueOf(d);
```