# imgur-android
A lightweight Imgur API client for android, built using Moshi and Retrofit

### How to install.

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.KirkBushman:imgur-android:Tag'
}
```

### Obtain a client.

```
val client = ImgurClient(UserlessCredentials(**CLIENT ID**), logging = true)
```

### Use it to browse Gfycat.

```
// get album data
val album = client.album(albumHash)

// get gallery data
val gallery = client.gallery(galleryHash)
```

### License
This project is licensed under the MIT License
