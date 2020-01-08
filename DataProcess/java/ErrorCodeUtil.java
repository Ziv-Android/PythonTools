package com.togic.errorcode;

import android.content.Context;
import android.content.res.Resources;

import com.togic.account.AccountCenter;
import com.togic.account.AccountUtils;
import com.togic.base.util.LogUtil;
import com.togic.livevideo.R;

import java.util.Locale;

/**
 * @author ziv
 */
public class ErrorCodeUtil {
    private static final String TAG = "ErrorCodeUtil";

    public static String errorMsg(Context context, int errorCode) {
        String msg = "未知错误(0)\n请联系客服";
        int safetyErrorCase = checkErrorCode(errorCode);
        switch (safetyErrorCase) {
            case VideoErrorCode.UNKNOWN_ERROR_UPPER_LOGIC_ERROR:
                // 未知错误
                msg = buildUpMsg(R.string.unknown_error_upper_logic_error, R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error, R.string.player_unknown_error_upper_logic_error);
                break;
            case VideoErrorCode.UPPER_PARAMETER_ERROR_UPPER_LOGIC_ERROR:
                // 上层参数错误
                reasonMsgId = R.string.upper_parameter_error_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.player_parameter_error_upper_logic_error;
                break;
            case VideoErrorCode.PLAYER_STATUS_ERROR_UPPER_LOGIC_ERROR:
                // 播放器状态错误
                reasonMsgId = R.string.player_status_error_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.player_status_error_upper_logic_error;
                break;
            case VideoErrorCode.PLAYER_CREATION_FAILED_UPPER_LOGIC_ERROR:
                // 播放器创建失败
                reasonMsgId = R.string.player_creation_failed_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.play_error_upper_logic_error;
                break;
            case VideoErrorCode.AUTHENTICATION_FAILURE_UPPER_LOGIC_ERROR:
                // 鉴权失败
                reasonMsgId = R.string.authentication_failure_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.failed_to_get_play_permission_upper_logic_error;
                break;
            case VideoErrorCode.PHONE_DOES_NOT_SUPPORT_UPPER_LOGIC_ERROR:
                // 手机不支持
                reasonMsgId = R.string.phone_does_not_support_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.your_device_does_not_support_playing_this_movie_upper_logic_error;
                break;
            case VideoErrorCode.PLAY_ADDRESS_IS_EMPTY_UPPER_LOGIC_ERROR:
                // 播放地址为空
                reasonMsgId = R.string.play_address_is_empty_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.play_request_address_is_empty_upper_logic_error;
                break;
            case VideoErrorCode.CALL_OF_SELF_GRIND_HARD_SOLUTION_INTERFACE_FAILED_UPPER_LOGIC_ERROR:
                // 自研硬解接口调用失败
                reasonMsgId = R.string.call_of_self_grind_hard_solution_interface_failed_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.unable_to_play_upper_logic_error;
                break;
            case VideoErrorCode.DOWNLOAD_COMPONENT_LOAD_FAILED_UPPER_LOGIC_ERROR:
                // 下载组件加载失败
                reasonMsgId = R.string.download_component_load_failed_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.play_error_upper_logic_error;
                break;
            case VideoErrorCode.VINFO_PARSING_FAILED_UPPER_LOGIC_ERROR:
                // VINFO 解析失败
                reasonMsgId = R.string.vinfo_parsing_failed_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.play_error_upper_logic_error;
                break;
            case VideoErrorCode.DOWNLOAD_COMPONENT_STARTONLINEOROFFLINEPLAY_RETURN_1_UPPER_LOGIC_ERROR:
                // 下载组件startOnlineOrOfflinePlay返回-1
                reasonMsgId = R.string.download_component_startonlineorofflineplay_return_1_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.play_error_upper_logic_error;
                break;
            case VideoErrorCode.OTHER_MISTAKES_SELF_DEVELOPED_PLAYER:
                // 其他错误
                reasonMsgId = R.string.other_mistakes_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.GENERAL_ERROR_SELF_DEVELOPED_PLAYER:
                // 通用错误
                reasonMsgId = R.string.general_error_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.MEMORY_ERROR_SELF_DEVELOPED_PLAYER:
                // 内存错误
                reasonMsgId = R.string.memory_error_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.FILE_IO_ERROR_SELF_DEVELOPED_PLAYER:
                // 文件IO错误
                reasonMsgId = R.string.file_io_error_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.ILLEGAL_PARAMETER_SELF_DEVELOPED_PLAYER:
                // 参数不合法
                reasonMsgId = R.string.illegal_parameter_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.EXTERNAL_ACTIVE_CLOSE_SELF_DEVELOPED_PLAYER:
                // 外部主动关闭
                reasonMsgId = R.string.external_active_close_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.THE_PLAYER_IS_NOT_READY_SELF_DEVELOPED_PLAYER:
                // 播放器没准备好
                reasonMsgId = R.string.the_player_is_not_ready_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.NETWORK_ERROR_SELF_DEVELOPED_PLAYER:
                // 网络错误
                reasonMsgId = R.string.network_error_self_developed_player;
                solveMsgId = R.string.check_network_connection_and_try_again_self_developed_player;
                showMsgId = R.string.play_error_self_developed_player;
                break;
            case VideoErrorCode.DATA_IN_WRONG_FORMAT_SELF_DEVELOPED_PLAYER:
                // 数据格式错误
                reasonMsgId = R.string.data_in_wrong_format_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.BUFFER_TIMEOUT_SELF_DEVELOPED_PLAYER:
                // 缓冲超时
                reasonMsgId = R.string.buffer_timeout_self_developed_player;
                solveMsgId = R.string.check_network_connection_and_try_again_self_developed_player;
                showMsgId = R.string.not_enough_playback_data_available_self_developed_player;
                break;
            case VideoErrorCode.TRY_OVERTIME_SELF_DEVELOPED_PLAYER:
                // 试看超时
                reasonMsgId = R.string.try_overtime_self_developed_player;
                solveMsgId = R.string.check_network_connection_and_try_again_self_developed_player;
                showMsgId = R.string.not_enough_playback_data_available_self_developed_player;
                break;
            case VideoErrorCode.FORMAT_NOT_SUPPORTED_SELF_DEVELOPED_PLAYER:
                // 格式不支持
                reasonMsgId = R.string.format_not_supported_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.video_format_error_self_developed_player;
                break;
            case VideoErrorCode.TCP_RECEIVE_FAILED_SELF_DEVELOPED_PLAYER:
                // TCP接收失败
                reasonMsgId = R.string.tcp_receive_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.DECODER_REGISTRATION_FAILED_SELF_DEVELOPED_PLAYER:
                // 解码器注册失败
                reasonMsgId = R.string.decoder_registration_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.SOCKET_FAILED_TO_GET_LOCAL_ADDRESS_SELF_DEVELOPED_PLAYER:
                // socket获取本地地址失败
                reasonMsgId = R.string.socket_failed_to_get_local_address_self_developed_player;
                solveMsgId = R.string.check_network_connection_and_try_again_self_developed_player;
                showMsgId = R.string.play_error_self_developed_player;
                break;
            case VideoErrorCode.SOCKET_OPEN_FAILED_SELF_DEVELOPED_PLAYER:
                // socket打开失败
                reasonMsgId = R.string.socket_open_failed_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.BIND_FAILURE_SELF_DEVELOPED_PLAYER:
                // bind失败
                reasonMsgId = R.string.bind_failure_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.LISTENER_FAILED_SELF_DEVELOPED_PLAYER:
                // listener失败
                reasonMsgId = R.string.listener_failed_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.POLL_FAILURE_SELF_DEVELOPED_PLAYER:
                // Poll失败
                reasonMsgId = R.string.poll_failure_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.ACCEPT_FAILED_SELF_DEVELOPED_PLAYER:
                // accept 失败
                reasonMsgId = R.string.accept_failed_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.RECV_FAILURE_SELF_DEVELOPED_PLAYER:
                // Recv失败
                reasonMsgId = R.string.recv_failure_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.READ_TIMEOUT_SELF_DEVELOPED_PLAYER:
                // read超时
                reasonMsgId = R.string.read_timeout_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.SEND_FAILURE_SELF_DEVELOPED_PLAYER:
                // send失败
                reasonMsgId = R.string.send_failure_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.WRITE_TIMEOUT_SELF_DEVELOPED_PLAYER:
                // write超时
                reasonMsgId = R.string.write_timeout_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.OPEN_TIMEOUT_SELF_DEVELOPED_PLAYER:
                // open超时
                reasonMsgId = R.string.open_timeout_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.OTHER_SOCKET_RELATED_ERRORS_SELF_DEVELOPED_PLAYER:
                // socket相关的其他错误
                reasonMsgId = R.string.other_socket_related_errors_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.IO_ERROR_SELF_DEVELOPED_PLAYER:
                // IO错误
                reasonMsgId = R.string.io_error_self_developed_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.ILLEGAL_DATA_SELF_DEVELOPED_PLAYER:
                // 数据不合法
                reasonMsgId = R.string.illegal_data_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_parameter_error_self_developed_player;
                break;
            case VideoErrorCode.NO_DECODER_FOUND_SELF_DEVELOPED_PLAYER:
                // 没找到解码器
                reasonMsgId = R.string.no_decoder_found_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.NO_CORRESPONDING_DEMUXER_FOUND_SELF_DEVELOPED_PLAYER:
                // 没找到对应demuxer
                reasonMsgId = R.string.no_corresponding_demuxer_found_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.EXTERNAL_EXIT_SELF_DEVELOPED_PLAYER:
                // 外部退出
                reasonMsgId = R.string.external_exit_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.THIRD_PARTY_LIBRARY_ERROR_SELF_DEVELOPED_PLAYER:
                // 第三方库错误
                reasonMsgId = R.string.third_party_library_error_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.NO_CORRESPONDING_FILTER_FOUND_SELF_DEVELOPED_PLAYER:
                // 没找到对应filter
                reasonMsgId = R.string.no_corresponding_filter_found_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.DECODING_PARAMETER_SETTING_FAILED_SELF_DEVELOPED_PLAYER:
                // 解码参数设置失败
                reasonMsgId = R.string.decoding_parameter_setting_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.NO_CORRESPONDING_AGREEMENT_FOUND_SELF_DEVELOPED_PLAYER:
                // 没找到对应协议
                reasonMsgId = R.string.no_corresponding_agreement_found_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.NO_CORRESPONDING_STREAM_FORMAT_FOUND_SELF_DEVELOPED_PLAYER:
                // 没找到对应流格式
                reasonMsgId = R.string.no_corresponding_stream_format_found_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.UNKNOWN_ERROR_SELF_DEVELOPED_PLAYER:
                // 未知错误
                reasonMsgId = R.string.unknown_error_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.LINK_TIMEOUT_SELF_DEVELOPED_PLAYER:
                // 链接超时
                reasonMsgId = R.string.link_timeout_self_developed_player;
                solveMsgId = R.string.check_network_connection_and_try_again_self_developed_player;
                showMsgId = R.string.play_error_self_developed_player;
                break;
            case VideoErrorCode.NO_CORRESPONDING_DECODER_CONTEXT_FOUND_SELF_DEVELOPED_PLAYER:
                // 没找到对应解码器上下文
                reasonMsgId = R.string.no_corresponding_decoder_context_found_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.VIDEO_DECODER_NOT_FOUND_SELF_DEVELOPED_PLAYER:
                // video decoder 没找到
                reasonMsgId = R.string.video_decoder_not_found_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.VIDEO_DECODER_DECODING_FAILED_SELF_DEVELOPED_PLAYER:
                // video decoder 解码失败
                reasonMsgId = R.string.video_decoder_decoding_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.VIDEO_PTS_ERROR_SELF_DEVELOPED_PLAYER:
                // video pts 错误
                reasonMsgId = R.string.video_pts_error_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.AUDIO_DECODER_NOT_FOUND_SELF_DEVELOPED_PLAYER:
                // audio decoder 没找到
                reasonMsgId = R.string.audio_decoder_not_found_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.AUDIO_DECODER_DECODING_FAILED_SELF_DEVELOPED_PLAYER:
                // audio decoder 解码失败
                reasonMsgId = R.string.audio_decoder_decoding_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.AUDIO_PTS_ERROR_SELF_DEVELOPED_PLAYER:
                // audio pts 错误
                reasonMsgId = R.string.audio_pts_error_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.DATA_FLOW_ERROR_PLAYER_BASE_ERROR_SELFPLAYER_AVSRC_ERROR_SELF_DEVELOPED_PLAYER:
                // 数据流错误Player_base_err_selfplayer_avsrc_error
                reasonMsgId = R.string.data_flow_error_player_base_error_selfplayer_avsrc_error_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.FAILED_TO_SET_DECODER_PLAYER_BASE_ERR_SELFPLAYER_SET_DEC_FAILED_SELF_DEVELOPED_PLAYER:
                // 设置解码器失败Player_base_err_selfplayer_set_dec_failed
                reasonMsgId = R.string.failed_to_set_decoder_player_base_err_selfplayer_set_dec_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.DECODING_FAILED_PLAYER_BASE_ERR_SELFPLAYER_DECISION_FAILED_SELF_DEVELOPED_PLAYER:
                // 解码失败Player_base_err_selfplayer_decider_failed
                reasonMsgId = R.string.decoding_failed_player_base_err_selfplayer_decision_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.DOLBY_DECODING_FAILED_PLAYER_BASE_ERR_SELFPLAYER_DOLBY_FAILED_SELF_DEVELOPED_PLAYER:
                // dolby解码失败Player_base_err_selfplayer_dolby_failed
                reasonMsgId = R.string.dolby_decoding_failed_player_base_err_selfplayer_dolby_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.HEVC_DECODING_FAILED_PLAYER_BASE_ERR_SELFPLAYER_HEVC_FAILED_SELF_DEVELOPED_PLAYER:
                // hevc解码失败Player_base_err_selfplayer_hevc_failed
                reasonMsgId = R.string.hevc_decoding_failed_player_base_err_selfplayer_hevc_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.PLAYER_BASE_ERR_SELFPLAYER_URL_ERROR_SELF_DEVELOPED_PLAYER:
                // URL有问题Player_base_err_selfplayer_url_error
                reasonMsgId = R.string.player_base_err_selfplayer_url_error_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.FAILED_TO_OPEN_PLAYER_BASE_ERR_SELFPLAYER_OPEN_FAILED_SELF_DEVELOPED_PLAYER:
                // 打开失败Player_base_err_selfplayer_open_failed
                reasonMsgId = R.string.failed_to_open_player_base_err_selfplayer_open_failed_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.START_FUNCTION_EXCEPTION_PLAYER_BASE_ERR_SELFPLAYER_START_EXCE_SELF_DEVELOPED_PLAYER:
                // start函数异常Player_base_err_selfplayer_start_exce
                reasonMsgId = R.string.start_function_exception_player_base_err_selfplayer_start_exce_self_developed_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_self_developed_player;
                showMsgId = R.string.player_unknown_error_self_developed_player;
                break;
            case VideoErrorCode.PLAYER_BASE_ERR_SELFPLAYER_NETWORK_ERR_SELF_DEVELOPED_PLAYER:
                // 网络问题Player_base_err_selfplayer_network_err
                reasonMsgId = R.string.player_base_err_selfplayer_network_err_self_developed_player;
                solveMsgId = R.string.check_network_connection_and_try_again_self_developed_player;
                showMsgId = R.string.play_error_self_developed_player;
                break;
            case VideoErrorCode.TIMEOUT_PLAYER_BASE_ERR_SELFPLAYER_TIMEOUT_SELF_DEVELOPED_PLAYER:
                // 超时Player_base_err_selfplayer_timeout
                reasonMsgId = R.string.timeout_player_base_err_selfplayer_timeout_self_developed_player;
                solveMsgId = R.string.check_network_connection_and_try_again_self_developed_player;
                showMsgId = R.string.play_error_self_developed_player;
                break;
            case VideoErrorCode.SYSTEM_PLAYER_UNKNOWN_ERROR_SYSTEM_PLAYER:
                // 系统播放器未知错误
                reasonMsgId = R.string.system_player_unknown_error_system_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_system_player;
                showMsgId = R.string.player_unknown_error_system_player;
                break;
            case VideoErrorCode.INTERNAL_TIMEOUT_PREPARE_TIMEOUT_25_SECONDS_SYSTEM_PLAYER:
                // 内部超时，prepare超时25秒
                reasonMsgId = R.string.internal_timeout_prepare_timeout_25_seconds_system_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_system_player;
                showMsgId = R.string.player_unknown_error_system_player;
                break;
            case VideoErrorCode.DATA_TIMEOUT_TAKE_DATA_FOR_10_SECONDS_TIMEOUT_SYSTEM_PLAYER:
                // 数据超时，取数据10秒超时
                reasonMsgId = R.string.data_timeout_take_data_for_10_seconds_timeout_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.ILLEGAL_PLAY_STATUS_SYSTEM_PLAYER:
                // 播放状态非法
                reasonMsgId = R.string.illegal_play_status_system_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_system_player;
                showMsgId = R.string.player_unknown_error_system_player;
                break;
            case VideoErrorCode.ILLEGAL_PLAYBACK_PARAMETERS_SYSTEM_PLAYER:
                // 播放参数非法
                reasonMsgId = R.string.illegal_playback_parameters_system_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_system_player;
                showMsgId = R.string.player_unknown_error_system_player;
                break;
            case VideoErrorCode.FILE_IO_ERROR_SYSTEM_PLAYER:
                // 文件IO错误
                reasonMsgId = R.string.file_io_error_system_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_system_player;
                showMsgId = R.string.player_parameter_error_system_player;
                break;
            case VideoErrorCode.THE_CODING_FORMAT_IS_NOT_STANDARD_SYSTEM_PLAYER:
                // 编码格式不规范
                reasonMsgId = R.string.the_coding_format_is_not_standard_system_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_system_player;
                showMsgId = R.string.player_unknown_error_system_player;
                break;
            case VideoErrorCode.FORMAT_NOT_SUPPORTED_SYSTEM_PLAYER:
                // 格式不支持
                reasonMsgId = R.string.format_not_supported_system_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_system_player;
                showMsgId = R.string.video_format_error_system_player;
                break;
            case VideoErrorCode.THE_CURRENT_VIDEO_STREAM_DOES_NOT_SUPPORT_LOOPING_SYSTEM_PLAYER:
                // 当前视频流不支持循环播放
                reasonMsgId = R.string.the_current_video_stream_does_not_support_looping_system_player;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_system_player;
                showMsgId = R.string.player_unknown_error_system_player;
                break;
            case VideoErrorCode.NO_CHANGE_IN_PLAYBACK_PROGRESS_IN_12_SECONDS_SYSTEM_PLAYER:
                // 12秒内播放进度没变化
                reasonMsgId = R.string.no_change_in_playback_progress_in_12_seconds_system_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_system_player;
                showMsgId = R.string.player_parameter_error_system_player;
                break;
            case VideoErrorCode.MEDIASERVER_PROCESS_ERROR_SYSTEM_PLAYER:
                // mediaserver进程错误
                reasonMsgId = R.string.mediaserver_process_error_system_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_system_player;
                showMsgId = R.string.player_parameter_error_system_player;
                break;
            case VideoErrorCode.OPEN_COMMON_ERROR_SYSTEM_PLAYER:
                // open通用错误
                reasonMsgId = R.string.open_common_error_system_player;
                solveMsgId = R.string.please_restart_the_device_and_try_again_system_player;
                showMsgId = R.string.player_parameter_error_system_player;
                break;
            case VideoErrorCode.SYSTEM_BUFFER_TIMEOUT_SYSTEM_PLAYER:
                // 系统缓冲超时
                reasonMsgId = R.string.system_buffer_timeout_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.NETWORK_ERROR_SYSTEM_PLAYER:
                // 网络错误
                reasonMsgId = R.string.network_error_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.NETWORK_LAYER_UNKNOWN_ERROR_SYSTEM_PLAYER:
                // 网络层未知错误
                reasonMsgId = R.string.network_layer_unknown_error_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.THE_DOMAIN_NAME_COULD_NOT_BE_RESOLVED_UNKNOWHOSTEXCEPTION_SYSTEM_PLAYER:
                // 无法解析该域名-UnknowHostException
                reasonMsgId = R.string.the_domain_name_could_not_be_resolved_unknowhostexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.CONNECTION_ERROR_CONNECTEXCEPTION_SYSTEM_PLAYER:
                // 连接出错-ConnectException
                reasonMsgId = R.string.connection_error_connectexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.REQUEST_TIMEOUT_CONNECTTIMEOUTEXCEPTION_SYSTEM_PLAYER:
                // 请求超时-ConnectTimeoutException
                reasonMsgId = R.string.request_timeout_connecttimeoutexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.SERVER_RESPONSE_TIMEOUT_SOCKETIMEOUTEXCEPTION_SYSTEM_PLAYER:
                // 服务器响应超时-SocketTimeoutException
                reasonMsgId = R.string.server_response_timeout_socketimeoutexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.IO_EXCEPTION_IOEXCEPTION_SYSTEM_PLAYER:
                // IO异常-IOException
                reasonMsgId = R.string.io_exception_ioexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.PARAMETER_EXCEPTION_ILLEGALVALUEEXCEPTION_SYSTEM_PLAYER:
                // 参数异常-IllegalValueException
                reasonMsgId = R.string.parameter_exception_illegalvalueexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.FILE_CANNOT_FIND_EXCEPTION_FILENOTFOUNDEXCEPTION_SYSTEM_PLAYER:
                // 文件找不到异常-FileNotFoundException
                reasonMsgId = R.string.file_cannot_find_exception_filenotfoundexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.PROTOCOL_ERROR_CLLIENTPROTOCOLEXCEPTION_SYSTEM_PLAYER:
                // 协议错误-CllientProtocolException
                reasonMsgId = R.string.protocol_error_cllientprotocolexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.CIRCULAR_REDIRECTION_CIRCULAR_REDIRECTEXCEPTION_SYSTEM_PLAYER:
                // 循环重定向-CircularRedirectException
                reasonMsgId = R.string.circular_redirection_circular_redirectexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.NO_RESPONSE_FROM_SERVER_NOHTTPRESPONSEEXCEPTION_SYSTEM_PLAYER:
                // 服务器无响应-NoHttpResponseException
                reasonMsgId = R.string.no_response_from_server_nohttpresponseexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.RETURN_HTTP_CORRESPONDING_STATUS_CODE_SYSTEM_PLAYER:
                // 返回http对应状态码
                reasonMsgId = R.string.return_http_corresponding_status_code_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.HTTP_RETURN_INFORMATION_IS_NOT_XML_SYSTEM_PLAYER:
                // http返回信息不是xml
                reasonMsgId = R.string.http_return_information_is_not_xml_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.CGI_RETURNS_S_0_SYSTEM_PLAYER:
                // cgi返回s != '0'
                reasonMsgId = R.string.cgi_returns_s_0_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.XML_PARSING_FAILED_SYSTEM_PLAYER:
                // xml解析失败
                reasonMsgId = R.string.xml_parsing_failed_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_SSLEXCEPTION_SYSTEM_PLAYER:
                // https异常-SSLException
                reasonMsgId = R.string.https_exception_sslexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_HANDSHAKEEXCEPTION_SYSTEM_PLAYER:
                // https异常-HandShakeException
                reasonMsgId = R.string.https_exception_handshakeexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_KEYEXCEPTION_SYSTEM_PLAYER:
                // https异常-KeyException
                reasonMsgId = R.string.https_exception_keyexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_PEERUNVERIFIEDEXCEPTION_SYSTEM_PLAYER:
                // https异常-PeerUnverifiedException
                reasonMsgId = R.string.https_exception_peerunverifiedexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_PROTOCOLEXCEPTION_SYSTEM_PLAYER:
                // https异常-ProtocolException
                reasonMsgId = R.string.https_exception_protocolexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.SOCKET_ERROR_SOCKETEXCEPTION_SYSTEM_PLAYER:
                // socket错误-SocketException
                reasonMsgId = R.string.socket_error_socketexception_system_player;
                solveMsgId = R.string.check_network_connection_and_try_again_system_player;
                showMsgId = R.string.play_error_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_101_SYSTEM_PLAYER:
                // http状态码-101
                reasonMsgId = R.string.http_status_code_101_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_200_SYSTEM_PLAYER:
                // http状态码-200
                reasonMsgId = R.string.http_status_code_200_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_307_SYSTEM_PLAYER:
                // http状态码-307
                reasonMsgId = R.string.http_status_code_307_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_400_SYSTEM_PLAYER:
                // http状态码-400
                reasonMsgId = R.string.http_status_code_400_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_401_SYSTEM_PLAYER:
                // http状态码-401
                reasonMsgId = R.string.http_status_code_401_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_402_SYSTEM_PLAYER:
                // http状态码-402
                reasonMsgId = R.string.http_status_code_402_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_403_SYSTEM_PLAYER:
                // http状态码-403
                reasonMsgId = R.string.http_status_code_403_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_404_SYSTEM_PLAYER:
                // http状态码-404
                reasonMsgId = R.string.http_status_code_404_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_405_SYSTEM_PLAYER:
                // http状态码-405
                reasonMsgId = R.string.http_status_code_405_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_500_SYSTEM_PLAYER:
                // http状态码-500
                reasonMsgId = R.string.http_status_code_500_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_501_SYSTEM_PLAYER:
                // http状态码-501
                reasonMsgId = R.string.http_status_code_501_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_502_SYSTEM_PLAYER:
                // http状态码-502
                reasonMsgId = R.string.http_status_code_502_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_503_SYSTEM_PLAYER:
                // http状态码-503
                reasonMsgId = R.string.http_status_code_503_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_504_SYSTEM_PLAYER:
                // http状态码-504
                reasonMsgId = R.string.http_status_code_504_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_505_SYSTEM_PLAYER:
                // http状态码-505
                reasonMsgId = R.string.http_status_code_505_system_player;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_system_player;
                showMsgId = R.string.background_server_busy_system_player;
                break;
            case VideoErrorCode.THE_SPECIFIED_FORMAT_WAS_NOT_FOUND_FOR_OFFLINE_DOWNLOAD_GETVINFO_RETURN_FORMAT_PROBLEM:
                // 离线下载没有找到指定的format
                reasonMsgId = R.string.the_specified_format_was_not_found_for_offline_download_getvinfo_return_format_problem;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.OFFLINE_DOWNLOAD_GETVINFO_PARSING_FAILED_GETVINFO_RETURN_FORMAT_PROBLEM:
                // 离线下载getVinfo解析失败
                reasonMsgId = R.string.offline_download_getvinfo_parsing_failed_getvinfo_return_format_problem;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.THE_URL_IN_THE_OFFLINE_DOWNLOAD_VINFO_IS_EMPTY_GETVINFO_RETURN_FORMAT_PROBLEM:
                // 离线下载vinfo里面的url为空
                reasonMsgId = R.string.the_url_in_the_offline_download_vinfo_is_empty_getvinfo_return_format_problem;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.OFFLINE_DOWNLOAD_REQUEST_DRM_VIDEO_RETURN_NON_DRM_VIDEO_WILL_RE_REQUEST_NON_DRM_VIDEO_DOWNLOAD_GETVINFO_RETURN_FORMAT_PROBLEM:
                // 离线下载请求drm视频，返回非drm视频，将重新请求非drm视频下载
                reasonMsgId = R.string.offline_download_request_drm_video_return_non_drm_video_will_re_request_non_drm_video_download_getvinfo_return_format_problem;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.OFFLINE_DOWNLOAD_REQUEST_DRM_VIDEO_GETVINFO_PARSING_FAILED_GETVINFO_RETURN_FORMAT_PROBLEM:
                // 离线下载请求drm视频，返getVinfo解析失败
                reasonMsgId = R.string.offline_download_request_drm_video_getvinfo_parsing_failed_getvinfo_return_format_problem;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.OFFLINE_DOWNLOAD_DOES_NOT_HAVE_A_LEGAL_DOWNLOAD_TYPE_GETVINFO_RETURN_FORMAT_PROBLEM:
                // 离线下载没有合法的下载类型
                reasonMsgId = R.string.offline_download_does_not_have_a_legal_download_type_getvinfo_return_format_problem;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.OFFLINE_DOWNLOAD_ENCRYPTED_VIDEO_IS_RETURNED_IN_THE_BACKGROUND_BUT_THE_KEY_IS_EMPTY_GETVINFO_RETURN_FORMAT_PROBLEM:
                // 离线下载，后台返回加密视频，但是key为空
                reasonMsgId = R.string.offline_download_encrypted_video_is_returned_in_the_background_but_the_key_is_empty_getvinfo_return_format_problem;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.GETVINFO_PARSING_FAILED_GETVINFO_RETURN_FORMAT_PROBLEM:
                // getVinfo解析失败
                reasonMsgId = R.string.getvinfo_parsing_failed_getvinfo_return_format_problem;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.FORMAT_NOT_FOUND_GETVINFO_RETURN_FORMAT_PROBLEM:
                // 没有找到format
                reasonMsgId = R.string.format_not_found_getvinfo_return_format_problem;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.URL_IN_VINFO_IS_EMPTY_GETVINFO_RETURN_FORMAT_PROBLEM:
                // vinfo中url为空
                reasonMsgId = R.string.url_in_vinfo_is_empty_getvinfo_return_format_problem;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_return_format_problem;
                showMsgId = R.string.play_error_getvinfo_return_format_problem;
                break;
            case VideoErrorCode.CGI_PARAMETER_ERROR_OR_ERROR_SENDING_TO_SERVER_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI参数错误或者向服务器发包错误
                reasonMsgId = R.string.cgi_parameter_error_or_error_sending_to_server_getvinfo_returns_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.CGI_RECEIVE_PACKAGE_ERROR_FROM_SERVER_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI从服务器接包错误
                reasonMsgId = R.string.cgi_receive_package_error_from_server_getvinfo_returns_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.CGI_UNPACKING_FROM_SERVER_ERROR_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI从服务器解包错误
                reasonMsgId = R.string.cgi_unpacking_from_server_error_getvinfo_returns_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.CGI_CONNECTION_SERVER_NETWORK_ERROR_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI连接服务器网络错误
                reasonMsgId = R.string.cgi_connection_server_network_error_getvinfo_returns_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.CGI_CONNECTION_TIMEOUT_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI连接超时
                reasonMsgId = R.string.cgi_connection_timeout_getvinfo_returns_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.CGI_ACCESS_SERVICE_UNKNOWN_ERROR_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI访问服务未知错误
                reasonMsgId = R.string.cgi_access_service_unknown_error_getvinfo_returns_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.CGI_SYSTEM_ERROR_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI系统错误
                reasonMsgId = R.string.cgi_system_error_getvinfo_returns_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.NUMBER_OF_VIDS_OUT_OF_RANGE_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // vid个数超出范围
                reasonMsgId = R.string.number_of_vids_out_of_range_getvinfo_returns_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.CGI_ACCESS_SERVICE_FAILED_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI访问服务失败
                reasonMsgId = R.string.cgi_access_service_failed_getvinfo_returns_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_VIDEO_VIDEO_TIMEOUT_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // vid不合法（video超时）
                reasonMsgId = R.string.illegal_video_video_timeout_getvinfo_returns_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_VIDEO_STATUS_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 视频状态不合法
                reasonMsgId = R.string.illegal_video_status_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_DEFINITION_FORMAT_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 清晰度格式不合法
                reasonMsgId = R.string.illegal_definition_format_getvinfo_returns_background_error_code;
                solveMsgId = R.string.please_press_menu_key_to_switch_sharpness_or_exit_to_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.wrong_video_definition_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.ERROR_IN_PAY_SERVICE_SPP_TPAY_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 付费服务spp_tpay出错
                reasonMsgId = R.string.error_in_pay_service_spp_tpay_getvinfo_returns_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_SPEED_FORMAT_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 速度格式不合法
                reasonMsgId = R.string.illegal_speed_format_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_FILE_NAME_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 文件名不合法
                reasonMsgId = R.string.illegal_file_name_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.VIDEO_FORMAT_DOES_NOT_EXIST_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 视频格式不存在
                reasonMsgId = R.string.video_format_does_not_exist_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_FILE_STATUS_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 文件状态不合法
                reasonMsgId = R.string.illegal_file_status_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.FORMAT_LIST_IS_EMPTY_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // format列表为空
                reasonMsgId = R.string.format_list_is_empty_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_CONSTRUCT_KEY_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 构造key失败
                reasonMsgId = R.string.failed_to_construct_key_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.HLS_CDN_NOT_FOUND_OR_FAILED_TO_CONSTRUCT_SHA_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 未找到HLS CDN或者构造sha失败
                reasonMsgId = R.string.hls_cdn_not_found_or_failed_to_construct_sha_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.NO_SUPPORT_FOR_HLS_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 不支持HLS
                reasonMsgId = R.string.no_support_for_hls_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_GENERATE_FILENAME_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 生成文件名失败
                reasonMsgId = R.string.failed_to_generate_filename_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_PARTITION_NUMBER_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 分片号不合法
                reasonMsgId = R.string.illegal_partition_number_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_CONSTRUCT_FILE_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 构造文件失败
                reasonMsgId = R.string.failed_to_construct_file_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_GET_M3U8_FILENAME_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 获取m3u8文件名失败
                reasonMsgId = R.string.failed_to_get_m3u8_filename_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_GENERATE_HLS_KEY_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 生成HLS key 失败
                reasonMsgId = R.string.failed_to_generate_hls_key_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.NON_GENUINE_TENCENT_VIDEO_APP_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 非正版腾讯视频app
                reasonMsgId = R.string.non_genuine_tencent_video_app_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.COPYRIGHT_RESTRICTIONS_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 版权限制
                reasonMsgId = R.string.copyright_restrictions_getvinfo_returns_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_returns_background_error_code;
                showMsgId = R.string.due_to_copyright_restrictions_only_services_are_provided_to_mainland_china_your_location_is_1_s_please_give_feedback_if_there_is_any_mistake_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.REFERER_RESTRICTIONS_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // referer限制
                reasonMsgId = R.string.referer_restrictions_getvinfo_returns_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.QZONE_PERMISSION_RESTRICTIONS_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // qzone权限限制
                reasonMsgId = R.string.qzone_permission_restrictions_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.PAYMENT_RESTRICTION_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 付费限制
                reasonMsgId = R.string.payment_restriction_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.ACCESS_IP_IS_BLACKLIST_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 访问ip是黑名单
                reasonMsgId = R.string.access_ip_is_blacklist_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.CGI_ACCESS_KEY_INCORRECT_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI访问key不正确
                reasonMsgId = R.string.cgi_access_key_incorrect_getvinfo_returns_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.CGI_ACCESS_FREQUENCY_INSURANCE_AND_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // CGI访问频率险资和
                reasonMsgId = R.string.cgi_access_frequency_insurance_and_getvinfo_returns_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.TOO_MANY_ACCOUNT_LOGIN_DEVICES_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // 帐号登录设备过多
                reasonMsgId = R.string.too_many_account_login_devices_getvinfo_returns_background_error_code;
                solveMsgId = R.string.please_go_to_my_help_center_to_check_the_rules_getvinfo_returns_background_error_code;
                showMsgId = R.string.the_number_of_login_devices_for_your_account_exceeds_the_limit_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.QQOPENERROR_GETVINFO_RETURNS_BACKGROUND_ERROR_CODE:
                // QQOpenError
                reasonMsgId = R.string.qqopenerror_getvinfo_returns_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvinfo_returns_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvinfo_returns_background_error_code;
                break;
            case VideoErrorCode.NETWORK_LAYER_UNKNOWN_ERROR_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 网络层未知错误
                reasonMsgId = R.string.network_layer_unknown_error_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.THE_DOMAIN_NAME_COULD_NOT_BE_RESOLVED_UNKNOWHOSTEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 无法解析该域名-UnknowHostException
                reasonMsgId = R.string.the_domain_name_could_not_be_resolved_unknowhostexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.CONNECTION_ERROR_CONNECTEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 连接出错-ConnectException
                reasonMsgId = R.string.connection_error_connectexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.REQUEST_TIMEOUT_CONNECTTIMEOUTEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 请求超时-ConnectTimeoutException
                reasonMsgId = R.string.request_timeout_connecttimeoutexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.SERVER_RESPONSE_TIMEOUT_SOCKETIMEOUTEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 服务器响应超时-SocketTimeoutException
                reasonMsgId = R.string.server_response_timeout_socketimeoutexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.IO_EXCEPTION_IOEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // IO异常-IOException
                reasonMsgId = R.string.io_exception_ioexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.PARAMETER_EXCEPTION_ILLEGALVALUEEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 参数异常-IllegalValueException
                reasonMsgId = R.string.parameter_exception_illegalvalueexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.FILE_CANNOT_FIND_EXCEPTION_FILENOTFOUNDEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 文件找不到异常-FileNotFoundException
                reasonMsgId = R.string.file_cannot_find_exception_filenotfoundexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.PROTOCOL_ERROR_CLLIENTPROTOCOLEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 协议错误-CllientProtocolException
                reasonMsgId = R.string.protocol_error_cllientprotocolexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.CIRCULAR_REDIRECTION_CIRCULAR_REDIRECTEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 循环重定向-CircularRedirectException
                reasonMsgId = R.string.circular_redirection_circular_redirectexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.NO_RESPONSE_FROM_SERVER_NOHTTPRESPONSEEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 服务器无响应-NoHttpResponseException
                reasonMsgId = R.string.no_response_from_server_nohttpresponseexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.RETURN_HTTP_CORRESPONDING_STATUS_CODE_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // 返回http对应状态码
                reasonMsgId = R.string.return_http_corresponding_status_code_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_RETURN_INFORMATION_IS_NOT_XML_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http返回信息不是xml
                reasonMsgId = R.string.http_return_information_is_not_xml_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.CGI_RETURNS_S_0_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // cgi返回s != '0'
                reasonMsgId = R.string.cgi_returns_s_0_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.XML_PARSING_FAILED_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // xml解析失败
                reasonMsgId = R.string.xml_parsing_failed_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_SSLEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // https异常-SSLException
                reasonMsgId = R.string.https_exception_sslexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_HANDSHAKEEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // https异常-HandShakeException
                reasonMsgId = R.string.https_exception_handshakeexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_KEYEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // https异常-KeyException
                reasonMsgId = R.string.https_exception_keyexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_PEERUNVERIFIEDEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // https异常-PeerUnverifiedException
                reasonMsgId = R.string.https_exception_peerunverifiedexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTPS_EXCEPTION_PROTOCOLEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // https异常-ProtocolException
                reasonMsgId = R.string.https_exception_protocolexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.SOCKET_ERROR_SOCKETEXCEPTION_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // socket错误-SocketException
                reasonMsgId = R.string.socket_error_socketexception_getvkey_getvbkey_network_error;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_network_error;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_101_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-101
                reasonMsgId = R.string.http_status_code_101_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_200_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-200
                reasonMsgId = R.string.http_status_code_200_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_307_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-307
                reasonMsgId = R.string.http_status_code_307_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_400_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-400
                reasonMsgId = R.string.http_status_code_400_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_401_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-401
                reasonMsgId = R.string.http_status_code_401_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_402_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-402
                reasonMsgId = R.string.http_status_code_402_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_403_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-403
                reasonMsgId = R.string.http_status_code_403_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_404_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-404
                reasonMsgId = R.string.http_status_code_404_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_405_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-405
                reasonMsgId = R.string.http_status_code_405_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_500_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-500
                reasonMsgId = R.string.http_status_code_500_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_501_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-501
                reasonMsgId = R.string.http_status_code_501_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_502_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-502
                reasonMsgId = R.string.http_status_code_502_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_503_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-503
                reasonMsgId = R.string.http_status_code_503_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_504_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-504
                reasonMsgId = R.string.http_status_code_504_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_505_GETVKEY_GETVBKEY_NETWORK_ERROR:
                // http状态码-505
                reasonMsgId = R.string.http_status_code_505_getvkey_getvbkey_network_error;
                solveMsgId = R.string.the_engineer_is_repairing_it_urgently_please_try_again_later_getvkey_getvbkey_network_error;
                showMsgId = R.string.background_server_busy_getvkey_getvbkey_network_error;
                break;
            case VideoErrorCode.FAILED_TO_DOWNLOAD_GETVKEY_OFFLINE_RETURN_FORMAT_OF_GETVKEY_GETVBKEY:
                // 离线下载getVkey解析失败
                reasonMsgId = R.string.failed_to_download_getvkey_offline_return_format_of_getvkey_getvbkey;
                solveMsgId = R.string.check_network_connection_and_try_again_return_format_of_getvkey_getvbkey;
                showMsgId = R.string.get_parameter_error_return_format_of_getvkey_getvbkey;
                break;
            case VideoErrorCode.ONLINE_PLAY_GETVKEY_PARSING_FAILED_RETURN_FORMAT_OF_GETVKEY_GETVBKEY:
                // 在线播放getVkey解析失败
                reasonMsgId = R.string.online_play_getvkey_parsing_failed_return_format_of_getvkey_getvbkey;
                solveMsgId = R.string.check_network_connection_and_try_again_return_format_of_getvkey_getvbkey;
                showMsgId = R.string.get_parameter_error_return_format_of_getvkey_getvbkey;
                break;
            case VideoErrorCode.CGI_PARAMETER_ERROR_CGI_CONTRACT_ERROR_TO_SERVER_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // cgi参数错误/cgi向服务器发包错误
                reasonMsgId = R.string.cgi_parameter_error_cgi_contract_error_to_server_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.CGI_RECEIVE_PACKAGE_ERROR_FROM_SERVER_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // cgi从服务器接包错误
                reasonMsgId = R.string.cgi_receive_package_error_from_server_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.CGI_UNPACKING_FROM_SERVER_ERROR_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // cgi从服务器解包错误
                reasonMsgId = R.string.cgi_unpacking_from_server_error_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.CGI_CONNECTION_SERVER_NETWORK_ERROR_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // cgi连接服务器网络错误
                reasonMsgId = R.string.cgi_connection_server_network_error_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.CGI_CONNECTION_SERVICE_TIMEOUT_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // cgi连接服务超时
                reasonMsgId = R.string.cgi_connection_service_timeout_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.CGI_ACCESS_SERVICE_UNKNOWN_ERROR_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // cgi访问服务未知错误
                reasonMsgId = R.string.cgi_access_service_unknown_error_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.CGI_SYSTEM_ERROR_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // cgi系统错误
                reasonMsgId = R.string.cgi_system_error_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.NUMBER_OF_VIDS_OUT_OF_RANGE_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // vid个数超出范围
                reasonMsgId = R.string.number_of_vids_out_of_range_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.CGI_ACCESS_SERVICE_FAILED_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // cgi访问服务失败
                reasonMsgId = R.string.cgi_access_service_failed_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.THE_INPUT_PARAMETER_VID_FORMAT_AND_FILENAME_DO_NOT_MATCH_ILLEGAL_VIDEO_VIDEO_TIMEOUT_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 传入参数vid,format和filename不匹配 vid不合法（video超时）
                reasonMsgId = R.string.the_input_parameter_vid_format_and_filename_do_not_match_illegal_video_video_timeout_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_VIDEO_VIDEO_TIMEOUT_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // vid不合法（video超时）
                reasonMsgId = R.string.illegal_video_video_timeout_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_VIDEO_STATUS_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 视频状态不合法
                reasonMsgId = R.string.illegal_video_status_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_DEFINITION_FORMAT_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 清晰度格式不合法
                reasonMsgId = R.string.illegal_definition_format_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ERROR_IN_PAID_SERVICE_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 付费服务出错
                reasonMsgId = R.string.error_in_paid_service_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.check_network_connection_and_try_again_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_SPEED_FORMAT_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 速度格式不合法
                reasonMsgId = R.string.illegal_speed_format_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_FILE_NAME_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 文件名不合法
                reasonMsgId = R.string.illegal_file_name_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_FORMAT_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // format不合法
                reasonMsgId = R.string.illegal_format_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_FILE_STATUS_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 文件状态不合法
                reasonMsgId = R.string.illegal_file_status_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.FORMAT_LIST_IS_EMPTY_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // format列表为空
                reasonMsgId = R.string.format_list_is_empty_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_CONSTRUCT_KEY_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 构造key失败
                reasonMsgId = R.string.failed_to_construct_key_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_CONSTRUCT_SHA_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 构造sha失败
                reasonMsgId = R.string.failed_to_construct_sha_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.NO_SUPPORT_FOR_HLS_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 不支持HLS
                reasonMsgId = R.string.no_support_for_hls_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_GENERATE_FILENAME_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 生成filename失败了
                reasonMsgId = R.string.failed_to_generate_filename_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.IDX_OUT_OF_RANGE_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // idx超出范围
                reasonMsgId = R.string.idx_out_of_range_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_CONSTRUCT_FILE_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 构造文件失败
                reasonMsgId = R.string.failed_to_construct_file_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_GET_M3U8_FILENAME_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 获取m3u8文件名失败
                reasonMsgId = R.string.failed_to_get_m3u8_filename_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.FAILED_TO_GENERATE_HLS_KEY_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 生成hls key失败
                reasonMsgId = R.string.failed_to_generate_hls_key_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.NON_GENUINE_TENCENT_VIDEO_APP_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 非正版腾讯视频app
                reasonMsgId = R.string.non_genuine_tencent_video_app_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.error_getting_video_information_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.COPYRIGHT_RESTRICTIONS_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 版权限制
                reasonMsgId = R.string.copyright_restrictions_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.REFERER_RESTRICTIONS_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // referer限制
                reasonMsgId = R.string.referer_restrictions_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.QZONE_PERMISSION_RESTRICTIONS_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // qzone权限限制
                reasonMsgId = R.string.qzone_permission_restrictions_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.the_program_is_temporarily_unavailable_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.PAYMENT_RESTRICTION_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 付费限制
                reasonMsgId = R.string.payment_restriction_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.you_are_watching_paid_programs_please_watch_after_purchase_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ACCESS_IP_IS_BLACKLIST_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // 访问ip是黑名单
                reasonMsgId = R.string.access_ip_is_blacklist_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.limited_viewing_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.CGI_ACCESS_KEY_INCORRECT_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // CGI访问key不正确
                reasonMsgId = R.string.cgi_access_key_incorrect_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.CGI_ACCESS_FREQUENCY_INSURANCE_AND_GETVKEY_GETVBKEY_RETURN_BACKGROUND_ERROR_CODE:
                // CGI访问频率险资和
                reasonMsgId = R.string.cgi_access_frequency_insurance_and_getvkey_getvbkey_return_background_error_code;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_getvkey_getvbkey_return_background_error_code;
                showMsgId = R.string.get_parameter_error_getvkey_getvbkey_return_background_error_code;
                break;
            case VideoErrorCode.ILLEGAL_INPUT_PARAMETER_LIVEINFO_NETWORK_LAYER_ERROR:
                // 输入参数非法
                reasonMsgId = R.string.illegal_input_parameter_liveinfo_network_layer_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_network_layer_error;
                showMsgId = R.string.get_parameter_error_liveinfo_network_layer_error;
                break;
            case VideoErrorCode.CGI_ERROR_LIVEINFO_NETWORK_LAYER_ERROR:
                // CGI错误
                reasonMsgId = R.string.cgi_error_liveinfo_network_layer_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_network_layer_error;
                showMsgId = R.string.get_parameter_error_liveinfo_network_layer_error;
                break;
            case VideoErrorCode.UNKNOWN_ERROR_LIVEINFO_NETWORK_LAYER_ERROR:
                // 未知错误
                reasonMsgId = R.string.unknown_error_liveinfo_network_layer_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_network_layer_error;
                showMsgId = R.string.get_parameter_error_liveinfo_network_layer_error;
                break;
            case VideoErrorCode.NETWORK_ERROR_LIVEINFO_NETWORK_LAYER_ERROR:
                // 网络错误
                reasonMsgId = R.string.network_error_liveinfo_network_layer_error;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_network_layer_error;
                showMsgId = R.string.get_parameter_error_liveinfo_network_layer_error;
                break;
            case VideoErrorCode.INCORRECT_INFO_RETURNED_LIVEINFO_NETWORK_LAYER_ERROR:
                // 返回的info不对
                reasonMsgId = R.string.incorrect_info_returned_liveinfo_network_layer_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_network_layer_error;
                showMsgId = R.string.get_parameter_error_liveinfo_network_layer_error;
                break;
            case VideoErrorCode.JSON_PARSING_ERROR_PARSING_ERROR:
                // json解析错误
                reasonMsgId = R.string.json_parsing_error_parsing_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_parsing_error;
                showMsgId = R.string.get_parameter_error_parsing_error;
                break;
            case VideoErrorCode.CHANNEL_ID_NOT_FOUND_LIVEINFO_BACKGROUND_RETURN:
                // 查不到频道id
                reasonMsgId = R.string.channel_id_not_found_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.live_id_error_liveinfo_background_return;
                break;
            case VideoErrorCode.RESTRICTED_VIEWING_IN_NON_KEY_AREAS_LIVEINFO_BACKGROUND_RETURN:
                // 非重点区域限制观看
                reasonMsgId = R.string.restricted_viewing_in_non_key_areas_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.BANDWIDTH_REACHES_A_CERTAIN_PROPORTION_LIMITING_VIEWING_IN_NON_KEY_AREAS_LIVEINFO_BACKGROUND_RETURN:
                // 带宽达到一定比例，限制非重点区域观看
                reasonMsgId = R.string.bandwidth_reaches_a_certain_proportion_limiting_viewing_in_non_key_areas_liveinfo_background_return;
                solveMsgId = R.string.please_try_again_later_liveinfo_background_return;
                showMsgId = R.string.too_many_people_are_watching_the_current_program_liveinfo_background_return;
                break;
            case VideoErrorCode.BANDWIDTH_IS_FULL_AS_A_WHOLE_LIMIT_VIEWING_LIVEINFO_BACKGROUND_RETURN:
                // 带宽整体已满，限制观看
                reasonMsgId = R.string.bandwidth_is_full_as_a_whole_limit_viewing_liveinfo_background_return;
                solveMsgId = R.string.please_try_again_later_liveinfo_background_return;
                showMsgId = R.string.too_many_people_are_watching_the_current_program_liveinfo_background_return;
                break;
            case VideoErrorCode.NO_BROADCASTING_COPYRIGHT_IN_THE_REGION_LIVEINFO_BACKGROUND_RETURN:
                // 所在地区无播放版权
                reasonMsgId = R.string.no_broadcasting_copyright_in_the_region_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.CHANNEL_SIGNAL_INTERRUPT_LIVEINFO_BACKGROUND_RETURN:
                // 频道信号中断
                reasonMsgId = R.string.channel_signal_interrupt_liveinfo_background_return;
                solveMsgId = R.string.please_exit_and_try_again_liveinfo_background_return;
                showMsgId = R.string.live_signal_interrupt_liveinfo_background_return;
                break;
            case VideoErrorCode.PROGRAM_NOT_STARTED_LIVEINFO_BACKGROUND_RETURN:
                // 节目未开始
                reasonMsgId = R.string.program_not_started_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_current_program_has_not_started_liveinfo_background_return;
                break;
            case VideoErrorCode.PROGRAM_ENDED_LIVEINFO_BACKGROUND_RETURN:
                // 节目已结束
                reasonMsgId = R.string.program_ended_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_current_program_has_ended_liveinfo_background_return;
                break;
            case VideoErrorCode.THE_CURRENT_CHANNEL_HAS_REACHED_THE_MAXIMUM_NUMBER_OF_PEOPLE_LIVEINFO_BACKGROUND_RETURN:
                // 当前频道达到人数上限
                reasonMsgId = R.string.the_current_channel_has_reached_the_maximum_number_of_people_liveinfo_background_return;
                solveMsgId = R.string.please_try_again_later_liveinfo_background_return;
                showMsgId = R.string.too_many_people_are_watching_the_current_program_liveinfo_background_return;
                break;
            case VideoErrorCode.FORCE_NEW_LIVE_LIVEINFO_BACKGROUND_RETURN:
                // 强制新直播
                reasonMsgId = R.string.force_new_live_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.FORCE_CONTROL_P2P_LIVEINFO_BACKGROUND_RETURN:
                // 强制控件P2P
                reasonMsgId = R.string.force_control_p2p_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.NO_COPYRIGHT_IN_THE_CURRENT_PERIOD_OF_THE_PROGRAM_LIVEINFO_BACKGROUND_RETURN:
                // 节目当前时段无版权
                reasonMsgId = R.string.no_copyright_in_the_current_period_of_the_program_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.ONLY_PC_WIN_PLATFORM_LOADS_CONTROL_AND_PLAYS_IT_WITH_P2P_LIVEINFO_BACKGROUND_RETURN:
                // 仅PC（win平台）加载控件，用P2P播放
                reasonMsgId = R.string.only_pc_win_platform_loads_control_and_plays_it_with_p2p_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.ERROR_IN_CARRYING_PARAMETER_FORMAT_LIVEINFO_BACKGROUND_RETURN:
                // 携带参数格式出错
                reasonMsgId = R.string.error_in_carrying_parameter_format_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.get_parameter_error_liveinfo_background_return;
                break;
            case VideoErrorCode.UNKNOWN_VIDEO_STREAM_TYPE_REQUESTED_LIVEINFO_BACKGROUND_RETURN:
                // 请求的视频流类型未知
                reasonMsgId = R.string.unknown_video_stream_type_requested_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.get_parameter_error_liveinfo_background_return;
                break;
            case VideoErrorCode.FOR_INTERNAL_LIVE_BROADCAST_ONLY_FOR_INTERNAL_LIVE_BROADCAST_OF_THE_COMPANY_LIVEINFO_BACKGROUND_RETURN:
                // （内部直播用）仅公司内部直播
                reasonMsgId = R.string.for_internal_live_broadcast_only_for_internal_live_broadcast_of_the_company_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.get_parameter_error_liveinfo_background_return;
                break;
            case VideoErrorCode.PC_WEB_INVALID_REFERER_LIVEINFO_BACKGROUND_RETURN:
                // PC web 无效 referer
                reasonMsgId = R.string.pc_web_invalid_referer_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.get_parameter_error_liveinfo_background_return;
                break;
            case VideoErrorCode.ONLY_INTERNAL_LIVE_BROADCAST_OF_THE_COMPANY_USERS_ARE_NOT_ON_THE_WHITE_LIST_LIVEINFO_BACKGROUND_RETURN:
                // 仅公司内部直播，用户不在白名单
                reasonMsgId = R.string.only_internal_live_broadcast_of_the_company_users_are_not_on_the_white_list_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.UNKNOWN_APP_SOURCE_LIVEINFO_BACKGROUND_RETURN:
                // 未知app来源
                reasonMsgId = R.string.unknown_app_source_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_the_official_channel_to_download_the_app_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.FOR_FLASH_FLASH_PLAYER_THE_SOURCE_PAGE_IS_NOT_IN_THE_WHITE_LIST_LIVEINFO_BACKGROUND_RETURN:
                // （flash用）flash播放器，来源页面不在白名单内
                reasonMsgId = R.string.for_flash_flash_player_the_source_page_is_not_in_the_white_list_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.INVALID_COMMAND_WORD_LIVEINFO_BACKGROUND_RETURN:
                // 无效的命令字
                reasonMsgId = R.string.invalid_command_word_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.get_parameter_error_liveinfo_background_return;
                break;
            case VideoErrorCode.EXCLUSIVE_USE_OF_LIVE_EDUCATION_FAILED_TO_VERIFY_THE_RIGHT_LIVEINFO_BACKGROUND_RETURN:
                // 教育直播专用，验权失败
                reasonMsgId = R.string.exclusive_use_of_live_education_failed_to_verify_the_right_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.get_parameter_error_liveinfo_background_return;
                break;
            case VideoErrorCode.FAILED_TO_REQUEST_PAYMENT_AUTHENTICATION_MODULE_NETWORK_TIMEOUT_OR_RESOLUTION_ERROR_LIVEINFO_BACKGROUND_RETURN:
                // 请求付费鉴权模块失败（网络超时或解析出错）
                reasonMsgId = R.string.failed_to_request_payment_authentication_module_network_timeout_or_resolution_error_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.SNG_PERMISSION_VERIFICATION_TIMEOUT_LIVEINFO_BACKGROUND_RETURN:
                // sng权限验证超时
                reasonMsgId = R.string.sng_permission_verification_timeout_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.NO_USER_LOGIN_INFORMATION_THE_LOGIN_COOKIE_LACKS_REQUIRED_FIELDS_LIVEINFO_BACKGROUND_RETURN:
                // 无用户登录信息（登陆态cookie缺少必填字段）
                reasonMsgId = R.string.no_user_login_information_the_login_cookie_lacks_required_fields_liveinfo_background_return;
                solveMsgId = R.string.please_login_again_at_my_liveinfo_background_return;
                showMsgId = R.string.wrong_login_information_liveinfo_background_return;
                break;
            case VideoErrorCode.VIP_VERIFICATION_TIMEOUT_LIVEINFO_BACKGROUND_RETURN:
                // vip验证超时
                reasonMsgId = R.string.vip_verification_timeout_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.PTLOGIN_VERIFICATION_TIMEOUT_LIVEINFO_BACKGROUND_RETURN:
                // ptlogin验证超时
                reasonMsgId = R.string.ptlogin_verification_timeout_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.PTLOGIN_VALIDATION_FAILED_LIVEINFO_BACKGROUND_RETURN:
                // ptlogin验证失败
                reasonMsgId = R.string.ptlogin_validation_failed_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.L5_ERROR_LOGIN_VERIFICATION_FAILED_LIVEINFO_BACKGROUND_RETURN:
                // l5出错，登录验证失败
                reasonMsgId = R.string.l5_error_login_verification_failed_liveinfo_background_return;
                solveMsgId = R.string.please_login_again_at_my_liveinfo_background_return;
                showMsgId = R.string.wrong_login_information_liveinfo_background_return;
                break;
            case VideoErrorCode.CURRENT_PROGRAM_OUTSTANDING_LIVEINFO_BACKGROUND_RETURN:
                // 当前节目未付清
                reasonMsgId = R.string.current_program_outstanding_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.you_are_watching_paid_programs_please_watch_after_purchase_liveinfo_background_return;
                break;
            case VideoErrorCode.QQ_LOGIN_VERIFICATION_FAILED_LIVEINFO_BACKGROUND_RETURN:
                // qq登录验证失败
                reasonMsgId = R.string.qq_login_verification_failed_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.CKEY_VERIFICATION_FAILED_LIVEINFO_BACKGROUND_RETURN:
                // CKEY验证失败
                reasonMsgId = R.string.ckey_verification_failed_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.PAYMENT_VERIFICATION_REQUEST_RETRY_TIMEOUT_LIVEINFO_BACKGROUND_RETURN:
                // 付费验证请求重试超时
                reasonMsgId = R.string.payment_verification_request_retry_timeout_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.PAYMENT_VERIFICATION_REQUEST_WITHOUT_UIN_FIELD_LIVEINFO_BACKGROUND_RETURN:
                // 付费验证请求未带uin字段
                reasonMsgId = R.string.payment_verification_request_without_uin_field_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.PAYMENT_VERIFICATION_RESULT_PARSING_ERROR_LIVEINFO_BACKGROUND_RETURN:
                // 付费验证结果解析错误
                reasonMsgId = R.string.payment_verification_result_parsing_error_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.PTLOGIN_AUTHENTICATION_RETRY_TIMEOUT_LIVEINFO_BACKGROUND_RETURN:
                // ptlogin验证重试超时
                reasonMsgId = R.string.ptlogin_authentication_retry_timeout_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.PTLONGIN_FAILED_TO_VERIFY_INITIALIZATION_REQUEST_LIVEINFO_BACKGROUND_RETURN:
                // ptlongin验证初始化请求失败
                reasonMsgId = R.string.ptlongin_failed_to_verify_initialization_request_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.PTLOGIN_VALIDATION_RESULT_PARSING_ERROR_LOGIN_VALIDATION_FAILED_LIVEINFO_BACKGROUND_RETURN:
                // ptlogin验证结果解析错误，登录验证失败
                reasonMsgId = R.string.ptlogin_validation_result_parsing_error_login_validation_failed_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.ILLEGAL_HEAD_LENGTH_LIVEINFO_BACKGROUND_RETURN:
                // 非法头部长度
                reasonMsgId = R.string.illegal_head_length_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.NAME_SERVICE_ERROR_LIVEINFO_BACKGROUND_RETURN:
                // 名字服务出错
                reasonMsgId = R.string.name_service_error_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.PROTOBUF_SERIALIZATION_ERROR_LIVEINFO_BACKGROUND_RETURN:
                // protobuf序列化出错
                reasonMsgId = R.string.protobuf_serialization_error_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.UTOPIA_AUTHORITY_VERIFICATION_FAILED_LIVEINFO_BACKGROUND_RETURN:
                // 乌托邦权限验证失败
                reasonMsgId = R.string.utopia_authority_verification_failed_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.NOT_LOGGED_INTO_THE_UTOPIAN_SYSTEM_LIVEINFO_BACKGROUND_RETURN:
                // 未登录乌托邦系统
                reasonMsgId = R.string.not_logged_into_the_utopian_system_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.UTOPIA_VERIFICATION_TIMEOUT_INTERNAL_SYSTEM_VERIFICATION_FAILED_LIVEINFO_BACKGROUND_RETURN:
                // 乌托邦验证超时，内部系统验证失败
                reasonMsgId = R.string.utopia_verification_timeout_internal_system_verification_failed_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.member_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.THE_NUMBER_OF_TRIALS_REACHED_THE_UPPER_LIMIT_LIVEINFO_BACKGROUND_RETURN:
                // 试看次数达到上限
                reasonMsgId = R.string.the_number_of_trials_reached_the_upper_limit_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_number_of_trials_reached_the_upper_limit_liveinfo_background_return;
                break;
            case VideoErrorCode.TRY_TO_SEE_THE_FAILURE_OF_TECHNOLOGY_AUTHENTICATION_LIVEINFO_BACKGROUND_RETURN:
                // 试看技术鉴权失败
                reasonMsgId = R.string.try_to_see_the_failure_of_technology_authentication_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.try_failure_liveinfo_background_return;
                break;
            case VideoErrorCode.TRY_COUNT_FAILED_UNABLE_TO_TRY_LIVEINFO_BACKGROUND_RETURN:
                // 试看计数失败，无法试看
                reasonMsgId = R.string.try_count_failed_unable_to_try_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.try_failure_liveinfo_background_return;
                break;
            case VideoErrorCode.WECHAT_LOGIN_VERIFICATION_FAILED_LIVEINFO_BACKGROUND_RETURN:
                // 微信登录验证失败
                reasonMsgId = R.string.wechat_login_verification_failed_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.account_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.WECHAT_LOGIN_VERIFICATION_TIMEOUT_LIVEINFO_BACKGROUND_RETURN:
                // 微信登录验证超时
                reasonMsgId = R.string.wechat_login_verification_timeout_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.account_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.WECHAT_INTERNAL_BILL_VERIFICATION_TIMEOUT_LIVEINFO_BACKGROUND_RETURN:
                // 微信内部票据验证超时
                reasonMsgId = R.string.wechat_internal_bill_verification_timeout_liveinfo_background_return;
                solveMsgId = R.string.check_network_connection_and_try_again_liveinfo_background_return;
                showMsgId = R.string.account_authentication_failed_liveinfo_background_return;
                break;
            case VideoErrorCode.THERE_ARE_CURRENTLY_NO_LIVE_PROGRAMS_LIVEINFO_BACKGROUND_RETURN:
                // 当前没有正在直播的节目
                reasonMsgId = R.string.there_are_currently_no_live_programs_liveinfo_background_return;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_liveinfo_background_return;
                showMsgId = R.string.the_program_is_temporarily_unavailable_liveinfo_background_return;
                break;
            case VideoErrorCode.REQUEST_PARAMETER_ERROR_OLD_VERSION_1:
                // 请求参数错误
                reasonMsgId = R.string.request_parameter_error_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.USERS_HAVE_NOT_OPENED_CORRESPONDING_PLATFORMS_FRIENDS_SPACE_MICROBLOG_OLD_VERSION:
                // 用户没有开通对应的平台（朋友、空间、微博...）
                reasonMsgId = R.string.users_have_not_opened_corresponding_platforms_friends_space_microblog_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.no_corresponding_function_permission_old_version;
                break;
            case VideoErrorCode.ILLEGAL_OPERATION_USUALLY_UNAUTHORIZED_OPERATION_OLD_VERSION:
                // 非法操作，通常是进行了不被授权的操作
                reasonMsgId = R.string.illegal_operation_usually_unauthorized_operation_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.no_permission_to_do_this_old_version;
                break;
            case VideoErrorCode.THE_USER_HAS_NO_LOGIN_STATUS_THE_REASONS_MAY_BE_1_THE_USER_DID_NOT_REGISTER_WITH_THE_PLATFORM_NO_QQ_SPACE_FRIENDS_MICROBLOG_ETC_2_OPENKEY_EXPIRED_OLD_VERSION:
                // 用户没有登录态。原因可能有：1）用户没有到该平台注册（没有注册QQ空间，朋友，微博等）；2）openkey过期。
                reasonMsgId = R.string.the_user_has_no_login_status_the_reasons_may_be_1_the_user_did_not_register_with_the_platform_no_qq_space_friends_microblog_etc_2_openkey_expired_old_version;
                solveMsgId = R.string.please_confirm_and_log_in_again_old_version;
                showMsgId = R.string.account_login_status_is_abnormal_old_version;
                break;
            case VideoErrorCode.ACCOUNT_BLOCKED_OLD_VERSION:
                // 账户被冻结
                reasonMsgId = R.string.account_blocked_old_version;
                solveMsgId = R.string.please_confirm_and_log_in_again_old_version;
                showMsgId = R.string.account_number_blocked_old_version;
                break;
            case VideoErrorCode.INSUFFICIENT_ACCOUNT_BALANCE_OLD_VERSION:
                // 账户余额不足
                reasonMsgId = R.string.insufficient_account_balance_old_version;
                solveMsgId = R.string.please_confirm_and_recharge_old_version;
                showMsgId = R.string.insufficient_account_balance_old_version;
                break;
            case VideoErrorCode.USERS_DON_T_HAVE_TENCENT_FRIENDS_OLD_VERSION:
                // 用户没有开通腾讯朋友
                reasonMsgId = R.string.users_don_t_have_tencent_friends_old_version;
                solveMsgId = R.string.please_open_and_try_again_old_version;
                showMsgId = R.string.you_don_t_have_tencent_friends_old_version;
                break;
            case VideoErrorCode.THE_USER_HAS_NOT_OPENED_QQ_SPACE_OLD_VERSION:
                // 用户没有开通QQ空间
                reasonMsgId = R.string.the_user_has_not_opened_qq_space_old_version;
                solveMsgId = R.string.please_open_and_try_again_old_version;
                showMsgId = R.string.you_didn_t_open_qq_space_old_version;
                break;
            case VideoErrorCode.CDKEY_DOES_NOT_EXIST_OLD_VERSION:
                // cdkey不存在
                reasonMsgId = R.string.cdkey_does_not_exist_old_version;
                solveMsgId = R.string.please_check_and_try_again_old_version;
                showMsgId = R.string.the_cdkey_does_not_exist_old_version;
                break;
            case VideoErrorCode.THERE_IS_NO_BINDING_RELATIONSHIP_BETWEEN_THE_USER_AND_CDKEY_OR_THE_GIFT_HAS_BEEN_GIVEN_OLD_VERSION:
                // 用户和cdkey不存在绑定关系，或礼品赠送完毕
                reasonMsgId = R.string.there_is_no_binding_relationship_between_the_user_and_cdkey_or_the_gift_has_been_given_old_version;
                solveMsgId = R.string.please_replace_cdkey_and_try_again_old_version;
                showMsgId = R.string.unable_to_use_the_cdkey_old_version;
                break;
            case VideoErrorCode.LIMITED_PARTICIPATION_OLD_VERSION:
                // 参加活动受限
                reasonMsgId = R.string.limited_participation_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.unable_to_participate_in_the_event_old_version;
                break;
            case VideoErrorCode.THE_LOGIN_VERIFICATION_OF_THE_MULTI_ZONE_SERVICE_SELECTION_PAGE_FAILED_BECAUSE_THE_USER_LOGIN_RECORD_DOES_NOT_EXIST_OR_THE_LOGIN_HAS_TIMED_OUT_OLD_VERSION:
                // 多区选服页面登录验证失败，原因：用户登录记录不存在，或登录已超时。
                reasonMsgId = R.string.the_login_verification_of_the_multi_zone_service_selection_page_failed_because_the_user_login_record_does_not_exist_or_the_login_has_timed_out_old_version;
                solveMsgId = R.string.please_confirm_and_log_in_again_old_version;
                showMsgId = R.string.account_login_status_is_abnormal_old_version;
                break;
            case VideoErrorCode.INVALID_REQUEST_PARAMETER_OLD_VERSION:
                // 请求参数无效。
                reasonMsgId = R.string.invalid_request_parameter_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.APPID_IN_REQUEST_DOES_NOT_EXIST_OLD_VERSION:
                // 请求中的appid不存在
                reasonMsgId = R.string.appid_in_request_does_not_exist_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.NO_API_ACCESS_OLD_VERSION:
                // 无API访问权限。
                reasonMsgId = R.string.no_api_access_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.no_permission_to_do_this_old_version;
                break;
            case VideoErrorCode.IP_DOES_NOT_HAVE_PERMISSION_OLD_VERSION:
                // IP没有权限。
                reasonMsgId = R.string.ip_does_not_have_permission_old_version;
                solveMsgId = R.string.in_case_of_misjudgment_please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.unable_to_provide_services_to_your_region_due_to_copyright_restrictions_old_version;
                break;
            case VideoErrorCode.SIGNATURE_PARAMETER_SIG_VERIFICATION_FAILED_OLD_VERSION:
                // 签名参数sig校验失败。
                reasonMsgId = R.string.signature_parameter_sig_verification_failed_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.parameter_verification_failed_old_version;
                break;
            case VideoErrorCode.ACCESS_FREQUENCY_OUT_OF_LIMIT_OLD_VERSION:
                // 访问频率超限
                reasonMsgId = R.string.access_frequency_out_of_limit_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.access_frequency_exceeds_system_limit_old_version;
                break;
            case VideoErrorCode.ILLEGAL_AGREEMENT_OLD_VERSION:
                // 协议不合法
                reasonMsgId = R.string.illegal_agreement_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.REQUEST_IS_LIMITED_USUALLY_SECURITY_AUDIT_FAILS_OLD_VERSION:
                // 请求受限，通常是安全审计没通过
                reasonMsgId = R.string.request_is_limited_usually_security_audit_fails_old_version;
                solveMsgId = R.string.please_go_to_qq_security_center_to_check_your_account_number_old_version;
                showMsgId = R.string.account_authentication_failed_for_security_reasons_old_version;
                break;
            case VideoErrorCode.API_DOES_NOT_EXIST_OLD_VERSION:
                // API不存在。
                reasonMsgId = R.string.api_does_not_exist_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.WHEN_DEBUGGING_OPENAPI_IN_THE_TEST_ENVIRONMENT_THE_OPENID_CORRESPONDING_TO_THE_QQ_NUMBER_OF_THE_NON_DEBUGGER_IS_PASSED_IN_AND_THIS_RETURN_CODE_WILL_BE_RETURNED_OLD_VERSION:
                // 在测试环境中进行OpenAPI调试时，传入的是非调试者QQ号对应的OpenID ，将会返回本返回码
                reasonMsgId = R.string.when_debugging_openapi_in_the_test_environment_the_openid_corresponding_to_the_qq_number_of_the_non_debugger_is_passed_in_and_this_return_code_will_be_returned_old_version;
                solveMsgId = R.string.please_change_the_qq_login_of_the_debugger_old_version;
                showMsgId = R.string.this_openapi_is_for_debuggers_only_old_version;
                break;
            case VideoErrorCode.SYSTEM_INTERNAL_ERROR_OLD_VERSION:
                // 系统内部错误
                reasonMsgId = R.string.system_internal_error_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.INVALID_ACCESS_TOKEN_VUSESSION_OLD_VERSION:
                // access_token/vusession无效
                reasonMsgId = R.string.invalid_access_token_vusession_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.THE_OPENAPI_CALLED_BY_THE_APPLICATION_IS_NOT_AUTHORIZED_BY_THE_USER_OLD_VERSION:
                // 应用调用的OpenAPI未经用户授权。
                reasonMsgId = R.string.the_openapi_called_by_the_application_is_not_authorized_by_the_user_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.unauthorized_interface_called_old_version;
                break;
            case VideoErrorCode.ACCESS_TOKEN_HAS_BEEN_REVOKED_PLEASE_GET_ACCESS_TOKEN_AGAIN_OLD_VERSION:
                // access_token已废除，请重新获取access_token。
                reasonMsgId = R.string.access_token_has_been_revoked_please_get_access_token_again_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.account_login_status_is_abnormal_old_version;
                break;
            case VideoErrorCode.OPENID_IS_ILLEGAL_OLD_VERSION:
                // openid不合法。
                reasonMsgId = R.string.openid_is_illegal_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.OPENKEY_IS_ILLEGAL_OLD_VERSION:
                // openkey不合法。
                reasonMsgId = R.string.openkey_is_illegal_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
//            case VideoErrorCode.OPENID_OR_OPENKEY_VALIDATION_FAILED_OLD_VERSION:
//                // openid或者openkey验证失败。
//                reasonMsgId = R.string.openid_or_openkey_validation_failed_old_version;
//                solveMsgId = R.string.please_login_again_at_my_old_version;
//                showMsgId = R.string.request_parameter_error_old_version;
//                break;
            case VideoErrorCode.SYSTEM_ERROR_FOR_OPENAPI_RETRYABLE_OLD_VERSION_58:
                // OpenAPI的系统错误（可重试）
                reasonMsgId = R.string.system_error_for_openapi_retryable_old_version;
                solveMsgId = R.string.please_try_again_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.SYSTEM_ERROR_FOR_OPENAPI_RETRYABLE_OLD_VERSION_60:
                // OpenAPI的系统错误（可重试）
                reasonMsgId = R.string.system_error_for_openapi_retryable_old_version;
                solveMsgId = R.string.please_try_again_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.SYSTEM_ERROR_FOR_OPENAPI_RETRYABLE_OLD_VERSION_65:
                // OpenAPI的系统错误（可重试）
                reasonMsgId = R.string.system_error_for_openapi_retryable_old_version;
                solveMsgId = R.string.please_try_again_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.OPENID_AND_ACCESS_TOKEN_DO_NOT_MATCH_OLD_VERSION:
                // openid和access_token不匹配
                reasonMsgId = R.string.openid_and_access_token_do_not_match_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
//            case VideoErrorCode.THIS_RETURN_CODE_INDICATES_THAT_THE_USER_HAS_MODIFIED_THE_QQ_PASSWORD_RESULTING_IN_THE_FAILURE_OF_ACCESS_TOKEN_AND_NEEDS_TO_GUIDE_THE_USER_TO_LOG_IN_AGAIN_OLD_VERSION:
//                // 此返回码表示用户修改了QQ密码，导致Access Token失效，需要引导用户重新登陆。
//                reasonMsgId = R.string.this_return_code_indicates_that_the_user_has_modified_the_qq_password_resulting_in_the_failure_of_access_token_and_needs_to_guide_the_user_to_log_in_again_old_version;
//                solveMsgId = R.string.please_confirm_and_log_in_again_old_version;
//                showMsgId = R.string.your_account_password_has_been_modified_old_version;
//                break;
            case VideoErrorCode.REQUEST_PARAMETER_ERROR_OLD_VERSION_201:
                // 请求参数错误
                reasonMsgId = R.string.request_parameter_error_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.ACCESS_TOKEN_FREQUENCY_LIMIT_IN_LIVING_ROOM_OLD_VERSION:
                // 客厅access_token频率限制
                reasonMsgId = R.string.access_token_frequency_limit_in_living_room_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.SYSTEM_ERROR_OLD_VERSION:
                // 系统错误
                reasonMsgId = R.string.system_error_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.INVALID_LIVING_ROOM_APPID_OLD_VERSION:
                // 客厅appid无效
                reasonMsgId = R.string.invalid_living_room_appid_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.LIVING_ROOM_APPID_STATUS_IS_ABNORMAL_OLD_VERSION:
                // 客厅appid状态异常
                reasonMsgId = R.string.living_room_appid_status_is_abnormal_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.SERVER_IP_RESTRICTIONS_OLD_VERSION:
                // 服务器ip限制
                reasonMsgId = R.string.server_ip_restrictions_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.INVALID_ACCESS_OU_TOKEN_OLD_VERSION:
                // access_token无效
                reasonMsgId = R.string.invalid_access_ou_token_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.LIVING_ROOM_ACCESS_OU_TOKEN_EXPIRED_OLD_VERSION:
                // 客厅access_token过期
                reasonMsgId = R.string.living_room_access_ou_token_expired_old_version;
                solveMsgId = R.string.please_login_again_at_my_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.CONDITIONAL_ERROR_OLD_VERSION:
                // 条件错误
                reasonMsgId = R.string.conditional_error_old_version;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_old_version;
                showMsgId = R.string.request_parameter_error_old_version;
                break;
            case VideoErrorCode.UNKNOWN_ERROR_BUSINESS_SIDE_LOGIC_ERROR:
                // 未知错误
                reasonMsgId = R.string.unknown_error_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.INVALID_PARAMETER_BUSINESS_SIDE_LOGIC_ERROR:
                // 无效参数
                reasonMsgId = R.string.invalid_parameter_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_ALLOCATE_SPACE_BUSINESS_SIDE_LOGIC_ERROR:
                // 分配空间失败
                reasonMsgId = R.string.failed_to_allocate_space_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.INVALID_TPT_FILE_BUSINESS_SIDE_LOGIC_ERROR:
                // 无效tpt文件
                reasonMsgId = R.string.invalid_tpt_file_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.INVALID_FILE_TYPE_BUSINESS_SIDE_LOGIC_ERROR:
                // 无效文件类型
                reasonMsgId = R.string.invalid_file_type_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.SEEK_FILE_OPERATION_FAILED_BUSINESS_SIDE_LOGIC_ERROR:
                // seek文件操作失败
                reasonMsgId = R.string.seek_file_operation_failed_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.INVALID_FILE_DATA_BUSINESS_SIDE_LOGIC_ERROR:
                // 无效文件数据
                reasonMsgId = R.string.invalid_file_data_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.SOCKET_INFORMATION_EXISTS_BUSINESS_SIDE_LOGIC_ERROR:
                // 套接字信息存在
                reasonMsgId = R.string.socket_information_exists_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.SOCKET_INFORMATION_DOES_NOT_EXIST_BUSINESS_SIDE_LOGIC_ERROR:
                // 套接字信息不存在
                reasonMsgId = R.string.socket_information_does_not_exist_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_VERIFY_P2P_DOWNLOAD_DATA_FROM_TPT_BUSINESS_SIDE_LOGIC_ERROR:
                // 从Tpt里面校验P2P下载的数据失败
                reasonMsgId = R.string.failed_to_verify_p2p_download_data_from_tpt_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_VERIFY_LOCAL_BUFFER_DATA_FROM_TPT_BUSINESS_SIDE_LOGIC_ERROR:
                // 从Tpt里面校验本地缓冲的数据失败
                reasonMsgId = R.string.failed_to_verify_local_buffer_data_from_tpt_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_THREAD_BUSINESS_SIDE_LOGIC_ERROR:
                // 创建线程失败
                reasonMsgId = R.string.failed_to_create_thread_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_CONDITION_VARIABLE_BUSINESS_SIDE_LOGIC_ERROR:
                // 创建条件变量失败
                reasonMsgId = R.string.failed_to_create_condition_variable_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_DELETE_CONDITION_VARIABLE_BUSINESS_SIDE_LOGIC_ERROR:
                // 删除条件变量失败
                reasonMsgId = R.string.failed_to_delete_condition_variable_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.WAIT_CONDITION_VARIABLE_FAILED_BUSINESS_SIDE_LOGIC_ERROR:
                // 等待条件变量失败
                reasonMsgId = R.string.wait_condition_variable_failed_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_SEND_CONDITIONAL_VARIABLE_SIGNAL_BUSINESS_SIDE_LOGIC_ERROR:
                // 发送条件变量信号失败
                reasonMsgId = R.string.failed_to_send_conditional_variable_signal_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.TIMEOUT_WAITING_FOR_CONDITION_VARIABLE_BUSINESS_SIDE_LOGIC_ERROR:
                // 等待条件变量超时
                reasonMsgId = R.string.timeout_waiting_for_condition_variable_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.NO_CORRESPONDING_RECORD_FOUND_BUSINESS_SIDE_LOGIC_ERROR:
                // 没有找到对应的record
                reasonMsgId = R.string.no_corresponding_record_found_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.PLAYDATA_NOT_FOUND_BUSINESS_SIDE_LOGIC_ERROR_19:
                // 没找到PlayData
                reasonMsgId = R.string.playdata_not_found_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_PLAYBACK_TASK_BUSINESS_SIDE_LOGIC_ERROR:
                // 建立播放任务失败
                reasonMsgId = R.string.failed_to_create_playback_task_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.BLOCKSIZE_ERROR_BUSINESS_SIDE_LOGIC_ERROR:
                // blockSize错误
                reasonMsgId = R.string.blocksize_error_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.NO_CORRESPONDING_STORAGEID_FOUND_BUSINESS_SIDE_LOGIC_ERROR:
                // 没找到对应的storageId
                reasonMsgId = R.string.no_corresponding_storageid_found_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_BUSINESS_SIDE_LOGIC_ERROR_23:
                // 建立下载任务失败
                reasonMsgId = R.string.failed_to_create_download_task_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.NO_VIDEOINFO_FOUND_BUSINESS_SIDE_LOGIC_ERROR:
                // 没有找到videoInfo
                reasonMsgId = R.string.no_videoinfo_found_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_P2P_PLAYBACK_TASK_BUSINESS_SIDE_LOGIC_ERROR:
                // 创建p2p播放任务失败
                reasonMsgId = R.string.failed_to_create_p2p_playback_task_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_GET_ACTIVEWINDOWMANAGER_BUSINESS_SIDE_LOGIC_ERROR:
                // 获取activeWindowManager失败
                reasonMsgId = R.string.failed_to_get_activewindowmanager_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FILE_SIZE_CONFLICT_BUSINESS_SIDE_LOGIC_ERROR:
                // 文件大小冲突
                reasonMsgId = R.string.file_size_conflict_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.INCORRECT_PLAYBACK_DATA_BUSINESS_SIDE_LOGIC_ERROR:
                // 播放数据不正确
                reasonMsgId = R.string.incorrect_playback_data_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_PLAY_SUBMITTED_DATA_BUSINESS_SIDE_LOGIC_ERROR:
                // 播放提交数据失败
                reasonMsgId = R.string.failed_to_play_submitted_data_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.BLOCK_NOT_DOWNLOADED_BUSINESS_SIDE_LOGIC_ERROR:
                // block未下载完成
                reasonMsgId = R.string.block_not_downloaded_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_GET_SYSTEM_TIME_BUSINESS_SIDE_LOGIC_ERROR:
                // 获取系统时间失败
                reasonMsgId = R.string.failed_to_get_system_time_business_side_logic_error;
                solveMsgId = R.string.check_network_connection_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_GET_PARTITION_NUMBER_BUSINESS_SIDE_LOGIC_ERROR:
                // 获取分片号失败
                reasonMsgId = R.string.failed_to_get_partition_number_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_START_MP4_TASK_BUSINESS_SIDE_LOGIC_ERROR:
                // 启动mp4任务失败
                reasonMsgId = R.string.failed_to_start_mp4_task_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.MCS_NOT_AVAILABLE_BUSINESS_SIDE_LOGIC_ERROR:
                // mcs不可用
                reasonMsgId = R.string.mcs_not_available_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.PROFILE_FILE_NOT_FOUND_BUSINESS_SIDE_LOGIC_ERROR:
                // 找不到profile文件
                reasonMsgId = R.string.profile_file_not_found_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.STORAGE_PATH_DOES_NOT_EXIST_BUSINESS_SIDE_LOGIC_ERROR:
                // 存储路径不存在
                reasonMsgId = R.string.storage_path_does_not_exist_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.DOWNLOAD_TASK_ALREADY_EXISTS_BUSINESS_SIDE_LOGIC_ERROR:
                // 已存在下载任务
                reasonMsgId = R.string.download_task_already_exists_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.THE_SPECIFIED_CACHE_WAS_NOT_FOUND_BUSINESS_SIDE_LOGIC_ERROR:
                // 没有找到指定的cache
                reasonMsgId = R.string.the_specified_cache_was_not_found_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.WHEN_DECRYPTING_THE_KEY_THE_VALUE_IS_EMPTY_BUSINESS_SIDE_LOGIC_ERROR:
                // 解密key时，值为空
                reasonMsgId = R.string.when_decrypting_the_key_the_value_is_empty_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.WHEN_DECRYPTING_NONCE_THE_VALUE_IS_NULL_BUSINESS_SIDE_LOGIC_ERROR_40:
                // 解密nonce时值为空
                reasonMsgId = R.string.when_decrypting_nonce_the_value_is_null_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.PLAYDATA_NOT_FOUND_BUSINESS_SIDE_LOGIC_ERROR_41:
                // 没有找到Playdata
                reasonMsgId = R.string.playdata_not_found_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_OPEN_MP4_TASK_BUSINESS_SIDE_LOGIC_ERROR:
                // 开启mp4任务失败
                reasonMsgId = R.string.failed_to_open_mp4_task_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_GET_AWM_BUSINESS_SIDE_LOGIC_ERROR:
                // 获取AWM失败
                reasonMsgId = R.string.failed_to_get_awm_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.WRONG_PROXY_URL_BUSINESS_SIDE_LOGIC_ERROR:
                // 代理URL有误
                reasonMsgId = R.string.wrong_proxy_url_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.PLAYDATA_IS_NOT_READY_BUSINESS_SIDE_LOGIC_ERROR:
                // PlayData没有准备好
                reasonMsgId = R.string.playdata_is_not_ready_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_BUSINESS_SIDE_LOGIC_ERROR_46:
                // 创建下载任务失败
                reasonMsgId = R.string.failed_to_create_download_task_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.RECORD_NOT_FOUND_BUSINESS_SIDE_LOGIC_ERROR:
                // 找不到记录
                reasonMsgId = R.string.record_not_found_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.INSUFFICIENT_DATA_BUSINESS_SIDE_LOGIC_ERROR:
                // 数据不足
                reasonMsgId = R.string.insufficient_data_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.SEND_TO_PLAYER_FAILED_BUSINESS_SIDE_LOGIC_ERROR:
                // 发送给播放器失败
                reasonMsgId = R.string.send_to_player_failed_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_VERIFY_FILE_BUSINESS_SIDE_LOGIC_ERROR:
                // 校验文件失败
                reasonMsgId = R.string.failed_to_verify_file_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_TASK_BUSINESS_SIDE_LOGIC_ERROR:
                // 创建任务失败
                reasonMsgId = R.string.failed_to_create_task_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.START_TASK_FAILED_BUSINESS_SIDE_LOGIC_ERROR:
                // 开始任务失败
                reasonMsgId = R.string.start_task_failed_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.TASK_DOES_NOT_EXIST_BUSINESS_SIDE_LOGIC_ERROR:
                // 任务不存在
                reasonMsgId = R.string.task_does_not_exist_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.THE_BACKGROUND_RETURNS_ENCRYPTED_VIDEO_BUT_THE_ENCRYPTION_KEY_IS_EMPTY_BUSINESS_SIDE_LOGIC_ERROR:
                // 后台返回加密视频，但是加密key为空
                reasonMsgId = R.string.the_background_returns_encrypted_video_but_the_encryption_key_is_empty_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_HLS_TASK_BUSINESS_SIDE_LOGIC_ERROR:
                // 创建HLS任务失败
                reasonMsgId = R.string.failed_to_create_hls_task_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_START_HLS_TASK_BUSINESS_SIDE_LOGIC_ERROR:
                // 开始HLS任务失败
                reasonMsgId = R.string.failed_to_start_hls_task_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.THE_REQUESTED_DOWNLOAD_TYPE_IS_INCONSISTENT_WITH_THE_RETURNED_DOWNLOAD_TYPE_BUSINESS_SIDE_LOGIC_ERROR:
                // 请求的下载类型和返回的下载类型不一致
                reasonMsgId = R.string.the_requested_download_type_is_inconsistent_with_the_returned_download_type_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.THE_VALUE_IS_EMPTY_WHEN_DECRYPTING_THE_KEY_BUSINESS_SIDE_LOGIC_ERROR:
                // 解密key时值为空
                reasonMsgId = R.string.the_value_is_empty_when_decrypting_the_key_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.WHEN_DECRYPTING_NONCE_THE_VALUE_IS_NULL_BUSINESS_SIDE_LOGIC_ERROR_59:
                // 解密nonce时值为空
                reasonMsgId = R.string.when_decrypting_nonce_the_value_is_null_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_BECAUSE_RECORD_IS_EMPTY_BUSINESS_SIDE_LOGIC_ERROR:
                // 创建下载任务失败，原因为record为空
                reasonMsgId = R.string.failed_to_create_download_task_because_record_is_empty_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_BECAUSE_INITIALIZATION_FAILED_BUSINESS_SIDE_LOGIC_ERROR:
                // 创建下载任务失败，原因为初始化失败
                reasonMsgId = R.string.failed_to_create_download_task_because_initialization_failed_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_OPENCACHE_FAILED_BUSINESS_SIDE_LOGIC_ERROR:
                // 创建下载任务失败，openCache失败
                reasonMsgId = R.string.failed_to_create_download_task_opencache_failed_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_FAILED_TO_GET_CONFIGURATION_INFORMATION_SYSTEM_ERROR_CODE_BUSINESS_SIDE_LOGIC_ERROR:
                // 创建下载任务失败，获取配置信息失败（系统错误码）
                reasonMsgId = R.string.failed_to_create_download_task_failed_to_get_configuration_information_system_error_code_business_side_logic_error;
                solveMsgId = R.string.restart_the_device_and_try_again_business_side_logic_error;
                showMsgId = R.string.download_error_business_side_logic_error;
                break;
            case VideoErrorCode.FAILED_TO_CREATE_SOCKET_NETWORK_OPERATION_ERROR:
                // 创建套接字失败
                reasonMsgId = R.string.failed_to_create_socket_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_BIND_LOCAL_PORT_NETWORK_OPERATION_ERROR:
                // 绑定本地端口失败
                reasonMsgId = R.string.failed_to_bind_local_port_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.SOCKET_LISTENING_FAILED_NETWORK_OPERATION_ERROR:
                // 套接字监听失败
                reasonMsgId = R.string.socket_listening_failed_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_GET_SOCKET_OPTIONS_NETWORK_OPERATION_ERROR:
                // 获取套接字选项失败
                reasonMsgId = R.string.failed_to_get_socket_options_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_SET_SOCKET_OPTIONS_NETWORK_OPERATION_ERROR:
                // 设置套接字选项失败
                reasonMsgId = R.string.failed_to_set_socket_options_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_TRANSLATE_IP_ADDRESS_NETWORK_OPERATION_ERROR:
                // 转换ip地址失败
                reasonMsgId = R.string.failed_to_translate_ip_address_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_CONNECT_TO_SERVER_NETWORK_OPERATION_ERROR:
                // 连接服务器失败
                reasonMsgId = R.string.failed_to_connect_to_server_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_SEND_DATA_NETWORK_OPERATION_ERROR:
                // 发送数据失败
                reasonMsgId = R.string.failed_to_send_data_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAIL_IN_CLOSE_SOCKET_NETWORK_OPERATION_ERROR:
                // 关闭套接字失败
                reasonMsgId = R.string.fail_in_close_socket_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.SELECT_FUNCTION_FAILED_NETWORK_OPERATION_ERROR:
                // select函数失败
                reasonMsgId = R.string.select_function_failed_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_ACCEPT_NEW_USER_NETWORK_OPERATION_ERROR:
                // 接受新的用户失败
                reasonMsgId = R.string.failed_to_accept_new_user_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_ACCEPT_DATA_NETWORK_OPERATION_ERROR:
                // 接受数据失败
                reasonMsgId = R.string.failed_to_accept_data_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_JOIN_MULTICAST_GROUP_NETWORK_OPERATION_ERROR:
                // 加入多播组失败
                reasonMsgId = R.string.failed_to_join_multicast_group_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_SET_MULTICAST_NO_FEEDBACK_LOCAL_NETWORK_OPERATION_ERROR:
                // 设置多播不反馈本地失败
                reasonMsgId = R.string.failed_to_set_multicast_no_feedback_local_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAILED_TO_EXIT_MULTICAST_GROUP_NETWORK_OPERATION_ERROR:
                // 退出多播组失败
                reasonMsgId = R.string.failed_to_exit_multicast_group_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.INVALID_SOCKET_NETWORK_OPERATION_ERROR:
                // 无效套接字
                reasonMsgId = R.string.invalid_socket_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HTTP_RETURNED_ERROR_NETWORK_OPERATION_ERROR:
                // http返回错误
                reasonMsgId = R.string.http_returned_error_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HTTP_SERVICE_NOT_AVAILABLE_NETWORK_OPERATION_ERROR:
                // http服务不可用
                reasonMsgId = R.string.http_service_not_available_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.USER_NETWORK_NOT_AVAILABLE_NETWORK_OPERATION_ERROR:
                // 用户网络不可用
                reasonMsgId = R.string.user_network_not_available_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.USER_NETWORK_HIJACKED_NETWORK_OPERATION_ERROR:
                // 用户网络被劫持
                reasonMsgId = R.string.user_network_hijacked_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.DOWNLOAD_FILE_MD5_VALUE_CONTINUOUS_VERIFICATION_FAILED_MULTIPLE_TIMES_NETWORK_OPERATION_ERROR:
                // 下载文件md5值连续检验失败多次
                reasonMsgId = R.string.download_file_md5_value_continuous_verification_failed_multiple_times_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.OFFLINE_DOWNLOAD_REQUEST_DRM_TIMEOUT_NETWORK_OPERATION_ERROR:
                // 离线下载请求drm超时
                reasonMsgId = R.string.offline_download_request_drm_timeout_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.GETLICENSE_TIMEOUT_NETWORK_OPERATION_ERROR:
                // getLicense超时
                reasonMsgId = R.string.getlicense_timeout_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HTTP_SERVICE_DOES_NOT_EXIST_NETWORK_OPERATION_ERROR:
                // http服务不存在
                reasonMsgId = R.string.http_service_does_not_exist_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.CDN_CONNECTION_ERROR_NETWORK_OPERATION_ERROR:
                // cdn连接有错误
                reasonMsgId = R.string.cdn_connection_error_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.DOWNLOAD_URL_IS_NULL_NETWORK_OPERATION_ERROR:
                // 下载url为null
                reasonMsgId = R.string.download_url_is_null_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.DNS_RESOLUTION_ERROR_NETWORK_OPERATION_ERROR:
                // DNS解析错误
                reasonMsgId = R.string.dns_resolution_error_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.ERROR_CREATING_SOCKET_NETWORK_OPERATION_ERROR:
                // 创建socket错误
                reasonMsgId = R.string.error_creating_socket_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.LINK_ERROR_NETWORK_OPERATION_ERROR:
                // 连接出错
                reasonMsgId = R.string.link_error_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.SEND_ERROR_NETWORK_OPERATION_ERROR:
                // 发送错误
                reasonMsgId = R.string.send_error_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.ACCEPT_ERROR_NETWORK_OPERATION_ERROR:
                // 接受出错
                reasonMsgId = R.string.accept_error_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.POLL_SELECT_TIMEOUT_NETWORK_OPERATION_ERROR:
                // poll select超时
                reasonMsgId = R.string.poll_select_timeout_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.ERROR_REDIRECTING_IP_NETWORK_OPERATION_ERROR:
                // 重定向IP出错
                reasonMsgId = R.string.error_redirecting_ip_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.TOO_MANY_REDIRECTS_ERROR_NETWORK_OPERATION_ERROR:
                // 重定向次数过多出错
                reasonMsgId = R.string.too_many_redirects_error_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HTTP_STATUS_CODE_ERROR_NETWORK_OPERATION_ERROR:
                // http状态码错误
                reasonMsgId = R.string.http_status_code_error_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HTTP_PARSING_ERROR_NETWORK_OPERATION_ERROR:
                // http解析错误
                reasonMsgId = R.string.http_parsing_error_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.ERROR_IN_XML_PARSING_RETURNED_NETWORK_OPERATION_ERROR:
                // 返回的xml解析出错
                reasonMsgId = R.string.error_in_xml_parsing_returned_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.ERROR_IN_RETURNED_CONTENT_NETWORK_OPERATION_ERROR:
                // 返回的内容出错
                reasonMsgId = R.string.error_in_returned_content_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HTTP_TIMEOUT_3S_NETWORK_OPERATION_ERROR:
                // http超时（3s）
                reasonMsgId = R.string.http_timeout_3s_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.SEND_RETURNS_EAGAIN_NETWORK_OPERATION_ERROR:
                // Send返回EAGAIN
                reasonMsgId = R.string.send_returns_eagain_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.GETSOCKOPT_FAILED_FOR_THE_CONNECTED_SOCKET_NETWORK_OPERATION_ERROR:
                // 对于连接的socket,getsockopt失败
                reasonMsgId = R.string.getsockopt_failed_for_the_connected_socket_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.GETSOCKOPT_SUCCEEDED_FOR_THE_CONNECTED_SOCKET_BUT_RETURNED_ERROR_NETWORK_OPERATION_ERROR:
                // 对于连接的socket,getsockopt成功，但是返回了ERROR
                reasonMsgId = R.string.getsockopt_succeeded_for_the_connected_socket_but_returned_error_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.ILLEGAL_HLS_HTTP_PARAMETER_NETWORK_OPERATION_ERROR:
                // hls http参数不合法
                reasonMsgId = R.string.illegal_hls_http_parameter_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.ILLEGAL_HLS_URL_NETWORK_OPERATION_ERROR:
                // hls url不合法
                reasonMsgId = R.string.illegal_hls_url_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_DNS_PARSING_FAILED_NETWORK_OPERATION_ERROR:
                // hls dns解析失败
                reasonMsgId = R.string.hls_dns_parsing_failed_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_FAILED_TO_CREATE_SOCKET_NETWORK_OPERATION_ERROR:
                // hls 创建socket失败
                reasonMsgId = R.string.hls_failed_to_create_socket_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_CONNECTION_FAILED_NETWORK_OPERATION_ERROR:
                // hls 连接失败
                reasonMsgId = R.string.hls_connection_failed_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_CONNECTION_TIMEOUT_NETWORK_OPERATION_ERROR:
                // hls 连接超时
                reasonMsgId = R.string.hls_connection_timeout_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_SEND_TIMEOUT_NETWORK_OPERATION_ERROR:
                // hls 发送超时
                reasonMsgId = R.string.hls_send_timeout_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_FAILED_TO_APPLY_FOR_MEMORY_NETWORK_OPERATION_ERROR:
                // hls 申请内存失败
                reasonMsgId = R.string.hls_failed_to_apply_for_memory_network_operation_error;
                solveMsgId = R.string.insufficient_system_space_restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_ACCEPT_FAILED_NETWORK_OPERATION_ERROR:
                // hls 接受失败
                reasonMsgId = R.string.hls_accept_failed_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_ACCEPT_TIMEOUT_NETWORK_OPERATION_ERROR:
                // hls 接受超时
                reasonMsgId = R.string.hls_accept_timeout_network_operation_error;
                solveMsgId = R.string.check_the_network_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.INSUFFICIENT_HLS_BUFFER_NETWORK_OPERATION_ERROR:
                // hls buffer不足
                reasonMsgId = R.string.insufficient_hls_buffer_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_HTTP_HEADER_OVERFLOW_NETWORK_OPERATION_ERROR:
                // hls http头溢出
                reasonMsgId = R.string.hls_http_header_overflow_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_HTTP_RETURN_ERROR_CODE_DETECTION_ILLEGAL_NETWORK_OPERATION_ERROR:
                // hls http返回错误码检测非法
                reasonMsgId = R.string.hls_http_return_error_code_detection_illegal_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.ILLEGAL_FILE_SIZE_RETURNED_BY_HLS_HTTP_NETWORK_OPERATION_ERROR:
                // hls http返回文件大小非法
                reasonMsgId = R.string.illegal_file_size_returned_by_hls_http_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.ILLEGAL_HLS_HTTP_CONTENTLENGTH_NETWORK_OPERATION_ERROR:
                // hls http ContentLength非法
                reasonMsgId = R.string.illegal_hls_http_contentlength_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_HTTP_FROM_DIRECTED_ILLEGAL_NETWORK_OPERATION_ERROR:
                // hls http从定向非法
                reasonMsgId = R.string.hls_http_from_directed_illegal_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_RETURNS_HTTP_ERROR_CODE_NETWORK_OPERATION_ERROR:
                // hls 返回http错误码
                reasonMsgId = R.string.hls_returns_http_error_code_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_ACCEPT_OVERFLOW_NETWORK_OPERATION_ERROR:
                // hls 接受溢出
                reasonMsgId = R.string.hls_accept_overflow_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_SERVER_SHUT_DOWN_ABNORMALLY_NETWORK_OPERATION_ERROR:
                // hls 服务器异常关闭
                reasonMsgId = R.string.hls_server_shut_down_abnormally_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_SOCKET_ERROR_NETWORK_OPERATION_ERROR:
                // hls socket错误
                reasonMsgId = R.string.hls_socket_error_network_operation_error;
                solveMsgId = R.string.restart_the_device_and_try_again_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_RETRY_EXCEEDED_LIMIT_NETWORK_OPERATION_ERROR:
                // hls 重试超过限制
                reasonMsgId = R.string.hls_retry_exceeded_limit_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_UNKNOWN_ERROR_NETWORK_OPERATION_ERROR:
                // hls 未知错误
                reasonMsgId = R.string.hls_unknown_error_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.LOCK_FAILURE_NETWORK_OPERATION_ERROR:
                // 锁失败
                reasonMsgId = R.string.lock_failure_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.IN_HLS_CONNECTION_NETWORK_OPERATION_ERROR:
                // hls 连接中
                reasonMsgId = R.string.in_hls_connection_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_SOCKET_IS_BUSY_NETWORK_OPERATION_ERROR:
                // hls socket正忙
                reasonMsgId = R.string.hls_socket_is_busy_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_302_JUMP_WHEN_DOWNLOADS_TS_NETWORK_OPERATION_ERROR:
                // hls 下载ts时发生302跳转
                reasonMsgId = R.string.hls_302_jump_when_downloads_ts_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.HLS_302_JUMPS_TO_THE_SAME_URL_NETWORK_OPERATION_ERROR:
                // hls 302跳转到相同的URL
                reasonMsgId = R.string.hls_302_jumps_to_the_same_url_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.CONTENT_TYPE_RETURNED_BY_HLS_IS_WRONG_NETWORK_OPERATION_ERROR:
                // hls 返回的ContentType有错
                reasonMsgId = R.string.content_type_returned_by_hls_is_wrong_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FILE_SIZE_RETURNED_BY_HLS_CDN_CHANGES_NETWORK_OPERATION_ERROR:
                // hls cdn返回的文件大小发生变化
                reasonMsgId = R.string.file_size_returned_by_hls_cdn_changes_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.TOO_MANY_JUMPS_IN_HLS_302_NETWORK_OPERATION_ERROR:
                // hls 302跳转次数过多
                reasonMsgId = R.string.too_many_jumps_in_hls_302_network_operation_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_network_operation_error;
                showMsgId = R.string.download_error_network_operation_error;
                break;
            case VideoErrorCode.FAIL_TO_OPEN_FILE_DOCUMENT_OPERATION_RELATED:
                // 打开文件失败
                reasonMsgId = R.string.fail_to_open_file_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.FAILED_TO_GET_FILE_DOCUMENT_OPERATION_RELATED:
                // 获取文件失败
                reasonMsgId = R.string.failed_to_get_file_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.FAILED_TO_WRITE_FILE_DOCUMENT_OPERATION_RELATED:
                // 写文件失败
                reasonMsgId = R.string.failed_to_write_file_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.FAILED_TO_GET_FILE_SIZE_DOCUMENT_OPERATION_RELATED:
                // 获取文件大小失败
                reasonMsgId = R.string.failed_to_get_file_size_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.INSUFFICIENT_DISK_SPACE_DOCUMENT_OPERATION_RELATED_5:
                // 磁盘空间不足
                reasonMsgId = R.string.insufficient_disk_space_document_operation_related;
                solveMsgId = R.string.insufficient_system_space_restart_the_device_and_try_again_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.FILE_WAS_NOT_FOUND_DOCUMENT_OPERATION_RELATED:
                // 文件没找到
                reasonMsgId = R.string.file_was_not_found_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.VFS_IS_EMPTY_DOCUMENT_OPERATION_RELATED:
                // vfs为空
                reasonMsgId = R.string.vfs_is_empty_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.THERE_IS_NO_SUCH_PATH_DOCUMENT_OPERATION_RELATED:
                // 没有这个路径
                reasonMsgId = R.string.there_is_no_such_path_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.CACHE_NOT_FOUND_DOCUMENT_OPERATION_RELATED:
                // 找不到cache
                reasonMsgId = R.string.cache_not_found_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.FAILED_TO_READ_CACHE_DOCUMENT_OPERATION_RELATED:
                // 读cache失败
                reasonMsgId = R.string.failed_to_read_cache_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.WRITE_CACHE_FAILED_DOCUMENT_OPERATION_RELATED:
                // 写cache失败
                reasonMsgId = R.string.write_cache_failed_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.OFFLINE_FILE_DOES_NOT_EXIST_DOCUMENT_OPERATION_RELATED:
                // 离线文件不存在
                reasonMsgId = R.string.offline_file_does_not_exist_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.INSUFFICIENT_DISK_SPACE_DOCUMENT_OPERATION_RELATED_13:
                // 磁盘空间不足
                reasonMsgId = R.string.insufficient_disk_space_document_operation_related;
                solveMsgId = R.string.insufficient_system_space_restart_the_device_and_try_again_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.DOWNLOAD_FILE_RENAME_FAILED_DOCUMENT_OPERATION_RELATED:
                // 下载文件重命名失败
                reasonMsgId = R.string.download_file_rename_failed_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.WRITE_FILE_LENGTH_ERROR_DOCUMENT_OPERATION_RELATED:
                // 写文件长度错误
                reasonMsgId = R.string.write_file_length_error_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.THE_DIRECTORY_FOR_TOGGLE_SETTINGS_IS_EMPTY_DOCUMENT_OPERATION_RELATED:
                // 切换设置的目录为空
                reasonMsgId = R.string.the_directory_for_toggle_settings_is_empty_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.THE_DIRECTORY_CREATION_DIRECTORY_FOR_TOGGLE_SETTINGS_IS_EMPTY_DOCUMENT_OPERATION_RELATED:
                // 切换设置的目录创建目录为空
                reasonMsgId = R.string.the_directory_creation_directory_for_toggle_settings_is_empty_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.READ_WRITE_FILE_SYSTEM_ERROR_CODE_DOCUMENT_OPERATION_RELATED:
                // 读写文件系统错误码
                reasonMsgId = R.string.read_write_file_system_error_code_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.SYSTEM_BASIC_ERROR_CODE_DOCUMENT_OPERATION_RELATED:
                // 系统基本错误码
                reasonMsgId = R.string.system_basic_error_code_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.VFS_OPEN_FAILED_DOCUMENT_OPERATION_RELATED:
                // vfs 打开失败
                reasonMsgId = R.string.vfs_open_failed_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.VFS_INVALID_PARAMETER_DOCUMENT_OPERATION_RELATED:
                // vfs 无效参数
                reasonMsgId = R.string.vfs_invalid_parameter_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.ILLEGAL_OFFSET_DOCUMENT_OPERATION_RELATED:
                // offset 非法
                reasonMsgId = R.string.illegal_offset_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.NO_DATA_IN_LOCAL_BUFFER_DOCUMENT_OPERATION_RELATED:
                // 本地缓冲没数据
                reasonMsgId = R.string.no_data_in_local_buffer_document_operation_related;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_document_operation_related;
                showMsgId = R.string.download_error_document_operation_related;
                break;
            case VideoErrorCode.FAILED_TO_UPDATE_RECORD_DB_RELATED_ERROR:
                // 更新record失败
                reasonMsgId = R.string.failed_to_update_record_db_related_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_db_related_error;
                showMsgId = R.string.download_error_db_related_error;
                break;
            case VideoErrorCode.FAILED_TO_UPDATE_VINFO_DB_RELATED_ERROR:
                // 更新vinfo失败
                reasonMsgId = R.string.failed_to_update_vinfo_db_related_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_db_related_error;
                showMsgId = R.string.download_error_db_related_error;
                break;
            case VideoErrorCode.RECORD_DELETE_DB_FAILED_DB_RELATED_ERROR:
                // 记录删除db失败
                reasonMsgId = R.string.record_delete_db_failed_db_related_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_db_related_error;
                showMsgId = R.string.download_error_db_related_error;
                break;
            case VideoErrorCode.FAILED_TO_ADD_RECORD_DB_RELATED_ERROR:
                // 添加记录失败
                reasonMsgId = R.string.failed_to_add_record_db_related_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_db_related_error;
                showMsgId = R.string.download_error_db_related_error;
                break;
            case VideoErrorCode.FAILED_TO_CONVERT_VFS_ON_UPGRADE_DB_RELATED_ERROR:
                // 升级时转换vfs失败
                reasonMsgId = R.string.failed_to_convert_vfs_on_upgrade_db_related_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_db_related_error;
                showMsgId = R.string.download_error_db_related_error;
                break;
            case VideoErrorCode.FAILED_TO_UPDATE_VINFO_INFORMATION_DURING_UPGRADE_DB_RELATED_ERROR:
                // 升级时更新vinfo信息失败
                reasonMsgId = R.string.failed_to_update_vinfo_information_during_upgrade_db_related_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_db_related_error;
                showMsgId = R.string.download_error_db_related_error;
                break;
            case VideoErrorCode.RELATED_HTTP_ERROR_CODES_RETURNED_BY_CDN_CDN_RELATED_ERRORS:
                // cdn返回的相关的http错误码
                reasonMsgId = R.string.related_http_error_codes_returned_by_cdn_cdn_related_errors;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_cdn_related_errors;
                showMsgId = R.string.download_error_cdn_related_errors;
                break;
            case VideoErrorCode.HLS_302_CDN_RELATED_ERRORS:
                // hls 302
                reasonMsgId = R.string.hls_302_cdn_related_errors;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_cdn_related_errors;
                showMsgId = R.string.download_error_cdn_related_errors;
                break;
            case VideoErrorCode.HLS_403_CDN_RELATED_ERRORS:
                // hls 403
                reasonMsgId = R.string.hls_403_cdn_related_errors;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_cdn_related_errors;
                showMsgId = R.string.download_error_cdn_related_errors;
                break;
            case VideoErrorCode.HLS_404_CDN_RELATED_ERRORS:
                // hls 404
                reasonMsgId = R.string.hls_404_cdn_related_errors;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_cdn_related_errors;
                showMsgId = R.string.download_error_cdn_related_errors;
                break;
            case VideoErrorCode.HLS_416_CDN_RELATED_ERRORS:
                // hls 416
                reasonMsgId = R.string.hls_416_cdn_related_errors;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_cdn_related_errors;
                showMsgId = R.string.download_error_cdn_related_errors;
                break;
            // 版本更新兼容
            case VideoErrorCode.OPENID_OR_OPENKEY_VALIDATION_FAILED_OLD_VERSION:
                // 由于修改密码导致的AccessToken失效
            case VideoErrorCode.THIS_RETURN_CODE_INDICATES_THAT_THE_USER_HAS_MODIFIED_THE_QQ_PASSWORD_RESULTING_IN_THE_FAILURE_OF_ACCESS_TOKEN_AND_NEEDS_TO_GUIDE_THE_USER_TO_LOG_IN_AGAIN_OLD_VERSION:
                // 此返回码表示用户修改了QQ密码，导致Access Token失效，需要引导用户重新登陆。
                reasonMsgId = R.string.this_return_code_indicates_that_the_user_has_modified_the_qq_password_resulting_in_the_failure_of_access_token_and_needs_to_guide_the_user_to_log_in_again_old_version;
                solveMsgId = R.string.please_confirm_and_log_in_again_old_version;
                showMsgId = R.string.your_account_password_has_been_modified_old_version;
                break;
            default:
                // 未知错误
                buildUpMsg(R.string.unknown_error_upper_logic_error, R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error, R.string.player_unknown_error_upper_logic_error);
                reasonMsgId = R.string.unknown_error_upper_logic_error;
                solveMsgId = R.string.please_go_to_my_feedback_to_give_us_feedback_upper_logic_error;
                showMsgId = R.string.player_unknown_error_upper_logic_error;
                break;
        }
        Resources resources = context.getResources();
        String reasonMsg = "未知错误";
        String solveMsg = "请联系客服, 将问题反馈给我们, 谢谢";
        String showMsg = "播放失败";
        if (resources != null) {
            reasonMsg = resources.getString(reasonMsgId);
            solveMsg = resources.getString(solveMsgId);
            showMsg = resources.getString(showMsgId);
        }
        LogUtil.e(TAG, String.format(Locale.CHINA, "错误码: %d, 错误原因: %s, 推荐解决方式: %s", errorCode, reasonMsg, solveMsg));
        return String.format(Locale.CHINA, "%s(%d)\n%s", showMsg, errorCode, solveMsg);
    }

