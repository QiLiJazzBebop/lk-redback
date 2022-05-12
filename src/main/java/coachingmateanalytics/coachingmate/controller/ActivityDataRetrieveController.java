package coachingmateanalytics.coachingmate.controller;

import coachingmateanalytics.coachingmate.service.FrontEndService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.Doc;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Date: 23/4/22 16:06
 * @Description:
 * There are changes from original version
 * adjust the @GetMapping to new path
 * retrieve all the athlete data as List<Document> format
 */
@Controller
@RequestMapping("/activity")
//@CrossOrigin("http://localhost:3000")
public class ActivityDataRetrieveController {
    @Autowired
    FrontEndService frontEndService;

    @GetMapping("/getActivityByUsername")
    @ApiOperation(value = "retrieve Data By Username", notes = "query all activity data of specific user")
    public ResponseEntity<List<Document>> retrieveActivityByUser(@ApiParam(required = true, type = "String") @RequestParam("username") String username){
        List<Document> activityByUsername = frontEndService.findActivityByUsername(username);
        return ResponseEntity.ok(activityByUsername);
    }

    @GetMapping("/getActivityByAccessToken")
    @ApiOperation(value = "retrieve Data By Username", notes = "query all activity data of specific user")
    public ResponseEntity<List<Document>> retrieveActivityByAccessToken(@ApiParam(required = true, type = "String") @RequestParam("accessToken") String accessToken){
        List<Document> activityByAccessToken = frontEndService.findActivityByAccessToken(accessToken);
        return ResponseEntity.ok(activityByAccessToken);
    }

    @GetMapping("/getSwimActivityByAccessToken")
    @ApiOperation(value = "retrieve Data By Username", notes = "query all activity details data of specific user")
    public ResponseEntity<List<Document>> retrieveSwimByAccessToken(@ApiParam(required = true, type = "String") @RequestParam("accessToken") String accessToken) {

        List<Document> activityDetailsByAccessToken = frontEndService.findActivityByAccessToken(accessToken);
//        for (Document epoch : activityDetailsByAccessToken){
//            String activityType = epoch.getString("activityType");
//            if activityType == ""
//
//        }
        return ResponseEntity.ok(activityDetailsByAccessToken);
    }

    /* From this part, provide data to front end
       1) epoch data, json format:
       [{‘date’: 2022-05-12, ‘calories’:120, ‘steps’:1000}, {‘date’: 2022-05-13, ‘calories’:150, ‘steps’:1300}]
     */

    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
    }

    public static Document generateEpochDoc(Date dateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = formatter.format(dateTime);

        Document dateUnit = new Document()
                .append("date", strDate)
                .append("calories", 0)
                .append("distance", 0.0);
        return dateUnit;
    }

    @GetMapping("/getEpochTimeLineByAccessToken")
    @ApiOperation(value = "retrieve Data By Username", notes = "query all activity data of specific user")
    public ResponseEntity<List<Document>> retrieveEpochTimeLineByAccessToken(@ApiParam(required = true, type = "String") @RequestParam("accessToken") String accessToken){
        // reference
        // java.util.Date time=new Date((long)timeStamp*1000);
        // const yesterday = new Date(today)
        // yesterday.setDate(yesterday.getDate() - 1)

        List<Document> epochByAccessToken = frontEndService.findEpochByAccessToken(accessToken);
        // sort the epoch by datetime
        Collections.sort(epochByAccessToken, (f1, f2)->{return f2.getInteger("startTimeInSeconds").compareTo(f1.getInteger("startTimeInSeconds"));});
        //Initialize the result list
        List<Document> returnList = new ArrayList<>();
        // generate result format
        Date latestTime = new Date(((long) epochByAccessToken.get(0).getInteger("startTimeInSeconds"))*1000);
        Document latestDoc = generateEpochDoc(latestTime);
        for (Document epoch : epochByAccessToken){
            Date docDate = new Date(((long) epoch.getInteger("startTimeInSeconds"))*1000);
            // add doc if not in same day
            if (!isSameDay(docDate, latestTime)){
                returnList.add(latestDoc);
                // re-initialized
                latestDoc = generateEpochDoc(latestTime);
                latestTime = new Date(((long) epoch.getInteger("startTimeInSeconds"))*1000);
            }
            //update value of doc
            latestDoc.replace("calories", epoch.getInteger("activeKilocalories") + latestDoc.getInteger("calories"));
            try {
                latestDoc.replace("distance", epoch.getDouble("distanceInMeters") + latestDoc.getDouble("distance"));
            } catch (Exception e){
                latestDoc.replace("distance", (Double.valueOf(epoch.getInteger("distanceInMeters")) + latestDoc.getDouble("distance")));
            }
        }
        return ResponseEntity.ok(returnList);
    }


    @GetMapping("/getEpochByAccessToken")
    @ApiOperation(value = "retrieve Data By Username", notes = "query all activity data of specific user")
    public ResponseEntity<List<Document>> retrieveEpochByAccessToken(@ApiParam(required = true, type = "String") @RequestParam("accessToken") String accessToken) {

        List<Document> epochByAccessToken = frontEndService.findEpochByAccessToken(accessToken);
        return ResponseEntity.ok(epochByAccessToken);
    }

}
