package coachingmateanalytics.coachingmate;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AppTest {

    @Test
    public void testApp() throws JSONException {

        // test upcoming string to json object
        System.out.println("hello world");
        JSONObject obj = new JSONObject("{\"activities\":[{\"durationInSeconds\":15,\"activeKilocalories\":1,\"averageSpeedInMetersPerSecond\":0.37,\"averageHeartRateInBeatsPerMinute\":99,\"distanceInMeters\":5.62,\"activityName\":\"Running\",\"userId\":\"5073e79f-df60-45dc-92f2-bc0ef300f1f0\",\"deviceName\":\"forerunner935\",\"steps\":8,\"averageRunCadenceInStepsPerMinute\":25.828125,\"averagePaceInMinutesPerKilometer\":45.045044,\"activityId\":8623463169,\"startTimeInSeconds\":1649748853,\"userAccessToken\":\"227a7c55-590d-498f-97ad-fb6ba3cb259f\",\"startTimeOffsetInSeconds\":36000,\"maxPaceInMinutesPerKilometer\":8.888888,\"maxHeartRateInBeatsPerMinute\":107,\"summaryId\":\"8623463169\",\"maxRunCadenceInStepsPerMinute\":156.0,\"maxSpeedInMetersPerSecond\":1.875,\"activityType\":\"RUNNING\"}]}");
        JSONObject obj2 = new JSONObject("{\"activityDetails\":[{\"userId\":\"5073e79f-df60-45dc-92f2-bc0ef300f1f0\",\"userAccessToken\":\"227a7c55-590d-498f-97ad-fb6ba3cb259f\",\"summaryId\":\"8654619722-detail\",\"activityId\":8654619722,\"summary\":{\"activityId\":8654619722,\"activityName\":\"Running\",\"durationInSeconds\":12,\"startTimeInSeconds\":1650193374,\"startTimeOffsetInSeconds\":36000,\"activityType\":\"RUNNING\",\"averageHeartRateInBeatsPerMinute\":87,\"deviceName\":\"forerunner935\",\"maxHeartRateInBeatsPerMinute\":92},\"samples\":[{\"startTimeInSeconds\":1650193374,\"elevationInMeters\":37.79999923706055,\"airTemperatureCelcius\":33.0,\"heartRate\":86,\"speedMetersPerSecond\":0.0,\"stepsPerMinute\":0.0,\"totalDistanceInMeters\":0.0,\"timerDurationInSeconds\":0,\"clockDurationInSeconds\":0,\"movingDurationInSeconds\":0},{\"startTimeInSeconds\":1650193375,\"elevationInMeters\":37.79999923706055,\"airTemperatureCelcius\":33.0,\"heartRate\":86,\"speedMetersPerSecond\":0.0,\"stepsPerMinute\":0.0,\"totalDistanceInMeters\":0.0,\"timerDurationInSeconds\":1,\"clockDurationInSeconds\":1,\"movingDurationInSeconds\":0},{\"startTimeInSeconds\":1650193384,\"elevationInMeters\":36.79999923706055,\"airTemperatureCelcius\":33.0,\"heartRate\":90,\"speedMetersPerSecond\":0.0,\"stepsPerMinute\":0.0,\"totalDistanceInMeters\":0.0,\"timerDurationInSeconds\":10,\"clockDurationInSeconds\":10,\"movingDurationInSeconds\":0},{\"startTimeInSeconds\":1650193385,\"elevationInMeters\":37.0,\"airTemperatureCelcius\":33.0,\"heartRate\":92,\"speedMetersPerSecond\":0.0,\"stepsPerMinute\":0.0,\"totalDistanceInMeters\":0.0,\"timerDurationInSeconds\":11,\"clockDurationInSeconds\":11,\"movingDurationInSeconds\":0}],\"laps\":[{\"startTimeInSeconds\":1650193374}]}]}");
        JSONArray array = obj.getJSONArray("activities");
        JSONArray array2 = new JSONArray("[{\"summaryId\":\"x42f72c9-612e11dae53d462a-0b98-4ae8-9fdc28f392a1cd8078\",\"calendarDate\":\"2021-08-31\",\"startTimeInSeconds\":1630409178,\"durationInSeconds\":120,\"offsetStartTimeInSeconds\":7200,\"summaries\":[{\"summaryType\":\"heart_rate\",\"minValue\":78.0,\"maxValue\":87.0,\"avgValue\":83.0,\"epochSummaries\":{\"0\":84.0,\"1\":84.0,\"2\":83.0,\"3\":83.0,\"4\":83.0,\"5\":84.0,\"115\":82.0,\"116\":82.0,\"117\":83.0,\"118\":85.0,\"119\":85.0,\"120\":85.0}},{\"summaryType\":\"respiration\",\"minValue\":13.449999809265137,\"maxValue\":15.319999694824219,\"avgValue\":14.489999771118164,\"epochSummaries\":{\"0\":15.319999694824219,\"1\":15.319999694824219,\"2\":15.319999694824219,\"3\":15.319999694824219,\"4\":15.09000015258789,\"5\":15.09000015258789,\"115\":13.859999656677246,\"116\":13.859999656677246,\"117\":14.300000190734863,\"118\":15.229999542236328,\"119\":15.229999542236328,\"120\":15.319999694824219}},{\"summaryType\":\"stress\",\"minValue\":78.0,\"maxValue\":87.0,\"avgValue\":82.0,\"epochSummaries\":{\"0\":78.0,\"1\":78.0,\"2\":78.0,\"3\":78.0,\"4\":78.0,\"5\":78.0,\"115\":83.0,\"116\":83.0,\"117\":83.0,\"118\":82.0,\"119\":82.0,\"120\":82.0}},{\"summaryType\":\"spo2\",\"minValue\":84.0,\"maxValue\":86.0,\"avgValue\":85.0,\"epochSummaries\":{\"0\":86.0,\"1\":86.0,\"2\":86.0,\"3\":86.0,\"4\":86.0,\"5\":86.0,\"115\":84.0,\"116\":84.0,\"117\":84.0,\"118\":86.0,\"119\":86.0,\"120\":86.0}},{\"summaryType\":\"rmssd_hrv\",\"avgValue\":20.0},{\"summaryType\":\"sdrr_hrv\",\"avgValue\":32.0}]}]");

        for(int i = 0 ; i < array.length() ; i++){
            JSONObject activity = array.getJSONObject(i);
        }

        // test utc data
        Date now = new Date();
        System.out.println(now.getTime());

        for (int i = 0; i < array.length(); i++) {
            JSONObject epoch = array2.getJSONObject(i);
        }
    }

}
