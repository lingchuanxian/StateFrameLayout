package cn.fjlcx.android.ling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.fjlcx.android.stateframelayout.StateAttr;
import cn.fjlcx.android.stateframelayout.StateFrameLayout;

/**
 * @author ling_cx
 */
public class MainActivity extends AppCompatActivity {
	private StateFrameLayout mStateFrameLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mStateFrameLayout = (StateFrameLayout) findViewById(R.id.stateframe);

	}

	private View.OnClickListener clickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this, "click!", Toast.LENGTH_SHORT).show();
		}
	};

	public void content(View view) {
		mStateFrameLayout.showState(new StateAttr.Builder()
				.setState(StateAttr.State.datas)
				.build());
	}

	public void loading(View view) {
		mStateFrameLayout.showState(new StateAttr.Builder()
				.setState(StateAttr.State.loading)
				.setMessage("正在加载")
				.setProgressColor(R.color.stfmessageColor)
				.build()
		);
	}

	public void empty(View view) {
		mStateFrameLayout.showState(new StateAttr.Builder()
				.setState(StateAttr.State.empty)
				.setShowImage(true)
				.setMessage("暂无数据")
				.setMessageSize(16)
				.build()
		);
	}

	public void error(View view) {
		mStateFrameLayout.showState(
				new StateAttr.Builder()
						.setState(StateAttr.State.error)
						.setShowImage(true)
						.setMessage("未知异常")
						.setImageClickListener(clickListener)
						.build()
		);
	}

	public void offline(View view) {
		mStateFrameLayout.showState(new StateAttr.Builder()
				.setState(StateAttr.State.offline)
				.setShowImage(true)
				.setMessage("网络不可用")
				.build()
		);
	}

}
