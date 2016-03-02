package org.zhgeaits.wfsf;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by zhangge on 2015/11/3.
 */
public abstract class CameraWorkFlowAbstractStrategy implements ICameraWorkFlowStrategy {

    public static String SQUARE_JUMP_PATH = "yymobile://Shenqu/TinyVideo/Tab";//跳转到广场的链接

    protected CameraWorkFlowActivity mParentActivity;
    protected String mExportUrl;
    protected boolean isVideoEffect;
    protected boolean isMusicEffect;
    protected boolean isDecorateEffect;
    protected String mEffectTag;

    public CameraWorkFlowAbstractStrategy(CameraWorkFlowActivity mParentActivity) {
        this.mParentActivity = mParentActivity;
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void initData(Bundle savedInstanceState, Intent intent) {
        if(savedInstanceState != null) {
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void wrapVideoInfoFromEdit(Intent data) {
    }
}
