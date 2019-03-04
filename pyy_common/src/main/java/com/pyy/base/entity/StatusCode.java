package com.pyy.base.entity;

/**
 * 状态码接口
 * @author panyy
 */
public class StatusCode {
    /** 成功 */
    public static final int OK = 20000;

    /** 失败 */
    public static final int ERROR = 200001;

    /** 用户名或密码错误 */
    public static final int LOGIN_ERROR = 200002;

    /** 权限不足 */
    public static final int ACCESS_ERROR = 200003;

    /** 远程调用失败 */
    public static final int REMOTE_ERROR = 200004;

    /** 重复操作 */
    public static final int REP_ERROR = 200005;
}
