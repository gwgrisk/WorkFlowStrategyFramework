package org.zhgeaits.wfsf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by zhangge on 2015/11/3.
 * 短拍视频生成工作流
 */
public class CameraWorkFlowActivity extends Activity {

    public static final int CAMERA_WORKFLOW_STRATEGY_RECORD = 1;//默认录制
    public static final int CAMERA_WORKFLOW_STRATEGY_LOCAL = 2;//默认本地视频
    public static final int CAMERA_WORKFLOW_STRATEGY_PHOTO = 3;//默认本地图片
    public static final int CAMERA_WORKFLOW_STRATEGY_WORK = 4;//默认本地作品集
    public static final int CAMERA_WORKFLOW_STRATEGY_EDIT = 5;//默认编辑
    public static final int CAMERA_WORKFLOW_STRATEGY_RELEASE = 6;//默认发布
    public static final int CAMERA_WORKFLOW_STRATEGY_WEB_RECORD = 11;//从web跳转过来的策略
    public static final int CAMERA_WORKFLOW_STRATEGY_WEB_LOCAL = 12;
    public static final int CAMERA_WORKFLOW_STRATEGY_WEB_PHOTO = 13;
    public static final int CAMERA_WORKFLOW_STRATEGY_TOPIC_JUMP_RECORD = 21;//从话题小组那边跳转过来的策略
    public static final int CAMERA_WORKFLOW_STRATEGY_TOPIC_JUMP_LOCAL = 22;
    public static final int CAMERA_WORKFLOW_STRATEGY_TOPIC_JUMP_PHOTO = 23;

    public static final String KEY_CAMERA_WORKFLOW_STRATEGY = "key_camera_workflow_strategy";

    private int mStrategy;
    private ICameraWorkFlowStrategy mCameraStrategey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent() != null) {
            mStrategy = getIntent().getIntExtra(KEY_CAMERA_WORKFLOW_STRATEGY, CAMERA_WORKFLOW_STRATEGY_RECORD);
        } else if(savedInstanceState != null) {
            mStrategy = savedInstanceState.getInt(KEY_CAMERA_WORKFLOW_STRATEGY);
        }


        switch (mStrategy) {
            case CAMERA_WORKFLOW_STRATEGY_RECORD:
                break;
            case CAMERA_WORKFLOW_STRATEGY_LOCAL:
                break;
            default:
                break;
        }

        mCameraStrategey.initData(savedInstanceState, getIntent());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mCameraStrategey != null) {
            mCameraStrategey.onSaveInstanceState(outState);
        }
        outState.putInt(KEY_CAMERA_WORKFLOW_STRATEGY, mStrategy);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(mCameraStrategey != null) {
            mCameraStrategey.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mCameraStrategey != null) {
            mCameraStrategey.onDestroy();
        }
    }

    public void sendInternalMessage(CameraWorkFlowData message) {
        mCameraStrategey.handleInternalMessage(message);
    }

    public void reset() {
    }

    public ICameraWorkFlowStrategy getStrategy() {
        return mCameraStrategey;
    }

}
