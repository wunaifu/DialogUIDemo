package com.fu.dialoguidemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.fu.dialoguidemo.bean.PopuBean;
import com.fu.dialoguidemo.listener.TdataListener;
import com.fu.dialoguidemo.adapter.TieAdapter;
import com.fu.dialoguidemo.bean.BuildBean;
import com.fu.dialoguidemo.bean.TieBean;
import com.fu.dialoguidemo.listener.DialogUIDateTimeSaveListener;
import com.fu.dialoguidemo.listener.DialogUIItemListener;
import com.fu.dialoguidemo.listener.DialogUIListener;
import com.fu.dialoguidemo.widget.DateSelectorWheelView;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener */{

    Activity mActivity;
    Context mContext;
    @Bind(R.id.ll_main)
    LinearLayout llMain;
    @Bind(R.id.btn_popu)
    Button btnPopu;
//    private LinearLayout llMain;
//    private Button btnPopu;
//    private Button btnCustomAlert;
//    private Button btnCustomBottomAlert;
//    private Button btnSystemAlert;
//    private Button btnLoading;
//    private Button btnMdLoading;
//    private Button btnAlertMultichoose;
//    private Button btnAlertSinglechoose;
//    private Button btnMdAlert;
//    private Button btnTieAlert;
//    private Button btnAlertInput;
//    private Button btnCenterSheet;
//    private Button btnBottomSheetCancel;
//    private Button btnMdBottomVertical;
//    private Button btnMdBottomHorizontal;
//    private Button btnToastTop;
//    private Button btnToastCenter;
//    private Button btnToast;
//    private Button btnSelectYmd;
//    private Button btnSelectYmdhm;
//    private Button btnSelectYmdhms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mActivity = this;
        mContext = getApplication();
        DialogUIUtils.init(mContext);


//        llMain = (LinearLayout) findViewById(R.id.ll_main);
//        btnPopu = (Button) findViewById(R.id.btn_popu);
//        btnCustomAlert = (Button) findViewById(R.id.btn_custom_alert);
//        btnCustomBottomAlert = (Button) findViewById(R.id.btn_custom_bottom_alert);
//        btnSystemAlert = (Button) findViewById(R.id.btn_system_alert);
//        btnLoading = (Button) findViewById(R.id.btn_loading);
//        btnMdLoading = (Button) findViewById(R.id.btn_md_loading);
//        btnAlertMultichoose = (Button) findViewById(R.id.btn_alert_multichoose);
//        btnAlertSinglechoose = (Button) findViewById(R.id.btn_alert_singlechoose);
//        btnMdAlert = (Button) findViewById(R.id.btn_md_alert);
//        btnTieAlert = (Button) findViewById(R.id.btn_tie_alert);
//        btnAlertInput = (Button) findViewById(R.id.btn_alert_input);
//        btnCenterSheet = (Button) findViewById(R.id.btn_center_sheet);
//        btnBottomSheetCancel = (Button) findViewById(R.id.btn_bottom_sheet_cancel);
//        btnMdBottomVertical = (Button) findViewById(R.id.btn_md_bottom_vertical);
//        btnMdBottomHorizontal = (Button) findViewById(R.id.btn_md_bottom_horizontal);
//        btnToastTop = (Button) findViewById(R.id.btn_toast_top);
//        btnToastCenter = (Button) findViewById(R.id.btn_toast_center);
//        btnToast = (Button) findViewById(R.id.btn_toast);
//        btnSelectYmd = (Button) findViewById(R.id.btn_select_ymd);
//        btnSelectYmdhm = (Button) findViewById(R.id.btn_select_ymdhm);
//        btnSelectYmdhms = (Button) findViewById(R.id.btn_select_ymdhms);
//
//
//        llMain = (LinearLayout) findViewById(R.id.ll_main);
//        btnPopu.setOnClickListener(this);
//        btnCustomAlert.setOnClickListener(this);
//        btnCustomBottomAlert.setOnClickListener(this);
//        btnSystemAlert.setOnClickListener(this);
//        btnLoading.setOnClickListener(this);
//        btnMdLoading.setOnClickListener(this);
//        btnAlertMultichoose.setOnClickListener(this);
//        btnAlertSinglechoose.setOnClickListener(this);
//        btnMdAlert.setOnClickListener(this);
//        btnTieAlert.setOnClickListener(this);
//        btnAlertInput.setOnClickListener(this);
//        btnCenterSheet.setOnClickListener(this);
//        btnBottomSheetCancel.setOnClickListener(this);
//        btnMdBottomVertical.setOnClickListener(this);
//        btnMdBottomHorizontal.setOnClickListener(this);
//        btnToastTop.setOnClickListener(this);
//        btnToastCenter.setOnClickListener(this);
//        btnToast.setOnClickListener(this);
//        btnSelectYmd.setOnClickListener(this);
//        btnSelectYmdhm.setOnClickListener(this);
//        btnSelectYmdhms.setOnClickListener(this);
    }

    String msg = "别总是来日方长，这世上挥手之间的都是人走茶凉。";

    @OnClick({R.id.btn_custom_alert, R.id.btn_custom_bottom_alert, R.id.btn_system_alert, R.id.btn_loading, R.id.btn_md_loading, R.id.btn_md_alert, R.id.btn_tie_alert,
            R.id.btn_bottom_sheet_cancel, R.id.btn_center_sheet, R.id.btn_alert_input,
            R.id.btn_alert_multichoose, R.id.btn_alert_singlechoose, R.id.btn_md_bottom_vertical, R.id.btn_md_bottom_horizontal,
            R.id.btn_toast_top, R.id.btn_toast_center, R.id.btn_toast,
            R.id.btn_select_ymd, R.id.btn_select_ymdhm, R.id.btn_select_ymdhms, R.id.btn_popu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_popu:
                DialogUIUtils.showPopuWindow(mContext, LinearLayout.LayoutParams.MATCH_PARENT, 4, btnPopu, new TdataListener() {
                    @Override
                    public void initPupoData(List<PopuBean> lists) {
                        for (int i = 0; i < 5; i++) {
                            PopuBean popu = new PopuBean();
                            popu.setTitle("item" + i);
                            popu.setId(i);
                            lists.add(popu);
                        }
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position) {
                    }
                });
                break;
            case R.id.btn_custom_alert:
                View rootView = View.inflate(mActivity, R.layout.custom_dialog_layout, null);
                final Dialog dialog = DialogUIUtils.showCustomAlert(this, rootView, Gravity.CENTER, true, false).show();
                rootView.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUIUtils.dismiss(dialog);
                    }
                });
                break;
            case R.id.btn_custom_bottom_alert:
                View rootViewB = View.inflate(mActivity, R.layout.custom_dialog_bottom_layout, null);
                DialogUIUtils.showCustomBottomAlert(this, rootViewB).show();
                break;
            case R.id.btn_system_alert:
                new AlertDialog
                        .Builder(mActivity)
                        .setTitle("标题")
                        .setMessage("这是内容")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create()
                        .show();
                break;
            case R.id.btn_loading:
                DialogUIUtils.showLoading(this, "加载中...", false, true, true, true).show();
                break;
            case R.id.btn_md_loading:
                DialogUIUtils.showMdLoading(this, "加载中...", true, true, true, true).show();
                break;

            case R.id.btn_alert_multichoose:
                String[] words = new String[]{"1", "2", "3"};
                boolean[] choseDefault = new boolean[]{false, false, false};
                DialogUIUtils.showMdMultiChoose(mActivity, "标题", words, choseDefault, new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }
                }).show();
                break;
            case R.id.btn_alert_singlechoose:
                String[] words2 = new String[]{"1", "2", "3"};
                DialogUIUtils.showSingleChoose(mActivity, "单选", 0, words2, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "--" + position);
                    }
                }).show();
                break;
            case R.id.btn_md_alert:
                DialogUIUtils.showMdAlert(mActivity, "标题", msg, new DialogUIListener() {
                    @Override
                    public void onPositive() {
                        showToast("onPositive");
                    }

                    @Override
                    public void onNegative() {
                        showToast("onNegative");
                    }

                }).show();
                break;
            case R.id.btn_tie_alert:
                DialogUIUtils.showAlert(mActivity, "标题", msg, "", "", "确定", "", true, true, true, new DialogUIListener() {
                    @Override
                    public void onPositive() {
                        showToast("onPositive");
                    }

                    @Override
                    public void onNegative() {
                        showToast("onNegative");
                    }

                }).show();
                break;
            case R.id.btn_alert_input:
                DialogUIUtils.showAlert(mActivity, "登录", "", "请输入用户名", "请输入密码", "登录", "取消", false, true, true, new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }

                    @Override
                    public void onGetInput(CharSequence input1, CharSequence input2) {
                        super.onGetInput(input1, input2);
                        showToast("input1:" + input1 + "--input2:" + input2);
                    }
                }).show();
                break;
            case R.id.btn_center_sheet: {
                List<TieBean> strings = new ArrayList<TieBean>();
                strings.add(new TieBean("1"));
                strings.add(new TieBean("2"));
                strings.add(new TieBean("3"));
                DialogUIUtils.showSheet(mActivity, strings, "", Gravity.CENTER, true, true, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text);
                    }
                }).show();
            }
            break;
            case R.id.btn_bottom_sheet_cancel: {
                List<TieBean> strings = new ArrayList<TieBean>();
                strings.add(new TieBean("1"));
                strings.add(new TieBean("2"));
                strings.add(new TieBean("3"));
                DialogUIUtils.showSheet(mActivity, strings, "取消", Gravity.BOTTOM, true, true, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "---" + position);
                    }

                    @Override
                    public void onBottomBtnClick() {
                        showToast("取消");
                    }
                }).show();
            }
            break;
            case R.id.btn_md_bottom_vertical:
                List<TieBean> datas2 = new ArrayList<TieBean>();
                datas2.add(new TieBean("1"));
                datas2.add(new TieBean("2"));
                datas2.add(new TieBean("3"));
                datas2.add(new TieBean("4"));
                datas2.add(new TieBean("5"));
                datas2.add(new TieBean("6"));
                TieAdapter adapter = new TieAdapter(mContext, datas2, true);
                BuildBean buildBean = DialogUIUtils.showMdBottomSheet(mActivity, true, "", datas2, 0, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "---" + position);
                    }
                });
                buildBean.mAdapter = adapter;
                buildBean.show();
                break;
            case R.id.btn_md_bottom_horizontal:
                List<TieBean> datas3 = new ArrayList<TieBean>();
                datas3.add(new TieBean("1"));
                datas3.add(new TieBean("2"));
                datas3.add(new TieBean("3"));
                datas3.add(new TieBean("4"));
                datas3.add(new TieBean("5"));
                datas3.add(new TieBean("6"));
                DialogUIUtils.showMdBottomSheet(mActivity, false, "标题", datas3, 4, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "---" + position);
                    }
                }).show();
                break;

            case R.id.btn_toast_top:
                DialogUIUtils.showToastTop("上部的Toast弹出方式");
                break;
            case R.id.btn_toast_center:
                DialogUIUtils.showToastCenter("中部的Toast弹出方式");
                break;
            case R.id.btn_toast:
                DialogUIUtils.showToast("默认的Toast弹出方式");
                break;
            case R.id.btn_select_ymd: {
                DialogUIUtils.showDatePick(mActivity, Gravity.CENTER, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDD, 0, new DialogUIDateTimeSaveListener() {
                    @Override
                    public void onSaveSelectedDate(int tag, String selectedDate) {

                    }
                }).show();
            }
            break;
            case R.id.btn_select_ymdhm: {
                DialogUIUtils.showDatePick(mActivity, Gravity.CENTER, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMM, 0, new DialogUIDateTimeSaveListener() {
                    @Override
                    public void onSaveSelectedDate(int tag, String selectedDate) {

                    }
                }).show();
            }
            break;
            case R.id.btn_select_ymdhms: {
                DialogUIUtils.showDatePick(mActivity, Gravity.BOTTOM, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMMSS, 0, new DialogUIDateTimeSaveListener() {
                    @Override
                    public void onSaveSelectedDate(int tag, String selectedDate) {

                    }
                }).show();
            }
            break;

        }
    }


    public void showToast(CharSequence msg) {
        DialogUIUtils.showToastLong(msg.toString());
    }
}
