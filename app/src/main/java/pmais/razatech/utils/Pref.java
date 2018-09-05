package pmais.razatech.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PointF;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pmais.razatech.utils.PinView.calculateDifference;

public class Pref {

    private static String CLICK_POINTS_TAG = "clicking_points";


    public static List<PointF> loadPinPoints(Context context) {
        SharedPreferences setting = context.getSharedPreferences("ABc", Context.MODE_PRIVATE);
        List<PointF> cartData;
        if (setting.contains(CLICK_POINTS_TAG)) {
            String jsonCart = setting.getString(CLICK_POINTS_TAG, null);
            Gson gson = new Gson();
            try {
                PointF[] cartItems = gson.fromJson(jsonCart, PointF[].class);
                cartData = Arrays.asList(cartItems);
                cartData = new ArrayList<>(cartData);
            } catch (Exception e) {
                return null;
            }
            return cartData;
        }
        return null;
    }

    public static void addPinPoints(PointF item, Context context) {
        List<PointF> mList = loadPinPoints(context);
        if (mList == null)
            mList = new ArrayList<>();
        mList.add(item);
        storePinPoints(mList, context);
    }

    public static void storePinPoints(List items, Context context) {
        SharedPreferences setting = context.getSharedPreferences("ABc", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = setting.edit();
        Gson gson = new Gson();
        String obj = gson.toJson(items);
        editor.putString(CLICK_POINTS_TAG, obj);
        editor.apply();
    }

    public static void removePinPoint(PointF item, Context context) {
        List<PointF> mList = loadPinPoints(context);
        for (int i = 0; i < mList.size(); i++) {
            PointF point = mList.get(i);
            if (calculateDifference(point, item)) {
                mList.remove(i);
            }
        }
        storePinPoints(mList, context);
    }

}
