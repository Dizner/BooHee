package com.boohee.boohee.fragment.PartnerFragments.Partnerfragmentes;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_ViewPager;
import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;
import com.boohee.boohee.R;
import com.boohee.boohee.View.Partner_View.Sift_loseweight_WebView_Activity;
import com.boohee.boohee.View.Partner_View.V_Partner_ViewPager;
import com.boohee.boohee.View.Partner_View.V_Partner_sift;
import com.boohee.boohee.adapter.Partner_Adapter.Partner_sift_ListView_Adapter;
import com.boohee.boohee.adapter.Partner_Adapter.Partner_sift_viewPager_Adapter;
import com.boohee.boohee.presenter.Partner_Presenter.P_ViewPager_Partner;
import com.boohee.boohee.presenter.Partner_Presenter.P_ViewPager_Partner_Impl;
import com.boohee.boohee.presenter.Partner_Presenter.P_friends_Partner_Impl;
import com.boohee.boohee.presenter.Partner_Presenter.P_sift_Partner_Impl;

import java.util.List;

/**
 * Created by PF on 2016/11/18.
 */

public class PartnerFragment_fragment_sift extends Fragment{

    public PartnerFragment_fragment_sift(){ }

    private LinearLayout sift_loseweight,sift_succeed,sift_reduce,sift_hottopic = null;
    private View.OnClickListener sift_loseweight_listener = null;


    private ProgressBar sift_Fragment_Loading = null;

    private ViewPager partner_sift_item_headVP = null;

    private ListView Partner_sift_list = null;

    public static PartnerFragment_fragment_sift getInstance(int index){
        PartnerFragment_fragment_sift fragment_sift = new PartnerFragment_fragment_sift();

        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        fragment_sift.setArguments(bundle);

        return fragment_sift;
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.partner_sift_list,container,false);



        Partner_sift_list = (ListView) view.findViewById(R.id.Partner_sift_list);
        sift_Fragment_Loading = (ProgressBar) view.findViewById(R.id.sift_Fragment_Loading);

        View titleitem = inflater.inflate(R.layout.partner_sift_item_head,null);
        partner_sift_item_headVP = (ViewPager) titleitem.findViewById(R.id.partner_sift_item_headVP);
        sift_loseweight = (LinearLayout) titleitem.findViewById(R.id.sift_loseweight);
        sift_succeed = (LinearLayout) titleitem.findViewById(R.id.sift_succeed);
        sift_reduce = (LinearLayout) titleitem.findViewById(R.id.sift_reduce);
        sift_hottopic = (LinearLayout) titleitem.findViewById(R.id.sift_hottopic);




        P_ViewPager_Partner_Impl p_viewPager_partner_impl = new P_ViewPager_Partner_Impl(new V_Partner_ViewPager(){

            private List<Partner_ViewPager.SlidersBean> viewpager;

            @Override
            public void setViewPagerPartnerBean(Partner_ViewPager Partner_ViewPager) {



                partner_sift_item_headVP.setAdapter(new Partner_sift_viewPager_Adapter(getContext(),Partner_ViewPager.getSliders()  ));

            }
        });

        p_viewPager_partner_impl.initViewPagerPartner();


        Partner_sift_list.addHeaderView(titleitem);

        P_sift_Partner_Impl p_sift_partner_impl =new P_sift_Partner_Impl(new V_Partner_sift() {
            @Override
            public void setPartnerBean(Partner_sift partner_sift) {

                sift_Fragment_Loading.setVisibility(View.VISIBLE);



                Partner_sift_ListView_Adapter siftAdapter = new Partner_sift_ListView_Adapter(partner_sift,getContext());
                Partner_sift_list.setAdapter(siftAdapter);

                sift_Fragment_Loading.setVisibility(View.GONE);
            }
        });

        p_sift_partner_impl.initPartnerData();



        sift_loseweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Sift_loseweight_WebView_Activity.class));
            }
        });

        sift_succeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sift_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sift_hottopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }
}
