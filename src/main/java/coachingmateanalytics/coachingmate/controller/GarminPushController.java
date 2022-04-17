package coachingmateanalytics.coachingmate.controller;

import coachingmateanalytics.coachingmate.service.ActivityService;


import coachingmateanalytics.coachingmate.utils.Consts;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GarminPushController {
    private static final Logger logger = LoggerFactory.getLogger(GarminPushController.class);
    public static final String STORE_PATH="D:/coachingmate/public/garmin_raw/";

    @Autowired
    ActivityService activityService;
//
////    configure this url to end point configuration, and the garmin endpoint will transfer the data to this server
//    @PostMapping("/push")
//    @ApiOperation(value = "push data url", notes = "configure this url to end point configuration, " +
//            "and the garmin endpoint will transfer the data to this server")
//    public ResponseEntity<String> acceptPushedFile1(@ApiParam(type = "MultipartFile") MultipartFile file, @ApiParam(type = "String") String uploadMetaData) {
//        logger.debug("start push data");
//        logger.info("uploadMetaData :" + uploadMetaData);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        try {
////            byte[] data = IOUtils.toByteArray(file.getInputStream());
////            String dataHead = new String(data, 0, 47182);
////            logger.info("Activity Data" + dataHead);
////            Activity activity = new Activity("3f3d5af3-7847-413e-a9fe-47aeffb6de44", uploadMetaData);
////            activityService.saveActivity(activity);
//            JSONObject jsonObject = JSON.parseObject(uploadMetaData);
//            String access_token = jsonObject.getString("oauthToken");
//            FitRecordRepository repository;
//            FitReader reader;
//            FitRecord record;
//            reader = FitReader.getInstance();
//            repository = reader.readInputStream(file.getInputStream());
//            record = repository.getFitRecord("session");
//            //----new added----//
//            int statistic_id = record.getIntValue(0, "statistic_id");
//            int user_id = record.getIntValue(0, "user_id");
//            int serial_number = record.getIntValue(0, "serial_number");
//            int session_id = record.getIntValue(0, "session_id");
//
//            int sport  = record.getIntValue(0, "sport");
//            DateTime start_time = record.getTimeValue(0, "start_time");
//
//            //----new added----//
//            // user_profile
//            int gender = record.getIntValue(0, "gender");
//            int age = record.getIntValue(0, "age");
//            int height = record.getIntValue(0, "height");
//            int weight = record.getIntValue(0, "weight");
//
//            // activity//
//            int type = record.getIntValue(0, "type");
//
//            // session //
//            DateTime timestamp = record.getTimeValue(0, "timestamp");
//            int avg_heart_rate = record.getIntValue(0, "avg_heart_rate");
//            int max_heart_rate = record.getIntValue(0, "max_heart_rate");
//            double swim_stroke = record.getIntValue(0, "swim_stroke");
//            double avg_stance_time_percent =record.getDistanceValue(0, "avg_stance_time_percent");
//
//            //----new added----//
//            double start_position_lat = record.getLatLonValue(0, "start_position_lat");
//            double start_position_long = record.getLatLonValue(0, "start_position_long");
//            double total_elapsed_time = record.getElapsedTimeValue(0, "total_elapsed_time");
//            double total_distance = record.getDistanceValue(0, "total_distance");
//            double total_cycles = record.getDistanceValue(0, "total_cycles");
//            double avg_stroke_count = record.getIntValue(0, "avg_stroke_count");
//            double avg_stroke_distance = record.getDistanceValue(0, "avg_stroke_distance");
//            double total_calories = record.getDistanceValue(0, "total_calories");
//            double avg_speed = record.getSpeedValue(0, "avg_speed");
//            double max_speed = record.getSpeedValue(0, "max_speed");
//            double avg_power = record.getDistanceValue(0, "avg_power");
//            double max_power = record.getDistanceValue(0, "max_power");
//            double total_ascent = record.getDistanceValue(0, "total_ascent");
//            double total_descent = record.getDistanceValue(0, "total_descent");
//            int num_laps = record.getIntValue(0, "num_laps");
//            double training_stress_score = record.getDistanceValue(0, "training_stress_score");
//            double intensity_factor = record.getDistanceValue(0, "intensity_factor");
//            double pool_length = record.getDistanceValue(0, "pool_length");
//            int threshold_power = record.getIntValue(0, "threshold_power");
//            int avg_cadence = record.getIntValue(0, "avg_cadence");
//            int max_cadence = record.getIntValue(0, "max_cadence");
//            double total_fat_calories = record.getDistanceValue(0, "total_fat_calories");
//            int normalized_power = record.getIntValue(0, "normalized_power");
//            int num_active_lengths = record.getIntValue(0, "num_active_lengths");
//            int sub_sport = record.getIntValue(0, "sub_sport");
//
//
//            Statistic statistic = new Statistic(access_token, statistic_id, user_id, sport, start_time.toString(),
//                                                start_position_lat, start_position_long, total_elapsed_time, total_distance, total_cycles,
//                                                avg_stroke_count , avg_stroke_distance, total_calories, avg_speed, max_speed,
//                                                avg_power, max_power, total_ascent, total_descent, num_laps,
//                                                training_stress_score, intensity_factor, pool_length, threshold_power, avg_cadence,
//                                                max_cadence, total_fat_calories, normalized_power, num_active_lengths, sub_sport,
//                                                //----new added---- //
//                                                gender, age, height, weight, type, timestamp.toString(), avg_heart_rate, max_heart_rate, swim_stroke,
//                                                avg_stance_time_percent, serial_number, session_id);
//            logger.info("finishing parse data ");
//            activityService.saveActivity(statistic);
//        } catch (Exception e) {
//            httpHeaders.set("Retry-After", "120");
//            return ResponseEntity.status(503).headers(httpHeaders).body("Failed to process. Reason : " + e.getMessage());
//        }
//        httpHeaders.set("Location", "public/garmin_raw");
//        return ResponseEntity.accepted().headers(httpHeaders).body("Accept the pushed file");
//    }

    @PostMapping("/activities")
    @ApiOperation(value = "push2 data url", notes = "configure2 this url to end point configuration, " +
            "and the garmin endpoint will transfer the data to this server")
    public ResponseEntity<String> activityReceiverFromGarmin(@RequestBody String info){
        logger.info("start push activity Receiver From Garmin data");
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            JSONObject obj = new JSONObject(info);
            JSONArray array = obj.getJSONArray("activities");
            for (int i = 0; i < array.length(); i++) {
                JSONObject activity = array.getJSONObject(i);
                activityService.saveActivity(activity);
            }
        }
        catch (Exception e){
            httpHeaders.set("Get json fault", "120");
            return ResponseEntity.status(503).headers(httpHeaders).body("Failed to process. Reason : " + e.getMessage());
        }
        httpHeaders.set("Location", "public/garmin_raw");
        return ResponseEntity.accepted().headers(httpHeaders).body("Accept the pushed file");
    }

