package apiConfig;

import java.util.HashMap;
import java.util.Map;

public class QueryParams {

	//query params
	public Map<String, String> defaultqueryParams(){
		Map<String, String> queryparam = new HashMap<String, String>();
		queryparam.put("dist-max", "10LD");
		queryparam.put("sort", "dist");
		queryparam.put("body", "ALL");

		return queryparam;

	}

	//query params
	public Map<String, String> queryParamsdate(){
		Map<String, String> queryparam = new HashMap<String, String>();
		queryparam.put("dist-max", "10LD");
		queryparam.put("sort", "dist");
		queryparam.put("date-min", "2018-01-01");

		return queryparam;

	}

}
//queryparam.put("dist_min_GET_ASTERIODS", "10LD");
//queryparam.put("date_min_GET_ASTERIODS", "2020-01-01");
//queryparam.put("date_max_GET_ASTERIODS", "2020-02-02");