# AndroidKEx

| Extensions for Kotlin. Use the power of Kotlin to make your code smaller and beautiful. |<img src="https://github.com/robertlevonyan/AndroidKEx/blob/master/Pictures/kex.png?raw=true"  width="500" />|
|----------------------------------------------------------------------------------------------|-----------|

[ ![Download](https://api.bintray.com/packages/robertlevonyan/maven/AndroidKEx/images/download.svg) ](https://bintray.com/robertlevonyan/maven/AndroidKEx/_latestVersion)

## Setup

#### Gradle:

Add following line of code to your module(app) level gradle file

```
    implementation 'com.robertlevonyan.view:AndroidKEx:1.1.0'
```

#### Maven:

```
  <dependency>
    <groupId>com.robertlevonyan.components</groupId>
    <artifactId>AndroidKEx</artifactId>
    <version>1.1.0</version>
    <type>pom</type>
  </dependency>
```

## Usage

### Context extensions

```
  // This extensions are also work in Fragments
  
  val myColor = color(R.color.my_color_res)                     // get any color from your recources
  val myString = string(R.string.my_string_res)                 // get any String from your recources
  val myDimen = dimen(R.dimen.my_dimen_res)                     // get any dimension value from your recources as Float
  val myDimenInt = dimenInt(R.dimen.my_dimen_res)               // get any dimension value from your recources as Int
  val myInt = int(R.dimen.my_int_res)                           // get any int value from your recources
  val myFont = font(R.dimen.my_font_res)                        // get any font value from your recources
  val myStringArray = stringArray(R.array.my_string_array_res)  // get any string array from your recources
  val myIntArray = intArray(R.array.my_int_array_res)           // get any int array from your recources
  
  // Show toast with context, second parameter is optional, default value is Toast.LENGTH_SHORT
  toast("Some message", Toast.LENGTH_LONG)
  toast(R.string.message_res)
```

### Activity extensions

```kotlin
  /* Replace a fragment in container, optional parameters
    addToBackStack (default value is false)
    backStackName (default value is "")
    inAnimationRes (default value is 0)
    outAnimationRes (default value is 0)
  */
  replaceFragment(fragment, R.id.container)
  
  /* Add a fragment in container, optional parameters
    addToBackStack (default value is false)
    backStackName (default value is "")
    inAnimationRes (default value is 0)
    outAnimationRes (default value is 0)
  */
  addFragment(fragment, R.id.container)
```
