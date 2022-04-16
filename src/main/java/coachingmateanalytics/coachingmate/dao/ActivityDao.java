package coachingmateanalytics.coachingmate.dao;

import org.bson.Document;
import org.json.JSONObject;

import java.util.List;

/**
 * @Date: 24/9/20 10:14
 * @Description:
 */
public interface ActivityDao {
    void saveActivity(JSONObject activity, String savePosition);

    List<Document> findByAccessToken(String accessToken, String savePosition);
}
