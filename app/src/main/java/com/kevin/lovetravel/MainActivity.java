package com.kevin.lovetravel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kevin.lovetravel.fragment.HomeFragment;
import com.kevin.lovetravel.fragment.MeFragment;
import com.kevin.lovetravel.fragment.MessageFragment;
import com.kevin.lovetravel.fragment.TravelFragment;
import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private long exitTime = 0;//退出程序时间

    //控件的引入
    @Bind(R.id.id_BmMenu_ImgBt_home)
    ImageButton mMenuImgBtHome;
    @Bind(R.id.id_BmMenu_tv_home)
    TextView mMenuTvHome;
    @Bind(R.id.id_BmMenu_layout_home)
    PercentLinearLayout mMenuLayoutHome;
    @Bind(R.id.id_BmMenu_ImgBt_message)
    ImageButton mMenuImgBtMessage;
    @Bind(R.id.id_BmMenu_tv_message)
    TextView mMenuTvMessage;
    @Bind(R.id.id_BmMenu_layout_message)
    PercentLinearLayout mMenuLayoutMessage;
    @Bind(R.id.id_BmMenu_ImgBt_shop)
    ImageButton mMenuImgBtShop;
    @Bind(R.id.id_BmMenu_tv_shop)
    TextView mMenuTvShop;
    @Bind(R.id.id_BmMenu_layout_shop)
    PercentLinearLayout mMenuLayoutTravel;
    @Bind(R.id.id_BmMenu_ImgBt_me)
    ImageButton mMenuImgBtMe;
    @Bind(R.id.id_BmMenu_tv_me)
    TextView mMenuTvMe;
    @Bind(R.id.id_BmMenu_layout_me)
    PercentLinearLayout mMenuLayoutMe;

    private Fragment mHomeFragment;
    private Fragment mMessageFragment;
    private Fragment mTravelFragment;
    private Fragment mMeFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSelect(0);
    }

    /**
     * 选择当前界面
     * @param i
     */
    private void setSelect(int i){
        //获取FragmentManager对象
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        /**
         * 在现实新的界面的时候，先隐藏之前的界面
         * 通过Switch判断
         */
        hideFragment(transaction);

        switch (i) {
            case 0:
                /**
                 * 先判断当前布局是否存在，再进行界面绘制，防止内存浪费
                 * 1.当前视图不存在，就创建
                 * 2.视图存在，则直接显示
                 * 其他case 也一样
                 */
                if ( mHomeFragment== null) {
                    mHomeFragment = new HomeFragment();

                    transaction.add(R.id.id_mainFrameLayout, mHomeFragment);
                }else {
                    transaction.show(mHomeFragment);
                }
                //选择了该界面，则对应的图标换成有颜色的,文字也改为对应的颜色
                mMenuImgBtHome.setImageResource(R.mipmap.icon_home_selected_0975ff);
                mMenuTvHome.setTextColor(Color.parseColor("#0975ff"));
                break;
            case 1:
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    transaction.add(R.id.id_mainFrameLayout, mMessageFragment);

                }else {
                    transaction.show(mMessageFragment);
                }

                mMenuImgBtMessage.setImageResource(R.mipmap.icon_message_selected_0975ff);
                mMenuTvMessage.setTextColor(Color.parseColor("#0975ff"));
                break;

            case 2:
                if (mTravelFragment == null) {
                    mTravelFragment = new TravelFragment();
                    transaction.add(R.id.id_mainFrameLayout, mTravelFragment);
                }else {
                    transaction.show(mTravelFragment);

                }
                mMenuImgBtShop.setImageResource(R.mipmap.icon_shop_selected_0975ff);
                mMenuTvShop.setTextColor(Color.parseColor("#0975ff"));
                break;

            case 3:
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                    transaction.add(R.id.id_mainFrameLayout, mMeFragment);

                }else {
                    transaction.show(mMeFragment);
                }
                mMenuImgBtMe.setImageResource(R.mipmap.icon_me_selected_0975ff);
                mMenuTvMe.setTextColor(Color.parseColor("#0975ff"));
                break;


            default:
                break;
        }
        //提交事务
        transaction.commit();
    }

    /**
     * 拥有隐藏Fragment，防止界面重叠
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction)
    {
        /**
         * 判断当前显示界面是否为空，不为空就需要隐藏，空表示该界面并未显示，不需隐藏操作
         */
        if (mHomeFragment != null)
        {
            transaction.hide(mHomeFragment);
        }
        if (mMessageFragment != null)
        {
            transaction.hide(mMessageFragment);
        }
        if (mTravelFragment != null)
        {
            transaction.hide(mTravelFragment);
        }
        if (mMeFragment != null)
        {
            transaction.hide(mMeFragment);
        }
    }

    /**
     * 每次选定当前界面的时候，需要调用该方法
     * 用于界面底部Tab各个tab的图标、文字初始化，恢复成无颜色状态
     */
    private void resetImgs(){
        mMenuImgBtHome.setImageResource(R.mipmap.icon_home_normal_929292);
        mMenuImgBtMessage.setImageResource(R.mipmap.icon_message_normal_929292);
        mMenuImgBtShop.setImageResource(R.mipmap.icon_shop_normal_929292);
        mMenuImgBtMe.setImageResource(R.mipmap.icon_me_normal_929292);

        mMenuTvHome.setTextColor(Color.BLACK);
        mMenuTvMessage.setTextColor(Color.BLACK);
        mMenuTvShop.setTextColor(Color.BLACK);
        mMenuTvMe.setTextColor(Color.BLACK);

    }





    @OnClick({R.id.id_BmMenu_layout_home, R.id.id_BmMenu_layout_message, R.id.id_BmMenu_layout_shop, R.id.id_BmMenu_layout_me})
    public void onClick(View view) {
        resetImgs();//初始化各个图标的颜色，先将各个图标设置为无颜色图标
        switch (view.getId()) {
            case R.id.id_BmMenu_layout_home:
                setSelect(0);
                break;
            case R.id.id_BmMenu_layout_message:
                setSelect(1);
                break;
            case R.id.id_BmMenu_layout_shop:
                setSelect(2);
                break;
            case R.id.id_BmMenu_layout_me:
                setSelect(3);
                break;
        }
    }
    /**
     * 在2s内按了两次返回键，则退出程序
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
