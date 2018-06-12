# AndroidKEx

| Extensions for Kotlin. Use the power of Kotlin to make your code smaller and beautiful. |<img src="https://github.com/robertlevonyan/AndroidKEx/blob/master/Pictures/kex.png?raw=true"  width="500" />|
|----------------------------------------------------------------------------------------------|-----------|

[ ![Download](https://api.bintray.com/packages/robertlevonyan/maven/AndroidKEx/images/download.svg) ](https://bintray.com/robertlevonyan/maven/AndroidKEx/_latestVersion)

## Setup

#### Gradle:

Add following line of code to your module(app) level gradle file

```groovy
    implementation 'com.robertlevonyan.view:AndroidKEx:1.1.1'
```

#### Maven:

```xml
  <dependency>
    <groupId>com.robertlevonyan.components</groupId>
    <artifactId>AndroidKEx</artifactId>
    <version>1.1.1</version>
    <type>pom</type>
  </dependency>
```

## Usage

### Context extensions

```kotlin
  // This extensions are also work in Activities, Fragments, Dialogs and DialogFragments
  
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
  
  /* Start new activity, optional parameters
    extras (default value is Bundle())
    overrideTransitions (default value is false)
    enterAnimation (default value is 0)
    exitAnimation (default value is 0)
  */
  startActivity(activityToOpen)
  
  /* Start new activity for result, optional parameters
    extras (default value is Bundle())
    overrideTransitions (default value is false)
    enterAnimation (default value is 0)
    exitAnimation (default value is 0)
  */
  startActivityForResult(activityToOpen, requestCode)
  
  /* Start new activity with transitions, optional parameter
    extras (default value is Bundle())
  */
  startActivityWithTransitions(activityToOpen, options)
  
  /* Start new activity for result with transitions, optional parameter
    extras (default value is Bundle())
  */
  startActivityForResultWithTransitions(activityToOpen, requestCode, options)
  
  /* Start new activity for result with transitions, optional parameter
    requestCode (default value is 0)
    extras (default value is Bundle())
  */
  startActivityFromFragmentWithTransitions(activityToOpen, fragmentFrom, options)
  
  /* Start new activity for result with transitions, optional parameter
    extras (default value is Bundle())
  */
  startActivityFromFragmentWithResult(activityToOpen, fragmentFrom, requestCode)
  
  // Works on API19+
  makeTranslucentStatusBar()
  
  // Works on API23+
  lightStatusBar()
  
  // Works on API19+, removes the previous
  makeNormalStatusBar()
  
  // Works on API19+
  makeTranslucentNavigationBar()
  
  // Works on API26+
  lightNavigation()
  
  // Works on API19+, removes the previous
  makeNormalNavigationBar()
```

### Fragment extensions

```kotlin
  /* Start new activity for result from fragment, optional parameters
    extras (default value is Bundle())
    overrideTransitions (default value is false)
    enterAnimation (default value is 0)
    exitAnimation (default value is 0)
  */
  startActivityForResult(activityToOpen, requestCode)
  
  /* Start new activity for result with transitions, optional parameter
    extras (default value is Bundle())
  */
  startActivityFromFragmentWithResult(activityToOpen, fragmentFrom, requestCode)
 
```

### Animator extensions

```kotlin
  val animator = ValueAnimator.ofFloat(1f, 10f)
  
  animator.onStart { ... }
  animator.onEnd { ... }
  animator.onCancel { ... }
  animator.onRepeat { ... }
  animator.onResume { ... }                                 // API 19+
  animator.onPause { ... }                                  // API 19+
  
  animator.addListener(
    { /* onStart */},
    { /* onEnd */},
    { /* onCancel */},
    { /* onRepeat */},
  )
  
  animator.addPauseListener(
    { /* onResume */ },
    { /* onPause */ }
  )
  
  val transition = Explode()
  
  transition.onTransitionStart { ... }
  transition.onTransitionEnd { ... }
  transition.onTransitionResume { ... }
  transition.onTransitionPause { ... }
  transition.onTransitionCancel { ... }
  
  transition.addListener(
    { /* onTransitionStart */ },
    { /* onTransitionEnd */ },
    { /* onTransitionResume */ },
    { /* onTransitionPause */ },
    { /* onTransitionCancel */ }
  )
```

### Collections extensions

```kotlin
  val list = ...
  
  val randomItem = list.randomItem()                        // Get random item from any List
```

### Calendar extensions

```kotlin
  val calendar = ...
  
  calendar.getDayOfWeek()
  calendar.getDayOfMonth()
  calendar.getDayOfWeekInMonth()
  calendar.getDayOfYear()
  calendar.getWeekOfMonth()
  calendar.getHourOfDay()
  calendar.getYear()
  calendar.getHour()
  calendar.getMinute()
  calendar.getSecond()
  calendar.getMillisecond()
```

### File extensions

```kotlin
    uri.realPath(context)
    
    string.toUri()
    
    file.toUri()
    file.copyInputStreamToFile(inputStream)
```

### Image extensions

```kotlin
   val bitmap = ...
   
   bitmap.rotate(degrees)
   bitmap.toUriJpeg(context, title, description)
   bitmap.toUriPng(context, title, description)
   bitmap.toUriWebp(context, title, description)
   bitmap.makeCircle()
   bitmap.toDrawable(context)
   uri.toBitmap(context)
  
   val drawable = ...
   
   drawable.toBitmap()
   uri.toDrawable(context)
   
   val imageView = ...
  
   imageView set R.drawable.image_res
   imageView set drawable
   imageView set bitmap
   imageView set icon                                                       // API 23+
   imageView set uri
```

### Text extensions

```kotlin
   val editText = ...
   
   editText.afterTextChanged { editable -> ... }
   editText.beforTextChanged { charSequence, start, count, after -> ... }
   editText.onTextChanged { charSequence, start, before, count -> ... }
   editText.focus()                                                         // focus on this EditText
   editText.requestFocusAndKeyboard()                                       // focus and open keyboard
   editText.clearFocusAndKeyboard()                                         // remove focus and close keyboard
   
   val textView = ...
   
   textView set R.string.some_text_resource
   textView set someString
   textView set someSpannable
```

### View extensions

```kotlin
   val view = ...
   
   view.dismissKeyboard()
   
   /* Create snackbar on view, optional parameters
       duration (default value is Snackbar.LENGTH_SHORT)
       actionName (default value is ")
       actionTextColor (default value is 0)
       action (default value is {})
   */
   view.snackbar(someStringMessage)
   view.snackbar(R.string.some_message_res)
   
   /*Animate different properties of view, optional parameters
       duration (default value is 300)
       repeatCount (default value is 0)
       repeatMode (default value is 0)
   */
   view.animateTranslationX(floatArrayOf( ... ))
   view.animateTranslationY(floatArrayOf( ... ))
   view.animateTranslationZ(floatArrayOf( ... ))            // API 21+
   view.animateScaleX(floatArrayOf( ... ))
   view.animateScaleY(floatArrayOf( ... ))
   view.animateAlpha(floatArrayOf( ... ))
   view.animateRotation(floatArrayOf( ... ))
   view.animateRotationX(floatArrayOf( ... ))
   view.animateRotationY(floatArrayOf( ... ))
   view.animateX(floatArrayOf( ... ))
   view.animateY(floatArrayOf( ... ))
   view.animateZ(floatArrayOf( ... ))                       // API 21+
   
   
   val animator = view.translationXAnimator(floatArrayOf( ... ))
   val animator = view.translationYAnimator(floatArrayOf( ... ))
   val animator = view.translationZAnimator(floatArrayOf( ... ))            // API 21+
   val animator = view.scaleXAnimator(floatArrayOf( ... ))
   val animator = view.scaleYAnimator(floatArrayOf( ... ))
   val animator = view.alphaAnimator(floatArrayOf( ... ))
   val animator = view.rotationAnimator(floatArrayOf( ... ))
   val animator = view.rotationXAnimator(floatArrayOf( ... ))
   val animator = view.rotationYAnimator(floatArrayOf( ... ))
   val animator = view.xAnimator(floatArrayOf( ... ))
   val animator = view.yAnimator(floatArrayOf( ... ))
   val animator = view.zAnimator(floatArrayOf( ... ))                       // API 21+
   
   view width 150                           // set view width
   view hesght 100                          // set view height
   
   val linearLayout = ...                   // or some other layout
   
   linearLayout inflate R.layout.some_layout_to_inflate
   
   val progressBar = ...
   
   progressBar.loaderColor(colorInt)
   
   val checkBox = ...                       // or some other compund button
   
   checkBox.onChecked { view, isChecked -> ... }
   
   val bottomSheetBehavior = ...
   
   bottomSheetBehavior.onSlide { bottomSheetView, slideOffset -> ... }
   bottomSheetBehavior.onStateChanged { bottomSheetView, newState -> ... }
```
