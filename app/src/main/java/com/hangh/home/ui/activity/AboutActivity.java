package com.hangh.home.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.hangh.home.R;
import com.hangh.home.utils.AlipaySdk;
import com.hangh.home.utils.T;
import com.hangh.home.ui.widget.Topbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by luqinmao on 2017/1/3.
 * 关于页面
 */

public class AboutActivity extends BaseActivity {


    @Bind(R.id.topbar_about)
    Topbar topbarAbout;
    @Bind(R.id.iv_pay)
    ImageView mIvPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        topbarAbout.setTopbarOnClickListener(new Topbar.TopbarOnClickListener() {
            @Override
            public void leftOnClick() {
                finish();
            }

            @Override
            public void rightOnClick() {

            }
        });
    }

    @OnClick(R.id.iv_pay)
    public void onViewClicked() {
        if (AlipaySdk.hasInstalledAlipayClient(AboutActivity.this)) {
            AlipaySdk.startAlipayClient(AboutActivity.this, "FKX03380N3ZXGG0WJUKL60");
        } else {
            T.showShort(AboutActivity.this,"谢谢，您没有安装支付宝客户端");
        }
    }
}
