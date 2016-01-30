package com.yc.wabc.event;

/**
 * 自定义菜单事件
 * 
 * @author Administrator
 * 
 */
public class MenuEvent extends BaseEvent {
	// 事件key值，与自定义菜单接口中的key值对应
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
