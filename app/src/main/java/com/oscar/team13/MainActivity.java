package com.oscar.team13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private TextView mTvResult;
    private Button mBtnDo;
    private RadioGroup mRadGrpDate,mRadGrpSwitch;
    private RadioButton mRadBtnDate1,mRadBtnDate2,mRadBtnDate3,mRadBtnTotal,mRadBtnToday;

    private ArrayList<Taiwan> mTaiwan;
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvResult=findViewById(R.id.TvResult);
        mBtnDo=findViewById(R.id.BtnDo);
        mBtnDo.setOnClickListener(btnDoOnClick);

        mRadBtnDate1=findViewById(R.id.RadBtnDate1);
        mRadBtnDate2=findViewById(R.id.RadBtnDate2);
        mRadBtnDate3=findViewById(R.id.RadBtnDate3);
        mRadGrpDate=findViewById(R.id.RadGrpDate);

        mRadBtnTotal=findViewById(R.id.RadBtnTotal);
        mRadBtnToday=findViewById(R.id.RadBtnToday);
        mRadGrpSwitch=findViewById(R.id.RadGrpSwitch);
        mRadGrpSwitch.setOnCheckedChangeListener(radGrpSwitchOnCheckedChange);
    }
    private RadioGroup.OnCheckedChangeListener radGrpSwitchOnCheckedChange =new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.RadBtnToday)
            {
                mRadBtnDate1.setText(getString(R.string.Today_Date_1));
                mRadBtnDate2.setText(getString(R.string.Today_Date_2));
                mode=1;
            }
            else
            {
                mRadBtnDate1.setText(getString(R.string.Total_Date_1));
                mRadBtnDate2.setText(getString(R.string.Total_Date_2));
                mode=2;
            }
        }
    };

    public View.OnClickListener btnDoOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (mRadGrpDate.getCheckedRadioButtonId()){
                case R.id.RadBtnDate1: // 19
                    mTvResult.setText("");
                    mTaiwan = new ArrayList<>();

                    //mode=1 當日 , 反之累積
                    if (mode==1){
                        //北部區域：包括臺北市、新北市、基隆市、新竹市、桃園市、新竹縣及宜蘭縣。
                        mTaiwan.add(new Taiwan("北部","台北市",30));
                        mTaiwan.add(new Taiwan("北部","新北市",81));
                        mTaiwan.add(new Taiwan("北部","桃園市",8));
                        mTaiwan.add(new Taiwan("北部","基隆市",2));
                        mTaiwan.add(new Taiwan("北部","新竹市",2));
                        mTaiwan.add(new Taiwan("北部","新竹縣",3));
                        mTaiwan.add(new Taiwan("北部","宜蘭縣",0));
                        //中部區域：包括臺中市、苗栗縣、彰化縣、南投縣及雲林縣。
                        mTaiwan.add(new Taiwan("中部","臺中市",1));
                        mTaiwan.add(new Taiwan("中部","苗栗縣",0));
                        mTaiwan.add(new Taiwan("中部","彰化縣",0));
                        mTaiwan.add(new Taiwan("中部","南投縣",0));
                        mTaiwan.add(new Taiwan("中部","雲林縣",0));
                        //南部區域：包括高雄市、臺南市、嘉義市、嘉義縣、屏東縣及澎湖縣。
                        mTaiwan.add(new Taiwan("南部","高雄市",0));
                        mTaiwan.add(new Taiwan("南部","臺南市",0));
                        mTaiwan.add(new Taiwan("南部","嘉義市",0));
                        mTaiwan.add(new Taiwan("南部","嘉義縣",0));
                        mTaiwan.add(new Taiwan("南部","屏東縣",0));
                        mTaiwan.add(new Taiwan("南部","澎湖縣",0));
                        //東部區域：包括花蓮縣及臺東縣。
                        mTaiwan.add(new Taiwan("東部","花蓮縣",0));
                        mTaiwan.add(new Taiwan("東部","臺東縣",0));
                        //福建省：包括金門縣與連江縣。
                        mTaiwan.add(new Taiwan("福建省","金門縣",0));
                        mTaiwan.add(new Taiwan("福建省","連江縣",0));

                        Collections.sort(mTaiwan);
                        showList();
                    }else {
                        //北部區域：包括臺北市、新北市、基隆市、新竹市、桃園市、新竹縣及宜蘭縣。
                        mTaiwan.add(new Taiwan("北部","台北市",4070));
                        mTaiwan.add(new Taiwan("北部","新北市",6080));
                        mTaiwan.add(new Taiwan("北部","桃園市",589));
                        mTaiwan.add(new Taiwan("北部","基隆市",277));
                        mTaiwan.add(new Taiwan("北部","新竹市",34));
                        mTaiwan.add(new Taiwan("北部","新竹縣",77));
                        mTaiwan.add(new Taiwan("北部","宜蘭縣",92));
                        //中部區域：包括臺中市、苗栗縣、彰化縣、南投縣及雲林縣。
                        mTaiwan.add(new Taiwan("中部","臺中市",182));
                        mTaiwan.add(new Taiwan("中部","苗栗縣",529));
                        mTaiwan.add(new Taiwan("中部","彰化縣",248));
                        mTaiwan.add(new Taiwan("中部","南投縣",30));
                        mTaiwan.add(new Taiwan("中部","雲林縣",20));
                        //南部區域：包括高雄市、臺南市、嘉義市、嘉義縣、屏東縣及澎湖縣。
                        mTaiwan.add(new Taiwan("南部","高雄市",63));
                        mTaiwan.add(new Taiwan("南部","臺南市",40));
                        mTaiwan.add(new Taiwan("南部","嘉義市",9));
                        mTaiwan.add(new Taiwan("南部","嘉義縣",18));
                        mTaiwan.add(new Taiwan("南部","屏東縣",33));
                        mTaiwan.add(new Taiwan("南部","澎湖縣",5));
                        //東部區域：包括花蓮縣及臺東縣。
                        mTaiwan.add(new Taiwan("東部","花蓮縣",68));
                        mTaiwan.add(new Taiwan("東部","臺東縣",22));
                        //福建省：包括金門縣與連江縣。
                        mTaiwan.add(new Taiwan("福建省","金門縣",0));
                        mTaiwan.add(new Taiwan("福建省","連江縣",4));

                        Collections.sort(mTaiwan);
                        showList();
                    }

                    break;
                case R.id.RadBtnDate2: //20
                    mTvResult.setText("");
                    mTaiwan = new ArrayList<>();
                    //20日 107例 宜蘭縣及基隆市各1例。
                    //mode=1 當日 , 反之累積
                    if (mode==1){
                        //北部區域：包括臺北市、新北市、基隆市、新竹市、桃園市、新竹縣及宜蘭縣。
                        mTaiwan.add(new Taiwan("北部","台北市",31));
                        mTaiwan.add(new Taiwan("北部","新北市",44));
                        mTaiwan.add(new Taiwan("北部","桃園市",16));
                        mTaiwan.add(new Taiwan("北部","基隆市",1));
                        mTaiwan.add(new Taiwan("北部","新竹市",0));
                        mTaiwan.add(new Taiwan("北部","新竹縣",4));
                        mTaiwan.add(new Taiwan("北部","宜蘭縣",1));
                        //中部區域：包括臺中市、苗栗縣、彰化縣、南投縣及雲林縣。
                        mTaiwan.add(new Taiwan("中部","臺中市",6));
                        mTaiwan.add(new Taiwan("中部","苗栗縣",3));
                        mTaiwan.add(new Taiwan("中部","彰化縣",1));
                        mTaiwan.add(new Taiwan("中部","南投縣",0));
                        mTaiwan.add(new Taiwan("中部","雲林縣",0));
                        //南部區域：包括高雄市、臺南市、嘉義市、嘉義縣、屏東縣及澎湖縣。
                        mTaiwan.add(new Taiwan("南部","高雄市",0));
                        mTaiwan.add(new Taiwan("南部","臺南市",0));
                        mTaiwan.add(new Taiwan("南部","嘉義市",0));
                        mTaiwan.add(new Taiwan("南部","嘉義縣",0));
                        mTaiwan.add(new Taiwan("南部","屏東縣",0));
                        mTaiwan.add(new Taiwan("南部","澎湖縣",0));
                        //東部區域：包括花蓮縣及臺東縣。
                        mTaiwan.add(new Taiwan("東部","花蓮縣",0));
                        mTaiwan.add(new Taiwan("東部","臺東縣",0));
                        //福建省：包括金門縣與連江縣。
                        mTaiwan.add(new Taiwan("福建省","金門縣",0));
                        mTaiwan.add(new Taiwan("福建省","連江縣",0));

                        Collections.sort(mTaiwan);
                        showList();
                    }else {
                        //北部區域：包括臺北市、新北市、基隆市、新竹市、桃園市、新竹縣及宜蘭縣。
                        mTaiwan.add(new Taiwan("北部","台北市",4215));
                        mTaiwan.add(new Taiwan("北部","新北市",6122));
                        mTaiwan.add(new Taiwan("北部","桃園市",632));
                        mTaiwan.add(new Taiwan("北部","基隆市",279));
                        mTaiwan.add(new Taiwan("北部","新竹市",34));
                        mTaiwan.add(new Taiwan("北部","新竹縣",78));
                        mTaiwan.add(new Taiwan("北部","宜蘭縣",93));
                        //中部區域：包括臺中市、苗栗縣、彰化縣、南投縣及雲林縣。
                        mTaiwan.add(new Taiwan("中部","臺中市",188));
                        mTaiwan.add(new Taiwan("中部","苗栗縣",526));
                        mTaiwan.add(new Taiwan("中部","彰化縣",251));
                        mTaiwan.add(new Taiwan("中部","南投縣",30));
                        mTaiwan.add(new Taiwan("中部","雲林縣",20));
                        //南部區域：包括高雄市、臺南市、嘉義市、嘉義縣、屏東縣及澎湖縣。
                        mTaiwan.add(new Taiwan("南部","高雄市",63));
                        mTaiwan.add(new Taiwan("南部","臺南市",41));
                        mTaiwan.add(new Taiwan("南部","嘉義市",9));
                        mTaiwan.add(new Taiwan("南部","嘉義縣",18));
                        mTaiwan.add(new Taiwan("南部","屏東縣",33));
                        mTaiwan.add(new Taiwan("南部","澎湖縣",5));
                        //東部區域：包括花蓮縣及臺東縣。
                        mTaiwan.add(new Taiwan("東部","花蓮縣",64));
                        mTaiwan.add(new Taiwan("東部","臺東縣",22));
                        //福建省：包括金門縣與連江縣。
                        mTaiwan.add(new Taiwan("福建省","金門縣",0));
                        mTaiwan.add(new Taiwan("福建省","連江縣",4));

                        Collections.sort(mTaiwan);
                        showList();
                    }

                    break;
                case R.id.RadBtnDate3: // 21
                    mTvResult.setText("");
                    mTaiwan = new ArrayList<>();

                    //mode=1 當日 , 反之累積
                    if (mode==1){
                        //北部區域：包括臺北市、新北市、基隆市、新竹市、桃園市、新竹縣及宜蘭縣。
                        mTaiwan.add(new Taiwan("北部","台北市",22));
                        mTaiwan.add(new Taiwan("北部","新北市",38));
                        mTaiwan.add(new Taiwan("北部","桃園市",5));
                        mTaiwan.add(new Taiwan("北部","基隆市",2));
                        mTaiwan.add(new Taiwan("北部","新竹市",0));
                        mTaiwan.add(new Taiwan("北部","新竹縣",0));
                        mTaiwan.add(new Taiwan("北部","宜蘭縣",0));
                        //中部區域：包括臺中市、苗栗縣、彰化縣、南投縣及雲林縣。
                        mTaiwan.add(new Taiwan("中部","臺中市",2));
                        mTaiwan.add(new Taiwan("中部","苗栗縣",3));
                        mTaiwan.add(new Taiwan("中部","彰化縣",1));
                        mTaiwan.add(new Taiwan("中部","南投縣",0));
                        mTaiwan.add(new Taiwan("中部","雲林縣",1));
                        //南部區域：包括高雄市、臺南市、嘉義市、嘉義縣、屏東縣及澎湖縣。
                        mTaiwan.add(new Taiwan("南部","高雄市",1));
                        mTaiwan.add(new Taiwan("南部","臺南市",0));
                        mTaiwan.add(new Taiwan("南部","嘉義市",0));
                        mTaiwan.add(new Taiwan("南部","嘉義縣",0));
                        mTaiwan.add(new Taiwan("南部","屏東縣",0));
                        mTaiwan.add(new Taiwan("南部","澎湖縣",0));
                        //東部區域：包括花蓮縣及臺東縣。
                        mTaiwan.add(new Taiwan("東部","花蓮縣",0));
                        mTaiwan.add(new Taiwan("東部","臺東縣",0));
                        //福建省：包括金門縣與連江縣。
                        mTaiwan.add(new Taiwan("福建省","金門縣",0));
                        mTaiwan.add(new Taiwan("福建省","連江縣",0));

                        Collections.sort(mTaiwan);
                        showList();
                    }else {
                        //北部區域：包括臺北市、新北市、基隆市、新竹市、桃園市、新竹縣及宜蘭縣。
                        mTaiwan.add(new Taiwan("北部","台北市",4237));
                        mTaiwan.add(new Taiwan("北部","新北市",6160));
                        mTaiwan.add(new Taiwan("北部","桃園市",637));
                        mTaiwan.add(new Taiwan("北部","基隆市",281));
                        mTaiwan.add(new Taiwan("北部","新竹市",34));
                        mTaiwan.add(new Taiwan("北部","新竹縣",78));
                        mTaiwan.add(new Taiwan("北部","宜蘭縣",93));
                        //中部區域：包括臺中市、苗栗縣、彰化縣、南投縣及雲林縣。
                        mTaiwan.add(new Taiwan("中部","臺中市",190));
                        mTaiwan.add(new Taiwan("中部","苗栗縣",529));
                        mTaiwan.add(new Taiwan("中部","彰化縣",252));
                        mTaiwan.add(new Taiwan("中部","南投縣",30));
                        mTaiwan.add(new Taiwan("中部","雲林縣",21));
                        //南部區域：包括高雄市、臺南市、嘉義市、嘉義縣、屏東縣及澎湖縣。
                        mTaiwan.add(new Taiwan("南部","高雄市",64));
                        mTaiwan.add(new Taiwan("南部","臺南市",41));
                        mTaiwan.add(new Taiwan("南部","嘉義市",9));
                        mTaiwan.add(new Taiwan("南部","嘉義縣",18));
                        mTaiwan.add(new Taiwan("南部","屏東縣",33));
                        mTaiwan.add(new Taiwan("南部","澎湖縣",5));
                        //東部區域：包括花蓮縣及臺東縣。
                        mTaiwan.add(new Taiwan("東部","花蓮縣",64));
                        mTaiwan.add(new Taiwan("東部","臺東縣",22));
                        //福建省：包括金門縣與連江縣。
                        mTaiwan.add(new Taiwan("福建省","金門縣",0));
                        mTaiwan.add(new Taiwan("福建省","連江縣",4));

                        Collections.sort(mTaiwan);
                        showList();
                    }

                    break;
            }
        }
    };

    private void showList() {
        for (Taiwan tmp:mTaiwan
        ) {
            mTvResult.append(tmp.toString() + "\n\n");
        }
    }
}