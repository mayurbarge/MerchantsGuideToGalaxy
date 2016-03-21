How to execute MerchantsConversionGuide ?

Setup maven and verify mvn command runs successfully.

1) Extract MerchantsGuideToGalaxy.zip to a location say c:\test
2) Go to the folder c:\test\MerchantsGuideToGalaxy
3) Run the below command to generate jar file, from the MerchantsGuideToGalaxy
mvn insall
4) Jar file with name merchantsguide.jar should get created under 
c:\test\MerchantsGuideToGalaxy\target
5) Go to the target folder and run the below command to execute the file
java -jar merchantsguide.jar "INPUT_FILE_PATH"
6) The output.txt should get generated under target folder



















How to execute the MerchantsConversionGuide ?

1) Extract the source to some folder say C:/MerchantsGuide
2) Open the folder and go to src/main/java
3) Compile the packages
javac com\galaxyguide\io\*.java
javac com\galaxyguide\metals\*.java
javac com\galaxyguide\numbers\*.java
4) Run the program with below command
java com.galaxyguide.io.MerchantsConversionGuide "C:\MayurWorkspace\MerchantsGuideToGalaxy\input.txt"
