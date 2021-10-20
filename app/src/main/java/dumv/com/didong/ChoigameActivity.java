package dumv.com.didong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

import dumv.com.didong.adapter.DapAnAdapter;
import dumv.com.didong.model.ChoiGameModels;
import dumv.com.didong.object.CauDo;

public class ChoigameActivity extends AppCompatActivity {

    ChoiGameModels models;
    CauDo cauDo;

    private String dapAn="yeuot";

    ArrayList<String> arrCauTraLoi;
    GridView gdvCauTraLoi;
    int index=0;

    ArrayList<String> arrDapAn;
    GridView gdvDapAn;

    ImageView imgAnhCauDo;
    TextView txvTienNguoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choigame);
        init();
        anhXa();
        setOnClick();
        hienCauDo();
    }

    private void anhXa(){
        gdvCauTraLoi =findViewById(R.id.gdvCauTraLoi);
        gdvDapAn =findViewById(R.id.gdvDapAn);
        imgAnhCauDo =findViewById(R.id.imgAnhCauDo);
        txvTienNguoiDung =findViewById(R.id.txvTienNguoiDung);
    }
    private void init(){
        models = new ChoiGameModels(this);
        arrCauTraLoi = new ArrayList<>();
        arrDapAn = new ArrayList<>();
    }

    private void hienCauDo(){
        cauDo = models.layCauDo();
        dapAn=cauDo.dapAn;

        bamData();
        hienThiCauTraLoi();
        hienThiDapAn();
        Glide.with(this)
                .load(cauDo.anh)
                .into(imgAnhCauDo);
        models.layThongTin();
        txvTienNguoiDung.setText(models.nguoiDung.tien+"$");
    }

    private void hienThiCauTraLoi(){
        gdvCauTraLoi.setNumColumns(arrCauTraLoi.size());
        gdvCauTraLoi.setAdapter(new DapAnAdapter(this, 0,arrCauTraLoi));
    }
    private void hienThiDapAn(){
        gdvDapAn.setNumColumns(arrDapAn.size()/2);
        gdvDapAn.setAdapter(new DapAnAdapter(this, 0,arrDapAn));
    }

    private void setOnClick(){
        gdvDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String A = (String) parent.getItemAtPosition(position);
                if(A.length()!=0 && index<arrCauTraLoi.size()) {
                    for (int i=0;i<arrCauTraLoi.size();i++){
                        if(arrCauTraLoi.get(i).length()==0){
                            index = i;
                            break;
                        }
                    }
                    arrDapAn.set(position,"");
                    arrCauTraLoi.set(index,A);
                    index++;
                    hienThiCauTraLoi();
                    hienThiDapAn();
                    checkWin();
                }
            }
        });
        gdvCauTraLoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String A = (String) parent.getItemAtPosition(position);
                if(A.length()!=0) {
                    index = position;
                    arrCauTraLoi.set(position,"");
                    for(int i=0;i<arrDapAn.size();i++){
                        if(arrDapAn.get(i).length()==0){
                            arrDapAn.set(i,A);
                            break;
                        }
                    }
                    hienThiCauTraLoi();
                    hienThiDapAn();
                }
            }
        });
    }

    private void bamData(){
        index=0;
        arrCauTraLoi.clear();
        arrDapAn.clear();
        Random r = new Random();
        for(int i=0;i<dapAn.length();i++){
            arrCauTraLoi.add("");
            String A = ""+ (char)(r.nextInt(26)+65);
            arrDapAn.add("A");
            String B = ""+ (char)(r.nextInt(26)+65);
            arrDapAn.add("B");
        }
        for(int i=0;i<dapAn.length();i++){
            String A = ""+dapAn.charAt(i);
            arrDapAn.set(i,A.toUpperCase());
        }
        for (int i=0;i<arrDapAn.size();i++){
            String A = arrDapAn.get(i);
            int vt = r.nextInt(arrDapAn.size());
            arrDapAn.set(i,arrDapAn.get(vt));//C B C D
            arrDapAn.set(vt,A);//C B A D
        }
    }

   private void checkWin(){
        String A="";
        for (String B:arrCauTraLoi){
            A=A+B;
        }
        A=A.toUpperCase();
        if(A.equals(dapAn.toUpperCase())){
            Toast.makeText(this, "Ban Da Chien Thang",Toast.LENGTH_SHORT).show();
            models.layThongTin();
            models.nguoiDung.tien=models.nguoiDung.tien+10;
            models.luuThongTin();
            hienCauDo();
        }
   }

    public void moGoiY(View view) {
        models.layThongTin();
        if(models.nguoiDung.tien<5){
            Toast.makeText(this, "Ban Da Het Tien",Toast.LENGTH_SHORT).show();
            return;
        }
        int id=-1;
        for (int i=0;i<arrCauTraLoi.size();i++){
            if(arrCauTraLoi.get(i).length()==0){
                id=1;
                break;
            }
        }
        if(id==-1){
            for (int i=0;i<arrCauTraLoi.size();i++){
                String A = dapAn.toUpperCase().charAt(i)+"";
                if(!arrCauTraLoi.get(i).toUpperCase().equals(A)) {
                    id=1;
                    break;
                }
            }
            for (int i=0;i<arrDapAn.size();i++){
                if(arrDapAn.get(i).length()==0){
                    arrDapAn.set(i,arrCauTraLoi.get(id));
                    break;
                }
            }
        }
        String goiY = "" + dapAn.charAt(id);
        goiY = goiY.toUpperCase();
        for (int i=0;i< arrCauTraLoi.size();i++){
            if(arrCauTraLoi.get(i).toUpperCase().equals(goiY)){
                arrCauTraLoi.set(i, "");
                break;
            }
        }

        for (int i = 0; i < arrDapAn.size(); i++) {
            if (goiY.equals(arrDapAn.get(i))) {
                arrDapAn.set(i, "");
                break;
            }
        }
        arrCauTraLoi.set(id, goiY);
        hienThiCauTraLoi();
        hienThiDapAn();
        models.layThongTin();
        models.nguoiDung.tien = models.nguoiDung.tien - 5;
        models.luuThongTin();
        txvTienNguoiDung.setText(models.nguoiDung.tien + "$");
    }

    public void doiCauHoi(View view) {
        models.layThongTin();
        if(models.nguoiDung.tien<10){
            Toast.makeText(this, "Ban Da Het Tien",Toast.LENGTH_SHORT).show();
            return;
        }
        models.nguoiDung.tien = models.nguoiDung.tien - 10;
        models.luuThongTin();
        txvTienNguoiDung.setText(models.nguoiDung.tien + "$");
        hienCauDo();

    }
}
