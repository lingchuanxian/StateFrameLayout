package cn.fjlcx.android.stateframelayout;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.view.View;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/10/26
 */

public class StateAttr {
	public enum State {
		datas,loading,empty,offline,error;
	}
	private State state;
	@DrawableRes
	private int imageRes;
	private boolean showImage = false;
	private String message;
	@ColorRes
	private int messageColor = R.color.stfmessageColor;
	private int messageSize = 14;
	private View.OnClickListener imageClickListener;
	@ColorRes
	private int progressColor;

	public StateAttr() {
		super();
	}

	public StateAttr(Builder builder) {
		this.state = builder.state;
		this.imageRes = builder.imageRes;
		this.showImage = builder.showImage;
		this.message = builder.message;
		this.messageColor = builder.messageColor;
		this.messageSize = builder.messageSize;
		this.imageClickListener = builder.imageClickListener;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getImageRes() {
		return imageRes;
	}

	public void setImageRes(int imageRes) {
		this.imageRes = imageRes;
	}

	public boolean isShowImage() {
		return showImage;
	}

	public void setShowImage(boolean showImage) {
		this.showImage = showImage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getMessageColor() {
		return messageColor;
	}

	public void setMessageColor(int messageColor) {
		this.messageColor = messageColor;
	}

	public int getMessageSize() {
		return messageSize;
	}

	public void setMessageSize(int messageSize) {
		this.messageSize = messageSize;
	}

	public View.OnClickListener getImageClickListener() {
		return imageClickListener;
	}

	public void setImageClickListener(View.OnClickListener imageClickListener) {
		this.imageClickListener = imageClickListener;
	}

	public int getProgressColor() {
		return progressColor;
	}

	public void setProgressColor(int progressColor) {
		this.progressColor = progressColor;
	}

	public static class Builder{
		public State state;
		@DrawableRes
		public int imageRes;
		public boolean showImage = false;
		public String message;
		@ColorRes
		public int messageColor = R.color.stfmessageColor;
		public int messageSize = 14;
		public View.OnClickListener imageClickListener;
		@ColorRes
		private int progressColor;

		public Builder setState(State val) {
			this.state = val;
			return this;
		}

		public Builder setImageRes(@DrawableRes int val) {
			this.imageRes = val;
			return this;
		}

		public Builder setShowImage(boolean val) {
			this.showImage = val;
			return this;
		}

		public Builder setMessage(String val) {
			this.message = val;
			return this;
		}

		public Builder setMessageColor(@ColorRes int val) {
			this.messageColor = val;
			return this;
		}

		public Builder setMessageSize(int val) {
			this.messageSize = val;
			return this;
		}

		public Builder setImageClickListener(View.OnClickListener val) {
			this.imageClickListener = val;
			return this;
		}

		public Builder setProgressColor(int progressColor) {
			this.progressColor = progressColor;
			return this;
		}

		public StateAttr build(){
			StateAttr stateAttr = new StateAttr(this);
			return stateAttr;
		}
	}
}
