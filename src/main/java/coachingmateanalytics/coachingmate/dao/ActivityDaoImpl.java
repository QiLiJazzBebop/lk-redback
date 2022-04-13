package coachingmateanalytics.coachingmate.dao;

import coachingmateanalytics.coachingmate.entity.Statistic;
import coachingmateanalytics.coachingmate.utils.Consts;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Date: 24/9/20 10:16
 * @Description:
 */
@Component
public class ActivityDaoImpl implements ActivityDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveActivity(JSONObject activity) {
        mongoTemplate.save(activity, Consts.MONGODB_ACTIVITY_COLLECTIN_NAME);
    }
    @Override
    public List<JSONObject> findAllByAccessToken(String accessToken) {
        Query query = Query.query(Criteria.where("access_token").is(accessToken));
        List<JSONObject> Activities = mongoTemplate.find(query, JSONObject.class,Consts.MONGODB_ACTIVITY_COLLECTIN_NAME);
        return Activities;
    }


}
