# enlargeImageView
android 点击图片放大全屏 再点击缩放回原来的位置 
## 先来张效果图  
![效果图](https://github.com/luchongbin/enlargeImageView/blob/master/gif/introduce.gif)  

## 使用说明  
1、Add it in your root build.gradle at the end of repositories:  
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```  
2、Add the dependency  
```  
dependencies {
	        implementation 'com.github.luchongbin:enlargeImageView:v1.0.0'
	}  
```  
3、在Mainifest文件中添加如下代码(即注册activity)
```
<activity
         android:theme="@style/EnlargeTheme.Transparent"
          android:name="com.luchongbin.enlarge.myenlarge.EnlargeImageDetailActivity">
 </activity>  
 ```
 4、在你所需要所用的地方添加如下代码  
```
        Intent intent = new Intent(this, EnlargeImageDetailActivity.class);
        intent.putExtra(CommonUtils.SpaceImageDetail.IMAGEURL, imageUrl);//传入 图片的URL
        int[] location = new int[2];
        view.getLocationOnScreen(location);//view 就是所点击的ImageView
        intent.putExtra(CommonUtils.SpaceImageDetail.LOCATIONX, location[0]);
        intent.putExtra(CommonUtils.SpaceImageDetail.LOCATIONY, location[1]);

        intent.putExtra(CommonUtils.SpaceImageDetail.WIDTH, view.getWidth());
        intent.putExtra(CommonUtils.SpaceImageDetail.HEIGHT, view.getHeight());
        startActivity(intent);
        overridePendingTransition(0, 0);
 ```  
 ##  License  
 MIT License

Copyright (c) 2018 卢崇斌

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
