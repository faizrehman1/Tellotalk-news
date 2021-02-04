

# TelloTalk News Sdk 

TelloTalkSdk is a solution for integrating chat messaging in your app.

## Prerequisites
You must have **AccessKey** and **ProjectToken** to use this SDK in your application.

## Installation

Add SDK dependency in your app build.gradle as following:

```java
implementation 'com.tilismtech.tellotalksdk:tellotalksdk:0.1.5@aar'
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
```java
  MyApplication.getInstance().getTelloApiClient().setNotificationState(new NotificationNewsObj(String category_id, String sub_category_id, String profileID);
```

## Send User to Specific News Item from Notication
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