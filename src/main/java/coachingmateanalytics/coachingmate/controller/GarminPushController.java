package coachingmateanalytics.coachingmate.controller;

import coachingmateanalytics.coachingmate.entity.Statistic;
import coachingmateanalytics.coachingmate.service.ActivityService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import hirondelle.date4j.DateTime;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.studioblueplanet.fitreader.FitReader;
import net.studioblueplanet.fitreader.FitRecord;
import net.studioblueplanet.fitreader.FitRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@RestController
public class GarminPushController {
    private static final Logger logger = LoggerFactory.getLogger(GarminPushController.class);
    public static final String STORE_PATH="D:/coachingmate/public/garmin_raw/";

    @Autowired
    ActivityService activityService;
    

    //configure this url to end point configuration, and the garmin endpoint will transfer the data to this server
    @PostMapping("/activity")
    public ResponseEntity<String> acceptPushedFile1(@ApiParam(type = "String") String info) {
        logger.debug("start push data");
        logger.info("info :" + info);
        HttpHeaders httpHeaders = new HttpHeaders();

//            byte[] data = IOUtils.toByteArray(file.getInputStream());
//            String dataHead = new String(data, 0, 47182);
//            logger.info("Activity Data" + dataHead);
//            Activity activity = new Activity("3f3d5af3-7847-413e-a9fe-47aeffb6de44", info);
//            activityService.saveActivity(activity);
        System.out.println(info);
        return null;
    }
}
