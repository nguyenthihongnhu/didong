package dumv.com.didong.model;

import java.util.ArrayList;

import dumv.com.didong.ChoigameActivity;
import dumv.com.didong.object.CauDo;
import dumv.com.didong.object.NguoiDung;

public class ChoiGameModels {
    ChoigameActivity c;
    ArrayList<CauDo> arr;
    int cauSo=-1;
    public NguoiDung nguoiDung;

    public ChoiGameModels(ChoigameActivity c) {
        this.c = c;
        nguoiDung = new NguoiDung();
        taoData();
    }
    private void taoData(){
        arr = new ArrayList<>();
    //    arr.add(new CauDo("", "", ""));
        arr.add(new CauDo("Màn 1", "hocduong", "https://lazi.vn/uploads/dhbc/1466612755_hoc-duong.jpg"));
        arr.add(new CauDo("Màn 2", "sauxa", "https://lazi.vn/uploads/dhbc/1470406880_sau-xa.jpg"));
        arr.add(new CauDo("Màn 3", "hoahau", "https://lazi.vn/uploads/dhbc/1466612864_hoa-hau.jpg"));
        arr.add(new CauDo("Màn 4", "hanhlang", "https://lazi.vn/uploads/dhbc/1466613154_hanh-lang.jpg"));
        arr.add(new CauDo("Màn 5", "cadao", "https://1.bp.blogspot.com/-Gpcp2PFRTz4/U8eW_0A_hYI/AAAAAAAACrw/sirdOt66sPE/s1600/2014-07-17+00.45.08-1.png"));
        arr.add(new CauDo("Màn 6", "matma", "https://1.bp.blogspot.com/-DvJsoAqJD84/U8eY0yhenFI/AAAAAAAACsE/vw4EM1Sk0GM/s1600/2014-07-17+00.45.56-1.png"));
        arr.add(new CauDo("Màn 7", "chidiem", "https://4.bp.blogspot.com/-JLK24fYR1iw/U8elmp9zjRI/AAAAAAAACuQ/TBp__5sop2M/s1600/2014-07-17+01.08.19-1.png"));
        arr.add(new CauDo("Màn 8", "khaucung", "https://1.bp.blogspot.com/-zU9OTbqt8z0/U8eadKE2iZI/AAAAAAAACsY/kGQCbVFBBY0/s1600/2014-07-17+00.46.38-1.png"));
        arr.add(new CauDo("Màn 9", "soctrang", "https://lazi.vn/uploads/dhbc/1516169297_bc2.jpg"));
        arr.add(new CauDo("Màn 10", "cungcau", "https://4.bp.blogspot.com/-9T6FtpnR4ns/U8eQOABrDlI/AAAAAAAACrM/qF_lLL506z0/s1600/2014-07-17+00.44.41-1.png"));
    }
    public CauDo layCauDo(){
        cauSo++;
        if (cauSo>= arr.size()){
            cauSo=arr.size()-1;
        }
        return arr.get(cauSo);
    }

    public void layThongTin(){
        nguoiDung.getTT(c);
    }
    public void luuThongTin(){
        nguoiDung.saveTT(c);
    }
}
