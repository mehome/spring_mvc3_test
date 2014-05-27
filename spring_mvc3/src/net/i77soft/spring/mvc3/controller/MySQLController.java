/**
 * 
 */
package net.i77soft.spring.mvc3.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.i77soft.dbutils.QueryHelper;
import net.i77soft.spring.mvc3.model.Client;
import net.i77soft.spring.mvc3.model.GameServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shines77
 *
 */

@Controller
@RequestMapping(value = "/mysql")
public class MySQLController {

	private final static int query_mode = 1;

	@RequestMapping("/db_test")
	@SuppressWarnings("unused")
	public ModelAndView db_test(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("mysql/db_test");
		StaticController.addGlobalObjects(mv, request);
		mv.addObject("hello", "Hello World!");    	// model中增加一个名为hello的字符串

		Client client = new Client();
		client.setName("User");
		mv.addObject("client", client);    			// 再增加一个名为client的自定义对象

		GameServer gameServer = null;
		if (query_mode == 1) {
			gameServer = QueryHelper.read(GameServer.class, "select * from gameserver where id = 1");
		}
		else if (query_mode == 2 || query_mode == 3) {
			Object[] result = null;
			if (query_mode == 2) {
				result = QueryHelper.selectOne("select * from gameserver");
				gameServer = new GameServer();
			}
			else {
				/* query_mode == 3 */
				List<Object[]> resultList = QueryHelper.select("select * from gameserver");
				result = resultList.get(0);
				gameServer = new GameServer();
			}
			if (result != null) {
				gameServer.setId((Long)(result[0]));
				gameServer.setRegionId((Integer)result[1]);
				gameServer.setRegionName((String)result[2]);
				gameServer.setAreaId((Integer)result[3]);
				gameServer.setAreaName((String)result[4]);
				gameServer.setAreaNameFull((String)result[5]);
			}
		}
		else {
			Map<String, Object> result = null;
			if (query_mode == 4) {
				result = QueryHelper.selectOne_map("select * from gameserver");
				gameServer = new GameServer();
			}
			else {
				/* query_mode == 5 */
				List<Map<String, Object>> resultList = QueryHelper.select_map("select * from gameserver");
				result = resultList.get(0);
				gameServer = new GameServer();
			}
			if (result != null) {
				gameServer.setId((Long)(result.get("id")));
				gameServer.setRegionId((Integer)result.get("regionId"));
				gameServer.setRegionName((String)result.get("regionName"));
				gameServer.setAreaId((Integer)result.get("areaId"));
				gameServer.setAreaName((String)result.get("areaName"));
				gameServer.setAreaNameFull((String)result.get("areaNameFull"));
			}
		}
		mv.addObject("gameserver", gameServer);

		return mv;
	}

}
