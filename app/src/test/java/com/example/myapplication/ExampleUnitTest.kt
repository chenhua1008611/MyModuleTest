package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)

        //https://www.bilibili.com/video/BV1eW4y1a7qD/?p=9&vd_source=3629532309315f1edfc2833510b35b44    参考学习视频
        // https://github.com/JefferyBoy/android-multi-module-demo
        // https://www.bilibili.com/video/BV1pY4y1A76J/?spm_id_from=333.999.0.0&vd_source=3629532309315f1edfc2833510b35b44
//        println("dddddd")

        val token = "{\n" +
                "  \"sourceChannel\": \"Orange\",\n" +
                "  \"packageName\": \"com.tcssj.mbjmb\",\n" +
                "  \"adid\": \"\",\n" +
                "  \"version\": \"12.0.0\",\n" +
                "  \"uuId\": \"\",\n" +
                "  \"userId\": \"\"\n" +
                "}";
//        var key = com.example.myapplication.Test.base64ToDecode("xDBrgJdnnY2w1Do7Ik6otonXQRgQyt46")
        var str = com.example.myapplication.Test.encrypt(token,"xDBrgJdnnY2w1Do7Ik6otonXQRgQyt46")
        println(str+"结束")


    }



}