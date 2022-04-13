package coachingmateanalytics.coachingmate.service;

import org.json.JSONObject;

import java.util.List;

/**
 * @Date: 24/9/20 16:03
 * @Description:
 */
public interface ActivityService {
    void saveActivity(JSONObject activity);
    List<JSONObject> findAllByUsername(String username);
    List<JSONObject> findAllByAccessToken(String accessToken);
}
