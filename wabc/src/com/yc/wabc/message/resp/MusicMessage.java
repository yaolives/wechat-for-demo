package com.yc.wabc.message.resp;

import com.yc.wabc.message.model.Music;

public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
