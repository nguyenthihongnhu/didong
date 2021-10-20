package dumv.com.didong.object;

import android.content.Context;
import android.content.SharedPreferences;

public class NguoiDung {
    private String nameData = "apppData";
    public int tien;
    public void saveTT(Context ct){
        SharedPreferences settings = ct.getSharedPreferences(nameData, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("tien", tien);
        editor.commit();
    }

    public void getTT(Context ct){
        SharedPreferences settings = ct.getSharedPreferences(nameData, 0);
        tien = settings.getInt("tien", 20);//20
    }
}
