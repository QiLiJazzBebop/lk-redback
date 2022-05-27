//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package coachingmateanalytics.coachingmate.controller;

import coachingmateanalytics.coachingmate.service.FrontEndService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/activity"})
public class ActivityDataRetrieveController {
    @Autowired
    FrontEndService frontEndService;

    public ActivityDataRetrieveController() {
    }

    @GetMapping({"/getActivityByUsername"})
    @ApiOperation(
            value = "retrieve Data By Username",
            notes = "query all activity data of specific user"
    )
    public ResponseEntity<List<Document>> retrieveActivityByUser(@ApiParam(required = true,type = "String") @RequestParam("username") String username) {
        List<Document> activityByUsername = this.frontEndService.findActivityByUsername(username);
        return ResponseEntity.ok(activityByUsername);
    }

    @GetMapping({"/getActivityByAccessToken"})
    @ApiOperation(
            value = "retrieve Data By Username",
            notes = "query all activity data of specific user"
    )
    public ResponseEntity<List<Document>> retrieveActivityByAccessToken(@ApiParam(required = true,type = "String") @RequestParam("accessToken") String accessToken) {
        List<Document> activityByAccessToken = this.frontEndService.findActivityByAccessToken(accessToken);
        return ResponseEntity.ok(activityByAccessToken);
    }

    @GetMapping({"/getActivityDetailsByAccessToken"})
    @ApiOperation(
            value = "retrieve Data By Username",
            notes = "query all activity data of specific user"
    )
    public ResponseEntity<List<Document>> retrieveActivityDetailsByAccessToken(@ApiParam(required = true,type = "String") @RequestParam("accessToken") String accessToken) {
        List<Document> activityDetailsByAccessToken = this.frontEndService.findActivityDetailsByAccessToken(accessToken);
        return ResponseEntity.ok(activityDetailsByAccessToken);
    }

    @GetMapping({"/getSwimmingActivityByAccessToken"})
    @ApiOperation(
            value = "retrieve Data By Username",
            notes = "query all activity details data of specific user"
    )
    public ResponseEntity<List<Document>> retrieveSwimByAccessToken(@ApiParam(required = true,type = "String") @RequestParam("accessToken") String accessToken) {
        List<Document> activityByAccessToken = this.frontEndService.findActivityByAccessToken(accessToken);
        List<Document> activityDetailsByAccessToken = this.frontEndService.findActivityDetailsByAccessToken(accessToken);
        Iterator var4 = activityByAccessToken.iterator();

        while(var4.hasNext()) {
            Document act1 = (Document)var4.next();
            ArrayList<Object> details = new ArrayList();
            Iterator var7 = activityDetailsByAccessToken.iterator();

            while(var7.hasNext()) {
                Document act2 = (Document)var7.next();
                if (act1.get("activityId").equals(act2.get("activityId"))) {
                    details = (ArrayList)act2.get("samples");
                }
            }

            act1.append("details", details);
        }

        List<Document> returnList = new ArrayList();
        Iterator var11 = activityByAccessToken.iterator();

        while(var11.hasNext()) {
            Document activity = (Document)var11.next();
            String activityName = activity.getString("activityName");
            if (activityName.equals("Swimming ")) {
                ArrayList<Object> details = (ArrayList)activity.get("details");
                Document tmpDocument = (new Document()).append("activityType", "Swimming").append("activityId", 0).append("time", 0).append("distance", 0).append("avgSpeed", 0.0D).append("calories", 0).append("pace", 0.0D).append("details", details);
                tmpDocument.replace("activityId", activity.get("activityId"));
                tmpDocument.replace("time", activity.getInteger("durationInSeconds"));
                tmpDocument.replace("distance", activity.getInteger("distanceInMeters"));
                tmpDocument.replace("avgSpeed", activity.getDouble("averageSpeedInMetersPerSecond"));
                tmpDocument.replace("calories", activity.getInteger("activeKilocalories"));
                tmpDocument.replace("pace", activity.getDouble("averagePaceInMinutesPerKilometer"));
                returnList.add(tmpDocument);
            }
        }

        return ResponseEntity.ok(returnList);
    }