//    @PostMapping("/push")
//    @ApiOperation(value = "push data url", notes = "configure this url to end point configuration, " +
//            "and the garmin endpoint will transfer the data to this server")
//    public ResponseEntity<String> fileReceiverFromGarmin(@ApiParam(type = "MultipartFile") MultipartFile file, @ApiParam(type = "String") String uploadMetaData) {
//        logger.info(String.valueOf(file.getClass()));
//        return null;
//    }

    @PostMapping("/activityDetails")
    @ApiOperation(value = "push data url", notes = "configure this url to end point configuration, " +
            "and the garmin endpoint will transfer the data to this server")
    public ResponseEntity<String> activityDetailsReceiverFromGarmin(@RequestBody String info) {
        logger.info("start push activity details Receiver From Garmin data");
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            JSONObject obj = new JSONObject(info);
            JSONArray array = obj.getJSONArray("activityDetails");
            for (int i = 0; i < array.length(); i++) {
                JSONObject activityDetail = array.getJSONObject(i);
                activityService.saveActivityDetails(activityDetail);
            }
        }
        catch (Exception e){
            httpHeaders.set("Get json fault", "120");
            return ResponseEntity.status(503).headers(httpHeaders).body("Failed to process. Reason : " + e.getMessage());
        }
        httpHeaders.set("Location", "public/garmin_raw");
        return ResponseEntity.accepted().headers(httpHeaders).body("Accept the pushed file");
    }
}
