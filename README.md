# EasyAndroid
This Library Will Make Your Android Develoment A Lot Easier

How TO ADD TO YOUR ANDROID PROJECT

STEP 1 = OPEN PROJECT LEVEL Build.gradle File

        allprojects {
         repositories {
            ...
            ...
            //add this line to here
            maven { url 'https://jitpack.io' }
          }
        }
        
STEP 2 = OPEN APP LEVEL Build.gradle File
  add this to dependencies section
  
  
  dependencies {
      ...
      ...
      //add this line here in dependencies
      implementation 'com.github.SagheerHussainZardari:EasyAndroid:2.0.3'
  }
  
 
