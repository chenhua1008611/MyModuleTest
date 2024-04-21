package com.example.myapplication;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class HttpTest {



    private void sendStringRequest(Context context){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        String url = "https://www.baidu.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                mTextView.setText("The StringRequest's response is "+ response.substring(0,500));
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
//                mTextView.setText("The StringRequest's response is: That didn't work!" );
            }
        });
        mQueue.add(stringRequest);
    }

    //JSONRequest
    private void sendJSONRequest(Context context){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        //网上找到的一个天气的API，暂时可用，稳定性待测= =
        String url = "https://www.sojson.com/open/api/weather/json.shtml?city=北京";
        //JsonObjectRequest和JsonArrayRequest是JsonRequest(抽象类)的子类
        //前者请求JSON数据，后者请求JSON数组
        /**
         * 参数说明：
         * 1：请求方法
         * 2：服务器的URL地址
         * 3：POST方式传递的JSON数据，如果为空则表示POST方式没有要提交的参数
         * 4：接收响应成功时返回的JSON数据的监听器
         * 4：接收响应失败时返回的错误信息的监听器
         */
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                mTextView.setText("The JSONRequest's response is " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                mTextView.setText("The JSONRequest's response is: That didn't work!" );
            }
        });
        //将请求放入请求队列
        mQueue.add(jsonObjectRequest);
    }


}
