package cn.fjlcx.android.stateframelayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/10/9
 */

public class StateFrameLayout extends LinearLayout{
	private static final String MSG_ONE_CHILD = "StatefulLayout must have one and only one child!";
	private View content;
	private LinearLayout stContainer;
	private ProgressBar stProgress;
	private ImageView stImage;
	private TextView stMessage;
	private Button stButton;

	public StateFrameLayout(@NonNull Context context) {
		super(context);
	}

	public StateFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		if (getChildCount() > 1) {
			throw new IllegalStateException(MSG_ONE_CHILD);
		}
		if (isInEditMode()) {return;}
		setOrientation(VERTICAL);
		content = getChildAt(0);
		LayoutInflater.from(getContext()).inflate(R.layout.state_template, this, true);
		stContainer = (LinearLayout) findViewById(R.id.stContainer);
		stProgress = (ProgressBar) findViewById(R.id.stProgress);
		stImage = (ImageView) findViewById(R.id.stImage);
		stMessage = (TextView) findViewById(R.id.stMessage);
		stButton = (Button) findViewById(R.id.stButton);
	}

	public void showState(StateAttr option){
		if(option.getState() == StateAttr.State.datas){
			content.setVisibility(VISIBLE);
			stContainer.setVisibility(GONE);
		}else{
			content.setVisibility(GONE);
			stContainer.setVisibility(VISIBLE);
			stButton.setVisibility(GONE);

			if(!TextUtils.isEmpty(option.getMessage())){
				stMessage.setText(option.getMessage());
				stMessage.setTextColor(getContext().getResources().getColor(option.getMessageColor()));
				stMessage.setTextSize(option.getMessageSize());
			}else{
				stMessage.setVisibility(GONE);
			}

			if(option.getState() == StateAttr.State.loading){
				stImage.setVisibility(GONE);
				stProgress.setVisibility(VISIBLE);
				stButton.setVisibility(GONE);
			}else{
				stProgress.setVisibility(GONE);

				if(option.isShowImage()){
					stImage.setVisibility(VISIBLE);
					if(option.getImageRes() == 0){
						if(option.getState() == StateAttr.State.empty){
							option.setImageRes(R.drawable.ic_empty);
						}else if(option.getState() == StateAttr.State.error){
							option.setImageRes(R.drawable.ic_error);
						}else if(option.getState() == StateAttr.State.offline){
							option.setImageRes(R.drawable.ic_net_error);
						}
					}
					stImage.setImageResource(option.getImageRes());
					stImage.setClickable(true);
					stImage.setOnClickListener(option.getImageClickListener());
				}else{
					stImage.setVisibility(GONE);
				}
			}
		}
	}
}
