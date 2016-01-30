package com.yc.wabc.message.resp;

import com.yc.wabc.message.model.Voice;

/**
 * 语音消息
 * 
 * @author Administrator
 * 
 */
public class VoiceMessage extends BaseMessage {
	// 语音
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

}
