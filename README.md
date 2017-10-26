# LingWidget
实现Android 多状态加载布局
## Usage
在app/build.gradle文件中添加依赖

    dependencies {
          compile 'com.github.smlcx:LingWidget:1.0'
    }
    
用StateFrameLayout包装一个目标区域（视图）来显示状态的视图

     <cn.fjlcx.android.stateframelayout.StateFrameLayout
           android:id="@+id/stateframe"
           android:layout_width="match_parent"
           android:layout_height="match_parent">
       
            <!-- your content here  -->
           <TextView
                 android:layout_width="match_parent"
                 android:layout_height="match_parent"
                 android:text="这是数据"
                 android:gravity="center"/>
             ...
     </cn.fjlcx.android.stateframelayout.StateFrameLayout>
     
最后在你的 activity/fragment 中获取StateFrameLayout引用并调用showXXX方法

	mStateFrameLayout = (StateFrameLayout) findViewById(R.id.stateframe);
	mStateFrameLayout.showLoading();
	
## API

如果将clickListener参数传递为null，则相关状态按钮将被隐藏。

#### 显示内容
* showContent()
 
#### 加载中
* showLoading()
* showLoading(@StringRes int messageId)

#### 空数据
* showEmpty()
* showEmpty(@StringRes int messageId)
* showEmpty(@StringRes int messageId,@DrawableRes int drawableId)

#### 异常
* showError(OnClickListener clickListener)
* showError(@StringRes int messageId,OnClickListener clickListener)
* showError(@StringRes int messageId,@DrawableRes int drawableId, OnClickListener clickListener)

#### 离线（无网络）
* showOffline(OnClickListener clickListener)
* showOffline(@StringRes int messageId, OnClickListener clickListener)
* showOffline(@StringRes int messageId,@DrawableRes int drawableId, OnClickListener clickListener)

## proguard-rules.pro

	-keep class cn.fjlcx.android.stateframelayout.** {
	*;
	}