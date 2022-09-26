package com.izlam.taskhamserv.Models

import com.google.gson.annotations.SerializedName

data class GenresModel(
    @SerializedName("genres")
    var gener :ArrayList<Genre>
    )
// int he manifest file set the service
//\
//
//
//<service
//android:name=".java.MyFirebaseMessagingService"
//android:exported="false">
//<intent-filter>
//<action android:name="com.google.firebase.MESSAGING_EVENT" />
//</intent-filter>
//</service>
//
//
//
//if u wont to set icon and calor set the meta data
//
//<meta-data
//android:name="com.google.firebase.messaging.default_notification_icon"
//android:resource="@drawable/ic_stat_ic_notification" />
//<!-- Set color used with incoming notification messages. This is used when no color is set for the incoming
//notification message. See README(https://goo.gl/6BKBk7) for more. -->
//<meta-data
//android:name="com.google.firebase.messaging.default_notification_color"
//android:resource="@color/colorAccent" />
//
//
//and if it has a channel
//<meta-data
//android:name="com.google.firebase.messaging.default_notification_channel_id"
//android:value="@string/default_notification_channel_id" />
//
////////////////////////////////////
//requestPermission
//
//private final ActivityResultLauncher<String> requestPermissionLauncher =
//registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
//    if (isGranted) {
//
//    } else {
//
//    }
//});
//
//
//private void askNotificationPermission() {
//    // This is only necessary for API level >= 33 (TIRAMISU)
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
//            PackageManager.PERMISSION_GRANTED) {
//
//        } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
//
//        } else {
//
//            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
//        }
//    }
//}
//
//
//FirebaseMessaging.getInstance().subscribeToTopic("weather")
//.addOnCompleteListener(new OnCompleteListener<Void>() {
//    @Override
//    public void onComplete(@NonNull Task<Void> task) {
//        String msg = "Subscribed";
//        if (!task.isSuccessful()) {
//            msg = "Subscribe failed";
//        }
//        Log.d(TAG, msg);
//        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//    }
//});
//
//



