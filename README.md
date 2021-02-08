

# TelloTalk News Sdk 

TelloTalk News SDK is a solution from integrating news in your app.

## Prerequisites
You must have **AccessKey** and **ProjectToken** to use this SDK in your application.

## Installation

Add SDK dependency in your app build.gradle as following:

```java
implementation 'com.tilismtech.tellotalksdk:tellotalksdk:0.1.6@aar'
```
in Project build.gradle
```java

repositories {
    google()
jcenter()
maven { url "https://dl.bintray.com/faizrehman1/TelloCast-News" }
}
```


## Usage

Extend your application class with *TelloApplication* class in TelloSDK. Initialize **TelloTalkSdk** client before using any of its features

```java
TelloApiClient.Builder builder = new TelloApiClient.Builder()
                .accessKey("accessKey")
                .projectToken("projectToken")
                .setContext(getApplicationContext())
              .notificationIcon("Drawable Resource for notification Small Icon");
        telloApiClient = builder.build();
```
 After initialization you can use **TelloApiClient** object to access SDK features.


Register user to Sdk using following method :
```java
 telloApiClient.registerUser(Context context,String profileId, OnSuccessListener<Boolean> listener)
```
This method will return true/false if user is register or not. After that on every app restart you need to call login to be able to access sdk.

## Send User to Specific Channel from Notication
If you want to go to a particular news' category, SDK needs to know user's profile id, category id and sub category id. You can provide these values in NotificationNewsObj class. By calling following method you can view news category.

```java
  MyApplication.getInstance().getTelloApiClient().routeToCategory(new NotificationNewsObj(String category_id, String sub_category_id, String profileID);
```

## Send User to Specific Channel from Notication (Through Json Model)
```java
  MyApplication.getInstance().getTelloApiClient().setNotificationState(new JSONObject()));
```

## Send User to Specific News Item from Notication
If you want to directly view a particular news you must call below method by providing required parameters. This method requires a presenting view controller and NotificationNewsObj in which you must provide profile Id, category Id, sub category Id, news Id, news title and news URL.

```java
MyApplication.getInstance().getTelloApiClient().showNewsItem(new NotificationNewsObj(String category_id, String sub_category_id, String profileID, String news_Id, String news_title, String news_url);
```

## Payload Example:
```java
String s="{\n" +
                " \"profileId\": \"test_android\",\n" +
                " \"sdkNotification\": {\n" +
                "   \"news_id\": 31330,\n" +
                "   \"news_title\": \"Blast in Afghanistan kills Mangal Bagh\",\n" +
                "   \"news_description\": \"KHYBER: Chief of one of Khyber district’s most dreaded and banned organisations, Lashkar-i-Islam (LI), Mangal Bagh was killed in a mine explosion in Nangarhar province of Afghanistan on Thursday\",\n" +
                "   \"news_url\": \"www.google.com\",\n" +
                "   \"category_id\": \"dawn\",\n" +
                "   \"sub_category_id\": \"Pakistan\"\n" +
                " }\n" +
                "}";
```



## Dependencies
```java
//For Network Calling
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//For Response Convertion    
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "androidx.coordinatorlayout:coordinatorlayout:1.1.0"
//For material views
    implementation 'com.google.android.material:material:1.2.1'
    implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
//Image load from URL    
    implementation('com.facebook.fresco:fresco:1.11.0') {
        exclude group: 'com.facebook.fresco', module: 'soloader'
        exclude group: 'com.facebook.fresco', module: 'nativeimagefilters'
        exclude group: 'com.facebook.fresco', module: 'nativeimagetranscoder'
        exclude group: 'com.facebook.fresco', module: 'memory-type-native'
        exclude group: 'com.facebook.fresco', module: 'imagepipeline-native'
    }
    implementation 'androidx.browser:browser:1.2.0'
}
```
## Set App Theme
You can change app theme for dark and light modes by using following methods
```java
boolean mode ; 
// mode = true; for dark theme
//  mode = false; for light theme
MyApplication.getInstance().getTelloApiClient().setUserInterface(mode); // For Dark Mode
```

## Set Color Code
You can set navigation bar tint color, background color of news channel background view, news channel and category selection color, and selected and unselected news channel and category text color.
```java
<color name="colorlight">#ffffff</color> // List Background Color for Light theme
    <color name="colordark">#141414</color> // List Background Color for Dark theme
    <color name="darkcard">#303030</color> // Card Color for Dark theme
    <color name="whitecard">#ffffff</color> // Card Color for Light theme
    <color name="darktext">#ffffff</color> // Card text color for dark theme
    <color name="lighttext">#303030</color> // Card text color for Light theme


    //Dark Mode
    <color name="dark_toolbar">#006064</color> // Dark Mode Toolbar Background Color
    <color name="dark_category_background">#0097A7</color>  // Dark Mode Category Background Color
    <color name="dark_subcategory_background">#26C6DA</color>  // Dark Mode Subcategory Background Color
    <color name="dark_category_selection">#E0F7FA</color> // Dark Mode Subcategory Indicator Color
    <color name="dark_subcategory_selection">#114A51</color> // Dark Mode Category Indicator Color
    <color name="dark_selected_tab_text">#000000</color> // Dark Mode Selected Tab Text Color
    <color name="dark_unselected_tab_text">#afafaf</color> // Dark Mode Un Selected Tab Text Color

    //Light Mode
    <color name="light_toolbar">#004D40</color> // Light Mode Toolbar Background Color
    <color name="light_category_background">#00796B</color> // Light Mode Category Background Color
    <color name="light_subcategory_background">#26A69A</color>  // Light Mode Subcategory Background Color
    <color name="light_category_selection">#B2DFDB</color> // Light Mode Subcategory Indicator Color
    <color name="light_subcategory_selection">#75132A</color> // Light Mode Category Indicator Color
    <color name="light_selected_tab_text">#000000</color> // Light Mode Selected Tab Text Color
    <color name="light_unselected_tab_text">#afafaf</color> // Light Mode Un Selected Tab Text Colors
}
```