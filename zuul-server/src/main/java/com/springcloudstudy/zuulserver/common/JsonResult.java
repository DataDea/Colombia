package com.springcloudstudy.zuulserver.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author yanghai
 * @date 14-12-12
 */
public class JsonResult {

//    /**
//     * 通用错误码 1000-1999
//     */
//    public static final ServiceException ERR_INVALID_HEADER = new ServiceException(1000, "非法请求头");
//    public static final ServiceException ERR_INVALID_HEADER_ID = new ServiceException(1001, "非法请求头，缺少用户ID");
//    public static final ServiceException ERR_INVALID_HEADER_TIMESTAMP = new ServiceException(1002, "签名校验失败，请校准客户端时间！");
//    public static final ServiceException ERR_INVALID_SIGNATURE = new ServiceException(1003, "非法请求");
//    public static final ServiceException ERR_INVALID_PARAM = new ServiceException(1004, "检查参数错误");
//    public static final ServiceException ERR_NO_PRIVILEGE = new ServiceException(1005, "没有权限");
//    public static final ServiceException ERR_EXPORT = new ServiceException(1006, "导出失败");
//    public static final ServiceException ERR_DATA_DUPLICATE = new ServiceException(1008, "数据重复");
//    public static final ServiceException ERR_NOT_HANDLER = new ServiceException(1009, "未处理该接口,请检查方法名");
//    public static final ServiceException ERR_INTERNAL_ERROR = new ServiceException(1010, "内部错误");
//    public static final ServiceException ERR_SQL_ERROR = new ServiceException(1011, "数据库异常");
//    public static final ServiceException ERR_SQL_LENGTH_ERROR = new ServiceException(1012, "数据库长度限制异常");
//    public static final ServiceException ERR_CONTENT_TYPE = new ServiceException(1013, "不支持该Content-Type");
//    public static final ServiceException ERR_URI_PRODUCES = new ServiceException(1014, "URI后缀匹配错误或其他格式错误");
//    public static final ServiceException ERR_DIR_CREATE = new ServiceException(1015, "文件夹创建失败");
//    public static final ServiceException ERR_FILE_CREATE = new ServiceException(1016, "文件创建失败");
//    public static final ServiceException ERR_ILLEGAL_INVOKE = new ServiceException(1017, "非法调用");
//
//    /**
//     * 用户错误码 2000-2999
//     */
//    public static final ServiceException ERR_ACCOUNT_NOT_EXIST = new ServiceException(2000, "账号不存在");
//    public static final ServiceException ERR_ACCOUNT_EXIST = new ServiceException(2001, "账号已存在");
//    public static final ServiceException ERR_EMAIL_EXIST = new ServiceException(2002, "邮箱已存在");
//    public static final ServiceException ERR_WRONG_PASSWORD = new ServiceException(2003, "密码不正确");
//    public static final ServiceException ERR_INVALID_EMAIL = new ServiceException(2004, "邮箱不合法");
//    public static final ServiceException ERR_INVALID_PHONE = new ServiceException(2005, "手机号不合法");
//    public static final ServiceException ERR_USER_NOT_EXIST = new ServiceException(2006, "用户不存在");
//    public static final ServiceException ERR_CUSTOMER_NOT_EXIST = new ServiceException(2007, "用户不存在");
//    public static final ServiceException ERR_INVALID_USE_STATUS = new ServiceException(2008, "账户被禁用,无法登录");
//
//    /**
//     * 估值错误码 3000-3999
//     */
//    public static final ServiceException ERR_VALUATION_NOT_EXIST = new ServiceException(3000, "评估单不存在");
//    public static final ServiceException ERR_VALUATION_NOT_ALREADY_CLOSE = new ServiceException(3002, "评估单已经关闭");
//    public static final ServiceException ERR_VALUATION_NOT_CLOSE = new ServiceException(3003, "仅当评估单处于关闭状态才能删除");
//    public static final ServiceException ERR_VALUATION_STATUS_ERR = new ServiceException(3004, "评估单状态异常");
//
//    public static final ServiceException ERR_VALUATION_TEMPLATE_NOT_EXIST = new ServiceException(3100, "模版不存在");
//    public static final ServiceException ERR_VALUATION_TEMPLATE_EMPTY = new ServiceException(3101, "客户模版不能为空");
//    public static final ServiceException ERR_VALUATION_TEMPLATE_STEP_EMPTY = new ServiceException(3102, "步骤不能为空");
//    public static final ServiceException ERR_VALUATION_TEMPLATE_STEP_DETAIL_EMPTY = new ServiceException(3103, "每个步骤必须至少包含一张图片");
//    public static final ServiceException ERR_VALUATION_REJECT_EMPTY = new ServiceException(3104, "退回说明不能为空");
//    public static final ServiceException ERR_VALUATION_TEMPLATE_PHOTO = new ServiceException(3105, "评估模板图信息不完整");
//    public static final ServiceException ERR_VALUATION_TEMPLATE_MODIFYING = new ServiceException(3106, "当前模板已被修改，不能执行当前操作");
//    public static final ServiceException ERR_VALUATION_TEMPLATE_TYPE_UN_MODIFY = new ServiceException(3107, "模版类型不能修改");
//    public static final ServiceException ERR_VALUATION_EXTRA_PHOTO = new ServiceException(3107, "评估单附加图信息不完整");
//    public static final ServiceException ERR_VALUATION_REPORT_CONFIG = new ServiceException(3108, "评估单模板配置信息异常");
//    public static final ServiceException ERR_VALUATION_TEMPLATE_STEP_PHOTO = new ServiceException(3109, "评估单模板步骤对应的框架图和拍照说明图的ID不能为空");
//    public static final ServiceException ERR_VALUATION_TEMPLATE_STATUS = new ServiceException(3110, "模板已被删除或者禁用");
//    public static final ServiceException ERR_VALUATION_STEP_DETAIL_NO_EXIST = new ServiceException(3111, "步骤对应的详情不存在");
//    public static final ServiceException ERR_VALUATION_ALREADY_RESUBMIT = new ServiceException(3112, "评估单已经提交");
//    public static final ServiceException ERR_VALUATION_CHECK_ITEM_NULL = new ServiceException(3113, "检测信息不能为空");
//    public static final ServiceException ERR_VALUATION_QR_CODE_ALREADY_USE = new ServiceException(3114, "该二维码已经被使用");
//    public static final ServiceException ERR_VALUATION_CUSTOMER_ID_NULL = new ServiceException(3115, "评估单对应的商户ID为NULL");
//    public static final ServiceException ERR_VALUATION_USER_ID_NULL = new ServiceException(3116, "评估单对应的提交用户ID为NULL");
//    public static final ServiceException ERR_VALUATION_CHECK_ITEM_INFO_NULL = new ServiceException(3117, "评估单的检测项的值为空");
//    public static final ServiceException ERR_VALUATION_QR_CODE_NOT_EXIT = new ServiceException(3118, "二维码不存在");
//    public static final ServiceException ERR_VALUATION_TEMPLATE_IDENTIFY_NULL = new ServiceException(3119, "模板的原始模板ID异常");
//    public static final ServiceException ERR_VALUATION_PDF_GENERATE = new ServiceException(3120, "PDF生成失败");
//
//    /**
//     * 第三方数据对接错误码 4000-4999
//     */
//    public static final ServiceException ERR_EXTERNAL_NOT_OPEN = new ServiceException(4000, "未启用接口对接,请联系AbleCloud");
//    public static final ServiceException ERR_EXTERNAL_OTHER = new ServiceException(4001, "其他错误");
//    public static final ServiceException ERR_EXTERNAL_VALUATION_NOT_EXIST = new ServiceException(4002, "评估单不存在");


    public int code;

    public String message;

    public Object data;

    /**
     * 成功返回
     */
    public JsonResult() {
    }

    /**
     * 成功返回
     */
    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
