package com.app.friendschat.ui.intro

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.app.friendschat.R
import com.app.friendschat.data.model.IntroModel
import com.app.friendschat.databinding.ActivityIntroBepicNewBinding
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.main.MainBepicActivity
import com.app.friendschat.ui.permission.PermissionBepicActivity
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.LocalStorageUtils
import com.app.friendschat.utils.widget.tapAndCheckInternet
import kotlin.reflect.KClass

class IntroBepicActivity : BaseActivity<IntroViewModel, ActivityIntroBepicNewBinding>() {

    private var countBepic = 0
    private lateinit var dotsNew: Array<ImageView?>
    private val listIntroBepic = mutableListOf<IntroModel>()
    private lateinit var introAdapterBepic: IntroAdapter

    override fun initView() {
        listIntroBepic.add(
            IntroModel(
                R.drawable.img_intro_1,
                resources.getString(R.string.Welcome_to_Your_Emoji_Art),
                resources.getString(R.string.Express_yourself_with_custom)
            )
        )
        listIntroBepic.add(
            IntroModel(
                R.drawable.img_intro_2,
                resources.getString(R.string.Start_Your_Sticker_Journey),
                resources.getString(R.string.Create_personalized_emojis)
            )
        )
        listIntroBepic.add(
            IntroModel(
                R.drawable.img_intro_3,
                resources.getString(R.string.Sticker_and_Emoji_Joy),
                resources.getString(R.string.Enjoy_making_unique_stickers)
            )
        )
        addBottomDotsBepic(0)
        introAdapterBepic = IntroAdapter(listIntroBepic)
        binding.viewpager.adapter = introAdapterBepic
        binding.viewpager.offscreenPageLimit = listIntroBepic.size

        binding.viewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        if (countBepic > 0) {
                            addBottomDotsBepic(position)
                        }
                        binding.tvNext.text = resources.getString(R.string.continue_txt)
                        binding.ivRowContinue.visibility = View.VISIBLE
                        EventTracking.logEvent(this@IntroBepicActivity, EventTracking.EVENT_NAME_ONBOARDING1_VIEW)
                    }

                    (listIntroBepic.size - 1) -> {
                        addBottomDotsBepic(position)
                        binding.tvNext.text = resources.getString(R.string.get_started)
                        binding.ivRowContinue.visibility = View.GONE
                        EventTracking.logEvent(this@IntroBepicActivity, EventTracking.EVENT_NAME_ONBOARDING3_VIEW)
                    }

                    else -> {
                        countBepic++
                        addBottomDotsBepic(position)
                        binding.tvNext.text = resources.getString(R.string.continue_txt)
                        binding.ivRowContinue.visibility = View.VISIBLE
                        EventTracking.logEvent(this@IntroBepicActivity, EventTracking.EVENT_NAME_ONBOARDING2_VIEW)
                    }
                }
            }
        })

    }

    override fun createViewModel(): Class<IntroViewModel> = IntroViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_intro_bepic_new

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {

    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {
    }

    override fun bindViewModel() {
        binding.tvNext.tapAndCheckInternet {
            if (binding.viewpager.currentItem < listIntroBepic.size - 1) {
                var current = getItemBepic(1)
                binding.viewpager.currentItem = current
            } else {
                val isPermissionScreenShowed = (LocalStorageUtils.readData(
                    this@IntroBepicActivity,
                    Constants.KEY_PERMISSION_SCREEN_SHOWED
                ) as Boolean?) ?: false
                if (isPermissionScreenShowed) {
                    showActivity(MainBepicActivity::class.java)
                } else {
                    showActivity(PermissionBepicActivity::class.java)
                }
                finish()

                EventTracking.logEvent(this@IntroBepicActivity, EventTracking.EVENT_NAME_ONBOARDING3_START_CLICK)
            }
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }

    private fun addBottomDotsBepic(currentPage: Int) {
        Log.d("VIET", "$currentPage")
        if (currentPage == 0) {
            binding.dot1.setBackgroundResource(R.drawable.dot_select)
            binding.dot2.setBackgroundResource(R.drawable.dot_not_select)
            binding.dot3.setBackgroundResource(R.drawable.dot_not_select)
        } else if (currentPage == 1) {
            binding.dot1.setBackgroundResource(R.drawable.dot_not_select)
            binding.dot2.setBackgroundResource(R.drawable.dot_select)
            binding.dot3.setBackgroundResource(R.drawable.dot_not_select)
        } else {
            binding.dot1.setBackgroundResource(R.drawable.dot_not_select)
            binding.dot2.setBackgroundResource(R.drawable.dot_not_select)
            binding.dot3.setBackgroundResource(R.drawable.dot_select)
        }
    }

    private fun getItemBepic(i: Int): Int {
        return binding.viewpager.currentItem + i
    }
}