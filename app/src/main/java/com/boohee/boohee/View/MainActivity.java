package com.boohee.boohee.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.boohee.boohee.R;
import com.boohee.boohee.fragment.LoseWeightFragment;
import com.boohee.boohee.fragment.MeFragment;
import com.boohee.boohee.fragment.PartnerFragment;
import com.boohee.boohee.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int currentfragmentIndex = 0;
    int lastChecked=0;
    //中间添加
    @BindView(R.id.Main_AddImg)
    public ImageView mainAddImg;
    //减肥
    @BindView(R.id.JianFei_Img)
    public ImageView reduceweightImage;
    @BindView(R.id.JianFei_Text)
    public TextView reduceweightText;
    //伙伴
    @BindView(R.id.HuoBan_Img)
    public ImageView partnerImage;
    @BindView(R.id.HuoBan_Text)
    public TextView partnerText;
    //商店
    @BindView(R.id.Shop_Img)
    public ImageView shopImage;
    @BindView(R.id.Shop_Text)
    public TextView shopText;
    //我
    @BindView(R.id.Me_Img)
    public ImageView meImage;
    @BindView(R.id.Me_Text)
    public TextView meText;
    private FragmentManager manager;
    //存放fragment的集合
    private List<Fragment> fragmentList;
    //用来存放ImageVIew组件的集合
    private List<ImageView> imageViewList;
    //用来存放TextView组件的集合
    private List<TextView> textViewList;
    //用来存放TextView组件的集合
    private List<Integer> imageList;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        setListener();
    }

    //给主页下面四个图片设置点击监听事件
    private void setListener() {
        mainAddImg.setOnClickListener(this);
        reduceweightImage.setOnClickListener(this);
        partnerImage.setOnClickListener(this);
        shopImage.setOnClickListener(this);
        meImage.setOnClickListener(this);

    }

    public void tabFragment(int fragmentIndex) {
        if (currentfragmentIndex != fragmentIndex) {
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            Fragment formFragment = fragmentList.get(currentfragmentIndex);
            Fragment toFragment = fragmentList.get(fragmentIndex);
            if (!toFragment.isAdded()) {
                transaction.hide(formFragment).add(R.id.Main_View, toFragment);
            } else {
                transaction.hide(formFragment).show(toFragment);
            }
//                transaction.addToBackStack(null);
            transaction.commit();
            currentfragmentIndex = fragmentIndex;
        }
    }


    private void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new LoseWeightFragment());
        fragmentList.add(new PartnerFragment());
        fragmentList.add(new ShopFragment());
        fragmentList.add(new MeFragment());

        imageViewList = new ArrayList<>();
        imageViewList.add(reduceweightImage);
        imageViewList.add(partnerImage);
        imageViewList.add(shopImage);
        imageViewList.add(meImage);

        imageList = new ArrayList<>();
        imageList.add(R.mipmap.a82);
        imageList.add(R.mipmap.a80);
        imageList.add(R.mipmap.a86);
        imageList.add(R.mipmap.a84);

        textViewList = new ArrayList<>();
        textViewList.add(reduceweightText);
        textViewList.add(partnerText);
        textViewList.add(shopText);
        textViewList.add(meText);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.JianFei_Img:
                if(lastChecked !=0) {
                    tabFragment(0);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(0).setImageResource(R.mipmap.a83);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
                    textViewList.get(0).setTextColor(Color.rgb(41, 165, 82));
                    lastChecked =0;
                }
            break;
            case R.id.HuoBan_Img:
                if(lastChecked !=1) {
                    tabFragment(1);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(1).setImageResource(R.mipmap.a81);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
                    textViewList.get(1).setTextColor(Color.rgb(41, 165, 82));

                    lastChecked = 1;
                }
                break;
            case R.id.Main_AddImg:
//                tabFragment(2);
//                if (currentfragmentIndex != 0) {
//                    imageViewList.get(currentfragmentIndex).setBackgroundResource(imageList.get(currentfragmentIndex));
//                    imageViewList.get(0).setBackgroundResource(R.mipmap.a4l);
//                }
                break;
            case R.id.Shop_Img:
                if(lastChecked !=2) {
                    tabFragment(2);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(2).setImageResource(R.mipmap.a87);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
                    textViewList.get(2).setTextColor(Color.rgb(41, 165, 82));

                    lastChecked = 2;
                }
                break;
            case R.id.Me_Img:
                if(lastChecked !=3) {
                    tabFragment(3);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(3).setImageResource(R.mipmap.a85);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
                    textViewList.get(3).setTextColor(Color.rgb(41, 165, 82));

                    lastChecked = 3;
                }
                break;
        }
    }
}
