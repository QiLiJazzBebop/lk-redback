package coachingmateanalytics.coachingmate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AppTest {

    @Test
    public void testApp() throws JSONException {

        // test upcoming string to json object
        System.out.println("hello world");
        JSONObject obj = new JSONObject("{\"activities\":[{\"durationInSeconds\":15,\"activeKilocalories\":1,\"averageSpeedInMetersPerSecond\":0.37,\"averageHeartRateInBeatsPerMinute\":99,\"distanceInMeters\":5.62,\"activityName\":\"Running\",\"userId\":\"5073e79f-df60-45dc-92f2-bc0ef300f1f0\",\"deviceName\":\"forerunner935\",\"steps\":8,\"averageRunCadenceInStepsPerMinute\":25.828125,\"averagePaceInMinutesPerKilometer\":45.045044,\"activityId\":8623463169,\"startTimeInSeconds\":1649748853,\"userAccessToken\":\"227a7c55-590d-498f-97ad-fb6ba3cb259f\",\"startTimeOffsetInSeconds\":36000,\"maxPaceInMinutesPerKilometer\":8.888888,\"maxHeartRateInBeatsPerMinute\":107,\"summaryId\":\"8623463169\",\"maxRunCadenceInStepsPerMinute\":156.0,\"maxSpeedInMetersPerSecond\":1.875,\"activityType\":\"RUNNING\"}]}");

        JSONArray array = obj.getJSONArray("activities");
        System.out.println(array.length());
        for(int i = 0 ; i < array.length() ; i++){
            JSONObject activity = array.getJSONObject(i);
        }

        // test utc data
        Date now = new Date();
        System.out.println(now.getTime());
    }

}
