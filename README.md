

# TelloTalk News Sdk 

TelloTalkSdk is a solution for integrating chat messaging in your app.

## Prerequisites
You must have **AccessKey** and **ProjectToken** to use this SDK in your application.

## Installation

Add SDK AAR in your app lib folder as following:

```java
implementation(name: 'Your AAR file name', ext: 'aar')
```

## Usage

Extend your application class with *TelloApplication* class in TelloSDK. Initialize **TelloTalkSdk** client before using any of its features

```java
TelloApiClient.Builder builder = new TelloApiClient.Builder()
                .accessKey("accessKey")
                .projectToken("projectToken")
              .notificationIcon("Drawable Resource for notification Small Icon");
        telloApiClient = builder.build();
```
 After initialization you can use **TelloApiClient** object to access SDK features.


Register user to Sdk using following method :
```java
 telloApiClient.registerUser(Context context,String profileId, OnSuccessListener<Boolean> listener)
```
This method will return true/false if user is register or not. After that on every app restart you need to call login to be able to access sdk  using following method:

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