    @GetMapping({"/getCyclingActivityByAccessToken"})
    @ApiOperation(
            value = "retrieve Data By Username",
            notes = "query all activity details data of specific user"
    )
    public ResponseEntity<List<Document>> retrieveBikeByAccessToken(@ApiParam(required = true,type = "String") @RequestParam("accessToken") String accessToken) {
        List<Document> activityByAccessToken = this.frontEndService.findActivityByAccessToken(accessToken);
        List<Document> activityDetailsByAccessToken = this.frontEndService.findActivityDetailsByAccessToken(accessToken);
        Iterator var4 = activityByAccessToken.iterator();

        while(var4.hasNext()) {
            Document act1 = (Document)var4.next();
            ArrayList<Object> details = new ArrayList();
            Iterator var7 = activityDetailsByAccessToken.iterator();

            while(var7.hasNext()) {
                Document act2 = (Document)var7.next();
                if (act1.get("activityId").equals(act2.get("activityId"))) {
                    details = (ArrayList)act2.get("samples");
                }
            }

            act1.append("details", details);
        }

        List<Document> returnList = new ArrayList();
        Iterator var11 = activityByAccessToken.iterator();

        while(var11.hasNext()) {
            Document activity = (Document)var11.next();
            String activityType = activity.getString("activityType");
            if (activityType.equals("CYCLING")) {
                ArrayList<Object> details = (ArrayList)activity.get("details");
                Document tmpDocument = (new Document()).append("activityType", "Cycling").append("activityId", 0).append("time", 0).append("distance", 0).append("avgSpeed", 0.0D).append("calories", 0).append("pace", 0.0D).append("heartRate", 0).append("details", details);
                tmpDocument.replace("activityId", activity.get("activityId"));
                tmpDocument.replace("time", activity.getInteger("durationInSeconds"));
                tmpDocument.replace("distance", activity.getInteger("distanceInMeters"));
                tmpDocument.replace("avgSpeed", activity.getDouble("averageSpeedInMetersPerSecond"));
                tmpDocument.replace("calories", activity.getInteger("activeKilocalories"));
                tmpDocument.replace("pace", activity.getDouble("averagePaceInMinutesPerKilometer"));
                tmpDocument.replace("heartRate", activity.getInteger("averageHeartRateInBeatsPerMinute"));
                returnList.add(tmpDocument);
            }
        }

        return ResponseEntity.ok(returnList);
    }

