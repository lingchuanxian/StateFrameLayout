# StateFrameLayout
实现Android 多状态加载布局
## Usage
在app/build.gradle文件中添加依赖

    dependencies {
          compile 'com.github.smlcx:StateFrameLayout:1.0.0'
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
     
最后在你的 activity/fragment 中获取StateFrameLayout引用并调用showState()方法
    用法如下：
    
    mStateFrameLayout = (StateFrameLayout) findViewById(R.id.stateframe);
    mStateFrameLayout.showState(new StateAttr.Builder()
                    .setState(StateAttr.State.loading)
                    .setMessage("正在加载")
                    .setProgressColor(R.color.stfmessageColor)
                    .build()
            );
	
## API

如果将clickListener参数传递为null，则相关状态按钮将被隐藏。


## proguard-rules.pro

	-keep class cn.fjlcx.android.stateframelayout.** {
	*;
	}