package org.zhgeaits.wfsf;

/**
 * Created by zhangge on 2015/11/4.
 */
public class CameraWorkFlowData {

    public int code;
    public Object data;

    public CameraWorkFlowData(int code) {
        this.code = code;
    }

    public CameraWorkFlowData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static CameraWorkFlowData generateByCode(int code) {
        return new CameraWorkFlowData(code);
    }

    public static CameraWorkFlowData generateByCodeAndData(int code, Object data) {
        return new CameraWorkFlowData(code, data);
    }
}