    @GetMapping({"/getRunningActivityByAccessToken"})
    @ApiOperation(
            value = "retrieve Data By Username",
            notes = "query all activity details data of specific user"
    )
    public ResponseEntity<List<Document>> retrieveRunByAccessToken(@ApiParam(required = true,type = "String") @RequestParam("accessToken") String accessToken) {
        List<Document> activityByAccessToken = this.frontEndService.findActivityByAccessToken(accessToken);
        List<Document> activityDetailsByAccessToken = this.frontEndService.findActivityDetailsByAccessToken(accessToken);
        Iterator var4 = activityByAccessToken.iterator();

        while(var4.hasNext()) {
            Document act1 = (Document)var4.next();
            ArrayList<Object> details = new ArrayList();
            Iterator var7 = activityDetailsByAccessToken.iterator();

            while(var7.hasNext()) {
                Document act2 = (Document)var7.next();
                if (act1.get("activityId").equals(act2.get("activityId"))) {
                    details = (ArrayList)act2.get("samples");
                }
            }

            act1.append("details", details);
        }

        List<Document> returnList = new ArrayList();
        Iterator var18 = activityByAccessToken.iterator();

        while(var18.hasNext()) {
            Document activity = (Document)var18.next();
            String activityName = activity.getString("activityName");
            if (activityName.equals("Running")) {
                ArrayList<Object> details = (ArrayList)activity.get("details");
                Document tmpDocument = (new Document()).append("activityType", "Running").append("activityId", 0).append("time", 0).append("distance", 0).append("avgSpeed", 0.0D).append("calories", 0).append("pace", 0.0D).append("avgCadence", 0).append("heartRate", 0).append("details", details);
                tmpDocument.replace("activityId", activity.get("activityId"));
                tmpDocument.replace("time", activity.getInteger("durationInSeconds"));

                try {
                    tmpDocument.replace("distance", activity.getInteger("distanceInMeters"));
                } catch (Exception var16) {
                    tmpDocument.replace("distance", 0);
                }

                try {
                    tmpDocument.replace("avgSpeed", activity.getDouble("averageSpeedInMetersPerSecond"));
                } catch (Exception var15) {
                    tmpDocument.replace("avgSpeed", 0.0D);
                }

                try {
                    tmpDocument.replace("calories", activity.getInteger("activeKilocalories"));
                } catch (Exception var14) {
                    tmpDocument.replace("calories", 0);
                }

                try {
                    tmpDocument.replace("pace", activity.getDouble("averagePaceInMinutesPerKilometer"));
                } catch (Exception var13) {
                    tmpDocument.replace("pace", 0.0D);
                }

                try {
                    tmpDocument.replace("avgCadence", activity.getInteger("averageRunCadenceInStepsPerMinute"));
                } catch (Exception var12) {
                    tmpDocument.replace("avgCadence", 0);
                }

                try {
                    tmpDocument.replace("heartRate", activity.getInteger("averageHeartRateInBeatsPerMinute"));
                } catch (Exception var11) {
                    tmpDocument.replace("heartRate", 0);
                }

                returnList.add(tmpDocument);
            }
        }

        return ResponseEntity.ok(returnList);
    }

    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.get(1) == calendar2.get(1) && calendar1.get(2) == calendar2.get(2) && calendar1.get(5) == calendar2.get(5);
    }

    public static Document generateEpochDoc(Date dateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = formatter.format(dateTime);
        Document dateUnit = (new Document()).append("date", strDate).append("calories", 0).append("distance", 0.0D);
        return dateUnit;
    }

    @GetMapping({"/getEpochTimeLineByAccessToken"})
    @ApiOperation(
            value = "retrieve Data By Username",
            notes = "query all activity data of specific user"
    )
    public ResponseEntity<List<Document>> retrieveEpochTimeLineByAccessToken(@ApiParam(required = true,type = "String") @RequestParam("accessToken") String accessToken) {
        List<Document> epochByAccessToken = this.frontEndService.findEpochByAccessToken(accessToken);
        Collections.sort(epochByAccessToken, (f1, f2) -> {
            return f2.getInteger("startTimeInSeconds").compareTo(f1.getInteger("startTimeInSeconds"));
        });
        List<Document> returnList = new ArrayList();
        Date latestTime = new Date((long)((Document)epochByAccessToken.get(0)).getInteger("startTimeInSeconds") * 1000L);
        Document latestDoc = generateEpochDoc(latestTime);
        Iterator var6 = epochByAccessToken.iterator();

        while(var6.hasNext()) {
            Document epoch = (Document)var6.next();
            Date docDate = new Date((long)epoch.getInteger("startTimeInSeconds") * 1000L);
            if (!isSameDay(docDate, latestTime)) {
                returnList.add(latestDoc);
                latestDoc = generateEpochDoc(latestTime);
                latestTime = new Date((long)epoch.getInteger("startTimeInSeconds") * 1000L);
            }

            latestDoc.replace("calories", epoch.getInteger("activeKilocalories") + latestDoc.getInteger("calories"));

            try {
                latestDoc.replace("distance", epoch.getDouble("distanceInMeters") + latestDoc.getDouble("distance"));
            } catch (Exception var10) {
                latestDoc.replace("distance", Double.valueOf((double)epoch.getInteger("distanceInMeters")) + latestDoc.getDouble("distance"));
            }
        }

        return ResponseEntity.ok(returnList);
    }

    @GetMapping({"/getEpochByAccessToken"})
    @ApiOperation(
            value = "retrieve Data By Username",
            notes = "query all activity data of specific user"
    )
    public ResponseEntity<List<Document>> retrieveEpochByAccessToken(@ApiParam(required = true,type = "String") @RequestParam("accessToken") String accessToken) {
        List<Document> epochByAccessToken = this.frontEndService.findEpochByAccessToken(accessToken);
        return ResponseEntity.ok(epochByAccessToken);
    }
}
