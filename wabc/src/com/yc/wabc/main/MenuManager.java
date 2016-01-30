package com.yc.wabc.main;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yc.wabc.pojo.AccessToken;
import com.yc.wabc.pojo.Button;
import com.yc.wabc.pojo.ClickButton;
import com.yc.wabc.pojo.ComplexButton;
import com.yc.wabc.pojo.Menu;
import com.yc.wabc.pojo.ViewButton;
import com.yc.wabc.utils.WeixinUtil;

/**
 * 菜单管理类,用于菜单的创建
 * 
 * @author Administrator
 * 
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	@Test
	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wx8fd1e45f0ffe1389";
		// 第三方用户唯一凭证密钥
		String appSecret = "f27d837b9c4cbf04578530d997302a02";

		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result)
				log.info("菜单创建成功！");
			else
				log.info("菜单创建失败，错误码：" + result);
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		ClickButton btn11 = new ClickButton();
		btn11.setName("天气预报");
		btn11.setType("click");
		btn11.setKey("11");

		ClickButton btn12 = new ClickButton();
		btn12.setName("翻译");
		btn12.setType("click");
		btn12.setKey("12");

		ClickButton btn13 = new ClickButton();
		btn13.setName("周边搜索");
		btn13.setType("click");
		btn13.setKey("13");

		ClickButton btn14 = new ClickButton();
		btn14.setName("历史上的今天");
		btn14.setType("click");
		btn14.setKey("14");

		ClickButton btn15 = new ClickButton();
		btn15.setName("热门电影查询");
		btn15.setType("click");
		btn15.setKey("15");

		ClickButton btn21 = new ClickButton();
		btn21.setName("歌曲点播");
		btn21.setType("click");
		btn21.setKey("21");

		ClickButton btn22 = new ClickButton();
		btn22.setName("经典小游戏");
		btn22.setType("click");
		btn22.setKey("22");

		ClickButton btn23 = new ClickButton();
		btn23.setName("号码归属地查询");
		btn23.setType("click");
		btn23.setKey("23");

		ClickButton btn24 = new ClickButton();
		btn24.setName("人脸识别");
		btn24.setType("click");
		btn24.setKey("24");

		ClickButton btn25 = new ClickButton();
		btn25.setName("智能陪聊");
		btn25.setType("click");
		btn25.setKey("25");

		ClickButton btn31 = new ClickButton();
		btn31.setName("幽默笑话");
		btn31.setType("click");
		btn31.setKey("31");

		ViewButton btn32 = new ViewButton();
		btn32.setName("OAuth授权");
		btn32.setType("view");
		btn32.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8fd1e45f0ffe1389&redirect_uri=http%3A%2F%2F1.wabc.sinaapp.com%2FOAuthServlet.action&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");

		ViewButton btn33 = new ViewButton();
		btn33.setName("进入微社区");
		btn33.setType("view");
		btn33.setUrl("http://mq.wsq.qq.com/259884321?_wv=1&filterType=&source=custom");

		ClickButton btn34 = new ClickButton();
		btn34.setName("关于小编");
		btn34.setType("click");
		btn34.setKey("34");

		ViewButton btn35 = new ViewButton();
		btn35.setName("使用帮助");
		btn35.setType("view");
		btn35.setUrl("http://www.baidu.com/");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("生活助手");
		mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14, btn15 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("休闲驿站");
		mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23, btn24, btn25 });

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("更多");
		mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33, btn34, btn35 });

		/**
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}
}
