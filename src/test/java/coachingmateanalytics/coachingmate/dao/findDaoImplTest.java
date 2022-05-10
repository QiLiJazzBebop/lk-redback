package coachingmateanalytics.coachingmate.dao;

import coachingmateanalytics.coachingmate.AppTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Date: 24/9/20 12:04
 * @Description:
 */
public class findDaoImplTest extends AppTest {
    private static final Logger logger = LoggerFactory.getLogger(findDaoImplTest.class);

    @Autowired
    private RetrieveFromDatabaseDao retrieveFromDatabaseDao;

    @Test
    public void saveActivity() {
//        Statistic activity = new Activity("3f3d5af3-7847-413e-a9fe-47aeffb6de44", "testData2");
//        activityDao.saveMongodb(activity);
    }

    @Test
    public void findAllByAccessToken() {
//        List<Activity> allByAccessToken = activityDao.findByAccessToken("3f3d5af3-7847-413e-a9fe-47aeffb6de44");
//        int i = 1;
//        for (Activity activity : allByAccessToken) {
//            logger.info(activity.getAccessToken() + i + " : " + activity.getData());
//        }

//        logger.info("total count : " + allByAccessToken.size());
    }
}