    private static String buildUpMsg(int reasonMsgId, int solveMsgId, int showMsgId) {

    }


    private static int checkErrorCode(int errorCode) {
        int safeErrorCode = errorCode;
        if (errorCode >= VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_OPENCACHE_FAILED_BUSINESS_SIDE_LOGIC_ERROR_MIN && errorCode <= VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_OPENCACHE_FAILED_BUSINESS_SIDE_LOGIC_ERROR_MAX) {
            safeErrorCode = VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_OPENCACHE_FAILED_BUSINESS_SIDE_LOGIC_ERROR;
        } else if (errorCode >= VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_FAILED_TO_GET_CONFIGURATION_INFORMATION_SYSTEM_ERROR_CODE_BUSINESS_SIDE_LOGIC_ERROR_MIN && errorCode <= VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_FAILED_TO_GET_CONFIGURATION_INFORMATION_SYSTEM_ERROR_CODE_BUSINESS_SIDE_LOGIC_ERROR_MAX) {
            safeErrorCode = VideoErrorCode.FAILED_TO_CREATE_DOWNLOAD_TASK_FAILED_TO_GET_CONFIGURATION_INFORMATION_SYSTEM_ERROR_CODE_BUSINESS_SIDE_LOGIC_ERROR;
        } else if (errorCode >= VideoErrorCode.READ_WRITE_FILE_SYSTEM_ERROR_CODE_DOCUMENT_OPERATION_RELATED_MIN && errorCode <= VideoErrorCode.READ_WRITE_FILE_SYSTEM_ERROR_CODE_DOCUMENT_OPERATION_RELATED_MAX) {
            safeErrorCode = VideoErrorCode.READ_WRITE_FILE_SYSTEM_ERROR_CODE_DOCUMENT_OPERATION_RELATED;
        } else if (errorCode >= VideoErrorCode.SYSTEM_BASIC_ERROR_CODE_DOCUMENT_OPERATION_RELATED_MIN && errorCode <= VideoErrorCode.SYSTEM_BASIC_ERROR_CODE_DOCUMENT_OPERATION_RELATED_MAX) {
            safeErrorCode = VideoErrorCode.SYSTEM_BASIC_ERROR_CODE_DOCUMENT_OPERATION_RELATED;
        }
        return safeErrorCode;
    }
}
