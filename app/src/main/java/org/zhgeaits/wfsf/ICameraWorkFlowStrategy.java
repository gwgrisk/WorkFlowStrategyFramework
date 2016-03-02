package org.zhgeaits.wfsf;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by zhangge on 2015/11/3.
 * 短拍视频生成工作流策略
 */
public interface ICameraWorkFlowStrategy {

    void initData(Bundle savedInstanceState, Intent intent);
    void handleInternalMessage(CameraWorkFlowData message);
    void onActivityResult(int requestCode, int resultCode, Intent data);
    void onSaveInstanceState(Bundle outState);
    void onDestroy();
    void wrapVideoInfoFromEdit(Intent data);
}
