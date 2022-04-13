package coachingmateanalytics.coachingmate.dao;

import coachingmateanalytics.coachingmate.entity.Statistic;
import org.json.JSONObject;

import java.util.List;

/**
 * @Date: 24/9/20 10:14
 * @Description:
 */
public interface ActivityDao {
    void saveActivity(JSONObject activity);
    List<JSONObject> findAllByAccessToken(String accessToken);
}
